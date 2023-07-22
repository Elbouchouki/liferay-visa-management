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

package com.liferay.gwenod.visa.service.service;

import com.liferay.gwenod.visa.service.model.Visa;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Visa. This utility wraps
 * <code>com.liferay.gwenod.visa.service.service.impl.VisaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see VisaLocalService
 * @generated
 */
public class VisaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.gwenod.visa.service.service.impl.VisaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Visa addVisa(
			String cin, String passport, String nom, String prenom,
			java.util.Date dateNaissance, String motifVoyage,
			java.util.Date dataVoyage, int dureeVoyage,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addVisa(
			cin, passport, nom, prenom, dateNaissance, motifVoyage, dataVoyage,
			dureeVoyage, serviceContext);
	}

	/**
	 * Adds the visa to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visa the visa
	 * @return the visa that was added
	 */
	public static Visa addVisa(Visa visa) {
		return getService().addVisa(visa);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new visa with the primary key. Does not add the visa to the database.
	 *
	 * @param visaId the primary key for the new visa
	 * @return the new visa
	 */
	public static Visa createVisa(long visaId) {
		return getService().createVisa(visaId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the visa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visaId the primary key of the visa
	 * @return the visa that was removed
	 * @throws PortalException if a visa with the primary key could not be found
	 * @throws NoSuchVisaException
	 */
	public static Visa deleteVisa(long visaId)
		throws com.liferay.gwenod.visa.service.exception.NoSuchVisaException,
			   PortalException {

		return getService().deleteVisa(visaId);
	}

	/**
	 * Deletes the visa from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visa the visa
	 * @return the visa that was removed
	 */
	public static Visa deleteVisa(Visa visa) {
		return getService().deleteVisa(visa);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.gwenod.visa.service.model.impl.VisaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.gwenod.visa.service.model.impl.VisaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Visa fetchVisa(long visaId) {
		return getService().fetchVisa(visaId);
	}

	/**
	 * Returns the visa matching the UUID and group.
	 *
	 * @param uuid the visa's UUID
	 * @param groupId the primary key of the group
	 * @return the matching visa, or <code>null</code> if a matching visa could not be found
	 */
	public static Visa fetchVisaByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchVisaByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Visa> getAllVisas() {
		return getService().getAllVisas();
	}

	public static List<Visa> getAllVisas(int start, int end) {
		return getService().getAllVisas(start, end);
	}

	public static List<Visa> getAllVisas(
		int start, int end, OrderByComparator<Visa> orderByComparator) {

		return getService().getAllVisas(start, end, orderByComparator);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the visa with the primary key.
	 *
	 * @param visaId the primary key of the visa
	 * @return the visa
	 * @throws PortalException if a visa with the primary key could not be found
	 * @throws NoSuchVisaException
	 */
	public static Visa getVisa(long visaId)
		throws com.liferay.gwenod.visa.service.exception.NoSuchVisaException,
			   PortalException {

		return getService().getVisa(visaId);
	}

	/**
	 * Returns the visa matching the UUID and group.
	 *
	 * @param uuid the visa's UUID
	 * @param groupId the primary key of the group
	 * @return the matching visa
	 * @throws PortalException if a matching visa could not be found
	 * @throws NoSuchVisaException
	 */
	public static Visa getVisaByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.gwenod.visa.service.exception.NoSuchVisaException,
			   PortalException {

		return getService().getVisaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the visas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.gwenod.visa.service.model.impl.VisaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @return the range of visas
	 */
	public static List<Visa> getVisas(int start, int end) {
		return getService().getVisas(start, end);
	}

	public static List<Visa> getVisasByKeywords(
		long userId, String keywords, int start, int end) {

		return getService().getVisasByKeywords(userId, keywords, start, end);
	}

	public static List<Visa> getVisasByKeywords(
		long userId, String keywords, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return getService().getVisasByKeywords(
			userId, keywords, start, end, orderByComparator);
	}

	public static List<Visa> getVisasByUserId(long userId) {
		return getService().getVisasByUserId(userId);
	}

	public static List<Visa> getVisasByUserId(long userId, int start, int end) {
		return getService().getVisasByUserId(userId, start, end);
	}

	public static List<Visa> getVisasByUserId(
		long userId, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return getService().getVisasByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns all the visas matching the UUID and company.
	 *
	 * @param uuid the UUID of the visas
	 * @param companyId the primary key of the company
	 * @return the matching visas, or an empty list if no matches were found
	 */
	public static List<Visa> getVisasByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getVisasByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of visas matching the UUID and company.
	 *
	 * @param uuid the UUID of the visas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching visas, or an empty list if no matches were found
	 */
	public static List<Visa> getVisasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Visa> orderByComparator) {

		return getService().getVisasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of visas.
	 *
	 * @return the number of visas
	 */
	public static int getVisasCount() {
		return getService().getVisasCount();
	}

	public static long getVisasCountByKeywords(long userId, String keywords) {
		return getService().getVisasCountByKeywords(userId, keywords);
	}

	public static Visa updateVisa(
			long visaId, String cin, String passport, String nom, String prenom,
			java.util.Date dateNaissance, String motifVoyage,
			java.util.Date dataVoyage, int dureeVoyage, String etat,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.gwenod.visa.service.exception.NoSuchVisaException,
			   com.liferay.gwenod.visa.service.exception.
				   VisaValidationException {

		return getService().updateVisa(
			visaId, cin, passport, nom, prenom, dateNaissance, motifVoyage,
			dataVoyage, dureeVoyage, etat, serviceContext);
	}

	/**
	 * Updates the visa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visa the visa
	 * @return the visa that was updated
	 */
	public static Visa updateVisa(Visa visa) {
		return getService().updateVisa(visa);
	}

	public static VisaLocalService getService() {
		return _service;
	}

	private static volatile VisaLocalService _service;

}