package org.hubotek.persistence.test;

import java.util.List;
import java.util.function.Function;

import org.hubotek.model.atom.AtomDocument;
import org.hubotek.model.document.HubotekDocument;
import org.hubotek.model.document.transformer.HubotekAtomDocumentTransformer;
import org.hubotek.model.document.transformer.HubotekRssDocumentTransformer;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.test.BaseModelTransactionDelimiter;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestHubotekDocumentPersistence extends BaseModelTransactionDelimiter{

	Function<AtomDocument , HubotekDocument> atomTransformer = a -> new HubotekAtomDocumentTransformer().apply(a);
	Function<RssDocument , HubotekDocument> rssTransformer = r -> new HubotekRssDocumentTransformer().apply(r);
	
	@Test
	public void should_persist_hubotek_document()
	{ 
		retrieveAtomDocuments().stream().map(a -> atomTransformer.apply(a)).forEach(hd -> persist(hd));
		retrieveRssDocuments().stream().map(r ->rssTransformer.apply(r)).forEach(hd -> persist(hd));
	}

	private List<AtomDocument> retrieveAtomDocuments() {
		String query = "Select ad from AtomDocument ad";
		return entityManager.createQuery(query , AtomDocument.class).getResultList();
	}

	private List<RssDocument> retrieveRssDocuments() {
		String query = "Select ad from RssDocument ad";
		return entityManager.createQuery(query , RssDocument.class).getResultList();
	}
	
	private void persist(HubotekDocument hd) {
		if (hd !=null)
			entityManager.persist(hd);
	}

}
