/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.layout.page.template.admin.web.internal.display.context;

import com.liferay.info.item.InfoItemClassDetails;
import com.liferay.info.item.InfoItemFormVariation;
import com.liferay.info.item.InfoItemServiceRegistry;
import com.liferay.info.item.provider.InfoItemFormVariationsProvider;
import com.liferay.info.localized.InfoLocalizedValue;
import com.liferay.layout.page.template.constants.LayoutPageTemplateEntryTypeConstants;
import com.liferay.layout.page.template.info.item.capability.DisplayPageInfoItemCapability;
import com.liferay.layout.page.template.model.LayoutPageTemplateEntry;
import com.liferay.layout.page.template.service.LayoutPageTemplateEntryLocalServiceUtil;
import com.liferay.layout.page.template.service.LayoutPageTemplateEntryServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class SelectDisplayPageMasterLayoutDisplayContext {

	public SelectDisplayPageMasterLayoutDisplayContext(
		HttpServletRequest httpServletRequest) {

		_httpServletRequest = httpServletRequest;

		_infoItemServiceRegistry =
			(InfoItemServiceRegistry)httpServletRequest.getAttribute(
				InfoItemServiceRegistry.class.getName());
		_themeDisplay = (ThemeDisplay)httpServletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	public JSONArray getMappingTypesJSONArray() {
		JSONArray mappingTypesJSONArray = JSONFactoryUtil.createJSONArray();

		for (InfoItemClassDetails infoItemClassDetails :
				_infoItemServiceRegistry.getInfoItemClassDetails(
					_themeDisplay.getScopeGroupId(),
					DisplayPageInfoItemCapability.KEY,
					_themeDisplay.getPermissionChecker())) {

			mappingTypesJSONArray.put(
				JSONUtil.put(
					"id",
					String.valueOf(
						PortalUtil.getClassNameId(
							infoItemClassDetails.getClassName()))
				).put(
					"label",
					infoItemClassDetails.getLabel(_themeDisplay.getLocale())
				).put(
					"subtypes",
					_getMappingFormVariationsJSONArray(infoItemClassDetails)
				));
		}

		return mappingTypesJSONArray;
	}

	public List<LayoutPageTemplateEntry> getMasterLayoutPageTemplateEntries() {
		List<LayoutPageTemplateEntry> masterLayoutPageTemplateEntries =
			new ArrayList<>();

		LayoutPageTemplateEntry layoutPageTemplateEntry =
			LayoutPageTemplateEntryLocalServiceUtil.
				createLayoutPageTemplateEntry(0);

		layoutPageTemplateEntry.setName(
			LanguageUtil.get(_httpServletRequest, "blank"));
		layoutPageTemplateEntry.setStatus(WorkflowConstants.STATUS_APPROVED);

		masterLayoutPageTemplateEntries.add(layoutPageTemplateEntry);

		masterLayoutPageTemplateEntries.addAll(
			LayoutPageTemplateEntryServiceUtil.getLayoutPageTemplateEntries(
				_themeDisplay.getScopeGroupId(),
				LayoutPageTemplateEntryTypeConstants.TYPE_MASTER_LAYOUT,
				WorkflowConstants.STATUS_APPROVED, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null));

		return masterLayoutPageTemplateEntries;
	}

	private JSONArray _getMappingFormVariationsJSONArray(
		InfoItemClassDetails infoItemClassDetails) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		InfoItemFormVariationsProvider<?> infoItemFormVariationsProvider =
			_infoItemServiceRegistry.getFirstInfoItemService(
				InfoItemFormVariationsProvider.class,
				infoItemClassDetails.getClassName());

		if (infoItemFormVariationsProvider == null) {
			return jsonArray;
		}

		Collection<InfoItemFormVariation> infoItemFormVariations =
			infoItemFormVariationsProvider.getInfoItemFormVariations(
				_themeDisplay.getScopeGroupId());

		for (InfoItemFormVariation infoItemFormVariation :
				infoItemFormVariations) {

			jsonArray.put(
				JSONUtil.put(
					"id", String.valueOf(infoItemFormVariation.getKey())
				).put(
					"label",
					() -> {
						InfoLocalizedValue<String> labelInfoLocalizedValue =
							infoItemFormVariation.getLabelInfoLocalizedValue();

						return labelInfoLocalizedValue.getValue(
							_themeDisplay.getLocale());
					}
				));
		}

		return jsonArray;
	}

	private final HttpServletRequest _httpServletRequest;
	private final InfoItemServiceRegistry _infoItemServiceRegistry;
	private final ThemeDisplay _themeDisplay;

}