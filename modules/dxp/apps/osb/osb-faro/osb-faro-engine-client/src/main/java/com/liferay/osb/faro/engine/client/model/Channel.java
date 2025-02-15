/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.osb.faro.engine.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author André Miranda
 */
public class Channel {

	public List<Map<String, Object>> getDataSources() {
		return _dataSources;
	}

	@JsonProperty("_embedded")
	public Map<String, Object> getEmbeddedResources() {
		return _embeddedResources;
	}

	public String getId() {
		return _id;
	}

	public String getName() {
		return _name;
	}

	public void setDataSources(List<Map<String, Object>> dataSources) {
		_dataSources = dataSources;
	}

	public void setEmbeddedResources(Map<String, Object> embeddedResources) {
		_embeddedResources = embeddedResources;
	}

	public void setId(String id) {
		_id = id;
	}

	public void setName(String name) {
		_name = name;
	}

	private List<Map<String, Object>> _dataSources;
	private Map<String, Object> _embeddedResources = new HashMap<>();
	private String _id;
	private String _name;

}