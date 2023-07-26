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

import com.liferay.gwenod.visa.model.Visa;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Visa. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see VisaServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface VisaService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.gwenod.visa.service.impl.VisaServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the visa remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link VisaServiceUtil} if injection and service tracking are not available.
	 */
	public Visa addVisa(
			String cin, String passport, String nom, String prenom,
			Date dateNaissance, String motifVoyage, Date dataVoyage,
			int dureeVoyage, ServiceContext serviceContext)
		throws PortalException;

	public Visa deleteVisa(long visaId, ServiceContext serviceContext)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getAllVisas(
			int start, int end, OrderByComparator<Visa> orderByComparator,
			ServiceContext serviceContext)
		throws PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getAllVisas(
			int start, int end, ServiceContext serviceContext)
		throws PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getAllVisas(ServiceContext serviceContext)
		throws PrincipalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Visa getVisa(long visaId, ServiceContext serviceContext)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getVisasByKeywords(
			long userId, String keywords, int start, int end,
			OrderByComparator<Visa> orderByComparator,
			ServiceContext serviceContext)
		throws PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getVisasByKeywords(
			long userId, String keywords, int start, int end,
			ServiceContext serviceContext)
		throws PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getVisasByUserId(
			long userId, int start, int end,
			OrderByComparator<Visa> orderByComparator,
			ServiceContext serviceContext)
		throws PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getVisasByUserId(
			long userId, int start, int end, ServiceContext serviceContext)
		throws PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Visa> getVisasByUserId(
			long userId, ServiceContext serviceContext)
		throws PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getVisasCountByKeywords(
			long userId, String keywords, ServiceContext serviceContext)
		throws PrincipalException;

	public Visa updateVisa(
			long visaId, String cin, String passport, String nom, String prenom,
			Date dateNaissance, String motifVoyage, Date dataVoyage,
			int dureeVoyage, int etat, ServiceContext serviceContext)
		throws PortalException;

}