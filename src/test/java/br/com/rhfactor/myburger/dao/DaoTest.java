package br.com.rhfactor.myburger.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class DaoTest {

	private static final String PERSISTENCE_UNIT = "test";	
	private static EntityManagerFactory FACTORY;
	private static EntityManager ENTITY_MANAGER;

	@BeforeClass
	public static void setUp() {
		FACTORY = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		ENTITY_MANAGER = FACTORY.createEntityManager();
	}

	@AfterClass
	public static void tearDown() {
		ENTITY_MANAGER.close();
		FACTORY.close();
	}

	@Before
	public void preRun() {
		ENTITY_MANAGER.getTransaction().begin();
	}

	@After
	public void postRun() {
		ENTITY_MANAGER.getTransaction().rollback();
	}

	public EntityManager getEntityManager() {
		return ENTITY_MANAGER;
	}

	public void flush() {
		ENTITY_MANAGER.flush();
	}

	public void clear() {
		ENTITY_MANAGER.clear();
	}

}
