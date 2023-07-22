package com.liferay.gwenod.visa.portlet.portlet.commands.view_visas;

import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;
import com.liferay.gwenod.visa.service.exception.NoSuchVisaException;
import com.liferay.gwenod.visa.service.model.Visa;
import com.liferay.gwenod.visa.service.service.VisaLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
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
    private VisaLocalService visaLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        long visaId = ParamUtil.getLong(renderRequest, "visaId", 0);

        System.out.println("visaId: " + visaId);

        try {
            Visa visa = visaLocalService.getVisa(visaId);
            renderRequest.setAttribute("visa", visa);

        } catch (PortalException pe) {
            pe.printStackTrace();
        }
        return VisaPortletKeys.MVCPaths.VIEW_VISA;
    }

}
