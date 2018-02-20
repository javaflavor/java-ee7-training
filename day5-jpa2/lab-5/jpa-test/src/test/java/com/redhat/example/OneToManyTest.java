package com.redhat.example;

import java.util.List;

import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.redhat.example.entity.onetomany.Cart;
import com.redhat.example.entity.onetomany.Record;

public class OneToManyTest extends TestBase {

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("RelationPU");
		em = emf.createEntityManager();
	}

	@Test
	public void test() {
		em.getTransaction().begin();

		Record record1 = new Record(1, null, 3);
		Record record2 = new Record(2, null, 7);
		Cart cart = new Cart(111);
		cart.getRecords().add(record1);
		cart.getRecords().add(record2);
		
		em.persist(record1);
		em.persist(record2);
		em.persist(cart);

		em.getTransaction().commit();
		em.clear();
		
		List<Cart> list = em.createQuery("select c from Cart c", Cart.class)
				.getResultList();
//		List<Cart> list = em.createQuery("select new Cart(c.id) from Cart c", Cart.class)
//				.getResultList();
//		List<Cart> list = em.createQuery("select distinct c from Cart c inner join fetch c.records", Cart.class)
//				.getResultList();
		System.out.println("### results:"+list.size());
		list.forEach(System.out::println);
	}

	@After
	public void tearDown() throws Exception {
		if (em.isOpen()) em.close();
		em = emf.createEntityManager();
		
		sql("show columns from Record");
		sql("show columns from Cart");
		sql("show columns from Cart_Record");
		sql("select * from Record");
		sql("select * from Cart");
		sql("select * from Cart_Record");

		em.close();
		emf.close();
	}

}
