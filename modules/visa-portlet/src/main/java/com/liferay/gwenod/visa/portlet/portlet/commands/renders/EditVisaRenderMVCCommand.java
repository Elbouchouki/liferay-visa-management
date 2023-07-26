package com.liferay.gwenod.visa.portlet.portlet.commands.renders;

import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;
import com.liferay.gwenod.visa.model.Visa;
import com.liferay.gwenod.visa.service.VisaService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.text.DateFormat;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + VisaPortletKeys.VISA,
                "mvc.command.name=" + VisaPortletKeys.MVCCommandNames.EDIT_VISA
        },
        service = MVCRenderCommand.class
)
public class EditVisaRenderMVCCommand implements MVCRenderCommand {
    @Reference
    private VisaService visaService;

    @Override
    public String render(
            RenderRequest renderRequest,
            RenderResponse renderResponse
    ) throws PortletException {

        long visaId = ParamUtil.getLong(renderRequest, "visaId", 0);

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(
                    Visa.class.getName(), renderRequest
            );

            Visa visa = visaService.getVisa(visaId, serviceContext);
            DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
                    "EEE MMM dd HH:mm:ss z yyyy"
            );
            renderRequest.setAttribute(
                    "dateNaissance", dateFormat.format(visa.getDateNaissance()));
            renderRequest.setAttribute(
                    "dateVoyage", dateFormat.format(visa.getDateVoyage()));
            renderRequest.setAttribute("visa", visa);

        } catch (PortalException pe) {
            pe.printStackTrace();
        }

        return VisaPortletKeys.MVCPaths.EDIT_VISA;
    }

}
