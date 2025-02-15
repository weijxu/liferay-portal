/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.frontend.data.set.taglib.servlet.taglib;

import com.liferay.frontend.data.set.filter.FDSFilter;
import com.liferay.frontend.data.set.filter.FDSFilterSerializer;
import com.liferay.frontend.data.set.model.FDSActionDropdownItem;
import com.liferay.frontend.data.set.model.FDSSortItem;
import com.liferay.frontend.data.set.model.FDSSortItemList;
import com.liferay.frontend.data.set.taglib.internal.servlet.ServletContextUtil;
import com.liferay.frontend.data.set.view.FDSViewSerializer;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

/**
 * @author Marco Leo
 * @author Alessio Antonio Rendina
 */
public class HeadlessDisplayTag extends BaseDisplayTag {

	@Override
	public int doStartTag() throws JspException {
		try {
			_appURL =
				PortalUtil.getPortalURL(getRequest()) +
					"/o/frontend-data-set-taglib/app";

			if (_creationMenu == null) {
				_creationMenu = new CreationMenu();
			}

			_setActiveViewSettingsJSON();
			_setFDSViewsContext();
			_setFDSFiltersContext();
		}
		catch (Exception exception) {
			_log.error(exception);
		}

		String randomKey = PortalUtil.generateRandomKey(
			getRequest(), "taglib_frontend_data_set_headless_display_page");

		setRandomNamespace(randomKey + StringPool.UNDERLINE);

		return super.doStartTag();
	}

	public String getActionParameterName() {
		return _actionParameterName;
	}

	public String getApiURL() {
		return _apiURL;
	}

	public List<DropdownItem> getBulkActionDropdownItems() {
		return _bulkActionDropdownItems;
	}

	public CreationMenu getCreationMenu() {
		return _creationMenu;
	}

	public List<FDSActionDropdownItem> getFdsActionDropdownItems() {
		return _fdsActionDropdownItems;
	}

	public List<FDSFilter> getFdsFilters() {
		return _fdsFilters;
	}

	public List<FDSSortItem> getFdsSortItemList() {
		return _fdsSortItemList;
	}

	public String getFormId() {
		return _formId;
	}

	public String getFormName() {
		return _formName;
	}

	public String getNestedItemsKey() {
		return _nestedItemsKey;
	}

	public String getNestedItemsReferenceKey() {
		return _nestedItemsReferenceKey;
	}

	public String getSelectedItemsKey() {
		return _selectedItemsKey;
	}

	public String getSelectionType() {
		return _selectionType;
	}

	public String getStyle() {
		return _style;
	}

	public boolean isCustomViewsEnabled() {
		return _customViewsEnabled;
	}

	public boolean isShowManagementBar() {
		return _showManagementBar;
	}

	public boolean isShowPagination() {
		return _showPagination;
	}

	public boolean isShowSearch() {
		return _showSearch;
	}

	public void setActionParameterName(String actionParameterName) {
		_actionParameterName = actionParameterName;
	}

	public void setApiURL(String apiURL) {
		_apiURL = apiURL;
	}

	public void setBulkActionDropdownItems(List<DropdownItem> bulkActions) {
		_bulkActionDropdownItems = bulkActions;
	}

	public void setCreationMenu(CreationMenu creationMenu) {
		_creationMenu = creationMenu;
	}

	public void setCustomViewsEnabled(boolean customViewsEnabled) {
		_customViewsEnabled = customViewsEnabled;
	}

	public void setFdsActionDropdownItems(
		List<FDSActionDropdownItem> fdsActionDropdownItems) {

		_fdsActionDropdownItems = fdsActionDropdownItems;
	}

	public void setFdsFilters(List<FDSFilter> fdsFilters) {
		_fdsFilters = fdsFilters;
	}

	public void setFdsSortItemList(FDSSortItemList fdsSortItemList) {
		_fdsSortItemList = fdsSortItemList;
	}

	public void setFormId(String formId) {
		_formId = formId;
	}

	public void setFormName(String formName) {
		_formName = formName;
	}

	public void setNestedItemsKey(String nestedItemsKey) {
		_nestedItemsKey = nestedItemsKey;
	}

	public void setNestedItemsReferenceKey(String nestedItemsReferenceKey) {
		_nestedItemsReferenceKey = nestedItemsReferenceKey;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		_fdsViewSerializer = ServletContextUtil.getFDSViewSerializer();

		_fdsFilterSerializer = ServletContextUtil.getFDSFilterSerializer();

		super.setPageContext(pageContext);

		setServletContext(ServletContextUtil.getServletContext());
	}

	public void setSelectedItemsKey(String selectedItemsKey) {
		_selectedItemsKey = selectedItemsKey;
	}

	public void setSelectionType(String selectionType) {
		_selectionType = selectionType;
	}

	public void setShowManagementBar(boolean showManagementBar) {
		_showManagementBar = showManagementBar;
	}

