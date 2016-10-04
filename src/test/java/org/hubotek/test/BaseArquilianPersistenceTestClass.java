package org.hubotek.test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class BaseArquilianPersistenceTestClass extends BaseArquilianTestClass{

	
	
	@PersistenceContext
    protected EntityManager entityManager;
    
    @Inject
    protected UserTransaction utx;
    
    
}
