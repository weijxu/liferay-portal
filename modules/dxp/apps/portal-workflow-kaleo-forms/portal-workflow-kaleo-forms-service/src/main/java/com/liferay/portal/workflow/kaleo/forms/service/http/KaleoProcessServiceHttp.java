/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.workflow.kaleo.forms.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.workflow.kaleo.forms.service.KaleoProcessServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>KaleoProcessServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Marcellus Tavares
 * @generated
 */
public class KaleoProcessServiceHttp {

	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess
			addKaleoProcess(
				HttpPrincipal httpPrincipal, long groupId, long ddmStructureId,
				java.util.Map<java.util.Locale, String> nameMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				long ddmTemplateId, String workflowDefinitionName,
				int workflowDefinitionVersion,
				com.liferay.portal.workflow.kaleo.forms.model.KaleoTaskFormPairs
					kaleoTaskFormPairs,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				KaleoProcessServiceUtil.class, "addKaleoProcess",
				_addKaleoProcessParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, ddmStructureId, nameMap, descriptionMap,
				ddmTemplateId, workflowDefinitionName,
				workflowDefinitionVersion, kaleoTaskFormPairs, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess
			deleteKaleoProcess(HttpPrincipal httpPrincipal, long kaleoProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				KaleoProcessServiceUtil.class, "deleteKaleoProcess",
				_deleteKaleoProcessParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, kaleoProcessId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess
			getKaleoProcess(HttpPrincipal httpPrincipal, long kaleoProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				KaleoProcessServiceUtil.class, "getKaleoProcess",
				_getKaleoProcessParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, kaleoProcessId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess> search(
			HttpPrincipal httpPrincipal, long groupId, String keywords,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess>
					orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				KaleoProcessServiceUtil.class, "search",
				_searchParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, keywords, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int searchCount(
		HttpPrincipal httpPrincipal, long groupId, String keywords) {

		try {
			MethodKey methodKey = new MethodKey(
				KaleoProcessServiceUtil.class, "searchCount",
				_searchCountParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess
			updateKaleoProcess(
				HttpPrincipal httpPrincipal, long kaleoProcessId,
				long ddmStructureId,
				java.util.Map<java.util.Locale, String> nameMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				long ddmTemplateId, String workflowDefinitionName,
				int workflowDefinitionVersion,
				com.liferay.portal.workflow.kaleo.forms.model.KaleoTaskFormPairs
					kaleoTaskFormPairs,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				KaleoProcessServiceUtil.class, "updateKaleoProcess",
				_updateKaleoProcessParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, kaleoProcessId, ddmStructureId, nameMap,
				descriptionMap, ddmTemplateId, workflowDefinitionName,
				workflowDefinitionVersion, kaleoTaskFormPairs, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		KaleoProcessServiceHttp.class);

	private static final Class<?>[] _addKaleoProcessParameterTypes0 =
		new Class[] {
			long.class, long.class, java.util.Map.class, java.util.Map.class,
			long.class, String.class, int.class,
			com.liferay.portal.workflow.kaleo.forms.model.KaleoTaskFormPairs.
				class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteKaleoProcessParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _getKaleoProcessParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _searchParameterTypes3 = new Class[] {
		long.class, String.class, int.class, int.class,
		com.liferay.portal.kernel.util.OrderByComparator.class
	};
	private static final Class<?>[] _searchCountParameterTypes4 = new Class[] {
		long.class, String.class
	};
	private static final Class<?>[] _updateKaleoProcessParameterTypes5 =
		new Class[] {
			long.class, long.class, java.util.Map.class, java.util.Map.class,
			long.class, String.class, int.class,
			com.liferay.portal.workflow.kaleo.forms.model.KaleoTaskFormPairs.
				class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};

}