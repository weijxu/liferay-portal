/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

AUI.add(
	'liferay-kaleo-designer-xml-util',
	(A) => {
		const Lang = A.Lang;
		const LString = Lang.String;

		const isNull = Lang.isNull;
		const isValue = Lang.isValue;

		const BUFFER_ATTR = [null, '="', null, '" '];

		const BUFFER_CLOSE_NODE = ['</', null, '>'];

		const BUFFER_OPEN_NODE = ['<', null, null, '>'];

		const STR_BLANK = '';

		const STR_CDATA_CLOSE = ']]>';

		const STR_CDATA_OPEN = '<![CDATA[';

		const STR_CHAR_CR_LF_CRLF = /\r\n|\r|\n/;

		const STR_CHAR_CRLF = '\r\n';

		const STR_CHAR_TAB = '\t';

		const STR_DASH = '-';

		const STR_METADATA = '<metadata';

		const STR_SPACE = ' ';

		const XMLUtil = {
			REGEX_TOKEN_1: /.+<\/\w[^>]*>$/,
			REGEX_TOKEN_2: /^<\/\w/,
			REGEX_TOKEN_3: /^<\w[^>]*[^/]>.*$/,

			create(name, content, attrs) {
				const instance = this;

				const node = instance.createObj(name, attrs);

				return (
					node.open +
					(isValue(content) ? content : STR_BLANK) +
					node.close
				);
			},

			createObj(name, attrs) {
				let attrBuffer = [STR_SPACE];
				const normalizedName = LString.uncamelize(
					name,
					STR_DASH
				).toLowerCase();

				if (attrs !== undefined && attrs.xmlns) {
					attrBuffer = [STR_CHAR_CRLF];
				}

				A.each(attrs, (item, index) => {
					if (item !== undefined) {
						BUFFER_ATTR[0] = index;
						BUFFER_ATTR[2] = item;

						if (attrs.xmlns) {
							attrBuffer.push(STR_CHAR_TAB);
						}

						attrBuffer.push(BUFFER_ATTR.join(STR_BLANK).trim());

						if (attrs.xmlns) {
							attrBuffer.push(STR_CHAR_CRLF);
						}
					}
				});

				const attributes = Lang.trimRight(attrBuffer.join(STR_BLANK));

				BUFFER_CLOSE_NODE[1] = normalizedName;

				BUFFER_OPEN_NODE[1] = normalizedName;
				BUFFER_OPEN_NODE[2] = attributes;

				if (attrs !== undefined && attrs.xmlns) {
					BUFFER_OPEN_NODE[3] = STR_CHAR_CRLF + '>';
				}
				else {
					BUFFER_OPEN_NODE[3] = '>';
				}

				return {
					close: BUFFER_CLOSE_NODE.join(STR_BLANK),
					open: BUFFER_OPEN_NODE.join(STR_BLANK),
				};
			},

			format(lines) {
				const instance = this;

				let formatted = STR_BLANK;
				let inCDATA = false;
				let pad = 0;

				lines.forEach((item) => {
					let indent = 0;

					if (!inCDATA) {
						if (item.match(instance.REGEX_TOKEN_1)) {
							indent = 0;
						}
						else if (item.match(instance.REGEX_TOKEN_2)) {
							if (pad !== 0) {
								pad -= 1;
							}
						}
						else if (item.match(instance.REGEX_TOKEN_3)) {
							indent = 1;
						}

						formatted += LString.repeat(STR_CHAR_TAB, pad);
					}

					if (item.indexOf(STR_METADATA) > -1) {
						const metadata = item.split(STR_CHAR_CR_LF_CRLF);
						item = '';
						for (let i = 0; i < metadata.length; i++) {
							if (i === 0 || i === 2) {
								pad += 1;
							}

							if (
								i === metadata.length - 2 ||
								i === metadata.length - 1
							) {
								pad -= 1;
							}

							item +=
								LString.repeat(STR_CHAR_TAB, pad) +
								metadata[i] +
								STR_CHAR_CRLF;
						}
					}
					else if (item.indexOf(STR_CDATA_OPEN) > -1) {
						let cdata = item.split(STR_CDATA_OPEN);

						item = LString.repeat(STR_CHAR_TAB, pad) + cdata[0];

						cdata = cdata[1].split(STR_CDATA_CLOSE);

						item +=
							LString.repeat(STR_CHAR_TAB, pad + 1) +
							STR_CDATA_OPEN +
							cdata[0] +
							STR_CDATA_CLOSE +
							STR_CHAR_CRLF +
							LString.repeat(STR_CHAR_TAB, pad) +
							cdata[1].trim();
					}

					formatted += item.trim() + STR_CHAR_CRLF;

					if (item.indexOf(STR_CDATA_CLOSE) > -1) {
						inCDATA = false;
					}
					else if (item.indexOf(STR_CDATA_OPEN) > -1) {
						inCDATA = true;
					}

					pad += indent;
				});

				return formatted.trim();
			},

			validateDefinition(definition) {
				const doc = A.DataType.XML.parse(definition);

				let valid = true;

				if (
					isNull(doc) ||
					isNull(doc.documentElement) ||
					A.one(doc).one('parsererror')
				) {
					valid = false;
				}

				return valid;
			},
		};

		Liferay.XMLUtil = XMLUtil;
	},
	'',
	{
		requires: ['aui-base'],
	}
);
