package com.redhat.example;

import java.util.List;

import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.redhat.example.entity.onetoone.Address;
import com.redhat.example.entity.onetoone.Employee;
import com.redhat.example.entity.onetoone.Mobile;
import com.redhat.example.entity.onetoone.State;

public class OneToOneTest extends TestBase {

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("OneToOnePU");
		em = emf.createEntityManager();
	}

	@Test
	public void test() {
		em.getTransaction().begin();
		
		Employee employee1 = new Employee(1, "Katsushi Nozaki",
				new Mobile("080-1111-1111", true),
				new Address("200 West Arbor Drive", "San Diego", State.CA, "92103"));
		Employee employee2 = new Employee(2, "Sadao Niwa",
				new Mobile("080-2222-2222", true),
				new Address("8622 Kennel Way", "La Jolla", State.CA, "92037"));
		
		// CascadeType.PERSISTなら親オブジェクトを保存すればOK
		em.persist(employee1);
		em.persist(employee2);

		em.getTransaction().commit();
		em.clear();		// エンティティキャッシュをクリア
		
		// OneToOne (Employee -> Mobile)ならデフォルトでEAGERフェッチだが、N+1問題となり効率が悪いため、join fetchを行うこと
		List<Employee> list = em.createQuery("select e from Employee e", Employee.class)
				.getResultList();
//		List<Employee> list = em.createQuery("select e from Employee e inner join fetch e.mobile", Employee.class)
//				.getResultList();

		em.close();
		System.out.println("### results:");
		list.forEach(System.out::println);
		
	}

	@After
	public void tearDown() throws Exception {
		if (em.isOpen()) em.close();
		em = emf.createEntityManager();
		
		System.out.println();
		sql("show columns from Employee");
		sql("show columns from Mobile");
		sql("select * from Employee");
		sql("select * from Mobile");

		em.getTransaction().begin();
		em.createQuery("delete from Employee e").executeUpdate();
		em.createQuery("delete from Mobile m").executeUpdate();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
