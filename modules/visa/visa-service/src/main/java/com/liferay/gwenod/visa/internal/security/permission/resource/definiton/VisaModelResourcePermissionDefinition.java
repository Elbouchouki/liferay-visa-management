package com.liferay.gwenod.visa.internal.security.permission.resource.definiton;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.gwenod.visa.constants.VisaConstants;
import com.liferay.gwenod.visa.model.Visa;
import com.liferay.gwenod.visa.service.impl.VisaLocalServiceImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.ModelResourcePermissionDefinition;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.function.Consumer;

@Component(
        immediate = true,
        service = ModelResourcePermissionDefinition.class
)
public class VisaModelResourcePermissionDefinition
        implements ModelResourcePermissionDefinition<Visa> {

    @Reference
    private VisaLocalServiceImpl visaLocalServiceImpl;

    @Reference(target = "(resource.name=" + VisaConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;

    @Reference
    private StagingPermission _stagingPermission;

    @Override
    public Visa getModel(long visaId) throws PortalException {
        return visaLocalServiceImpl.getVisa(visaId);
    }

    @Override
    public Class<Visa> getModelClass() {
        return Visa.class;
    }

    @Override
    public PortletResourcePermission getPortletResourcePermission() {
        return _portletResourcePermission;
    }

    @Override
    public long getPrimaryKey(Visa visa) {
        return visa.getVisaId();
    }

    @Override
    public void registerModelResourcePermissionLogics(
            ModelResourcePermission<Visa> modelResourcePermission,
            Consumer<ModelResourcePermissionLogic<Visa>> modelResourcePermissionLogicConsumer
    ) {
        modelResourcePermissionLogicConsumer.accept(
                new StagedModelPermissionLogic<>(
                        _stagingPermission,
                        "com_liferay_gwenod_visa_portlet_VisaPortlet",
                        Visa::getVisaId
                )
        );
    }
}
