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
 * Provides a wrapper for {@link VisaService}.
 *
 * @author Brian Wing Shun Chan
 * @see VisaService
 * @generated
 */
public class VisaServiceWrapper
	implements ServiceWrapper<VisaService>, VisaService {

	public VisaServiceWrapper() {
		this(null);
	}

	public VisaServiceWrapper(VisaService visaService) {
		_visaService = visaService;
	}

	@Override
	public com.liferay.gwenod.visa.model.Visa addVisa(
			String cin, String passport, String nom, String prenom,
			java.util.Date dateNaissance, String motifVoyage,
			java.util.Date dataVoyage, int dureeVoyage,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visaService.addVisa(
			cin, passport, nom, prenom, dateNaissance, motifVoyage, dataVoyage,
			dureeVoyage, serviceContext);
	}

	@Override
	public com.liferay.gwenod.visa.model.Visa deleteVisa(
			long visaId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visaService.deleteVisa(visaId, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa> getAllVisas(
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.gwenod.visa.model.Visa> orderByComparator,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _visaService.getAllVisas(
			start, end, orderByComparator, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa> getAllVisas(
			int start, int end,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _visaService.getAllVisas(start, end, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa> getAllVisas(
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _visaService.getAllVisas(serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _visaService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.gwenod.visa.model.Visa getVisa(
			long visaId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visaService.getVisa(visaId, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa>
			getVisasByKeywords(
				long userId, String keywords, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.gwenod.visa.model.Visa> orderByComparator,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _visaService.getVisasByKeywords(
			userId, keywords, start, end, orderByComparator, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa>
			getVisasByKeywords(
				long userId, String keywords, int start, int end,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _visaService.getVisasByKeywords(
			userId, keywords, start, end, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa> getVisasByUserId(
			long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.gwenod.visa.model.Visa> orderByComparator,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _visaService.getVisasByUserId(
			userId, start, end, orderByComparator, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa> getVisasByUserId(
			long userId, int start, int end,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _visaService.getVisasByUserId(
			userId, start, end, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.gwenod.visa.model.Visa> getVisasByUserId(
			long userId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _visaService.getVisasByUserId(userId, serviceContext);
	}

	@Override
	public long getVisasCountByKeywords(
			long userId, String keywords,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _visaService.getVisasCountByKeywords(
			userId, keywords, serviceContext);
	}

	@Override
	public com.liferay.gwenod.visa.model.Visa updateVisa(
			long visaId, String cin, String passport, String nom, String prenom,
			java.util.Date dateNaissance, String motifVoyage,
			java.util.Date dataVoyage, int dureeVoyage, int etat,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visaService.updateVisa(
			visaId, cin, passport, nom, prenom, dateNaissance, motifVoyage,
			dataVoyage, dureeVoyage, etat, serviceContext);
	}

	@Override
	public VisaService getWrappedService() {
		return _visaService;
	}

	@Override
	public void setWrappedService(VisaService visaService) {
		_visaService = visaService;
	}

	private VisaService _visaService;

}