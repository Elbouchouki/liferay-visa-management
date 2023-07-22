package com.liferay.gwenod.visa.service.validator.impl;

import com.liferay.gwenod.visa.service.exception.VisaValidationException;
import com.liferay.gwenod.visa.service.model.Visa;
import com.liferay.gwenod.visa.service.validator.VisaValidator;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component(
        immediate = true,
        service = VisaValidator.class
)
public class VisaValidatorImpl implements VisaValidator {

    @Override
    public void validate(Visa visa) throws VisaValidationException {
        validate(
                visa.getCin(), visa.getPassport(), visa.getNom(),
                visa.getPrenom(), visa.getDateNaissance(), visa.getMotifVoyage(),
                visa.getDateVoyage(), visa.getDureeVoyage()
        );
    }

    @Override
    public void validate(
            String cin, String passport, String nom, String prenom,
            Date dateNaissance, String motifVoyage, Date dateVoyage, int dureeVoyage
    ) throws VisaValidationException {
        List<String> errors = new ArrayList<>();

        boolean isValid = true;

        if (cin == null || cin.isEmpty()) {
            errors.add("CIN is required");
            isValid = false;
        }

        if (passport == null || passport.isEmpty()) {
            errors.add("Passport is required");
            isValid = false;
        }

        if (nom == null || nom.isEmpty()) {
            errors.add("Nom is required");
            isValid = false;
        }

        if (prenom == null || prenom.isEmpty()) {
            errors.add("Prenom is required");
            isValid = false;
        }

        if (motifVoyage == null || motifVoyage.isEmpty()) {
            errors.add("Motif de voyage is required");
            isValid = false;
        }

        if (dateNaissance == null) {
            errors.add("Date de naissance is required");
            isValid = false;
        }

        if (dateVoyage == null) {
            errors.add("Date de voyage is required");
            isValid = false;
        }

        if (dureeVoyage <= 0) {
            errors.add("Duree de voyage is required");
            isValid = false;
        }

        if (!isValid) {
            throw new VisaValidationException(errors);
        }
    }
}
