package org.hubotek.persistence.test;

import java.util.List;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hubotek.ElementEnum;
import org.hubotek.model.HubDocument;
import org.hubotek.model.atom.AtomBase;
import org.hubotek.model.cse.GoogleSearchEngine;
import org.hubotek.model.feed.FeedUrl;
import org.hubotek.model.google.GoogleBase;
import org.hubotek.model.google.news.NewsTopic;
import org.hubotek.model.lob.AtomDocumentContent;
import org.hubotek.model.lob.LobResultItem;
import org.hubotek.model.project.api.GoogleApiKey;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.search.GoogleSearchResult;
import org.hubotek.model.url.NamedUrl;
import org.hubotek.test.BasePersistenceTestClass;
import org.hubotek.util.DOMElementExtratorUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nanotek.Base;

@RunWith(Arquillian.class)
public class CseBaseTest extends BasePersistenceTestClass {
	
	@Deployment
	public static JavaArchive createDeployment() {
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
				.addPackage(NamedUrl.class.getPackage())
				.addPackage(GoogleSearchEngine.class.getPackage())
				.addClass(GoogleBase.class)
				.addPackage(NewsTopic.class.getPackage())
				.addPackage(LobResultItem.class.getPackage())
				.addPackage(GoogleSearchResult.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource("log4j.properties", "log4j.properties")
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml");
	}

	@Test
	public void should_verify_entity_manager() {
		Metamodel metaModel = entityManager.getMetamodel();
		System.err.println("Logging Entity Names " +  metaModel.getEntities().size());
		assertTrue(metaModel.getEntities().size() > 0);
		metaModel.getEntities().stream().forEach(t -> print(t));
	}

	@Test
	public void test_database_identity_lob_operations() throws Exception
	{ 
		 String expected_value = "This is become a result item"; 
		 
		 utx.begin();  
		 entityManager.joinTransaction();  
		 LobResultItem item = new LobResultItem();
		 item.setResult(expected_value);		 
		 entityManager.merge(item);
		 utx.commit(); 
		 utx.begin();  
		 entityManager.joinTransaction();  
		 List<LobResultItem> ris = entityManager.createQuery("Select ri from LobResultItem ri" , LobResultItem.class).getResultList();
		 ris.stream().forEach(ri -> compareResult(expected_value , ri.getResult()));
		 utx.commit(); 
	}
	
	private void compareResult(String expected_value, String result) {
		 assertEquals(expected_value, result);
	}

	@Test
	public void test_database_operations() throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException
	{ 
		 utx.begin();  
		 entityManager.joinTransaction();  
		 
		 NewsTopic topic = new NewsTopic(); 
		 topic.setId(1l);
		 topic.setTopic("technology");
		 entityManager.merge(topic);
		 utx.commit();  
	}
	
	private void print(EntityType<?> t) {
		System.err.println("Name of the Entity " + t.getName());
	}
	
}