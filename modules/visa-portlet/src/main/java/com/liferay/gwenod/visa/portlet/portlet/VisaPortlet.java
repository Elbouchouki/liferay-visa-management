package com.liferay.gwenod.visa.portlet.portlet;

import com.liferay.gwenod.visa.portlet.VisaManagementToolbarDisplayContext;
import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;

import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.Date;

/**
 * @author elbou
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=visa",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=Visa",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + VisaPortletKeys.VISA,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },

        service = Portlet.class
)
public class VisaPortlet extends MVCPortlet {

    @Reference
    private Portal _portal;


    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
        addManagementToolbarAttributes(renderRequest, renderResponse);
        super.render(renderRequest, renderResponse);
    }

    private void addManagementToolbarAttributes(
            RenderRequest renderRequest, RenderResponse renderResponse
    ) {
        LiferayPortletRequest liferayPortletRequest =
                _portal.getLiferayPortletRequest(renderRequest);

        LiferayPortletResponse liferayPortletResponse =
                _portal.getLiferayPortletResponse(renderResponse);

        VisaManagementToolbarDisplayContext visaManagementToolbarDisplayContext =
                new VisaManagementToolbarDisplayContext(
                        liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest)
                );

        renderRequest.setAttribute(
                "visaManagementToolbarDisplayContext",
                visaManagementToolbarDisplayContext
        );

    }

    @ProcessAction(name = "addVisa")
    public void addVisa(ActionRequest actionRequest, ActionResponse actionResponse) {
        System.out.println("addVisa");
        String cin = ParamUtil.getString(actionRequest, "cin");
        String passport = ParamUtil.getString(actionRequest, "passport");
        String nom = ParamUtil.getString(actionRequest, "nom");
        String prenom = ParamUtil.getString(actionRequest, "prenom");
        Date dateNaissance = ParamUtil.getDate(actionRequest, "dateNaissance", null);
        String motifVoyage = ParamUtil.getString(actionRequest, "motifVoyage");
        Date dataVoyage = ParamUtil.getDate(actionRequest, "dataVoyage", null);
        int dureeVoyage = ParamUtil.getInteger(actionRequest, "dureeVoyage");

        System.out.println("cin: " + cin);
        System.out.println("passport: " + passport);
        System.out.println("nom: " + nom);
        System.out.println("prenom: " + prenom);
        System.out.println("dateNaissance: " + dateNaissance);
        System.out.println("motifVoyage: " + motifVoyage);
        System.out.println("dataVoyage: " + dataVoyage);
        System.out.println("dureeVoyage: " + dureeVoyage);

    }
}