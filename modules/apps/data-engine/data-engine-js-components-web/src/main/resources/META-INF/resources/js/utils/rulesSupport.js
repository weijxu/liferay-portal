/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {getFieldProperty} from '../core/utils/fields';
import {Tokenizer} from './Tokenizer';
import {PagesVisitor} from './visitors.es';

const DEFAULT_FIELD_NAMES_REGEX_FOR_EXPRESSION = /[a-zA-Z]+\d{8}/g;

export function clearTargetValue(actions, index) {
	if (actions[index]) {
		actions[index].target = '';
	}

	return actions;
}

export function clearFirstOperandValue(condition) {
	if (condition && condition.operands[0]) {
		condition.operands[0].type = '';
		condition.operands[0].value = '';
	}

	return condition;
}

export function clearOperatorValue(condition) {
	if (condition) {
		condition.operator = '';
	}

	return condition;
}

export function clearSecondOperandValue(condition) {
	if (condition && condition.operands[1]) {
		condition.operands[1].type = '';
		condition.operands[1].value = '';
	}

	return condition;
}

export function clearAllConditionFieldValues(condition) {
	condition = clearFirstOperandValue(condition);
	condition = clearOperatorValue(condition);
	condition = clearSecondOperandValue(condition);

	return condition;
}

const fieldWithOptions = (fieldType) => {
	return (
		fieldType === 'radio' ||
		fieldType === 'checkbox_multiple' ||
		fieldType === 'select'
	);
};

export function getFieldOptions(fieldName, pages) {
	let options = [];
	const visitor = new PagesVisitor(pages);

	const field = visitor.findField((field) => {
		return field.fieldName === fieldName;
	});

	options = field ? field.options : [];

	return options;
}

export function getFieldType(fieldName, pages) {
	return getFieldProperty(pages, fieldName, 'type');
}

const optionBelongsToRule = (condition, options) => {
	return options.some(
		(option) => option.value === condition.operands[1]?.value
	);
};

const getExpressionFields = (
	action,
	regex = DEFAULT_FIELD_NAMES_REGEX_FOR_EXPRESSION
) => {
	return action.expression.match(regex);
};

const targetFieldExists = (target, pages) => {
	const visitor = new PagesVisitor(pages);

	let targetFieldExists = false;

	visitor.mapFields(
		({fieldName}) => {
			if (target === fieldName) {
				targetFieldExists = true;
			}
		},
		true,
		true
	);

	return targetFieldExists;
};

export function syncActions(pages, actions) {
	actions.forEach((action) => {
		if (action.action === 'auto-fill') {
			const {inputs, outputs} = action;

			Object.keys(inputs)
				.filter((key) => !targetFieldExists(inputs[key], pages))
				.map((key) => {
					inputs[key] = '';
				});

			Object.keys(outputs)
				.filter((key) => !targetFieldExists(outputs[key], pages))
				.map((key) => {
					outputs[key] = '';
				});
		}
		else if (action.action === 'calculate') {
			const expressionFields = getExpressionFields(action);

			if (expressionFields && !!expressionFields.length) {
				expressionFields.forEach((field) => {
					if (!targetFieldExists(field, pages)) {
						const inexistentField = new RegExp(field, 'g');

						action.expression = action.expression.replace(
							inexistentField,
							''
						);
					}
				});
			}

			if (!targetFieldExists(action.target, pages)) {
				action.target = '';
			}
		}
		else if (action.action === 'jump-to-page') {
			const target = parseInt(action.target, 10) + 1;

			if (pages.length < 3 || target > pages.length) {
				action.target = '';
			}
		}
		else if (!targetFieldExists(action.target, pages)) {
			action.target = '';
		}
	});

	return actions;
}

export function formatRules(pages, rules) {
	const visitor = new PagesVisitor(pages);

	const formattedRules = (rules || []).map((rule) => {
		const {actions, conditions} = rule;

		conditions.forEach((condition) => {
			let firstOperandFieldExists = false;
			let secondOperandFieldExists = false;

			const secondOperand = condition.operands[1];

			visitor.mapFields(
				({fieldName}) => {
					if (condition.operands[0].value === fieldName) {
						firstOperandFieldExists = true;
					}

					if (secondOperand && secondOperand.value === fieldName) {
						secondOperandFieldExists = true;
					}
				},
				true,
				true
			);

			const firstOperandFieldType = getFieldType(
				condition.operands[0].value,
				pages
			);

			if (
				firstOperandFieldExists &&
				fieldWithOptions(firstOperandFieldType) &&
				condition.operands[1]?.type !== 'field'
			) {
				const fieldName = condition.operands[0].value;
				const options = getFieldOptions(fieldName, pages);

				secondOperandFieldExists =
					options &&
					options[0]?.value !== '' &&
					optionBelongsToRule(condition, options);
			}

			if (
				condition.operands.length < 2 &&
				condition.operands[0].type === 'list'
			) {
				condition.operands = [
					{
						label: 'user',
						repeatable: false,
						type: 'user',
						value: 'user',
					},
					{
						...condition.operands[0],
						label: condition.operands[0].value,
					},
				];
			}

			if (condition.operands[0].value === 'user') {
				firstOperandFieldExists = true;
			}

			if (!firstOperandFieldExists) {
				clearAllConditionFieldValues(condition);
			}

			if (
				fieldWithOptions(firstOperandFieldType) &&
				!secondOperandFieldExists
			) {
				clearSecondOperandValue(condition);
			}

			if (
				!secondOperandFieldExists &&
				secondOperand &&
				secondOperand.type === 'field'
			) {
				clearSecondOperandValue(condition);
			}
		});

		return {
			...rule,
			actions: syncActions(pages, actions),
			conditions,
		};
	});

	return formattedRules;
}

