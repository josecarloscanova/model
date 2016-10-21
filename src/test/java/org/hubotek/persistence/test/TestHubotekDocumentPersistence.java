package org.hubotek.persistence.test;

import java.util.Date;
import java.util.List;

import org.hubotek.HubotekException;
import org.hubotek.model.atom.AtomDocument;
import org.hubotek.model.atom.AtomEntry;
import org.hubotek.model.document.DocumentType;
import org.hubotek.model.document.HubotekDocument;
import org.hubotek.model.document.HubotekDocumentEntry;
import org.hubotek.model.document.LegacyDocument;
import org.hubotek.model.lob.HubotekDocumentContent;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.test.BaseModelTransactionDelimiter;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestHubotekDocumentPersistence extends BaseModelTransactionDelimiter{

	@Test
	public void should_persist_hubotek_document()
	{ 
		List<LegacyDocument> atomDocuments = retrieveLegacyDocuments(); 
		atomDocuments.stream().map(a ->transform(a)).forEach(hd -> persist(hd));;
	}

	private void persist(HubotekDocument hd) {
		if (hd !=null)
			entityManager.persist(hd);
	}

	private HubotekDocument transform(LegacyDocument a) {
		
		System.err.println(a.getClass().getName());
		HubotekDocument hd = null;
		switch (a.getLegacyDocumentyType()){ 
			case ATOM: 
				hd = generateDocumentFromAtom((AtomDocument)a);
				break;
			case RSS:
				hd = generateDocumentFromRss((RssDocument)a);
				break;
		default: 
			throw new HubotekException("Not the correct document under test");
		}
		
		return hd;
	}

	private HubotekDocument generateDocumentFromRss(RssDocument a) {
		return null;
	}

	private HubotekDocument generateDocumentFromAtom(AtomDocument a) {
		HubotekDocument document = new HubotekDocument();
		document.setOrigin(a);
		document.setDateInsert(new Date());
		document.setDocumentType(DocumentType.XML);
		document.setLanguage("en");
		a.getEntries().stream().forEach(e -> document.getDocumentEntries().add(addNewEntryFromAtomEntry(e)));
		return document;
	}

	private HubotekDocumentEntry addNewEntryFromAtomEntry(AtomEntry e) {
		return new HubotekDocumentEntry(new HubotekDocumentContent(e.getContent().getContent()));
	}

	private List<LegacyDocument> retrieveLegacyDocuments() {
		String query = "Select ld from LegacyDocument ld";
		return entityManager.createQuery(query , LegacyDocument.class).getResultList();
	}
	
}
