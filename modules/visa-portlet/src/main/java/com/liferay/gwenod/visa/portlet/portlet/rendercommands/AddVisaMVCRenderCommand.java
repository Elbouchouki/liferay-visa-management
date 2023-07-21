package com.liferay.gwenod.visa.portlet.portlet.rendercommands;

import com.liferay.gwenod.visa.portlet.constants.MVCCommandNames;
import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + VisaPortletKeys.VISA,
                "mvc.command.name=" + MVCCommandNames.ADD_VISA
        },
        service = MVCRenderCommand.class
)
public class AddVisaMVCRenderCommand extends BaseMVCActionCommand implements MVCRenderCommand {
    @Override
    public String render(
            RenderRequest renderRequest,
            RenderResponse renderResponse
    ) throws PortletException {
        return "/visa/add.jsp";
    }

    @Override
    protected void doProcessAction(
            ActionRequest actionRequest,
            ActionResponse actionResponse
    ) throws Exception {
        System.out.println("doProcessAction");
    }
}
