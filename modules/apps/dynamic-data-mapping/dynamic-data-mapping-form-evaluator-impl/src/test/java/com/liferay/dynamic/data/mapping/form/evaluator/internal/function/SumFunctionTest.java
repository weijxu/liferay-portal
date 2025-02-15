/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

import com.liferay.portal.test.rule.LiferayUnitTestRule;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Leonardo Barros
 */
public class SumFunctionTest {

	@ClassRule
	@Rule
	public static final LiferayUnitTestRule liferayUnitTestRule =
		LiferayUnitTestRule.INSTANCE;

	@Test
	public void testApply() {
		SumFunction sumFunction = new SumFunction();

		BigDecimal result = sumFunction.apply(
			new BigDecimal[] {
				new BigDecimal(1), new BigDecimal(2), new BigDecimal(3)
			});

		Assert.assertEquals(new BigDecimal(6), result);
	}

	@Test
	public void testEmptyArray() {
		SumFunction sumFunction = new SumFunction();

		BigDecimal result = sumFunction.apply(new BigDecimal[0]);

		Assert.assertEquals(BigDecimal.ZERO, result);
	}

}