package com.liferay.gwenod.visa.portlet.portlet.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;
import com.liferay.gwenod.visa.portlet.security.VisaTopLevelPermission;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class VisaManagementToolbarDisplayContext extends BaseManagementToolbarDisplayContext {
    private final ThemeDisplay themeDisplay;

    public VisaManagementToolbarDisplayContext(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            HttpServletRequest httpServletRequest
    ) {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse);
        themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    @Override
    public CreationMenu getCreationMenu() {

        if (!VisaTopLevelPermission.contains(
                themeDisplay.getPermissionChecker(),
                themeDisplay.getScopeGroupId(),
                "ADD_ENTRY")) {
            return null;
        }

        return new CreationMenu() {
            {
                addDropdownItem(
                        dropdownItem -> {
                            dropdownItem.setHref(
                                    liferayPortletResponse.createRenderURL(),
                                    "mvcRenderCommandName", VisaPortletKeys.MVCCommandNames.ADD_VISA,
                                    "redirect", currentURLObj.toString());
                            dropdownItem.setLabel(
                                    LanguageUtil.get(httpServletRequest, "visa.add"));
                        });

            }
        };
    }

    @Override
    public String getClearResultsURL() {
        return getSearchActionURL();
    }

    @Override
    public String getSearchActionURL() {

        PortletURL searchURL = liferayPortletResponse.createRenderURL();

        searchURL.setProperty(
                "mvcRenderCommandName", VisaPortletKeys.MVCCommandNames.VIEW_VISAS);

        return searchURL.toString();
    }

}
