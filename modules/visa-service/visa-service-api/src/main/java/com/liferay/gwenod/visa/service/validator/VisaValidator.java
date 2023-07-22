package com.liferay.gwenod.visa.service.validator;

import com.liferay.gwenod.visa.service.exception.VisaValidationException;
import com.liferay.gwenod.visa.service.model.Visa;

import java.util.Date;

public interface VisaValidator {
    void validate(
            String cin, String passport, String nom,
            String prenom, Date dateNaissance, String motifVoyage,
            Date dataVoyage, int dureeVoyage
    ) throws VisaValidationException;

    void validate(Visa visa) throws VisaValidationException;
}
