package com.liferay.gwenod.visa.portlet.portlet;

import com.liferay.gwenod.visa.portlet.constants.VisaPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;

/**
 * @author Elbouchouki Ahmed
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=visa",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=Visa",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + VisaPortletKeys.VISA,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },

        service = Portlet.class
)
public class VisaPortlet extends MVCPortlet {
}