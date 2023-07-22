package com.liferay.gwenod.visa.portlet.portlet.commands.view_visas;

import com.liferay.gwenod.visa.portlet.VisaManagementToolbarDisplayContext;
import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;
import com.liferay.gwenod.visa.service.model.Visa;
import com.liferay.gwenod.visa.service.service.VisaLocalService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
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
    private VisaLocalService visaLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        addManagementToolbarAttributes(renderRequest, renderResponse);
        addVisaListAttributes(renderRequest);
        return VisaPortletKeys.MVCPaths.VIEW_VISAS;
    }


    private void addVisaListAttributes(
            RenderRequest renderRequest
    ) {

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

//        String orderByCol =
//                ParamUtil.getString(renderRequest, "orderByCol", "title");
        String orderByType =
                ParamUtil.getString(renderRequest, "orderByType", "asc");
        System.out.println("orderByType: " + orderByType);
//
//        OrderByComparator<Assignment> comparator =
//                OrderByComparatorFactoryUtil.create(
//                        "Assignment", orderByCol, !("asc").equals(orderByType));

        String keywords = ParamUtil.getString(renderRequest, "keywords");

        List<Visa> visas = visaLocalService.getVisasByKeywords(
                themeDisplay.getUserId(), keywords, start, end
        );

        long visasCountByKeywords = visaLocalService.getVisasCountByKeywords(
                themeDisplay.getUserId(), keywords
        );

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
