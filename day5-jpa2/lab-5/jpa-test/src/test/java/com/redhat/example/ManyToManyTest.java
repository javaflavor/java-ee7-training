package com.redhat.example;

import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.redhat.example.entity.manytomany.Organization;
import com.redhat.example.entity.manytomany.User;
import com.redhat.example.entity.onetomany.Cart;
import com.redhat.example.entity.onetomany.Record;

public class ManyToManyTest extends TestBase {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("ManyToManyPU");
		em = emf.createEntityManager();
	}

	@Test
	public void test() {
		em.getTransaction().begin();

		Organization group1 = new Organization(1, "group-1");
		Organization group2 = new Organization(2, "group-2");
		User user1 = new User(10, "user-1");
		User user2 = new User(20, "user-2");
		group1.getUsers().add(user1);
		group1.getUsers().add(user2);
		group2.getUsers().add(user1);
		
		em.persist(user1);
		em.persist(user2);
		em.persist(group1);
		em.persist(group2);

		em.getTransaction().commit();
	}

	@After
	public void tearDown() throws Exception {
		if (em.isOpen()) em.close();
		em = emf.createEntityManager();
		
		sql("show columns from User");
		sql("show columns from Organization");
		sql("show columns from Organization_User");
		sql("select * from User");
		sql("select * from Organization");
		sql("select * from Organization_User");

		em.close();
		emf.close();
	}

}
