/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.gwenod.visa.service.exception;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * @author Elbouchouki ahmed
 */
public class VisaValidationException extends PortalException {
    private List<String> _errors;

    public List<String> getErrors() {
        return _errors;
    }

    public VisaValidationException(List<String> errors) {
        super(String.join(",", errors));
        _errors = errors;
    }

    public VisaValidationException() {
    }

    public VisaValidationException(String msg) {
        super(msg);
    }

    public VisaValidationException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public VisaValidationException(Throwable throwable) {
        super(throwable);
    }

}