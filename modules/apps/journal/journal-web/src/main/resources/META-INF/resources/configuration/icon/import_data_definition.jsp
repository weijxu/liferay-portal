<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>

<div>
	<react:component
		module="js/modals/ImportDataDefinitionModal"
		props='<%=
			HashMapBuilder.<String, Object>put(
				"importDataDefinitionURL",
				PortletURLBuilder.createActionURL(
					renderResponse
				).setActionName(
					"/journal/import_data_definition"
				).setRedirect(
					currentURL
				).buildString()
			).put(
				"nameMaxLength", ModelHintsConstants.TEXT_MAX_LENGTH
			).build()
		%>'
	/>
</div>

<aui:script>
	Liferay.Util.setPortletConfigurationIconAction(
		'<portlet:namespace />importDataDefinition',
		() => {
			Liferay.componentReady(
				'<portlet:namespace />importDataDefinitionModal'
			).then((importDataDefinitionModal) => {
				importDataDefinitionModal.open();
			});
		}
	);
</aui:script>