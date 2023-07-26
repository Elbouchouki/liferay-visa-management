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

package com.liferay.gwenod.visa.service.impl;

import com.liferay.gwenod.visa.constants.VisaConstants;
import com.liferay.gwenod.visa.model.Visa;
import com.liferay.gwenod.visa.service.base.VisaServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import java.util.Date;
import java.util.List;

/**
 * @author Elbouchouki ahmed
 */
@Component(
        property = {
                "json.web.service.context.name=visamanagement",
                "json.web.service.context.path=Visa"
        },
        service = AopService.class
)
public class VisaServiceImpl extends VisaServiceBaseImpl {
    //    @Reference(
//            policy = ReferencePolicy.DYNAMIC,
//            policyOption = ReferencePolicyOption.GREEDY,
//            target = "(model.class.name=com.liferay.gwenod.visa.model.Visa)"
//    )
//    private volatile ModelResourcePermission<Visa> visaModelResourcePermission;
//
    @Reference(
            policy = ReferencePolicy.DYNAMIC,
            policyOption = ReferencePolicyOption.GREEDY,
            target = "(resource.name=" + VisaConstants.RESOURCE_NAME + ")"
    )
    private volatile PortletResourcePermission portletResourcePermission;


    public Visa addVisa(
            String cin, String passport, String nom,
            String prenom, Date dateNaissance, String motifVoyage,
            Date dataVoyage, int dureeVoyage, ServiceContext serviceContext
    ) throws PortalException {


        portletResourcePermission.check(
                getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.ADD_ENTRY
        );

        return visaLocalService.addVisa(
                cin, passport, nom, prenom, dateNaissance,
                motifVoyage, dataVoyage, dureeVoyage, serviceContext
        );
    }

    public Visa updateVisa(
            long visaId,
            String cin, String passport, String nom,
            String prenom, Date dateNaissance, String motifVoyage,
            Date dataVoyage, int dureeVoyage, int etat,
            ServiceContext serviceContext
    ) throws PortalException {

        portletResourcePermission.check(
                getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.UPDATE
        );

        return visaLocalService.updateVisa(
                visaId, cin, passport, nom, prenom, dateNaissance,
                motifVoyage, dataVoyage, dureeVoyage, etat, serviceContext
        );
    }

    public Visa deleteVisa(long visaId, ServiceContext serviceContext)
            throws PortalException {
        portletResourcePermission.check(
                getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.DELETE
        );
        return visaLocalService.deleteVisa(visaId);
    }

    public Visa getVisa(long visaId, ServiceContext serviceContext)
            throws PortalException {

        Visa visa = visaLocalService.getVisa(visaId);

        portletResourcePermission.check(
                getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.VIEW + "_DETAIL"
        );

        return visa;
    }

    // find all visas
    public List<Visa> getAllVisas(ServiceContext serviceContext) throws PrincipalException {
        portletResourcePermission.check(
                getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.VIEW + "_ALL"
        );
        return visaLocalService.getAllVisas();
    }

    public List<Visa> getAllVisas(int start, int end, ServiceContext serviceContext) throws PrincipalException {
        portletResourcePermission.check(
                getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.VIEW + "_ALL"
        );
        return visaLocalService.getAllVisas(start, end);
    }

    public List<Visa> getAllVisas(int start, int end, OrderByComparator<Visa> orderByComparator, ServiceContext serviceContext) throws PrincipalException {
        portletResourcePermission.check(
                getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.VIEW + "_ALL"
        );
        return visaLocalService.getAllVisas(start, end, orderByComparator);
    }

    // find visas by user id
    public List<Visa> getVisasByUserId(long userId, ServiceContext serviceContext) throws PrincipalException {
        portletResourcePermission.check(
                getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.VIEW + "_ALL"
        );
        return visaLocalService.getVisasByUserId(userId);

    }

    public List<Visa> getVisasByUserId(long userId, int start, int end, ServiceContext serviceContext) throws PrincipalException {
        portletResourcePermission.check(
                getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.VIEW + "_SELF"
        );
        return visaLocalService.getVisasByUserId(userId, start, end);
    }

    public List<Visa> getVisasByUserId(long userId, int start, int end, OrderByComparator<Visa> orderByComparator, ServiceContext serviceContext) throws PrincipalException {
        portletResourcePermission.check(
                getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.VIEW + "_SELF"
        );
        return visaLocalService.getVisasByUserId(userId, start, end, orderByComparator);
    }

    // find visas by user id and keywords
    public List<Visa> getVisasByKeywords(
            long userId, String keywords, int start, int end, ServiceContext serviceContext
    ) throws PrincipalException {
        portletResourcePermission.check(
                getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.VIEW + "_SELF"
        );
        return visaLocalService.getVisasByKeywords(userId, keywords, start, end);
    }

    public List<Visa> getVisasByKeywords(
            long userId, String keywords, int start, int end,
            OrderByComparator<Visa> orderByComparator, ServiceContext serviceContext
    ) throws PrincipalException {
        portletResourcePermission.check(
                getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.VIEW + "_SELF"
        );
        return visaLocalService.getVisasByKeywords(userId, keywords, start, end, orderByComparator);
    }

    public long getVisasCountByKeywords(long userId, String keywords, ServiceContext serviceContext
    ) throws PrincipalException {
        portletResourcePermission.check(
                getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.VIEW + "_SELF"
        );
        return visaLocalService.getVisasCountByKeywords(userId, keywords);
    }


}