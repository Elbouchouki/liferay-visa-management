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

import com.liferay.gwenod.visa.exception.NoSuchVisaException;
import com.liferay.gwenod.visa.model.Visa;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the visa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VisaUtil
 * @generated
 */
@ProviderType
public interface VisaPersistence extends BasePersistence<Visa> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VisaUtil} to access the visa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the visas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching visas
	 */
	public java.util.List<Visa> findByUuid(String uuid);

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
	public java.util.List<Visa> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Visa> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

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
	public java.util.List<Visa> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public Visa findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Returns the first visa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public Visa fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

	/**
	 * Returns the last visa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public Visa findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Returns the last visa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public Visa fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

	/**
	 * Returns the visas before and after the current visa in the ordered set where uuid = &#63;.
	 *
	 * @param visaId the primary key of the current visa
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public Visa[] findByUuid_PrevAndNext(
			long visaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Removes all the visas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of visas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching visas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the visa where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVisaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public Visa findByUUID_G(String uuid, long groupId)
		throws NoSuchVisaException;

	/**
	 * Returns the visa where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public Visa fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the visa where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public Visa fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the visa where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the visa that was removed
	 */
	public Visa removeByUUID_G(String uuid, long groupId)
		throws NoSuchVisaException;

	/**
	 * Returns the number of visas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching visas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the visas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching visas
	 */
	public java.util.List<Visa> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Visa> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Visa> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

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
	public java.util.List<Visa> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visa in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public Visa findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Returns the first visa in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public Visa fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

	/**
	 * Returns the last visa in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public Visa findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Returns the last visa in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public Visa fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

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
	public Visa[] findByUuid_C_PrevAndNext(
			long visaId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Removes all the visas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of visas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching visas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the visas where cin = &#63;.
	 *
	 * @param cin the cin
	 * @return the matching visas
	 */
	public java.util.List<Visa> findByCin(String cin);

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
	public java.util.List<Visa> findByCin(String cin, int start, int end);

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
	public java.util.List<Visa> findByCin(
		String cin, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

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
	public java.util.List<Visa> findByCin(
		String cin, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visa in the ordered set where cin = &#63;.
	 *
	 * @param cin the cin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public Visa findByCin_First(
			String cin,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Returns the first visa in the ordered set where cin = &#63;.
	 *
	 * @param cin the cin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public Visa fetchByCin_First(
		String cin,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

	/**
	 * Returns the last visa in the ordered set where cin = &#63;.
	 *
	 * @param cin the cin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public Visa findByCin_Last(
			String cin,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Returns the last visa in the ordered set where cin = &#63;.
	 *
	 * @param cin the cin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public Visa fetchByCin_Last(
		String cin,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

	/**
	 * Returns the visas before and after the current visa in the ordered set where cin = &#63;.
	 *
	 * @param visaId the primary key of the current visa
	 * @param cin the cin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public Visa[] findByCin_PrevAndNext(
			long visaId, String cin,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Removes all the visas where cin = &#63; from the database.
	 *
	 * @param cin the cin
	 */
	public void removeByCin(String cin);

	/**
	 * Returns the number of visas where cin = &#63;.
	 *
	 * @param cin the cin
	 * @return the number of matching visas
	 */
	public int countByCin(String cin);

	/**
	 * Returns all the visas where passport = &#63;.
	 *
	 * @param passport the passport
	 * @return the matching visas
	 */
	public java.util.List<Visa> findByPassport(String passport);

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
	public java.util.List<Visa> findByPassport(
		String passport, int start, int end);

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
	public java.util.List<Visa> findByPassport(
		String passport, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

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
	public java.util.List<Visa> findByPassport(
		String passport, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visa in the ordered set where passport = &#63;.
	 *
	 * @param passport the passport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public Visa findByPassport_First(
			String passport,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Returns the first visa in the ordered set where passport = &#63;.
	 *
	 * @param passport the passport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public Visa fetchByPassport_First(
		String passport,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

	/**
	 * Returns the last visa in the ordered set where passport = &#63;.
	 *
	 * @param passport the passport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public Visa findByPassport_Last(
			String passport,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Returns the last visa in the ordered set where passport = &#63;.
	 *
	 * @param passport the passport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public Visa fetchByPassport_Last(
		String passport,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

	/**
	 * Returns the visas before and after the current visa in the ordered set where passport = &#63;.
	 *
	 * @param visaId the primary key of the current visa
	 * @param passport the passport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public Visa[] findByPassport_PrevAndNext(
			long visaId, String passport,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Removes all the visas where passport = &#63; from the database.
	 *
	 * @param passport the passport
	 */
	public void removeByPassport(String passport);

	/**
	 * Returns the number of visas where passport = &#63;.
	 *
	 * @param passport the passport
	 * @return the number of matching visas
	 */
	public int countByPassport(String passport);

	/**
	 * Returns all the visas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching visas
	 */
	public java.util.List<Visa> findByUserId(long userId);

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
	public java.util.List<Visa> findByUserId(long userId, int start, int end);

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
	public java.util.List<Visa> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

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
	public java.util.List<Visa> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visa in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public Visa findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Returns the first visa in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public Visa fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

	/**
	 * Returns the last visa in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public Visa findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Returns the last visa in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public Visa fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

	/**
	 * Returns the visas before and after the current visa in the ordered set where userId = &#63;.
	 *
	 * @param visaId the primary key of the current visa
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public Visa[] findByUserId_PrevAndNext(
			long visaId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Removes all the visas where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of visas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching visas
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the visas where etat = &#63;.
	 *
	 * @param etat the etat
	 * @return the matching visas
	 */
	public java.util.List<Visa> findByEtat(int etat);

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
	public java.util.List<Visa> findByEtat(int etat, int start, int end);

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
	public java.util.List<Visa> findByEtat(
		int etat, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

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
	public java.util.List<Visa> findByEtat(
		int etat, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visa in the ordered set where etat = &#63;.
	 *
	 * @param etat the etat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public Visa findByEtat_First(
			int etat,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Returns the first visa in the ordered set where etat = &#63;.
	 *
	 * @param etat the etat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public Visa fetchByEtat_First(
		int etat,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

	/**
	 * Returns the last visa in the ordered set where etat = &#63;.
	 *
	 * @param etat the etat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	public Visa findByEtat_Last(
			int etat,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Returns the last visa in the ordered set where etat = &#63;.
	 *
	 * @param etat the etat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public Visa fetchByEtat_Last(
		int etat,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

	/**
	 * Returns the visas before and after the current visa in the ordered set where etat = &#63;.
	 *
	 * @param visaId the primary key of the current visa
	 * @param etat the etat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public Visa[] findByEtat_PrevAndNext(
			long visaId, int etat,
			com.liferay.portal.kernel.util.OrderByComparator<Visa>
				orderByComparator)
		throws NoSuchVisaException;

	/**
	 * Removes all the visas where etat = &#63; from the database.
	 *
	 * @param etat the etat
	 */
	public void removeByEtat(int etat);

	/**
	 * Returns the number of visas where etat = &#63;.
	 *
	 * @param etat the etat
	 * @return the number of matching visas
	 */
	public int countByEtat(int etat);

	/**
	 * Caches the visa in the entity cache if it is enabled.
	 *
	 * @param visa the visa
	 */
	public void cacheResult(Visa visa);

	/**
	 * Caches the visas in the entity cache if it is enabled.
	 *
	 * @param visas the visas
	 */
	public void cacheResult(java.util.List<Visa> visas);

	/**
	 * Creates a new visa with the primary key. Does not add the visa to the database.
	 *
	 * @param visaId the primary key for the new visa
	 * @return the new visa
	 */
	public Visa create(long visaId);

	/**
	 * Removes the visa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param visaId the primary key of the visa
	 * @return the visa that was removed
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public Visa remove(long visaId) throws NoSuchVisaException;

	public Visa updateImpl(Visa visa);

	/**
	 * Returns the visa with the primary key or throws a <code>NoSuchVisaException</code> if it could not be found.
	 *
	 * @param visaId the primary key of the visa
	 * @return the visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	public Visa findByPrimaryKey(long visaId) throws NoSuchVisaException;

	/**
	 * Returns the visa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param visaId the primary key of the visa
	 * @return the visa, or <code>null</code> if a visa with the primary key could not be found
	 */
	public Visa fetchByPrimaryKey(long visaId);

	/**
	 * Returns all the visas.
	 *
	 * @return the visas
	 */
	public java.util.List<Visa> findAll();

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
	public java.util.List<Visa> findAll(int start, int end);

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
	public java.util.List<Visa> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator);

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
	public java.util.List<Visa> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visa>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the visas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of visas.
	 *
	 * @return the number of visas
	 */
	public int countAll();

}