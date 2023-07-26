package com.liferay.gwenod.visa.portlet.portlet.commands.actions;


import com.liferay.gwenod.visa.model.Visa;
import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;
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

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + VisaPortletKeys.VISA,
                "mvc.command.name=" + VisaPortletKeys.MVCCommandNames.DELETE_VISA
        },
        service = MVCActionCommand.class
)
public class DeleteVisaActionMVCCommand extends BaseMVCActionCommand {
    @Reference
    private VisaService visaService;

    @Override
    protected void doProcessAction(
            ActionRequest actionRequest,
            ActionResponse actionResponse
    ) throws Exception {
        long visaId = ParamUtil.getLong(actionRequest, "visaId");
        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                Visa.class.getName(), actionRequest
        );
        try {
            visaService.deleteVisa(visaId, serviceContext);
            SessionMessages.add(actionRequest, "visaDeleted");
        } catch (Exception e) {
            SessionErrors.add(actionRequest, "serviceErrorDetails", e);
        }
    }
}
