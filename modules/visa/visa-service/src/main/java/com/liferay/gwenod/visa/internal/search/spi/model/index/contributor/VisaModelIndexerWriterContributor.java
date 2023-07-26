package com.liferay.gwenod.visa.internal.search.spi.model.index.contributor;

import com.liferay.gwenod.visa.model.Visa;
import com.liferay.gwenod.visa.service.VisaLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.gwenod.visa.model.Visa",
        service = ModelIndexerWriterContributor.class
)
public class VisaModelIndexerWriterContributor implements ModelIndexerWriterContributor<Visa> {
    @Override
    public void customize(
            BatchIndexingActionable batchIndexingActionable,
            ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

        batchIndexingActionable.setPerformActionMethod(
                (Visa visa) -> {
                    Document document =
                            modelIndexerWriterDocumentHelper.getDocument(visa);

                    batchIndexingActionable.addDocuments(document);
                });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {

        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
                visaLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(Visa visa) {
        return visa.getCompanyId();
    }

    @Reference
    protected VisaLocalService visaLocalService;

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

}
