package com.redhat.example.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.redhat.example.model.Person;

public class AbstractDaoTest {
	static EntityManagerFactory emf;
	static EntityManager em;
	
	static AbstractDao<Person,Integer> dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("TestPU");
		em = emf.createEntityManager();
		dao = new AbstractDao<Person,Integer>() {
			@Override
			public EntityManager getEntityManager() {
				return em;
			}
		};

		// Prepare test data.
		em.getTransaction().begin();
		em.persist(new Person("Katsushi", "Nozaki", 26));
		em.persist(new Person("Sadao", "Niwa", 31));
		em.persist(new Person("Asuka", "Kawano", 21));
		em.persist(new Person("Kunie", "Otake", 39));
		em.persist(new Person("Tsubasa", "Amano", 44));

		em.getTransaction().commit();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		em.getTransaction().begin();
		em.createQuery("delete from Person p").executeUpdate();
		em.getTransaction().commit();
		em.close();
        if (emf != null && emf.isOpen()) emf.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {

		dao.create(new Person("aaa", "AAA", 20));

		Person p = em.find(Person.class, 5);
		assertThat(p, is(notNullValue()));
	}

	@Test(expected=PersistenceException.class)
	public void testCreateDupKey() {
		dao.create(new Person(2, "aaa", "AAA", 20));
	}

	@Test
	public void testFind() {
		Person p = dao.find(100);
		assertThat(p, is(nullValue()));

		p = dao.find(3);
		assertThat(p, is(notNullValue()));
	}

	@Test
	public void testUpdate() {
		em.getTransaction().begin();
		Person p = em.find(Person.class, 2);
		p.setFirstName("aaa");
		dao.update(p);
		em.getTransaction().commit();

		p = em.find(Person.class, 2);
		assertThat(p.getFirstName(), is("aaa"));
	}

	@Test
	public void testRemove() {
		dao.remove(1);
		
		assertThat(dao.find(1), is(nullValue()));
	}

	@Test(expected=EntityNotFoundException.class)
	public void testRemoveNoId() {
		dao.remove(0);
	}


	@Test
	public void testFindAll() {
		List<Person> list = dao.findAll();

		assertThat(list.size(), is(5));
	}

}
