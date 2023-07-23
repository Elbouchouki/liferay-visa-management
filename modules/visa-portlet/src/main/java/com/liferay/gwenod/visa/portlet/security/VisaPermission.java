package com.liferay.gwenod.visa.portlet.security;


import com.liferay.gwenod.visa.model.Visa;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = VisaPermission.class
)
public class VisaPermission {
    private static ModelResourcePermission<Visa> visaModelResourcePermission;

    @Reference(
            target = "(model.class.name=com.liferay.gwenod.visa.model.Visa)",
            unbind = "-"
    )
    protected void setEntryModelPermission(
            ModelResourcePermission<Visa> modelResourcePermission) {
        visaModelResourcePermission = modelResourcePermission;
    }

    public static boolean contains(
            PermissionChecker permissionChecker,
            Visa visa,
            String actionId
    ) throws PortalException {
        return visaModelResourcePermission.contains(
                permissionChecker, visa, actionId
        );
    }

    public static boolean contains(
            PermissionChecker permissionChecker,
            long assignmentId,
            String actionId
    ) throws PortalException {
        return visaModelResourcePermission.contains(
                permissionChecker, assignmentId, actionId
        );
    }


}
