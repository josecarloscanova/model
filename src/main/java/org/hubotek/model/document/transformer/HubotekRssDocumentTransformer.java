package org.hubotek.model.document.transformer;

import java.util.Date;

import javax.inject.Named;

import org.hubotek.model.document.HubotekDocument;
import org.hubotek.model.document.HubotekDocumentEntry;
import org.hubotek.model.lob.HubotekDocumentContent;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.rss.RssItem;
import org.nanotek.common.domain.DocumentType;

@Named(value="hubotekRssDocumentTransformer")
public class HubotekRssDocumentTransformer implements HubotekLegacyDocumentTransformer<RssDocument> {

	
	@Override
	public HubotekDocument apply(RssDocument rssDocument) {
		return generateDocumentFromRss(rssDocument);
	}

	private HubotekDocument generateDocumentFromRss(RssDocument rssDocument) {
		HubotekDocument document = new HubotekDocument();
		document.setOrigin(rssDocument);
		document.setDateInsert(new Date());
		document.setDocumentType(DocumentType.XML);
		document.setLanguage("en");
		rssDocument.getRssItems().stream().forEach(e -> document.getDocumentEntries().add(addNewEntryFromRssEntry(e)));
		return document;
	}

	private HubotekDocumentEntry addNewEntryFromRssEntry(RssItem i) {
		return new HubotekDocumentEntry(new HubotekDocumentContent(i.getRssItemDescription().getDescription()));
	}
	
}
