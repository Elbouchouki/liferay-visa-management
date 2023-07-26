package com.liferay.gwenod.visa.internal.search.spi.model.index.contributor;

import com.liferay.gwenod.visa.model.Visa;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.gwenod.visa.model.Visa",
        service = ModelDocumentContributor.class
)
public class VisaModelDocumentContributor implements ModelDocumentContributor<Visa> {
    @Override
    public void contribute(Document document, Visa visa) {
        document.addText(Field.TITLE, visa.getCin());
        document.addText(Field.DESCRIPTION, visa.getPassport());
        document.addDate(Field.MODIFIED_DATE, visa.getModifiedDate());
    }
}
