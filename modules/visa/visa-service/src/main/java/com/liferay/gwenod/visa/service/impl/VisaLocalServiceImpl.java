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

import com.liferay.gwenod.visa.exception.NoSuchVisaException;
import com.liferay.gwenod.visa.exception.VisaValidationException;
import com.liferay.gwenod.visa.model.Visa;
import com.liferay.gwenod.visa.service.base.VisaLocalServiceBaseImpl;
import com.liferay.gwenod.visa.validator.VisaValidator;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Elbouchouki ahmed
 */
@Component(
        property = "model.class.name=com.liferay.gwenod.visa.model.Visa",
        service = AopService.class
)
public class VisaLocalServiceImpl extends VisaLocalServiceBaseImpl {
    @Reference
    private VisaValidator visaValidator;

    public Visa addVisa(
            String cin, String passport, String nom,
            String prenom, Date dateNaissance, String motifVoyage,
            Date dataVoyage, int dureeVoyage, ServiceContext serviceContext
    ) throws PortalException {
        Visa visa = createVisa(
                counterLocalService.increment(
                        Visa.class.getName()
                )
        );

        visa.setUserId(serviceContext.getUserId());
        visa.setGroupId(serviceContext.getScopeGroupId());
        visa.setCompanyId(serviceContext.getCompanyId());
        visa.setCreateDate(new Date());

        fillEntity(
                visa, cin, passport, nom, prenom, dateNaissance,
                motifVoyage, dataVoyage, dureeVoyage, 0
        );

        Visa addedVisa = super.addVisa(visa);

        boolean portletActions = false;
        boolean addGroupPermissions = true;
        boolean addGuestPermissions = true;

        resourceLocalService.addResources(
                visa.getCompanyId(), visa.getGroupId(), visa.getUserId(),
                Visa.class.getName(), visa.getVisaId(), portletActions,
                addGroupPermissions, addGuestPermissions
        );

        return addedVisa;

    }

    public Visa updateVisa(
            long visaId,
            String cin, String passport, String nom,
            String prenom, Date dateNaissance, String motifVoyage,
            Date dataVoyage, int dureeVoyage, int etat,
            ServiceContext serviceContext
    ) throws PortalException {
        Visa visa = this.getVisaById(visaId).orElseThrow(
                () -> new NoSuchVisaException("Visa with id " + visaId + " not found")
        );

        visa.setModifiedBy(serviceContext.getUserId());
        visa.setModifiedDate(new Date());

        fillEntity(
                visa, cin, passport, nom, prenom, dateNaissance,
                motifVoyage, dataVoyage, dureeVoyage, etat
        );

        return super.updateVisa(visa);
    }

    public Visa deleteVisa(long visaId)
            throws PortalException {
        Visa visa = this.getVisaById(visaId).orElseThrow(
                () -> new com.liferay.gwenod.visa.exception.NoSuchVisaException("Visa with id " + visaId + " not found")
        );

        resourceLocalService.deleteResource(
                visa, ResourceConstants.SCOPE_INDIVIDUAL
        );

        return visaPersistence.remove(visa);
    }

    public Visa getVisa(long visaId)
            throws PortalException {
        return this.getVisaById(visaId).orElseThrow(
                () -> new NoSuchVisaException("Visa with id " + visaId + " not found")
        );
    }


    // find all visas
    public List<Visa> getAllVisas() {
        return visaPersistence.findAll();
    }

    public List<Visa> getAllVisas(int start, int end) {
        return visaPersistence.findAll(start, end);
    }

    public List<Visa> getAllVisas(int start, int end, OrderByComparator<Visa> orderByComparator) {
        return visaPersistence.findAll(start, end, orderByComparator);
    }

    // find visas by user id

    public List<Visa> getVisasByUserId(long userId) {
        return visaPersistence.findByUserId(userId);
    }

    public List<Visa> getVisasByUserId(long userId, int start, int end) {
        return visaPersistence.findByUserId(userId, start, end);
    }

    public List<Visa> getVisasByUserId(long userId, int start, int end, OrderByComparator<Visa> orderByComparator) {
        return visaPersistence.findByUserId(userId, start, end, orderByComparator);
    }

    // find visas by user id and keywords

    public List<Visa> getVisasByKeywords(
            long userId, String keywords, int start, int end
    ) {
        return visaLocalService.dynamicQuery(
                getKeywordSearchDynamicQuery(userId, keywords), start, end
        );
    }

    public List<Visa> getVisasByKeywords(
            long userId, String keywords, int start, int end,
            OrderByComparator<Visa> orderByComparator) {
        return visaLocalService.dynamicQuery(
                getKeywordSearchDynamicQuery(userId, keywords), start, end,
                orderByComparator);
    }

    public long getVisasCountByKeywords(long userId, String keywords) {
        return visaLocalService.dynamicQueryCount(
                getKeywordSearchDynamicQuery(userId, keywords));
    }


    private DynamicQuery getKeywordSearchDynamicQuery(
            long userId, String keywords) {
        DynamicQuery dynamicQuery = dynamicQuery().add(
                RestrictionsFactoryUtil.eq("userId", userId));
        if (Validator.isNotNull(keywords)) {
            Disjunction disjunctionQuery =
                    RestrictionsFactoryUtil.disjunction();
            disjunctionQuery.add(
                    RestrictionsFactoryUtil.like(
                            "cin", "%" + keywords + "%")
            );
            disjunctionQuery.add(
                    RestrictionsFactoryUtil.like(
                            "passport", "%" + keywords + "%")
            );
            disjunctionQuery.add(
                    RestrictionsFactoryUtil.like(
                            "nom", "%" + keywords + "%")
            );
            disjunctionQuery.add(
                    RestrictionsFactoryUtil.like(
                            "prenom", "%" + keywords + "%")
            );
            dynamicQuery.add(disjunctionQuery);
        }
        return dynamicQuery;
    }


    private Optional<Visa> getVisaById(long visaId) {
        return Optional.ofNullable(visaPersistence.fetchByPrimaryKey(visaId));
    }

    private void fillEntity(
            Visa visa,
            String cin, String passport, String nom,
            String prenom, Date dateNaissance, String motifVoyage,
            Date dataVoyage, int dureeVoyage, int etat
    ) throws VisaValidationException {
        if (visa == null) return;
        if (cin != null) visa.setCin(cin);
        if (passport != null) visa.setPassport(passport);
        if (nom != null) visa.setNom(nom);
        if (prenom != null) visa.setPrenom(prenom);
        if (dateNaissance != null) visa.setDateNaissance(dateNaissance);
        if (motifVoyage != null) visa.setMotifVoyage(motifVoyage);
        if (dataVoyage != null) visa.setDateVoyage(dataVoyage);
        if (dureeVoyage != 0) visa.setDureeVoyage(dureeVoyage);
        visa.setEtat(etat);
        visaValidator.validate(visa);
    }

    @Override
    public Visa addVisa(Visa visa) {
        throw new UnsupportedOperationException("Not Supported Any More");
    }

    @Override
    public Visa updateVisa(Visa visa) {
        throw new UnsupportedOperationException("Not Supported Any More");
    }
}