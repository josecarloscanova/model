package org.hubotek.test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.nanotek.Base;

public class BasePersistenceTestClass extends BaseTestClass{

	@PersistenceContext
    protected EntityManager entityManager;
    
    @Inject
    private UserTransaction utx;
    
    protected void beginTransaction() throws Exception
	{ 
		utx.begin();  
		entityManager.joinTransaction(); 
	}
	
	protected void commitTransaction() throws Exception
	{ 
		utx.commit();
	}
	
	protected void persistBase(Base<?> base) {
		entityManager.persist(base);
	}
	
}
