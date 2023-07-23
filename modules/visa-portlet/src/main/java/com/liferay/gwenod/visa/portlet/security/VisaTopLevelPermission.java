package com.liferay.gwenod.visa.portlet.security;

import com.liferay.gwenod.visa.constants.VisaConstants;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true
)
public class VisaTopLevelPermission {

    private static PortletResourcePermission portletResourcePermission;

    @Reference(
            target = "(resource.name=" + VisaConstants.RESOURCE_NAME + ")",
            unbind = "-"
    )
    protected void setPortletResourcePermission(
            PortletResourcePermission _portletResourcePermission) {
        portletResourcePermission = _portletResourcePermission;
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long groupId, String actionId) {
        return portletResourcePermission.contains(
                permissionChecker,
                groupId,
                actionId
        );
    }
}