const expressionHasNonNumericFields = (action, fields) => {
	const expressionFields = getExpressionFields(action);
	let hasNonNumericFields = false;

	if (expressionFields && !!expressionFields.length) {
		expressionFields.forEach((value) => {
			const field = fields.find(({fieldName}) => fieldName === value);
			if (field?.type !== 'numeric') {
				hasNonNumericFields = true;
			}
		});
	}

	return hasNonNumericFields;
};

export function fieldNameBelongsToAction(actions, fieldName, fields) {
	const emptyField = '[]';

	return actions
		.map((action) => {
			if (action.action === 'auto-fill') {
				return (
					Object.values(action.inputs).some(
						(input) => input === fieldName
					) ||
					Object.values(action.outputs).some(
						(output) => output === fieldName
					)
				);
			}
			else if (action.action === 'calculate') {
				const {expression, target} = action;

				if (fieldName === '') {
					return (
						expression.indexOf(emptyField) !== -1 ||
						target === fieldName ||
						expressionHasNonNumericFields(action, fields)
					);
				}
				else {
					return (
						expression.indexOf(fieldName) !== -1 ||
						target === fieldName
					);
				}
			}
			else {
				return action.target === fieldName;
			}
		})
		.some((fieldFound) => fieldFound === true);
}

export function fieldNameBelongsToCondition(conditions, fieldName) {
	return conditions
		.map((condition) => {
			return condition.operands
				.map((operand) => operand.value === fieldName)
				.some((fieldFound) => fieldFound === true);
		})
		.some((fieldFound) => fieldFound === true);
}

export function findRuleByFieldName(fieldName, pages, rules) {
	return rules.some(
		(rule) =>
			fieldNameBelongsToAction(rule.actions, fieldName, pages) ||
			fieldNameBelongsToCondition(rule.conditions, fieldName)
	);
}

const isOperandValid = (operand) =>
	operand && Boolean(operand.type) && Boolean(operand.value);

export function isConditionsValid(conditions) {
	return conditions
		.map(({operator, operands: [left, right]}) => {
			if (['is-empty', 'not-is-empty'].includes(operator)) {
				return isOperandValid(left);
			}

			return (
				Boolean(operator) &&
				isOperandValid(left) &&
				isOperandValid(right)
			);
		})
		.every((result) => result === true);
}

export function isActionsValid(actions, dataProviders) {
	return actions
		.map(({action, target, ...payload}) => {
			switch (action) {
				case 'calculate': {
					const {expression} = payload;

					return (
						Boolean(target) &&
						Boolean(expression) &&
						Tokenizer.isValid(expression)
					);
				}
				case 'auto-fill': {
					const {inputs, label, outputs} = payload;

					let valid = Boolean(
						Object.values(inputs).length ||
							Object.values(outputs).length
					);

					const currentDataProvider = dataProviders.find(
						({id}) => id === label
					);

					const inputOutputLength =
						currentDataProvider?.inputOutputLength;

					const parametersQuantity =
						Object.keys(outputs).length +
						Object.values(inputs).length;

					if (inputOutputLength) {
						valid = parametersQuantity === inputOutputLength;
					}

					return Boolean(target) && valid;
				}
				default:
					return Boolean(target);
			}
		})
		.every((result) => result === true);
}

export function findInvalidRule(pages, rule) {
	return findRuleByFieldName('', pages, [rule]);
}

export function replaceFieldNameByFieldLabel(expression, fields) {
	const operands = expression.match(DEFAULT_FIELD_NAMES_REGEX_FOR_EXPRESSION);

	if (!operands) {
		return expression;
	}

	let newExpression = expression;

	operands.map((operand) => {
		return fields.forEach((field) => {
			if (field.fieldName === operand) {
				newExpression = newExpression.replace(operand, field.label);
			}
		});
	});

	return newExpression;
}
