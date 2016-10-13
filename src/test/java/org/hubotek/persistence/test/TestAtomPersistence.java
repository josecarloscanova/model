package org.hubotek.persistence.test;

import org.hubotek.test.ArquillianBaseModelConfigurator;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;


@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAtomPersistence extends ArquillianBaseModelConfigurator{

	
	@Test
	public void shoud_parse_atom_file() throws Exception
	{ 
		beginTransaction();
		
	}
}
