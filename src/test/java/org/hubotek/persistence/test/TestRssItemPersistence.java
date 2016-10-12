package org.hubotek.persistence.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.hubotek.ElementEnum;
import org.hubotek.model.HubDocument;
import org.hubotek.model.atom.AtomBase;
import org.hubotek.model.cse.GoogleSearchEngine;
import org.hubotek.model.feed.FeedUrl;
import org.hubotek.model.google.GoogleBase;
import org.hubotek.model.google.news.NewsTopic;
import org.hubotek.model.lob.AtomDocumentContent;
import org.hubotek.model.lob.GoogleResultItem;
import org.hubotek.model.lob.RssItemDescription;
import org.hubotek.model.project.api.GoogleApiKey;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.rss.RssDocumentBuilder;
import org.hubotek.model.rss.RssItem;
import org.hubotek.model.search.GoogleSearchResult;
import org.hubotek.model.url.NamedUrl;
import org.hubotek.test.BasePersistenceTestClass;
import org.hubotek.util.DOMElementExtratorUtil;
import org.hubotek.util.DomParser;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.nanotek.Base;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRssItemPersistence extends BasePersistenceTestClass{


	@Deployment
	public static JavaArchive createDeployment() {

		File[] files = Maven.resolver().loadPomFromFile("pom.xml")
				.importRuntimeDependencies().resolve().withTransitivity().asFile();

		return ShrinkWrap.create(JavaArchive.class)
				.addPackage(FeedUrl.class.getPackage())
				.addPackage(AtomDocumentContent.class.getPackage())
				.addPackage(AtomBase.class.getPackage())
				.addPackage(BasePersistenceTestClass.class.getPackage())
				.addPackage(Base.class.getPackage())
				.addPackage(GoogleApiKey.class.getPackage())
				.addPackage(DOMElementExtratorUtil.class.getPackage())
				.addPackage(ElementEnum.class.getPackage())
				.addPackage(HubDocument.class.getPackage())
				.addPackage(RssDocument.class.getPackage())
				.addPackage(RssItemDescription.class.getPackage())
				.addPackage(NamedUrl.class.getPackage())
				.addPackage(GoogleSearchEngine.class.getPackage())
				.addClass(GoogleBase.class)
				.addPackage(NewsTopic.class.getPackage())
				.addPackage(GoogleResultItem.class.getPackage())
				.addPackage(GoogleSearchResult.class.getPackage())
				.addPackage(TestRssItemPersistence.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource("log4j.properties", "log4j.properties")
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsResource("xml/google_news_feed1.xml" , "google_news_feed.xml" );
	}

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
