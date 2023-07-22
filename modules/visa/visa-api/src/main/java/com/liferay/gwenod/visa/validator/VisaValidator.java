

package com.liferay.gwenod.visa.validator;

import com.liferay.gwenod.visa.exception.VisaValidationException;
import com.liferay.gwenod.visa.model.Visa;

import java.util.Date;

public interface VisaValidator {
    void validate(
            String cin, String passport, String nom,
            String prenom, Date dateNaissance, String motifVoyage,
            Date dataVoyage, int dureeVoyage, int etat
    ) throws VisaValidationException;

    void validate(Visa visa) throws VisaValidationException;
}
