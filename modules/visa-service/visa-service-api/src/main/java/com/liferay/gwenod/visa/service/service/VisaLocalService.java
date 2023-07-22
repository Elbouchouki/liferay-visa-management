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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.gwenod.visa.service.exception.NoSuchVisaException;
import com.liferay.gwenod.visa.service.exception.VisaValidationException;
import com.liferay.gwenod.visa.service.model.Visa;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Visa. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see VisaLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface VisaLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.gwenod.visa.service.service.impl.VisaLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the visa local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link VisaLocalServiceUtil} if injection and service tracking are not available.
	 */
	public Visa addVisa(
			String cin, String passport, String nom, String prenom,
			Date dateNaissance, String motifVoyage, Date dataVoyage,
			int dureeVoyage, ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public Visa addVisa(Visa visa);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new visa with the primary key. Does not add the visa to the database.
	 *
	 * @param visaId the primary key for the new visa
	 * @return the new visa
	 */
	@Transactional(enabled = false)
	public Visa createVisa(long visaId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public Visa deleteVisa(long visaId)
		throws NoSuchVisaException, PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public Visa deleteVisa(Visa visa);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Visa fetchVisa(long visaId);

	/**
	 * Returns the visa matching the UUID and group.
	 *
	 * @param uuid the visa's UUID
	 * @param groupId the primary key of the group
	 * @return the matching visa, or <code>null</code> if a matching visa could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Visa fetchVisaByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getAllVisas();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getAllVisas(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getAllVisas(
		int start, int end, OrderByComparator<Visa> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the visa with the primary key.
	 *
	 * @param visaId the primary key of the visa
	 * @return the visa
	 * @throws PortalException if a visa with the primary key could not be found
	 * @throws NoSuchVisaException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Visa getVisa(long visaId)
		throws NoSuchVisaException, PortalException;

	/**
	 * Returns the visa matching the UUID and group.
	 *
	 * @param uuid the visa's UUID
	 * @param groupId the primary key of the group
	 * @return the matching visa
	 * @throws PortalException if a matching visa could not be found
	 * @throws NoSuchVisaException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Visa getVisaByUuidAndGroupId(String uuid, long groupId)
		throws NoSuchVisaException, PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getVisas(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getVisasByKeywords(
		long userId, String keywords, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getVisasByKeywords(
		long userId, String keywords, int start, int end,
		OrderByComparator<Visa> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getVisasByUserId(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getVisasByUserId(long userId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getVisasByUserId(
		long userId, int start, int end,
		OrderByComparator<Visa> orderByComparator);

	/**
	 * Returns all the visas matching the UUID and company.
	 *
	 * @param uuid the UUID of the visas
	 * @param companyId the primary key of the company
	 * @return the matching visas, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getVisasByUuidAndCompanyId(String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getVisasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Visa> orderByComparator);

	/**
	 * Returns the number of visas.
	 *
	 * @return the number of visas
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVisasCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getVisasCountByKeywords(long userId, String keywords);

	public Visa updateVisa(
			long visaId, String cin, String passport, String nom, String prenom,
			Date dateNaissance, String motifVoyage, Date dataVoyage,
			int dureeVoyage, String etat, ServiceContext serviceContext)
		throws NoSuchVisaException, VisaValidationException;

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
	@Indexable(type = IndexableType.REINDEX)
	public Visa updateVisa(Visa visa);

}