package org.hubotek.persistence.test;

import org.hubotek.model.atom.AtomDocument;
import org.hubotek.model.atom.AtomDocumentBuilder;
import org.hubotek.test.ArquillianBaseModelConfigurator;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;


@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAtomPersistence extends ArquillianBaseModelConfigurator{

	private static final String fileLocation = "C:/Java/git_repo/model/src/test/resources/xml/news_atom.xml";
	
	@Test
	public void shoud_parse_atom_file() throws Exception
	{ 
		
		AtomDocument atomDocument = new AtomDocumentBuilder().withDocument(generateDocumentFromSoource(fileLocation)).build();
		assertNotNull(atomDocument);
		beginTransaction();
		persistBase(atomDocument);
		commitTransaction();
		
	}
}
