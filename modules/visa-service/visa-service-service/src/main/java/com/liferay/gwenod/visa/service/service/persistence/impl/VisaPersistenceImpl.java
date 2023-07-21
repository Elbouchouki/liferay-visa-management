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

package com.liferay.gwenod.visa.service.service.persistence.impl;

import com.liferay.gwenod.visa.service.exception.NoSuchVisaException;
import com.liferay.gwenod.visa.service.model.Visa;
import com.liferay.gwenod.visa.service.model.VisaTable;
import com.liferay.gwenod.visa.service.model.impl.VisaImpl;
import com.liferay.gwenod.visa.service.model.impl.VisaModelImpl;
import com.liferay.gwenod.visa.service.service.persistence.VisaPersistence;
import com.liferay.gwenod.visa.service.service.persistence.VisaUtil;
import com.liferay.gwenod.visa.service.service.persistence.impl.constants.VisaManagementPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the visa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = VisaPersistence.class)
public class VisaPersistenceImpl
	extends BasePersistenceImpl<Visa> implements VisaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VisaUtil</code> to access the visa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VisaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the visas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching visas
	 */
	@Override
	public List<Visa> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Visa> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Visa> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Visa> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Visa> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Visa> list = null;

		if (useFinderCache) {
			list = (List<Visa>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Visa visa : list) {
					if (!uuid.equals(visa.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_VISA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VisaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Visa>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first visa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	@Override
	public Visa findByUuid_First(
			String uuid, OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		Visa visa = fetchByUuid_First(uuid, orderByComparator);

		if (visa != null) {
			return visa;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchVisaException(sb.toString());
	}

	/**
	 * Returns the first visa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public Visa fetchByUuid_First(
		String uuid, OrderByComparator<Visa> orderByComparator) {

		List<Visa> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	@Override
	public Visa findByUuid_Last(
			String uuid, OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		Visa visa = fetchByUuid_Last(uuid, orderByComparator);

		if (visa != null) {
			return visa;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchVisaException(sb.toString());
	}

	/**
	 * Returns the last visa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public Visa fetchByUuid_Last(
		String uuid, OrderByComparator<Visa> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Visa> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Visa[] findByUuid_PrevAndNext(
			long visaId, String uuid, OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		uuid = Objects.toString(uuid, "");

		Visa visa = findByPrimaryKey(visaId);

		Session session = null;

		try {
			session = openSession();

			Visa[] array = new VisaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, visa, uuid, orderByComparator, true);

			array[1] = visa;

			array[2] = getByUuid_PrevAndNext(
				session, visa, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Visa getByUuid_PrevAndNext(
		Session session, Visa visa, String uuid,
		OrderByComparator<Visa> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VISA_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(VisaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(visa)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Visa> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Visa visa :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(visa);
		}
	}

	/**
	 * Returns the number of visas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching visas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VISA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "visa.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(visa.uuid IS NULL OR visa.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the visa where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVisaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	@Override
	public Visa findByUUID_G(String uuid, long groupId)
		throws NoSuchVisaException {

		Visa visa = fetchByUUID_G(uuid, groupId);

		if (visa == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchVisaException(sb.toString());
		}

		return visa;
	}

	/**
	 * Returns the visa where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public Visa fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the visa where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public Visa fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Visa) {
			Visa visa = (Visa)result;

			if (!Objects.equals(uuid, visa.getUuid()) ||
				(groupId != visa.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_VISA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Visa> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Visa visa = list.get(0);

					result = visa;

					cacheResult(visa);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Visa)result;
		}
	}

	/**
	 * Removes the visa where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the visa that was removed
	 */
	@Override
	public Visa removeByUUID_G(String uuid, long groupId)
		throws NoSuchVisaException {

		Visa visa = findByUUID_G(uuid, groupId);

		return remove(visa);
	}

	/**
	 * Returns the number of visas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching visas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VISA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"visa.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(visa.uuid IS NULL OR visa.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"visa.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the visas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching visas
	 */
	@Override
	public List<Visa> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Visa> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Visa> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Visa> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Visa> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Visa> list = null;

		if (useFinderCache) {
			list = (List<Visa>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Visa visa : list) {
					if (!uuid.equals(visa.getUuid()) ||
						(companyId != visa.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_VISA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VisaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Visa>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Visa findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		Visa visa = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (visa != null) {
			return visa;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVisaException(sb.toString());
	}

	/**
	 * Returns the first visa in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public Visa fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Visa> orderByComparator) {

		List<Visa> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Visa findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		Visa visa = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (visa != null) {
			return visa;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVisaException(sb.toString());
	}

	/**
	 * Returns the last visa in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public Visa fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Visa> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Visa> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Visa[] findByUuid_C_PrevAndNext(
			long visaId, String uuid, long companyId,
			OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		uuid = Objects.toString(uuid, "");

		Visa visa = findByPrimaryKey(visaId);

		Session session = null;

		try {
			session = openSession();

			Visa[] array = new VisaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, visa, uuid, companyId, orderByComparator, true);

			array[1] = visa;

			array[2] = getByUuid_C_PrevAndNext(
				session, visa, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Visa getByUuid_C_PrevAndNext(
		Session session, Visa visa, String uuid, long companyId,
		OrderByComparator<Visa> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_VISA_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(VisaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(visa)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Visa> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Visa visa :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(visa);
		}
	}

	/**
	 * Returns the number of visas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching visas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VISA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"visa.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(visa.uuid IS NULL OR visa.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"visa.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCin;
	private FinderPath _finderPathWithoutPaginationFindByCin;
	private FinderPath _finderPathCountByCin;

	/**
	 * Returns all the visas where cin = &#63;.
	 *
	 * @param cin the cin
	 * @return the matching visas
	 */
	@Override
	public List<Visa> findByCin(String cin) {
		return findByCin(cin, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Visa> findByCin(String cin, int start, int end) {
		return findByCin(cin, start, end, null);
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
	@Override
	public List<Visa> findByCin(
		String cin, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return findByCin(cin, start, end, orderByComparator, true);
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
	@Override
	public List<Visa> findByCin(
		String cin, int start, int end,
		OrderByComparator<Visa> orderByComparator, boolean useFinderCache) {

		cin = Objects.toString(cin, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCin;
				finderArgs = new Object[] {cin};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCin;
			finderArgs = new Object[] {cin, start, end, orderByComparator};
		}

		List<Visa> list = null;

		if (useFinderCache) {
			list = (List<Visa>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Visa visa : list) {
					if (!cin.equals(visa.getCin())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_VISA_WHERE);

			boolean bindCin = false;

			if (cin.isEmpty()) {
				sb.append(_FINDER_COLUMN_CIN_CIN_3);
			}
			else {
				bindCin = true;

				sb.append(_FINDER_COLUMN_CIN_CIN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VisaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCin) {
					queryPos.add(cin);
				}

				list = (List<Visa>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first visa in the ordered set where cin = &#63;.
	 *
	 * @param cin the cin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	@Override
	public Visa findByCin_First(
			String cin, OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		Visa visa = fetchByCin_First(cin, orderByComparator);

		if (visa != null) {
			return visa;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cin=");
		sb.append(cin);

		sb.append("}");

		throw new NoSuchVisaException(sb.toString());
	}

	/**
	 * Returns the first visa in the ordered set where cin = &#63;.
	 *
	 * @param cin the cin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public Visa fetchByCin_First(
		String cin, OrderByComparator<Visa> orderByComparator) {

		List<Visa> list = findByCin(cin, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visa in the ordered set where cin = &#63;.
	 *
	 * @param cin the cin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	@Override
	public Visa findByCin_Last(
			String cin, OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		Visa visa = fetchByCin_Last(cin, orderByComparator);

		if (visa != null) {
			return visa;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cin=");
		sb.append(cin);

		sb.append("}");

		throw new NoSuchVisaException(sb.toString());
	}

	/**
	 * Returns the last visa in the ordered set where cin = &#63;.
	 *
	 * @param cin the cin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public Visa fetchByCin_Last(
		String cin, OrderByComparator<Visa> orderByComparator) {

		int count = countByCin(cin);

		if (count == 0) {
			return null;
		}

		List<Visa> list = findByCin(cin, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Visa[] findByCin_PrevAndNext(
			long visaId, String cin, OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		cin = Objects.toString(cin, "");

		Visa visa = findByPrimaryKey(visaId);

		Session session = null;

		try {
			session = openSession();

			Visa[] array = new VisaImpl[3];

			array[0] = getByCin_PrevAndNext(
				session, visa, cin, orderByComparator, true);

			array[1] = visa;

			array[2] = getByCin_PrevAndNext(
				session, visa, cin, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Visa getByCin_PrevAndNext(
		Session session, Visa visa, String cin,
		OrderByComparator<Visa> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VISA_WHERE);

		boolean bindCin = false;

		if (cin.isEmpty()) {
			sb.append(_FINDER_COLUMN_CIN_CIN_3);
		}
		else {
			bindCin = true;

			sb.append(_FINDER_COLUMN_CIN_CIN_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(VisaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCin) {
			queryPos.add(cin);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(visa)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Visa> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visas where cin = &#63; from the database.
	 *
	 * @param cin the cin
	 */
	@Override
	public void removeByCin(String cin) {
		for (Visa visa :
				findByCin(cin, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(visa);
		}
	}

	/**
	 * Returns the number of visas where cin = &#63;.
	 *
	 * @param cin the cin
	 * @return the number of matching visas
	 */
	@Override
	public int countByCin(String cin) {
		cin = Objects.toString(cin, "");

		FinderPath finderPath = _finderPathCountByCin;

		Object[] finderArgs = new Object[] {cin};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VISA_WHERE);

			boolean bindCin = false;

			if (cin.isEmpty()) {
				sb.append(_FINDER_COLUMN_CIN_CIN_3);
			}
			else {
				bindCin = true;

				sb.append(_FINDER_COLUMN_CIN_CIN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCin) {
					queryPos.add(cin);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CIN_CIN_2 = "visa.cin = ?";

	private static final String _FINDER_COLUMN_CIN_CIN_3 =
		"(visa.cin IS NULL OR visa.cin = '')";

	private FinderPath _finderPathWithPaginationFindByPassport;
	private FinderPath _finderPathWithoutPaginationFindByPassport;
	private FinderPath _finderPathCountByPassport;

	/**
	 * Returns all the visas where passport = &#63;.
	 *
	 * @param passport the passport
	 * @return the matching visas
	 */
	@Override
	public List<Visa> findByPassport(String passport) {
		return findByPassport(
			passport, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Visa> findByPassport(String passport, int start, int end) {
		return findByPassport(passport, start, end, null);
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
	@Override
	public List<Visa> findByPassport(
		String passport, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return findByPassport(passport, start, end, orderByComparator, true);
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
	@Override
	public List<Visa> findByPassport(
		String passport, int start, int end,
		OrderByComparator<Visa> orderByComparator, boolean useFinderCache) {

		passport = Objects.toString(passport, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPassport;
				finderArgs = new Object[] {passport};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPassport;
			finderArgs = new Object[] {passport, start, end, orderByComparator};
		}

		List<Visa> list = null;

		if (useFinderCache) {
			list = (List<Visa>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Visa visa : list) {
					if (!passport.equals(visa.getPassport())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_VISA_WHERE);

			boolean bindPassport = false;

			if (passport.isEmpty()) {
				sb.append(_FINDER_COLUMN_PASSPORT_PASSPORT_3);
			}
			else {
				bindPassport = true;

				sb.append(_FINDER_COLUMN_PASSPORT_PASSPORT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VisaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPassport) {
					queryPos.add(passport);
				}

				list = (List<Visa>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first visa in the ordered set where passport = &#63;.
	 *
	 * @param passport the passport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	@Override
	public Visa findByPassport_First(
			String passport, OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		Visa visa = fetchByPassport_First(passport, orderByComparator);

		if (visa != null) {
			return visa;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("passport=");
		sb.append(passport);

		sb.append("}");

		throw new NoSuchVisaException(sb.toString());
	}

	/**
	 * Returns the first visa in the ordered set where passport = &#63;.
	 *
	 * @param passport the passport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public Visa fetchByPassport_First(
		String passport, OrderByComparator<Visa> orderByComparator) {

		List<Visa> list = findByPassport(passport, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visa in the ordered set where passport = &#63;.
	 *
	 * @param passport the passport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	@Override
	public Visa findByPassport_Last(
			String passport, OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		Visa visa = fetchByPassport_Last(passport, orderByComparator);

		if (visa != null) {
			return visa;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("passport=");
		sb.append(passport);

		sb.append("}");

		throw new NoSuchVisaException(sb.toString());
	}

	/**
	 * Returns the last visa in the ordered set where passport = &#63;.
	 *
	 * @param passport the passport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public Visa fetchByPassport_Last(
		String passport, OrderByComparator<Visa> orderByComparator) {

		int count = countByPassport(passport);

		if (count == 0) {
			return null;
		}

		List<Visa> list = findByPassport(
			passport, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Visa[] findByPassport_PrevAndNext(
			long visaId, String passport,
			OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		passport = Objects.toString(passport, "");

		Visa visa = findByPrimaryKey(visaId);

		Session session = null;

		try {
			session = openSession();

			Visa[] array = new VisaImpl[3];

			array[0] = getByPassport_PrevAndNext(
				session, visa, passport, orderByComparator, true);

			array[1] = visa;

			array[2] = getByPassport_PrevAndNext(
				session, visa, passport, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Visa getByPassport_PrevAndNext(
		Session session, Visa visa, String passport,
		OrderByComparator<Visa> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VISA_WHERE);

		boolean bindPassport = false;

		if (passport.isEmpty()) {
			sb.append(_FINDER_COLUMN_PASSPORT_PASSPORT_3);
		}
		else {
			bindPassport = true;

			sb.append(_FINDER_COLUMN_PASSPORT_PASSPORT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(VisaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPassport) {
			queryPos.add(passport);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(visa)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Visa> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visas where passport = &#63; from the database.
	 *
	 * @param passport the passport
	 */
	@Override
	public void removeByPassport(String passport) {
		for (Visa visa :
				findByPassport(
					passport, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(visa);
		}
	}

	/**
	 * Returns the number of visas where passport = &#63;.
	 *
	 * @param passport the passport
	 * @return the number of matching visas
	 */
	@Override
	public int countByPassport(String passport) {
		passport = Objects.toString(passport, "");

		FinderPath finderPath = _finderPathCountByPassport;

		Object[] finderArgs = new Object[] {passport};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VISA_WHERE);

			boolean bindPassport = false;

			if (passport.isEmpty()) {
				sb.append(_FINDER_COLUMN_PASSPORT_PASSPORT_3);
			}
			else {
				bindPassport = true;

				sb.append(_FINDER_COLUMN_PASSPORT_PASSPORT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPassport) {
					queryPos.add(passport);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PASSPORT_PASSPORT_2 =
		"visa.passport = ?";

	private static final String _FINDER_COLUMN_PASSPORT_PASSPORT_3 =
		"(visa.passport IS NULL OR visa.passport = '')";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the visas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching visas
	 */
	@Override
	public List<Visa> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Visa> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<Visa> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<Visa> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Visa> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<Visa> list = null;

		if (useFinderCache) {
			list = (List<Visa>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Visa visa : list) {
					if (userId != visa.getUserId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_VISA_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VisaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<Visa>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first visa in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	@Override
	public Visa findByUserId_First(
			long userId, OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		Visa visa = fetchByUserId_First(userId, orderByComparator);

		if (visa != null) {
			return visa;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchVisaException(sb.toString());
	}

	/**
	 * Returns the first visa in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public Visa fetchByUserId_First(
		long userId, OrderByComparator<Visa> orderByComparator) {

		List<Visa> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visa in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	@Override
	public Visa findByUserId_Last(
			long userId, OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		Visa visa = fetchByUserId_Last(userId, orderByComparator);

		if (visa != null) {
			return visa;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchVisaException(sb.toString());
	}

	/**
	 * Returns the last visa in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public Visa fetchByUserId_Last(
		long userId, OrderByComparator<Visa> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<Visa> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Visa[] findByUserId_PrevAndNext(
			long visaId, long userId, OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		Visa visa = findByPrimaryKey(visaId);

		Session session = null;

		try {
			session = openSession();

			Visa[] array = new VisaImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, visa, userId, orderByComparator, true);

			array[1] = visa;

			array[2] = getByUserId_PrevAndNext(
				session, visa, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Visa getByUserId_PrevAndNext(
		Session session, Visa visa, long userId,
		OrderByComparator<Visa> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VISA_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(VisaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(visa)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Visa> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visas where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (Visa visa :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(visa);
		}
	}

	/**
	 * Returns the number of visas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching visas
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VISA_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"visa.userId = ?";

	private FinderPath _finderPathWithPaginationFindByEtat;
	private FinderPath _finderPathWithoutPaginationFindByEtat;
	private FinderPath _finderPathCountByEtat;

	/**
	 * Returns all the visas where etat = &#63;.
	 *
	 * @param etat the etat
	 * @return the matching visas
	 */
	@Override
	public List<Visa> findByEtat(String etat) {
		return findByEtat(etat, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Visa> findByEtat(String etat, int start, int end) {
		return findByEtat(etat, start, end, null);
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
	@Override
	public List<Visa> findByEtat(
		String etat, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return findByEtat(etat, start, end, orderByComparator, true);
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
	@Override
	public List<Visa> findByEtat(
		String etat, int start, int end,
		OrderByComparator<Visa> orderByComparator, boolean useFinderCache) {

		etat = Objects.toString(etat, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEtat;
				finderArgs = new Object[] {etat};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEtat;
			finderArgs = new Object[] {etat, start, end, orderByComparator};
		}

		List<Visa> list = null;

		if (useFinderCache) {
			list = (List<Visa>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Visa visa : list) {
					if (!etat.equals(visa.getEtat())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_VISA_WHERE);

			boolean bindEtat = false;

			if (etat.isEmpty()) {
				sb.append(_FINDER_COLUMN_ETAT_ETAT_3);
			}
			else {
				bindEtat = true;

				sb.append(_FINDER_COLUMN_ETAT_ETAT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VisaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEtat) {
					queryPos.add(etat);
				}

				list = (List<Visa>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first visa in the ordered set where etat = &#63;.
	 *
	 * @param etat the etat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	@Override
	public Visa findByEtat_First(
			String etat, OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		Visa visa = fetchByEtat_First(etat, orderByComparator);

		if (visa != null) {
			return visa;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("etat=");
		sb.append(etat);

		sb.append("}");

		throw new NoSuchVisaException(sb.toString());
	}

	/**
	 * Returns the first visa in the ordered set where etat = &#63;.
	 *
	 * @param etat the etat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public Visa fetchByEtat_First(
		String etat, OrderByComparator<Visa> orderByComparator) {

		List<Visa> list = findByEtat(etat, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visa in the ordered set where etat = &#63;.
	 *
	 * @param etat the etat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa
	 * @throws NoSuchVisaException if a matching visa could not be found
	 */
	@Override
	public Visa findByEtat_Last(
			String etat, OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		Visa visa = fetchByEtat_Last(etat, orderByComparator);

		if (visa != null) {
			return visa;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("etat=");
		sb.append(etat);

		sb.append("}");

		throw new NoSuchVisaException(sb.toString());
	}

	/**
	 * Returns the last visa in the ordered set where etat = &#63;.
	 *
	 * @param etat the etat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public Visa fetchByEtat_Last(
		String etat, OrderByComparator<Visa> orderByComparator) {

		int count = countByEtat(etat);

		if (count == 0) {
			return null;
		}

		List<Visa> list = findByEtat(etat, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Visa[] findByEtat_PrevAndNext(
			long visaId, String etat, OrderByComparator<Visa> orderByComparator)
		throws NoSuchVisaException {

		etat = Objects.toString(etat, "");

		Visa visa = findByPrimaryKey(visaId);

		Session session = null;

		try {
			session = openSession();

			Visa[] array = new VisaImpl[3];

			array[0] = getByEtat_PrevAndNext(
				session, visa, etat, orderByComparator, true);

			array[1] = visa;

			array[2] = getByEtat_PrevAndNext(
				session, visa, etat, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Visa getByEtat_PrevAndNext(
		Session session, Visa visa, String etat,
		OrderByComparator<Visa> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VISA_WHERE);

		boolean bindEtat = false;

		if (etat.isEmpty()) {
			sb.append(_FINDER_COLUMN_ETAT_ETAT_3);
		}
		else {
			bindEtat = true;

			sb.append(_FINDER_COLUMN_ETAT_ETAT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(VisaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEtat) {
			queryPos.add(etat);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(visa)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Visa> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visas where etat = &#63; from the database.
	 *
	 * @param etat the etat
	 */
	@Override
	public void removeByEtat(String etat) {
		for (Visa visa :
				findByEtat(etat, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(visa);
		}
	}

	/**
	 * Returns the number of visas where etat = &#63;.
	 *
	 * @param etat the etat
	 * @return the number of matching visas
	 */
	@Override
	public int countByEtat(String etat) {
		etat = Objects.toString(etat, "");

		FinderPath finderPath = _finderPathCountByEtat;

		Object[] finderArgs = new Object[] {etat};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VISA_WHERE);

			boolean bindEtat = false;

			if (etat.isEmpty()) {
				sb.append(_FINDER_COLUMN_ETAT_ETAT_3);
			}
			else {
				bindEtat = true;

				sb.append(_FINDER_COLUMN_ETAT_ETAT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEtat) {
					queryPos.add(etat);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ETAT_ETAT_2 = "visa.etat = ?";

	private static final String _FINDER_COLUMN_ETAT_ETAT_3 =
		"(visa.etat IS NULL OR visa.etat = '')";

	public VisaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Visa.class);

		setModelImplClass(VisaImpl.class);
		setModelPKClass(long.class);

		setTable(VisaTable.INSTANCE);
	}

	/**
	 * Caches the visa in the entity cache if it is enabled.
	 *
	 * @param visa the visa
	 */
	@Override
	public void cacheResult(Visa visa) {
		entityCache.putResult(VisaImpl.class, visa.getPrimaryKey(), visa);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {visa.getUuid(), visa.getGroupId()}, visa);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the visas in the entity cache if it is enabled.
	 *
	 * @param visas the visas
	 */
	@Override
	public void cacheResult(List<Visa> visas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (visas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Visa visa : visas) {
			if (entityCache.getResult(VisaImpl.class, visa.getPrimaryKey()) ==
					null) {

				cacheResult(visa);
			}
		}
	}

	/**
	 * Clears the cache for all visas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VisaImpl.class);

		finderCache.clearCache(VisaImpl.class);
	}

	/**
	 * Clears the cache for the visa.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Visa visa) {
		entityCache.removeResult(VisaImpl.class, visa);
	}

	@Override
	public void clearCache(List<Visa> visas) {
		for (Visa visa : visas) {
			entityCache.removeResult(VisaImpl.class, visa);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(VisaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(VisaImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(VisaModelImpl visaModelImpl) {
		Object[] args = new Object[] {
			visaModelImpl.getUuid(), visaModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, visaModelImpl);
	}

	/**
	 * Creates a new visa with the primary key. Does not add the visa to the database.
	 *
	 * @param visaId the primary key for the new visa
	 * @return the new visa
	 */
	@Override
	public Visa create(long visaId) {
		Visa visa = new VisaImpl();

		visa.setNew(true);
		visa.setPrimaryKey(visaId);

		String uuid = _portalUUID.generate();

		visa.setUuid(uuid);

		visa.setCompanyId(CompanyThreadLocal.getCompanyId());

		return visa;
	}

	/**
	 * Removes the visa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param visaId the primary key of the visa
	 * @return the visa that was removed
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	@Override
	public Visa remove(long visaId) throws NoSuchVisaException {
		return remove((Serializable)visaId);
	}

	/**
	 * Removes the visa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the visa
	 * @return the visa that was removed
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	@Override
	public Visa remove(Serializable primaryKey) throws NoSuchVisaException {
		Session session = null;

		try {
			session = openSession();

			Visa visa = (Visa)session.get(VisaImpl.class, primaryKey);

			if (visa == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVisaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(visa);
		}
		catch (NoSuchVisaException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Visa removeImpl(Visa visa) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(visa)) {
				visa = (Visa)session.get(
					VisaImpl.class, visa.getPrimaryKeyObj());
			}

			if (visa != null) {
				session.delete(visa);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (visa != null) {
			clearCache(visa);
		}

		return visa;
	}

	@Override
	public Visa updateImpl(Visa visa) {
		boolean isNew = visa.isNew();

		if (!(visa instanceof VisaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(visa.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(visa);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in visa proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Visa implementation " +
					visa.getClass());
		}

		VisaModelImpl visaModelImpl = (VisaModelImpl)visa;

		if (Validator.isNull(visa.getUuid())) {
			String uuid = _portalUUID.generate();

			visa.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (visa.getCreateDate() == null)) {
			if (serviceContext == null) {
				visa.setCreateDate(date);
			}
			else {
				visa.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!visaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				visa.setModifiedDate(date);
			}
			else {
				visa.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(visa);
			}
			else {
				visa = (Visa)session.merge(visa);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(VisaImpl.class, visaModelImpl, false, true);

		cacheUniqueFindersCache(visaModelImpl);

		if (isNew) {
			visa.setNew(false);
		}

		visa.resetOriginalValues();

		return visa;
	}

	/**
	 * Returns the visa with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the visa
	 * @return the visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	@Override
	public Visa findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVisaException {

		Visa visa = fetchByPrimaryKey(primaryKey);

		if (visa == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVisaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return visa;
	}

	/**
	 * Returns the visa with the primary key or throws a <code>NoSuchVisaException</code> if it could not be found.
	 *
	 * @param visaId the primary key of the visa
	 * @return the visa
	 * @throws NoSuchVisaException if a visa with the primary key could not be found
	 */
	@Override
	public Visa findByPrimaryKey(long visaId) throws NoSuchVisaException {
		return findByPrimaryKey((Serializable)visaId);
	}

	/**
	 * Returns the visa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param visaId the primary key of the visa
	 * @return the visa, or <code>null</code> if a visa with the primary key could not be found
	 */
	@Override
	public Visa fetchByPrimaryKey(long visaId) {
		return fetchByPrimaryKey((Serializable)visaId);
	}

	/**
	 * Returns all the visas.
	 *
	 * @return the visas
	 */
	@Override
	public List<Visa> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Visa> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Visa> findAll(
		int start, int end, OrderByComparator<Visa> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Visa> findAll(
		int start, int end, OrderByComparator<Visa> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Visa> list = null;

		if (useFinderCache) {
			list = (List<Visa>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VISA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VISA;

				sql = sql.concat(VisaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Visa>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the visas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Visa visa : findAll()) {
			remove(visa);
		}
	}

	/**
	 * Returns the number of visas.
	 *
	 * @return the number of visas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VISA);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "visaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VISA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VisaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the visa persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByCin = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCin",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"cin"}, true);

		_finderPathWithoutPaginationFindByCin = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCin",
			new String[] {String.class.getName()}, new String[] {"cin"}, true);

		_finderPathCountByCin = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCin",
			new String[] {String.class.getName()}, new String[] {"cin"}, false);

		_finderPathWithPaginationFindByPassport = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPassport",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"passport"}, true);

		_finderPathWithoutPaginationFindByPassport = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPassport",
			new String[] {String.class.getName()}, new String[] {"passport"},
			true);

		_finderPathCountByPassport = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPassport",
			new String[] {String.class.getName()}, new String[] {"passport"},
			false);

		_finderPathWithPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathWithPaginationFindByEtat = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEtat",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"etat"}, true);

		_finderPathWithoutPaginationFindByEtat = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEtat",
			new String[] {String.class.getName()}, new String[] {"etat"}, true);

		_finderPathCountByEtat = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEtat",
			new String[] {String.class.getName()}, new String[] {"etat"},
			false);

		_setVisaUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setVisaUtilPersistence(null);

		entityCache.removeCache(VisaImpl.class.getName());
	}

	private void _setVisaUtilPersistence(VisaPersistence visaPersistence) {
		try {
			Field field = VisaUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, visaPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = VisaManagementPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = VisaManagementPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = VisaManagementPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_VISA = "SELECT visa FROM Visa visa";

	private static final String _SQL_SELECT_VISA_WHERE =
		"SELECT visa FROM Visa visa WHERE ";

	private static final String _SQL_COUNT_VISA =
		"SELECT COUNT(visa) FROM Visa visa";

	private static final String _SQL_COUNT_VISA_WHERE =
		"SELECT COUNT(visa) FROM Visa visa WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "visa.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Visa exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Visa exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VisaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}