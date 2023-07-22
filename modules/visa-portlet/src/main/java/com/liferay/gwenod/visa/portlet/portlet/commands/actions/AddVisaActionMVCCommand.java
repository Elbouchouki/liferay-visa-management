package com.liferay.gwenod.visa.portlet.portlet.commands.actions;

import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;
import com.liferay.gwenod.visa.exception.VisaValidationException;
import com.liferay.gwenod.visa.model.Visa;
import com.liferay.gwenod.visa.service.VisaLocalService;
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

import javax.portlet.*;
import java.util.Date;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + VisaPortletKeys.VISA,
                "mvc.command.name=" + VisaPortletKeys.MVCCommandNames.ADD_VISA
        },
        service = MVCActionCommand.class
)
public class AddVisaActionMVCCommand extends BaseMVCActionCommand {

    @Reference
    private VisaLocalService visaLocalService;


    @Override
    protected void doProcessAction(
            ActionRequest actionRequest,
            ActionResponse actionResponse
    ) throws Exception {

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

            visaLocalService.addVisa(
                    cin,
                    passport,
                    nom,
                    prenom,
                    dateNaissance,
                    motifVoyage,
                    dataVoyage,
                    dureeVoyage,
                    serviceContext
            );

            SessionMessages.add(actionRequest, "visaAdded");

        } catch (VisaValidationException vve) {
            vve.printStackTrace();

            vve.getErrors().forEach(
                    key -> SessionErrors.add(actionRequest, key)
            );
            SessionErrors.add(actionRequest, "serviceErrorDetails", vve);

            actionResponse.getRenderParameters().setValue(
                    "mvcRenderCommandName", VisaPortletKeys.MVCCommandNames.ADD_VISA);

        } catch (PortalException pe) {

            pe.printStackTrace();

            SessionErrors.add(actionRequest, "serviceErrorDetails", pe);

            actionResponse.getRenderParameters().setValue(
                    "mvcRenderCommandName", VisaPortletKeys.MVCCommandNames.ADD_VISA);
        }

    }
}
