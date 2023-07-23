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

package com.liferay.gwenod.visa.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VisaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VisaLocalService
 * @generated
 */
public class VisaLocalServiceWrapper
	implements ServiceWrapper<VisaLocalService>, VisaLocalService {

	public VisaLocalServiceWrapper() {
		this(null);
	}

	public VisaLocalServiceWrapper(VisaLocalService visaLocalService) {
		_visaLocalService = visaLocalService;
	}

	@Override
	public com.liferay.gwenod.visa.model.Visa addVisa(
			String cin, String passport, String nom, String prenom,
			java.util.Date dateNaissance, String motifVoyage,
			java.util.Date dataVoyage, int dureeVoyage,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visaLocalService.addVisa(
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
	@Override
	public com.liferay.gwenod.visa.model.Visa addVisa(
		com.liferay.gwenod.visa.model.Visa visa) {

		return _visaLocalService.addVisa(visa);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new visa with the primary key. Does not add the visa to the database.
	 *
	 * @param visaId the primary key for the new visa
	 * @return the new visa
	 */
	@Override
	public com.liferay.gwenod.visa.model.Visa createVisa(long visaId) {
		return _visaLocalService.createVisa(visaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visaLocalService.deletePersistedModel(persistedModel);
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
	 */
	@Override
	public com.liferay.gwenod.visa.model.Visa deleteVisa(long visaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visaLocalService.deleteVisa(visaId);
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
	@Override
	public com.liferay.gwenod.visa.model.Visa deleteVisa(
		com.liferay.gwenod.visa.model.Visa visa) {

		return _visaLocalService.deleteVisa(visa);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _visaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _visaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _visaLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _visaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.gwenod.visa.model.impl.VisaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _visaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.gwenod.visa.model.impl.VisaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _visaLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _visaLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _visaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.gwenod.visa.model.Visa fetchVisa(long visaId) {
		return _visaLocalService.fetchVisa(visaId);
	}

	/**
	 * Returns the visa matching the UUID and group.
	 *
	 * @param uuid the visa's UUID
	 * @param groupId the primary key of the group
	 * @return the matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Override
	public com.liferay.gwenod.visa.model.Visa fetchVisaByUuidAndGroupId(
		String uuid, long groupId) {

		return _visaLocalService.fetchVisaByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _visaLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa> getAllVisas() {
		return _visaLocalService.getAllVisas();
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa> getAllVisas(
		int start, int end) {

		return _visaLocalService.getAllVisas(start, end);
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa> getAllVisas(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.gwenod.visa.model.Visa> orderByComparator) {

		return _visaLocalService.getAllVisas(start, end, orderByComparator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _visaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _visaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _visaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the visa with the primary key.
	 *
	 * @param visaId the primary key of the visa
	 * @return the visa
	 * @throws PortalException if a visa with the primary key could not be found
	 */
	@Override
	public com.liferay.gwenod.visa.model.Visa getVisa(long visaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visaLocalService.getVisa(visaId);
	}

	/**
	 * Returns the visa matching the UUID and group.
	 *
	 * @param uuid the visa's UUID
	 * @param groupId the primary key of the group
	 * @return the matching visa
	 * @throws PortalException if a matching visa could not be found
	 */
	@Override
	public com.liferay.gwenod.visa.model.Visa getVisaByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visaLocalService.getVisaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the visas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.gwenod.visa.model.impl.VisaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visas
	 * @param end the upper bound of the range of visas (not inclusive)
	 * @return the range of visas
	 */
	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa> getVisas(
		int start, int end) {

		return _visaLocalService.getVisas(start, end);
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa>
		getVisasByKeywords(long userId, String keywords, int start, int end) {

		return _visaLocalService.getVisasByKeywords(
			userId, keywords, start, end);
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa>
		getVisasByKeywords(
			long userId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.gwenod.visa.model.Visa> orderByComparator) {

		return _visaLocalService.getVisasByKeywords(
			userId, keywords, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa> getVisasByUserId(
		long userId) {

		return _visaLocalService.getVisasByUserId(userId);
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa> getVisasByUserId(
		long userId, int start, int end) {

		return _visaLocalService.getVisasByUserId(userId, start, end);
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa> getVisasByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.gwenod.visa.model.Visa> orderByComparator) {

		return _visaLocalService.getVisasByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns all the visas matching the UUID and company.
	 *
	 * @param uuid the UUID of the visas
	 * @param companyId the primary key of the company
	 * @return the matching visas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa>
		getVisasByUuidAndCompanyId(String uuid, long companyId) {

		return _visaLocalService.getVisasByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa>
		getVisasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.gwenod.visa.model.Visa> orderByComparator) {

		return _visaLocalService.getVisasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of visas.
	 *
	 * @return the number of visas
	 */
	@Override
	public int getVisasCount() {
		return _visaLocalService.getVisasCount();
	}

	@Override
	public long getVisasCountByKeywords(long userId, String keywords) {
		return _visaLocalService.getVisasCountByKeywords(userId, keywords);
	}

	@Override
	public com.liferay.gwenod.visa.model.Visa updateVisa(
			long visaId, String cin, String passport, String nom, String prenom,
			java.util.Date dateNaissance, String motifVoyage,
			java.util.Date dataVoyage, int dureeVoyage, int etat,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visaLocalService.updateVisa(
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
	@Override
	public com.liferay.gwenod.visa.model.Visa updateVisa(
		com.liferay.gwenod.visa.model.Visa visa) {

		return _visaLocalService.updateVisa(visa);
	}

	@Override
	public VisaLocalService getWrappedService() {
		return _visaLocalService;
	}

	@Override
	public void setWrappedService(VisaLocalService visaLocalService) {
		_visaLocalService = visaLocalService;
	}

	private VisaLocalService _visaLocalService;

}