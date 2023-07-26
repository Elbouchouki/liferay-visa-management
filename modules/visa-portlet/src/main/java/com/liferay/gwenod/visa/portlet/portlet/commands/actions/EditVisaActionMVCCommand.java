package com.liferay.gwenod.visa.portlet.portlet.commands.actions;

import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;
import com.liferay.gwenod.visa.exception.VisaValidationException;
import com.liferay.gwenod.visa.model.Visa;
import com.liferay.gwenod.visa.service.VisaService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Date;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + VisaPortletKeys.VISA,
                "mvc.command.name=" + VisaPortletKeys.MVCCommandNames.EDIT_VISA
        },
        service = MVCActionCommand.class
)
public class EditVisaActionMVCCommand extends BaseMVCActionCommand {

    @Reference
    private VisaService visaService;


    @Override
    protected void doProcessAction(
            ActionRequest actionRequest,
            ActionResponse actionResponse
    ) throws Exception {

        long visaId = ParamUtil.getLong(actionRequest, "visaId");
        int etat = ParamUtil.getInteger(actionRequest, "etat");
        String cin = ParamUtil.getString(actionRequest, "cin");
        String passport = ParamUtil.getString(actionRequest, "passport");
        String nom = ParamUtil.getString(actionRequest, "nom");
        String prenom = ParamUtil.getString(actionRequest, "prenom");
        Date dateNaissance = ParamUtil.getDate(actionRequest, "dateNaissance", null);
        String motifVoyage = ParamUtil.getString(actionRequest, "motifVoyage");
        Date dataVoyage = ParamUtil.getDate(actionRequest, "dataVoyage", null);
        int dureeVoyage = ParamUtil.getInteger(actionRequest, "dureeVoyage");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                Visa.class.getName(), actionRequest
        );

        try {
            visaService.updateVisa(
                    visaId,
                    cin,
                    passport,
                    nom,
                    prenom,
                    dateNaissance,
                    motifVoyage,
                    dataVoyage,
                    dureeVoyage,
                    etat,
                    serviceContext
            );

            SessionMessages.add(actionRequest, "visaEdited");

        } catch (VisaValidationException vve) {
            vve.printStackTrace();

            vve.getErrors().forEach(
                    key -> SessionErrors.add(actionRequest, key)
            );
            SessionErrors.add(actionRequest, "serviceErrorDetails", vve);

            actionResponse.getRenderParameters().setValue(
                    "mvcRenderCommandName", VisaPortletKeys.MVCCommandNames.EDIT_VISA);

        } catch (Exception pe) {

            pe.printStackTrace();

            SessionErrors.add(actionRequest, "serviceErrorDetails", pe);

            actionResponse.getRenderParameters().setValue(
                    "mvcRenderCommandName", VisaPortletKeys.MVCCommandNames.EDIT_VISA);
        }

    }
}
