package com.liferay.gwenod.visa.portlet.portlet.commands.renders;

import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;
import com.liferay.gwenod.visa.model.Visa;
import com.liferay.gwenod.visa.service.VisaService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
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
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        long visaId = ParamUtil.getLong(renderRequest, "visaId", 0);

        try {
            Visa visa = visaService.getVisa(visaId);
            if (visa.getModifiedBy() != 0) {
                User modifiedBy = UserLocalServiceUtil.getUser(visa.getUserId());
                renderRequest.setAttribute("modifiedBy", modifiedBy);
            }
            renderRequest.setAttribute("visa", visa);
        } catch (PortalException pe) {
            pe.printStackTrace();
        }
        return VisaPortletKeys.MVCPaths.VIEW_VISA;
    }

}
