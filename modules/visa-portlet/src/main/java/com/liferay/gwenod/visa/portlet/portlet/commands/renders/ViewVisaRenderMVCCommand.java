package com.liferay.gwenod.visa.portlet.portlet.commands.renders;

import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;
import com.liferay.gwenod.visa.model.Visa;
import com.liferay.gwenod.visa.service.VisaService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + VisaPortletKeys.VISA,
                "mvc.command.name=" + VisaPortletKeys.MVCCommandNames.VIEW_VISA
        },
        service = MVCRenderCommand.class
)
public class ViewVisaRenderMVCCommand implements MVCRenderCommand {
    @Reference
    private VisaService visaService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        long visaId = ParamUtil.getLong(renderRequest, "visaId", 0);
        System.out.println("->  visaId: " + visaId);

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(
                    Visa.class.getName(), renderRequest
            );
            Visa visa = visaService.getVisa(visaId, serviceContext);
            if (visa.getModifiedBy() != 0) {
                User modifiedBy = UserLocalServiceUtil.getUser(visa.getUserId());
                renderRequest.setAttribute("modifiedBy", modifiedBy);
            }

            renderRequest.setAttribute("visa", visa);
        } catch (PortalException pe) {
            System.out.println("->  Error while getting visa ...");
            pe.printStackTrace();
        }
        return VisaPortletKeys.MVCPaths.VIEW_VISA;
    }

}
