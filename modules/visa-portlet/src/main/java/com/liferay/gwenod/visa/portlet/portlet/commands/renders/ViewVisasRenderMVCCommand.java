package com.liferay.gwenod.visa.portlet.portlet.commands.renders;

import com.liferay.gwenod.visa.portlet.portlet.context.VisaManagementToolbarDisplayContext;
import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;
import com.liferay.gwenod.visa.model.Visa;
import com.liferay.gwenod.visa.portlet.security.VisaTopLevelPermission;
import com.liferay.gwenod.visa.service.VisaService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + VisaPortletKeys.VISA,
                "mvc.command.name=/",
                "mvc.command.name=" + VisaPortletKeys.MVCCommandNames.VIEW_VISAS
        },
        service = MVCRenderCommand.class
)
public class ViewVisasRenderMVCCommand implements MVCRenderCommand {

    @Reference
    private Portal portal;

    @Reference
    private VisaService visaService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            if (!VisaTopLevelPermission.contains(
                    themeDisplay.getPermissionChecker(),
                    themeDisplay.getScopeGroupId(),
                    ActionKeys.VIEW + "_SELF"
            )) {
                throw new PortalException("You are not authorized to view this widget");
            }

            addManagementToolbarAttributes(renderRequest, renderResponse);
            addPermissionAttributes(renderRequest);
            addVisaListAttributes(renderRequest);
            return VisaPortletKeys.MVCPaths.VIEW_VISAS;
        } catch (PortalException e) {
            renderRequest.setAttribute("errorMessage", e.getMessage());
            renderRequest.setAttribute("callBackURL", "/");
            return VisaPortletKeys.MVCPaths.ERROR;
        }
    }

    private void addPermissionAttributes(RenderRequest renderRequest) {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        boolean canDelete = VisaTopLevelPermission.contains(
                themeDisplay.getPermissionChecker(),
                themeDisplay.getScopeGroupId(),
                ActionKeys.DELETE
        );
        boolean canUpdate = VisaTopLevelPermission.contains(
                themeDisplay.getPermissionChecker(),
                themeDisplay.getScopeGroupId(),
                ActionKeys.UPDATE
        );

        boolean canView = VisaTopLevelPermission.contains(
                themeDisplay.getPermissionChecker(),
                themeDisplay.getScopeGroupId(),
                ActionKeys.VIEW + "_DETAIL"
        );

        boolean canViewPermissions = VisaTopLevelPermission.contains(
                themeDisplay.getPermissionChecker(),
                themeDisplay.getScopeGroupId(),
                ActionKeys.PERMISSIONS
        );

        renderRequest.setAttribute("canDelete", canDelete);
        renderRequest.setAttribute("canUpdate", canUpdate);
        renderRequest.setAttribute("canView", canView);
        renderRequest.setAttribute("canViewPermissions", canViewPermissions);
    }

    private void addVisaListAttributes(
            RenderRequest renderRequest
    ) throws PortalException {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        int currentPage = ParamUtil.getInteger(
                renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
                SearchContainer.DEFAULT_CUR);

        int delta = ParamUtil.getInteger(
                renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
                SearchContainer.DEFAULT_DELTA);

        int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
        int end = start + delta;

        String keywords = ParamUtil.getString(renderRequest, "keywords");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                Visa.class.getName(), renderRequest
        );

        List<Visa> visas = visaService.getVisasByKeywords(
                themeDisplay.getUserId(), keywords, start, end, serviceContext
        );

        Integer visasCountByKeywords =
                Math.toIntExact(visaService.getVisasCountByKeywords(
                        themeDisplay.getUserId(), keywords, serviceContext
                ));

        renderRequest.setAttribute("visas", visas);

        renderRequest.setAttribute("visasCount", visasCountByKeywords);

    }

    private void addManagementToolbarAttributes(
            RenderRequest renderRequest, RenderResponse renderResponse
    ) {
        LiferayPortletRequest liferayPortletRequest =
                portal.getLiferayPortletRequest(renderRequest);

        LiferayPortletResponse liferayPortletResponse =
                portal.getLiferayPortletResponse(renderResponse);

        VisaManagementToolbarDisplayContext visaManagementToolbarDisplayContext =
                new VisaManagementToolbarDisplayContext(
                        liferayPortletRequest, liferayPortletResponse, portal.getHttpServletRequest(renderRequest)
                );

        renderRequest.setAttribute(
                "visaManagementToolbarDisplayContext",
                visaManagementToolbarDisplayContext
        );
    }
}
