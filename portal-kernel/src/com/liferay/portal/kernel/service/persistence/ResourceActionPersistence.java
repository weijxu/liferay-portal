/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.kernel.service.persistence;

import com.liferay.portal.kernel.exception.NoSuchResourceActionException;
import com.liferay.portal.kernel.model.ResourceAction;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the resource action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceActionUtil
 * @generated
 */
@ProviderType
public interface ResourceActionPersistence
	extends BasePersistence<ResourceAction> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResourceActionUtil} to access the resource action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the resource actions where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching resource actions
	 */
	public java.util.List<ResourceAction> findByName(String name);

	/**
	 * Returns a range of all the resource actions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceActionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of resource actions
	 * @param end the upper bound of the range of resource actions (not inclusive)
	 * @return the range of matching resource actions
	 */
	public java.util.List<ResourceAction> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the resource actions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceActionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of resource actions
	 * @param end the upper bound of the range of resource actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource actions
	 */
	public java.util.List<ResourceAction> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceAction>
			orderByComparator);

	/**
	 * Returns an ordered range of all the resource actions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceActionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of resource actions
	 * @param end the upper bound of the range of resource actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource actions
	 */
	public java.util.List<ResourceAction> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceAction>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first resource action in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource action
	 * @throws NoSuchResourceActionException if a matching resource action could not be found
	 */
	public ResourceAction findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceAction>
				orderByComparator)
		throws NoSuchResourceActionException;

	/**
	 * Returns the first resource action in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource action, or <code>null</code> if a matching resource action could not be found
	 */
	public ResourceAction fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceAction>
			orderByComparator);

	/**
	 * Returns the last resource action in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource action
	 * @throws NoSuchResourceActionException if a matching resource action could not be found
	 */
	public ResourceAction findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceAction>
				orderByComparator)
		throws NoSuchResourceActionException;

	/**
	 * Returns the last resource action in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource action, or <code>null</code> if a matching resource action could not be found
	 */
	public ResourceAction fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceAction>
			orderByComparator);

	/**
	 * Returns the resource actions before and after the current resource action in the ordered set where name = &#63;.
	 *
	 * @param resourceActionId the primary key of the current resource action
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource action
	 * @throws NoSuchResourceActionException if a resource action with the primary key could not be found
	 */
	public ResourceAction[] findByName_PrevAndNext(
			long resourceActionId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceAction>
				orderByComparator)
		throws NoSuchResourceActionException;

	/**
	 * Removes all the resource actions where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of resource actions where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching resource actions
	 */
	public int countByName(String name);

	/**
	 * Returns the resource action where name = &#63; and actionId = &#63; or throws a <code>NoSuchResourceActionException</code> if it could not be found.
	 *
	 * @param name the name
	 * @param actionId the action ID
	 * @return the matching resource action
	 * @throws NoSuchResourceActionException if a matching resource action could not be found
	 */
	public ResourceAction findByN_A(String name, String actionId)
		throws NoSuchResourceActionException;

	/**
	 * Returns the resource action where name = &#63; and actionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param actionId the action ID
	 * @return the matching resource action, or <code>null</code> if a matching resource action could not be found
	 */
	public ResourceAction fetchByN_A(String name, String actionId);

	/**
	 * Returns the resource action where name = &#63; and actionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param actionId the action ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource action, or <code>null</code> if a matching resource action could not be found
	 */
	public ResourceAction fetchByN_A(
		String name, String actionId, boolean useFinderCache);

	/**
	 * Removes the resource action where name = &#63; and actionId = &#63; from the database.
	 *
	 * @param name the name
	 * @param actionId the action ID
	 * @return the resource action that was removed
	 */
	public ResourceAction removeByN_A(String name, String actionId)
		throws NoSuchResourceActionException;

	/**
	 * Returns the number of resource actions where name = &#63; and actionId = &#63;.
	 *
	 * @param name the name
	 * @param actionId the action ID
	 * @return the number of matching resource actions
	 */
	public int countByN_A(String name, String actionId);

	/**
	 * Caches the resource action in the entity cache if it is enabled.
	 *
	 * @param resourceAction the resource action
	 */
	public void cacheResult(ResourceAction resourceAction);

	/**
	 * Caches the resource actions in the entity cache if it is enabled.
	 *
	 * @param resourceActions the resource actions
	 */
	public void cacheResult(java.util.List<ResourceAction> resourceActions);

	/**
	 * Creates a new resource action with the primary key. Does not add the resource action to the database.
	 *
	 * @param resourceActionId the primary key for the new resource action
	 * @return the new resource action
	 */
	public ResourceAction create(long resourceActionId);

	/**
	 * Removes the resource action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceActionId the primary key of the resource action
	 * @return the resource action that was removed
	 * @throws NoSuchResourceActionException if a resource action with the primary key could not be found
	 */
	public ResourceAction remove(long resourceActionId)
		throws NoSuchResourceActionException;

	public ResourceAction updateImpl(ResourceAction resourceAction);

	/**
	 * Returns the resource action with the primary key or throws a <code>NoSuchResourceActionException</code> if it could not be found.
	 *
	 * @param resourceActionId the primary key of the resource action
	 * @return the resource action
	 * @throws NoSuchResourceActionException if a resource action with the primary key could not be found
	 */
	public ResourceAction findByPrimaryKey(long resourceActionId)
		throws NoSuchResourceActionException;

	/**
	 * Returns the resource action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceActionId the primary key of the resource action
	 * @return the resource action, or <code>null</code> if a resource action with the primary key could not be found
	 */
	public ResourceAction fetchByPrimaryKey(long resourceActionId);

	/**
	 * Returns all the resource actions.
	 *
	 * @return the resource actions
	 */
	public java.util.List<ResourceAction> findAll();

	/**
	 * Returns a range of all the resource actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceActionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource actions
	 * @param end the upper bound of the range of resource actions (not inclusive)
	 * @return the range of resource actions
	 */
	public java.util.List<ResourceAction> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the resource actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceActionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource actions
	 * @param end the upper bound of the range of resource actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of resource actions
	 */
	public java.util.List<ResourceAction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceAction>
			orderByComparator);

	/**
	 * Returns an ordered range of all the resource actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceActionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource actions
	 * @param end the upper bound of the range of resource actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of resource actions
	 */
	public java.util.List<ResourceAction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceAction>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the resource actions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of resource actions.
	 *
	 * @return the number of resource actions
	 */
	public int countAll();

}