package org.hubotek.persistence.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.rss.RssDocumentBuilder;
import org.hubotek.model.rss.RssItem;
import org.hubotek.test.ArquillianBaseModelConfigurator;
import org.hubotek.util.DomParser;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.nanotek.Base;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRssItemPersistence extends ArquillianBaseModelConfigurator{

	@Test
	public void shoud_parse_rss_file() throws Exception
	{ 
		utx.begin();  
		entityManager.joinTransaction();  
		InputStream is =  new FileInputStream(new File("C:/Java/git_repo/model/src/test/resources/xml/google_news_feed1.xml"));
		DomParser parser = new DomParser();
		Document document = parser.parseInput(new InputSource(is));
		RssDocument rssDocument = new RssDocumentBuilder().withDocument(document).build();
		assertNotNull(rssDocument);
		persistBase(rssDocument.getRssBody());
		persistBase(rssDocument.getRssImage());
		rssDocument.getRssItems().stream().forEach(i -> persistItem(i));
		entityManager.persist(rssDocument);
		utx.commit(); 
	}

	private void persistBase(Base<?> base) {
		entityManager.persist(base);
	}


	private void persistItem(RssItem i) {
		assertNotNull(i.getDescription());
		persistBase(i.getDescription());
		persistBase(i);
	}

}
