package org.hubotek.persistence.test;

import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.rss.RssDocumentBuilder;
import org.hubotek.model.rss.RssItem;
import org.hubotek.test.ArquillianBaseModelConfigurator;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRssItemPersistence extends ArquillianBaseModelConfigurator{

	private static final String fileLocation = "C:/Java/git_repo/model/src/test/resources/xml/google_news_feed1.xml";
	
	@Test
	public void shoud_parse_rss_file() throws Exception
	{ 
		beginTransaction();
		RssDocument rssDocument = new RssDocumentBuilder().withDocument(generateDocumentFromSoource(fileLocation)).build();
		assertNotNull(rssDocument);
		persistBase(rssDocument.getRssBody());
		persistBase(rssDocument.getRssImage());
		rssDocument.getRssItems().stream().forEach(i -> persistItem(i));
		entityManager.persist(rssDocument);
		commitTransaction(); 
	}

	private void persistItem(RssItem i) {
		assertNotNull(i.getDescription());
		persistBase(i.getDescription());
		persistBase(i);
	}

}
