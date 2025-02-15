/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.search.internal.query;

import com.liferay.portal.test.rule.LiferayUnitTestRule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Bryan Engler
 */
public class MultiMatchQueryImplTest {

	@ClassRule
	@Rule
	public static final LiferayUnitTestRule liferayUnitTestRule =
		LiferayUnitTestRule.INSTANCE;

	@Test
	public void testMultiMatchQueryConstructor1() {
		Object value = null;

		Map<String, Float> fieldsBoosts = new HashMap<>();

		fieldsBoosts.put("test", null);

		MultiMatchQueryImpl multiMatchQueryImpl = new MultiMatchQueryImpl(
			value, fieldsBoosts);

		Assert.assertNotNull(multiMatchQueryImpl);
	}

	@Test
	public void testMultiMatchQueryConstructor2() {
		Object value = null;

		Set<String> fields = new HashSet<>();

		fields.add("test");

		MultiMatchQueryImpl multiMatchQueryImpl = new MultiMatchQueryImpl(
			value, fields);

		Assert.assertNotNull(multiMatchQueryImpl);
	}

	@Test
	public void testMultiMatchQueryConstructor3() {
		Object value = null;
		String[] fields = {"test"};

		MultiMatchQueryImpl multiMatchQueryImpl = new MultiMatchQueryImpl(
			value, fields);

		Assert.assertNotNull(multiMatchQueryImpl);
	}

}