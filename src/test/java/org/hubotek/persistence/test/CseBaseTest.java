package org.hubotek.persistence.test;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.apache.log4j.Logger;
import org.hubotek.ElementEnum;
import org.hubotek.model.HubDocument;
import org.hubotek.model.cse.GoogleSearchEngineBase;
import org.hubotek.model.project.api.GoogleApiKey;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.url.BaseUrl;
import org.hubotek.model.url.NamedUrl;
import org.hubotek.test.BaseArquilianPersistenceTestClass;
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
public class CseBaseTest extends BaseArquilianPersistenceTestClass {
	
	/*@Inject
	Greeter greeter;

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(Greeter.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
*/
	
	private static final Logger logger = Logger.getLogger(CseBaseTest.class);
	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addPackage(BaseArquilianPersistenceTestClass.class.getPackage())
				.addPackage(Base.class.getPackage())
				.addPackage(GoogleApiKey.class.getPackage())
				.addPackage(DOMElementExtratorUtil.class.getPackage())
				.addPackage(ElementEnum.class.getPackage())
				.addPackage(HubDocument.class.getPackage())
				.addPackage(RssDocument.class.getPackage())
				.addPackage(NamedUrl.class.getPackage())
				.addPackage(GoogleSearchEngineBase.class.getPackage())
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

	private void print(EntityType<?> t) {
		System.err.println("Name of the Entity " + t.getName());
	}
	
}