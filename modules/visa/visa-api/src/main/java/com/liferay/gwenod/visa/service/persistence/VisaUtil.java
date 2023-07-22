/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.gwenod.visa.service.persistence;

import com.liferay.gwenod.visa.model.Visa;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the visa service. This utility wraps <code>com.liferay.gwenod.visa.service.persistence.impl.VisaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VisaPersistence
 * @generated
 */
public class VisaUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Visa visa) {
		getPersistence().clearCache(visa);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Visa> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Visa> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Visa> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Visa> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Visa update(Visa visa) {
		return getPersistence().update(visa);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Visa update(Visa visa, ServiceContext serviceContext) {
		return getPersistence().update(visa, serviceContext);
	}

	/**
	 * Returns all the visas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching visas
	 */
	public static List<Visa> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the visas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @return the range of matching visas
	 */
	public static List<Visa> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the visas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visas
	 */
	public static List<Visa> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visas
	 */
	public static List<Visa> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Visa> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first visa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public static Visa findByUuid_First(
			String uuid, OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first visa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchByUuid_First(
		String uuid, OrderByComparator<Visa> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last visa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public static Visa findByUuid_Last(
			String uuid, OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last visa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchByUuid_Last(
		String uuid, OrderByComparator<Visa> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the visas before and after the current visa in the ordered set where uuid = &#63;.
	 *
	 * @param visaId the primary key of the current visa
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public static Visa[] findByUuid_PrevAndNext(
			long visaId, String uuid, OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByUuid_PrevAndNext(
			visaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the visas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of visas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching visas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the visa where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVisaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public static Visa findByUUID_G(String uuid, long groupId)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the visa where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the visa where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the visa where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the visa that was removed
	 */
	public static Visa removeByUUID_G(String uuid, long groupId)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of visas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching visas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the visas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching visas
	 */
	public static List<Visa> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the visas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @return the range of matching visas
	 */
	public static List<Visa> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the visas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visas
	 */
	public static List<Visa> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visas
	 */
	public static List<Visa> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Visa> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first visa in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public static Visa findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first visa in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Visa> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last visa in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public static Visa findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last visa in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Visa> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the visas before and after the current visa in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param visaId the primary key of the current visa
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public static Visa[] findByUuid_C_PrevAndNext(
			long visaId, String uuid, long companyId,
			OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByUuid_C_PrevAndNext(
			visaId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the visas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of visas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching visas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the visas where cin = &#63;.
	 *
	 * @param cin the cin
	 * @return the matching visas
	 */
	public static List<Visa> findByCin(String cin) {
		return getPersistence().findByCin(cin);
	}

	/**
	 * Returns a range of all the visas where cin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param cin the cin
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @return the range of matching visas
	 */
	public static List<Visa> findByCin(String cin, int start, int end) {
		return getPersistence().findByCin(cin, start, end);
	}

	/**
	 * Returns an ordered range of all the visas where cin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param cin the cin
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visas
	 */
	public static List<Visa> findByCin(
		String cin, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return getPersistence().findByCin(cin, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visas where cin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param cin the cin
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visas
	 */
	public static List<Visa> findByCin(
		String cin, int start, int end,
		OrderByComparator<Visa> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCin(
			cin, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first visa in the ordered set where cin = &#63;.
	 *
	 * @param cin the cin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public static Visa findByCin_First(
			String cin, OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByCin_First(cin, orderByComparator);
	}

	/**
	 * Returns the first visa in the ordered set where cin = &#63;.
	 *
	 * @param cin the cin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchByCin_First(
		String cin, OrderByComparator<Visa> orderByComparator) {

		return getPersistence().fetchByCin_First(cin, orderByComparator);
	}

	/**
	 * Returns the last visa in the ordered set where cin = &#63;.
	 *
	 * @param cin the cin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public static Visa findByCin_Last(
			String cin, OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByCin_Last(cin, orderByComparator);
	}

	/**
	 * Returns the last visa in the ordered set where cin = &#63;.
	 *
	 * @param cin the cin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchByCin_Last(
		String cin, OrderByComparator<Visa> orderByComparator) {

		return getPersistence().fetchByCin_Last(cin, orderByComparator);
	}

	/**
	 * Returns the visas before and after the current visa in the ordered set where cin = &#63;.
	 *
	 * @param visaId the primary key of the current visa
	 * @param cin the cin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public static Visa[] findByCin_PrevAndNext(
			long visaId, String cin, OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByCin_PrevAndNext(
			visaId, cin, orderByComparator);
	}

	/**
	 * Removes all the visas where cin = &#63; from the database.
	 *
	 * @param cin the cin
	 */
	public static void removeByCin(String cin) {
		getPersistence().removeByCin(cin);
	}

	/**
	 * Returns the number of visas where cin = &#63;.
	 *
	 * @param cin the cin
	 * @return the number of matching visas
	 */
	public static int countByCin(String cin) {
		return getPersistence().countByCin(cin);
	}

	/**
	 * Returns all the visas where passport = &#63;.
	 *
	 * @param passport the passport
	 * @return the matching visas
	 */
	public static List<Visa> findByPassport(String passport) {
		return getPersistence().findByPassport(passport);
	}

	/**
	 * Returns a range of all the visas where passport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param passport the passport
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @return the range of matching visas
	 */
	public static List<Visa> findByPassport(
		String passport, int start, int end) {

		return getPersistence().findByPassport(passport, start, end);
	}

	/**
	 * Returns an ordered range of all the visas where passport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param passport the passport
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visas
	 */
	public static List<Visa> findByPassport(
		String passport, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return getPersistence().findByPassport(
			passport, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visas where passport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param passport the passport
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visas
	 */
	public static List<Visa> findByPassport(
		String passport, int start, int end,
		OrderByComparator<Visa> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByPassport(
			passport, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first visa in the ordered set where passport = &#63;.
	 *
	 * @param passport the passport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public static Visa findByPassport_First(
			String passport, OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByPassport_First(
			passport, orderByComparator);
	}

	/**
	 * Returns the first visa in the ordered set where passport = &#63;.
	 *
	 * @param passport the passport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchByPassport_First(
		String passport, OrderByComparator<Visa> orderByComparator) {

		return getPersistence().fetchByPassport_First(
			passport, orderByComparator);
	}

	/**
	 * Returns the last visa in the ordered set where passport = &#63;.
	 *
	 * @param passport the passport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public static Visa findByPassport_Last(
			String passport, OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByPassport_Last(
			passport, orderByComparator);
	}

	/**
	 * Returns the last visa in the ordered set where passport = &#63;.
	 *
	 * @param passport the passport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchByPassport_Last(
		String passport, OrderByComparator<Visa> orderByComparator) {

		return getPersistence().fetchByPassport_Last(
			passport, orderByComparator);
	}

	/**
	 * Returns the visas before and after the current visa in the ordered set where passport = &#63;.
	 *
	 * @param visaId the primary key of the current visa
	 * @param passport the passport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public static Visa[] findByPassport_PrevAndNext(
			long visaId, String passport,
			OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByPassport_PrevAndNext(
			visaId, passport, orderByComparator);
	}

	/**
	 * Removes all the visas where passport = &#63; from the database.
	 *
	 * @param passport the passport
	 */
	public static void removeByPassport(String passport) {
		getPersistence().removeByPassport(passport);
	}

	/**
	 * Returns the number of visas where passport = &#63;.
	 *
	 * @param passport the passport
	 * @return the number of matching visas
	 */
	public static int countByPassport(String passport) {
		return getPersistence().countByPassport(passport);
	}

	/**
	 * Returns all the visas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching visas
	 */
	public static List<Visa> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the visas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @return the range of matching visas
	 */
	public static List<Visa> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the visas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visas
	 */
	public static List<Visa> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visas
	 */
	public static List<Visa> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Visa> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first visa in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public static Visa findByUserId_First(
			long userId, OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first visa in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchByUserId_First(
		long userId, OrderByComparator<Visa> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last visa in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public static Visa findByUserId_Last(
			long userId, OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last visa in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchByUserId_Last(
		long userId, OrderByComparator<Visa> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the visas before and after the current visa in the ordered set where userId = &#63;.
	 *
	 * @param visaId the primary key of the current visa
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public static Visa[] findByUserId_PrevAndNext(
			long visaId, long userId, OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByUserId_PrevAndNext(
			visaId, userId, orderByComparator);
	}

	/**
	 * Removes all the visas where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of visas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching visas
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the visas where etat = &#63;.
	 *
	 * @param etat the etat
	 * @return the matching visas
	 */
	public static List<Visa> findByEtat(int etat) {
		return getPersistence().findByEtat(etat);
	}

	/**
	 * Returns a range of all the visas where etat = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param etat the etat
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @return the range of matching visas
	 */
	public static List<Visa> findByEtat(int etat, int start, int end) {
		return getPersistence().findByEtat(etat, start, end);
	}

	/**
	 * Returns an ordered range of all the visas where etat = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param etat the etat
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visas
	 */
	public static List<Visa> findByEtat(
		int etat, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return getPersistence().findByEtat(etat, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visas where etat = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param etat the etat
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visas
	 */
	public static List<Visa> findByEtat(
		int etat, int start, int end, OrderByComparator<Visa> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEtat(
			etat, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first visa in the ordered set where etat = &#63;.
	 *
	 * @param etat the etat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public static Visa findByEtat_First(
			int etat, OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByEtat_First(etat, orderByComparator);
	}

	/**
	 * Returns the first visa in the ordered set where etat = &#63;.
	 *
	 * @param etat the etat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchByEtat_First(
		int etat, OrderByComparator<Visa> orderByComparator) {

		return getPersistence().fetchByEtat_First(etat, orderByComparator);
	}

	/**
	 * Returns the last visa in the ordered set where etat = &#63;.
	 *
	 * @param etat the etat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public static Visa findByEtat_Last(
			int etat, OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByEtat_Last(etat, orderByComparator);
	}

	/**
	 * Returns the last visa in the ordered set where etat = &#63;.
	 *
	 * @param etat the etat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchByEtat_Last(
		int etat, OrderByComparator<Visa> orderByComparator) {

		return getPersistence().fetchByEtat_Last(etat, orderByComparator);
	}

	/**
	 * Returns the visas before and after the current visa in the ordered set where etat = &#63;.
	 *
	 * @param visaId the primary key of the current visa
	 * @param etat the etat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public static Visa[] findByEtat_PrevAndNext(
			long visaId, int etat, OrderByComparator<Visa> orderByComparator)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByEtat_PrevAndNext(
			visaId, etat, orderByComparator);
	}

	/**
	 * Removes all the visas where etat = &#63; from the database.
	 *
	 * @param etat the etat
	 */
	public static void removeByEtat(int etat) {
		getPersistence().removeByEtat(etat);
	}

	/**
	 * Returns the number of visas where etat = &#63;.
	 *
	 * @param etat the etat
	 * @return the number of matching visas
	 */
	public static int countByEtat(int etat) {
		return getPersistence().countByEtat(etat);
	}

	/**
	 * Caches the visa in the entity cache if it is enabled.
	 *
	 * @param visa the visa
	 */
	public static void cacheResult(Visa visa) {
		getPersistence().cacheResult(visa);
	}

	/**
	 * Caches the visas in the entity cache if it is enabled.
	 *
	 * @param visas the visas
	 */
	public static void cacheResult(List<Visa> visas) {
		getPersistence().cacheResult(visas);
	}

	/**
	 * Creates a new visa with the primary key. Does not add the visa to the database.
	 *
	 * @param visaId the primary key for the new visa
	 * @return the new visa
	 */
	public static Visa create(long visaId) {
		return getPersistence().create(visaId);
	}

	/**
	 * Removes the visa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param visaId the primary key of the visa
	 * @return the visa that was removed
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public static Visa remove(long visaId)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().remove(visaId);
	}

	public static Visa updateImpl(Visa visa) {
		return getPersistence().updateImpl(visa);
	}

	/**
	 * Returns the visa with the primary key or throws a <code>NoSuchVisaException</code> if it could not be found.
	 *
	 * @param visaId the primary key of the visa
	 * @return the visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public static Visa findByPrimaryKey(long visaId)
		throws com.liferay.gwenod.visa.exception.NoSuchVisaException {

		return getPersistence().findByPrimaryKey(visaId);
	}

	/**
	 * Returns the visa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param visaId the primary key of the visa
	 * @return the visa, or <code>null</code> if a visa with the primary key could not be found
	 */
	public static Visa fetchByPrimaryKey(long visaId) {
		return getPersistence().fetchByPrimaryKey(visaId);
	}

	/**
	 * Returns all the visas.
	 *
	 * @return the visas
	 */
	public static List<Visa> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the visas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @return the range of visas
	 */
	public static List<Visa> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the visas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of visas
	 */
	public static List<Visa> findAll(
		int start, int end, OrderByComparator<Visa> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of visas
	 */
	public static List<Visa> findAll(
		int start, int end, OrderByComparator<Visa> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the visas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of visas.
	 *
	 * @return the number of visas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VisaPersistence getPersistence() {
		return _persistence;
	}

	private static volatile VisaPersistence _persistence;

}