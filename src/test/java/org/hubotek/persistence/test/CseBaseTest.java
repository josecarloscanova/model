package org.hubotek.persistence.test;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.apache.log4j.Logger;
import org.hubotek.ElementEnum;
import org.hubotek.model.HubDocument;
import org.hubotek.model.cse.GoogleSearchEngineBase;
import org.hubotek.model.google.GoogleBase;
import org.hubotek.model.google.news.NewsTopic;
import org.hubotek.model.project.api.GoogleApiKey;
import org.hubotek.model.rss.RssDocument;
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

import junit.framework.Assert;

@RunWith(Arquillian.class)
public class CseBaseTest extends BasePersistenceTestClass {
	
	private static final Logger logger = Logger.getLogger(CseBaseTest.class);
	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addPackage(BasePersistenceTestClass.class.getPackage())
				.addPackage(Base.class.getPackage())
				.addPackage(GoogleApiKey.class.getPackage())
				.addPackage(DOMElementExtratorUtil.class.getPackage())
				.addPackage(ElementEnum.class.getPackage())
				.addPackage(HubDocument.class.getPackage())
				.addPackage(RssDocument.class.getPackage())
				.addPackage(NamedUrl.class.getPackage())
				.addPackage(GoogleSearchEngineBase.class.getPackage())
				.addClass(GoogleBase.class)
				.addPackage(NewsTopic.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource("log4j.properties", "log4j.properties")
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml");
	}

	@Test
	public void should_verify_entity_manager() {
		Metamodel metaModel = entityManager.getMetamodel();
		System.err.println("Logging Entity Names " +  metaModel.getEntities().size());
		Assert.assertTrue(metaModel.getEntities().size() > 0);
		metaModel.getEntities().stream().forEach(t -> print(t));
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