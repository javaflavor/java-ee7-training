package com.redhat.example.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.redhat.example.dao.AbstractDao;

public class Permission2Test {

	static EntityManagerFactory emf;
	static EntityManager em;
	
	static AbstractDao<Permission2,Integer> dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("TestPU");
		em = emf.createEntityManager();
		dao = new AbstractDao<Permission2,Integer>() {
			@Override
			public EntityManager getEntityManager() {
				return em;
			}
		};

		// Prepare test data.
		em.getTransaction().begin();
		em.persist(new Permission2(ActionType.READ));
		em.persist(new Permission2(ActionType.READ, ActionType.WRITE));
		em.persist(new Permission2(ActionType.READ, ActionType.WRITE, ActionType.EXECUTE));

		em.getTransaction().commit();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		em.getTransaction().begin();
		em.createQuery("delete from Permission2 p").executeUpdate();
		em.getTransaction().commit();
		em.close();
        if (emf != null && emf.isOpen()) emf.close();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		List<Permission2> list = dao.findAll();
		System.out.println("### list ="+list);
		assertThat(list.size(), is(3));
	}

	@Test
	public void testQuery() {
		List<Permission2> list = em.createQuery("select p from Permission2 p where p.actions like concat('%', :action, '%')", Permission2.class)
				.setParameter("action", ActionType.WRITE.name())
				.getResultList();
		System.out.println("### list ="+list);
		assertThat(list.size(), is(2));
	}

}
