package com.redhat.example;

import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.redhat.example.entity.inheritance.CustomerProject;
import com.redhat.example.entity.inheritance.InternalProject;

public class InheritanceTest extends TestBase {

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("InheritancePU");
		em = emf.createEntityManager();
	}

	@Test
	public void test() {
		em.getTransaction().begin();
		
		em.persist(new InternalProject(1, "aaa"));
		em.persist(new CustomerProject(2, "bbb", "Customer 1"));
		
		em.getTransaction().commit();
	}

	@After
	public void tearDown() throws Exception {
		if (em.isOpen()) em.close();
		em = emf.createEntityManager();
		
		sql("show tables");
		sql("select * from Project");
		sql("select * from InternalProject");
		sql("select * from CustomerProject");

		em.close();
		emf.close();
	}

}