	public void setShowPagination(boolean showPagination) {
		_showPagination = showPagination;
	}

	public void setShowSearch(boolean showSearch) {
		_showSearch = showSearch;
	}

	public void setStyle(String style) {
		_style = style;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_actionParameterName = null;
		_activeViewSettingsJSON = null;
		_apiURL = null;
		_appURL = null;
		_bulkActionDropdownItems = new ArrayList<>();
		_creationMenu = new CreationMenu();
		_customViewsEnabled = false;
		_fdsActionDropdownItems = new ArrayList<>();
		_fdsFilters = new ArrayList<>();
		_fdsFiltersContext = null;
		_fdsFilterSerializer = null;
		_fdsSortItemList = new FDSSortItemList();
		_fdsViewsContext = null;
		_fdsViewSerializer = null;
		_formId = null;
		_formName = null;
		_nestedItemsKey = null;
		_nestedItemsReferenceKey = null;
		_selectedItemsKey = null;
		_selectionType = null;
		_showManagementBar = true;
		_showPagination = true;
		_showSearch = true;
		_style = "default";
	}

	@Override
	protected Map<String, Object> prepareProps(Map<String, Object> props) {
		return super.prepareProps(
			HashMapBuilder.<String, Object>putAll(
				props
			).put(
				"actionParameterName",
				GetterUtil.getString(_actionParameterName)
			).put(
				"activeViewSettings", _activeViewSettingsJSON
			).put(
				"apiURL", _apiURL
			).put(
				"appURL", _appURL
			).put(
				"bulkActions", _bulkActionDropdownItems
			).put(
				"creationMenu", _creationMenu
			).put(
				"currentURL", PortalUtil.getCurrentURL(getRequest())
			).put(
				"customViewsEnabled", _customViewsEnabled
			).put(
				"filters", _fdsFiltersContext
			).put(
				"formId", _validateDataAttribute(_formId)
			).put(
				"formName", _validateDataAttribute(_formName)
			).put(
				"id", getId()
			).put(
				"itemsActions", _fdsActionDropdownItems
			).put(
				"nestedItemsKey", _validateDataAttribute(_nestedItemsKey)
			).put(
				"nestedItemsReferenceKey",
				_validateDataAttribute(_nestedItemsReferenceKey)
			).put(
				"portletId", PortalUtil.getPortletId(getRequest())
			).put(
				"selectedItemsKey", _validateDataAttribute(_selectedItemsKey)
			).put(
				"selectionType", _validateDataAttribute(_selectionType)
			).put(
				"showManagementBar", _showManagementBar
			).put(
				"showPagination", _showPagination
			).put(
				"showSearch", _showSearch
			).put(
				"sorting", _fdsSortItemList
			).put(
				"style", _validateDataAttribute(_style)
			).put(
				"views", _fdsViewsContext
			).build());
	}

	private void _setActiveViewSettingsJSON() {
		HttpServletRequest httpServletRequest = getRequest();

		PortalPreferences portalPreferences =
			PortletPreferencesFactoryUtil.getPortalPreferences(
				httpServletRequest);

		_activeViewSettingsJSON = portalPreferences.getValue(
			ServletContextUtil.getFDSSettingsNamespace(
				httpServletRequest, getId()),
			"activeViewSettingsJSON");
	}

	private void _setFDSFiltersContext() {
		_fdsFiltersContext = _fdsFilterSerializer.serialize(
			getId(), getFdsFilters(), PortalUtil.getLocale(getRequest()));
	}

	private void _setFDSViewsContext() {
		_fdsViewsContext = _fdsViewSerializer.serialize(
			getId(), PortalUtil.getLocale(getRequest()));
	}

	private Object _validateDataAttribute(Object object) {
		if (Validator.isNull(object)) {
			return null;
		}

		return object;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		HeadlessDisplayTag.class);

	private String _actionParameterName;
	private String _activeViewSettingsJSON;
	private String _apiURL;
	private String _appURL;
	private List<DropdownItem> _bulkActionDropdownItems = new ArrayList<>();
	private CreationMenu _creationMenu = new CreationMenu();
	private boolean _customViewsEnabled;
	private List<FDSActionDropdownItem> _fdsActionDropdownItems =
		new ArrayList<>();
	private List<FDSFilter> _fdsFilters = new ArrayList<>();
	private Object _fdsFiltersContext;
	private FDSFilterSerializer _fdsFilterSerializer;
	private FDSSortItemList _fdsSortItemList = new FDSSortItemList();
	private Object _fdsViewsContext;
	private FDSViewSerializer _fdsViewSerializer;
	private String _formId;
	private String _formName;
	private String _nestedItemsKey;
	private String _nestedItemsReferenceKey;
	private String _selectedItemsKey;
	private String _selectionType;
	private boolean _showManagementBar = true;
	private boolean _showPagination = true;
	private boolean _showSearch = true;
	private String _style = "default";

}