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
	public VisaService getWrappedService() {
		return _visaService;
	}

	@Override
	public void setWrappedService(VisaService visaService) {
		_visaService = visaService;
	}

	private VisaService _visaService;

}