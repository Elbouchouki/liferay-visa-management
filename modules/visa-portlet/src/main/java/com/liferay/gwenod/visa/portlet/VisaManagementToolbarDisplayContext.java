package com.liferay.gwenod.visa.portlet;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.gwenod.visa.portlet.constants.MVCCommandNames;
import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.http.HttpServletRequest;

public class VisaManagementToolbarDisplayContext extends BaseManagementToolbarDisplayContext {

    private final PortalPreferences _portalPreferences;
    private final ThemeDisplay _themeDisplay;

    public VisaManagementToolbarDisplayContext(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            HttpServletRequest httpServletRequest
    ) {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse);
        _portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
                liferayPortletRequest);

        _themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    @Override
    public CreationMenu getCreationMenu() {
        return new CreationMenu() {
            {
                addDropdownItem(
                        dropdownItem -> {
                            dropdownItem.setHref(
                                    liferayPortletResponse.createRenderURL(),
                                    "mvcRenderCommandName", MVCCommandNames.ADD_VISA,
                                    "redirect", currentURLObj.toString());
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "add-assignment"));
                        });
            }
        };
    }

    @Override
    protected String[] getNavigationKeys() {
        return new String[]{"all", "pending", "done"};
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
                    "descriptive");
        } else {
            _portalPreferences.setValue(
                    VisaPortletKeys.VISA, "visa-display-style",
                    displayStyle);

            httpServletRequest.setAttribute(
                    WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);
        }

        return displayStyle;
    }

   /* @Override
    protected List<DropdownItem> getOrderByDropdownItems() {
        return new DropdownItemList() {
            {
                add(
                        dropdownItem -> {
                            dropdownItem.setActive("title".equals(getOrderByCol()));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "orderByCol", "title");
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "title"));
                        });

                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    "createDate".equals(getOrderByCol()));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "orderByCol",
                                    "createDate");
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "create-date"));
                        });
            }
        };
    }
    private PortletURL _getCurrentSortingURL() throws PortletException {
        PortletURL sortingURL = PortletURLUtil.clone(
                currentURLObj, liferayPortletResponse);

        sortingURL.setParameter(
                "mvcRenderCommandName", "/visas/view");

        // Reset current page.

        sortingURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0");

        String keywords = ParamUtil.getString(request, "keywords");

        if (Validator.isNotNull(keywords)) {
            sortingURL.setParameter("keywords", keywords);
        }

        return sortingURL;
    }
    */


    /*@Override
    public String getSearchActionURL() {

        PortletURL searchURL = liferayPortletResponse.createRenderURL();


        searchURL.setProperty("mvcRenderCommandName", "/visas/view");

        String navigation = ParamUtil.getString(
                httpServletRequest,
                "navigation",
                "entries"
        );

        String orderByCol = ParamUtil.getString(httpServletRequest, "orderByCol", "cin");
        String orderByType = ParamUtil.getString(httpServletRequest, "orderByType", "asc");

        searchURL.getRenderParameters().setValue("navigation", navigation);
        searchURL.getRenderParameters().setValue("orderByCol", orderByCol);
        searchURL.getRenderParameters().setValue("orderByType", orderByType);

        return searchURL.toString();
    }*/

}
