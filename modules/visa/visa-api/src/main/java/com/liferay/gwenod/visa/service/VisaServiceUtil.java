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
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * Provides the remote service utility for Visa. This utility wraps
 * <code>com.liferay.gwenod.visa.service.impl.VisaServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see VisaService
 * @generated
 */
public class VisaServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.gwenod.visa.service.impl.VisaServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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

	public static Visa deleteVisa(
			long visaId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().deleteVisa(visaId, serviceContext);
	}

	public static List<Visa> getAllVisas(
			int start, int end, OrderByComparator<Visa> orderByComparator,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().getAllVisas(
			start, end, orderByComparator, serviceContext);
	}

	public static List<Visa> getAllVisas(
			int start, int end,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().getAllVisas(start, end, serviceContext);
	}

	public static List<Visa> getAllVisas(
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().getAllVisas(serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Visa getVisa(
			long visaId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().getVisa(visaId, serviceContext);
	}

	public static List<Visa> getVisasByKeywords(
			long userId, String keywords, int start, int end,
			OrderByComparator<Visa> orderByComparator,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().getVisasByKeywords(
			userId, keywords, start, end, orderByComparator, serviceContext);
	}

	public static List<Visa> getVisasByKeywords(
			long userId, String keywords, int start, int end,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().getVisasByKeywords(
			userId, keywords, start, end, serviceContext);
	}

	public static List<Visa> getVisasByUserId(
			long userId, int start, int end,
			OrderByComparator<Visa> orderByComparator,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().getVisasByUserId(
			userId, start, end, orderByComparator, serviceContext);
	}

	public static List<Visa> getVisasByUserId(
			long userId, int start, int end,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().getVisasByUserId(
			userId, start, end, serviceContext);
	}

	public static List<Visa> getVisasByUserId(
			long userId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().getVisasByUserId(userId, serviceContext);
	}

	public static long getVisasCountByKeywords(
			long userId, String keywords,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().getVisasCountByKeywords(
			userId, keywords, serviceContext);
	}

	public static Visa updateVisa(
			long visaId, String cin, String passport, String nom, String prenom,
			java.util.Date dateNaissance, String motifVoyage,
			java.util.Date dataVoyage, int dureeVoyage, int etat,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateVisa(
			visaId, cin, passport, nom, prenom, dateNaissance, motifVoyage,
			dataVoyage, dureeVoyage, etat, serviceContext);
	}

	public static VisaService getService() {
		return _service;
	}

	private static volatile VisaService _service;

}