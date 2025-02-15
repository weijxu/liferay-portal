/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.security.service.access.policy.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.security.service.access.policy.service.SAPEntryServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>SAPEntryServiceUtil</code> service
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
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SAPEntryServiceHttp {

	public static
		com.liferay.portal.security.service.access.policy.model.SAPEntry
				addSAPEntry(
					HttpPrincipal httpPrincipal,
					String allowedServiceSignatures, boolean defaultSAPEntry,
					boolean enabled, String name,
					java.util.Map<java.util.Locale, String> titleMap,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SAPEntryServiceUtil.class, "addSAPEntry",
				_addSAPEntryParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, allowedServiceSignatures, defaultSAPEntry, enabled,
				name, titleMap, serviceContext);

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

			return (com.liferay.portal.security.service.access.policy.model.
				SAPEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static
		com.liferay.portal.security.service.access.policy.model.SAPEntry
				deleteSAPEntry(HttpPrincipal httpPrincipal, long sapEntryId)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SAPEntryServiceUtil.class, "deleteSAPEntry",
				_deleteSAPEntryParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, sapEntryId);

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

			return (com.liferay.portal.security.service.access.policy.model.
				SAPEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static
		com.liferay.portal.security.service.access.policy.model.SAPEntry
				deleteSAPEntry(
					HttpPrincipal httpPrincipal,
					com.liferay.portal.security.service.access.policy.model.
						SAPEntry sapEntry)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SAPEntryServiceUtil.class, "deleteSAPEntry",
				_deleteSAPEntryParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, sapEntry);

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

			return (com.liferay.portal.security.service.access.policy.model.
				SAPEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static
		com.liferay.portal.security.service.access.policy.model.SAPEntry
				fetchSAPEntry(
					HttpPrincipal httpPrincipal, long companyId, String name)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SAPEntryServiceUtil.class, "fetchSAPEntry",
				_fetchSAPEntryParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, name);

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

			return (com.liferay.portal.security.service.access.policy.model.
				SAPEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.portal.security.service.access.policy.model.SAPEntry>
			getCompanySAPEntries(
				HttpPrincipal httpPrincipal, long companyId, int start,
				int end) {

		try {
			MethodKey methodKey = new MethodKey(
				SAPEntryServiceUtil.class, "getCompanySAPEntries",
				_getCompanySAPEntriesParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.portal.security.service.access.policy.model.
					SAPEntry>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.portal.security.service.access.policy.model.SAPEntry>
			getCompanySAPEntries(
				HttpPrincipal httpPrincipal, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.portal.security.service.access.policy.model.
						SAPEntry> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				SAPEntryServiceUtil.class, "getCompanySAPEntries",
				_getCompanySAPEntriesParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.portal.security.service.access.policy.model.
					SAPEntry>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getCompanySAPEntriesCount(
		HttpPrincipal httpPrincipal, long companyId) {

		try {
			MethodKey methodKey = new MethodKey(
				SAPEntryServiceUtil.class, "getCompanySAPEntriesCount",
				_getCompanySAPEntriesCountParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId);

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

	public static
		com.liferay.portal.security.service.access.policy.model.SAPEntry
				getSAPEntry(HttpPrincipal httpPrincipal, long sapEntryId)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SAPEntryServiceUtil.class, "getSAPEntry",
				_getSAPEntryParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, sapEntryId);

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

			return (com.liferay.portal.security.service.access.policy.model.
				SAPEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static
		com.liferay.portal.security.service.access.policy.model.SAPEntry
				getSAPEntry(
					HttpPrincipal httpPrincipal, long companyId, String name)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SAPEntryServiceUtil.class, "getSAPEntry",
				_getSAPEntryParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, name);

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

			return (com.liferay.portal.security.service.access.policy.model.
				SAPEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static
		com.liferay.portal.security.service.access.policy.model.SAPEntry
				updateSAPEntry(
					HttpPrincipal httpPrincipal, long sapEntryId,
					String allowedServiceSignatures, boolean defaultSAPEntry,
					boolean enabled, String name,
					java.util.Map<java.util.Locale, String> titleMap,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SAPEntryServiceUtil.class, "updateSAPEntry",
				_updateSAPEntryParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, sapEntryId, allowedServiceSignatures,
				defaultSAPEntry, enabled, name, titleMap, serviceContext);

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

			return (com.liferay.portal.security.service.access.policy.model.
				SAPEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SAPEntryServiceHttp.class);

	private static final Class<?>[] _addSAPEntryParameterTypes0 = new Class[] {
		String.class, boolean.class, boolean.class, String.class,
		java.util.Map.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteSAPEntryParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _deleteSAPEntryParameterTypes2 =
		new Class[] {
			com.liferay.portal.security.service.access.policy.model.SAPEntry.
				class
		};
	private static final Class<?>[] _fetchSAPEntryParameterTypes3 =
		new Class[] {long.class, String.class};
	private static final Class<?>[] _getCompanySAPEntriesParameterTypes4 =
		new Class[] {long.class, int.class, int.class};
	private static final Class<?>[] _getCompanySAPEntriesParameterTypes5 =
		new Class[] {
			long.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getCompanySAPEntriesCountParameterTypes6 =
		new Class[] {long.class};
	private static final Class<?>[] _getSAPEntryParameterTypes7 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getSAPEntryParameterTypes8 = new Class[] {
		long.class, String.class
	};
	private static final Class<?>[] _updateSAPEntryParameterTypes9 =
		new Class[] {
			long.class, String.class, boolean.class, boolean.class,
			String.class, java.util.Map.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};

}