package com.liferay.gwenod.visa.portlet.portlet.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.*;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class VisaManagementToolbarDisplayContext extends BaseManagementToolbarDisplayContext {

    private final PortalPreferences _portalPreferences;

    public VisaManagementToolbarDisplayContext(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            HttpServletRequest httpServletRequest
    ) {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse);
        _portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
                liferayPortletRequest);

    }

    @Override
    public CreationMenu getCreationMenu() {
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

    public String getDisplayStyle() {

        String displayStyle = ParamUtil.getString(httpServletRequest, "displayStyle");

        if (Validator.isNull(displayStyle)) {
            displayStyle = _portalPreferences.getValue(
                    VisaPortletKeys.VISA, "visa-display-style",
                    "table");

        } else {
            _portalPreferences.setValue(
                    VisaPortletKeys.VISA, "visa-display-style",
                    displayStyle);

            httpServletRequest.setAttribute(
                    WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);
        }

        return displayStyle;
    }

    @Override
    public String getSearchActionURL() {

        PortletURL searchURL = liferayPortletResponse.createRenderURL();

        searchURL.setProperty(
                "mvcRenderCommandName", VisaPortletKeys.MVCCommandNames.VIEW_VISAS);

        return searchURL.toString();
    }

}
