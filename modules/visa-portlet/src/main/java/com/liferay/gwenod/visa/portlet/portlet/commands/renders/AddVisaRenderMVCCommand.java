package com.liferay.gwenod.visa.portlet.portlet.commands.renders;

import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + VisaPortletKeys.VISA,
                "mvc.command.name=" + VisaPortletKeys.MVCCommandNames.ADD_VISA
        },
        service = MVCRenderCommand.class
)
public class AddVisaRenderMVCCommand implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest,
            RenderResponse renderResponse
    ) throws PortletException {
        return VisaPortletKeys.MVCPaths.ADD_VISA;
    }

}
