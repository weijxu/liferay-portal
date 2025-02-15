/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.headless.builder.model.listener.test;

import com.liferay.headless.builder.test.BaseTestCase;
import com.liferay.headless.builder.util.ObjectDefinitionTestUtil;
import com.liferay.object.field.util.ObjectFieldUtil;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectField;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.HTTPTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.test.rule.FeatureFlags;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sergio Jiménez del Coso
 */
@FeatureFlags({"LPS-167253", "LPS-184413", "LPS-186757"})
public class APIPropertyRelevantObjectEntryModelListenerTest
	extends BaseTestCase {

	@Before
	public void setUp() throws Exception {
		super.setUp();

		_objectField = ObjectFieldUtil.createObjectField(
			"Text", "String", true, true, null,
			StringUtil.toLowerCase(RandomTestUtil.randomString()),
			"x" + RandomTestUtil.randomString(), false);

		_objectField.setExternalReferenceCode(RandomTestUtil.randomString());

		_objectDefinition = ObjectDefinitionTestUtil.publishObjectDefinition(
			Collections.singletonList(_objectField));
	}

	@Test
	public void test() throws Exception {
		JSONObject apiApplicationJSONObject = HTTPTestUtil.invokeToJSONObject(
			JSONUtil.put(
				"applicationStatus", "published"
			).put(
				"baseURL", StringUtil.toLowerCase(RandomTestUtil.randomString())
			).put(
				"title", RandomTestUtil.randomString()
			).toString(),
			"headless-builder/applications", Http.Method.POST);

		JSONObject apiSchemaJSONObject = HTTPTestUtil.invokeToJSONObject(
			JSONUtil.put(
				"mainObjectDefinitionERC",
				_objectDefinition.getExternalReferenceCode()
			).put(
				"name", RandomTestUtil.randomString()
			).put(
				"r_apiApplicationToAPISchemas_c_apiApplicationId",
				apiApplicationJSONObject.getLong("id")
			).toString(),
			"headless-builder/schemas", Http.Method.POST);

		JSONObject jsonObject = HTTPTestUtil.invokeToJSONObject(
			JSONUtil.put(
				"description", RandomTestUtil.randomString()
			).put(
				"name", RandomTestUtil.randomString()
			).put(
				"objectFieldERC", "APPLICATION_STATUS"
			).toString(),
			"headless-builder/properties", Http.Method.POST);

		Assert.assertEquals("BAD_REQUEST", jsonObject.get("status"));
		Assert.assertEquals(
			"An API property must be related to an API schema.",
			jsonObject.get("title"));

		jsonObject = HTTPTestUtil.invokeToJSONObject(
			JSONUtil.put(
				"description", RandomTestUtil.randomString()
			).put(
				"name", RandomTestUtil.randomString()
			).put(
				"objectFieldERC", "APPLICATION_STATUS"
			).put(
				"r_apiSchemaToAPIProperties_c_apiSchemaId",
				apiSchemaJSONObject.get("id")
			).toString(),
			"headless-builder/properties", Http.Method.POST);

		Assert.assertEquals("BAD_REQUEST", jsonObject.get("status"));
		Assert.assertEquals(
			"An API property must be related to an existing object field.",
			jsonObject.get("title"));

		jsonObject = HTTPTestUtil.invokeToJSONObject(
			JSONUtil.put(
				"description", RandomTestUtil.randomString()
			).put(
				"name", RandomTestUtil.randomString()
			).put(
				"objectFieldERC", _objectField.getExternalReferenceCode()
			).put(
				"r_apiSchemaToAPIProperties_c_apiSchemaId",
				apiSchemaJSONObject.get("id")
			).toString(),
			"headless-builder/properties", Http.Method.POST);

		Assert.assertEquals(
			0,
			jsonObject.getJSONObject(
				"status"
			).get(
				"code"
			));
	}

	@DeleteAfterTestRun
	private ObjectDefinition _objectDefinition;

	@DeleteAfterTestRun
	private ObjectField _objectField;

}