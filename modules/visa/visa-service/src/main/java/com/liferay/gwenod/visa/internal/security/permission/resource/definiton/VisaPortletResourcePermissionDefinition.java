package com.liferay.gwenod.visa.internal.security.permission.resource.definiton;


import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.gwenod.visa.constants.VisaConstants;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.PortletResourcePermissionDefinition;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = PortletResourcePermissionDefinition.class
)
public class VisaPortletResourcePermissionDefinition
        implements PortletResourcePermissionDefinition {

    @Reference
    private StagingPermission _stagingPermission;

    @Override
    public PortletResourcePermissionLogic[] getPortletResourcePermissionLogics() {
        return new PortletResourcePermissionLogic[]{
                new StagedPortletPermissionLogic(
                        _stagingPermission,
                        "com_liferay_gwenod_visa_portlet_VisaPortlet"
                )
        };
    }

    @Override
    public String getResourceName() {
        return VisaConstants.RESOURCE_NAME;
    }
}
