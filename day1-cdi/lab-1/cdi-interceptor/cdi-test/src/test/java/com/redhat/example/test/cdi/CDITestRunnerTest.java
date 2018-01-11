package com.redhat.example.test.cdi;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CDITestRunner.class)
public class CDITestRunnerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Inject Foo foo;

	@Inject Bar bar;

	@Test
	public void createTest() {
		assertThat(foo, is(notNullValue()));
		assertThat(bar, is(notNullValue()));
	}

	public static class Foo {}

	@RequestScoped
	public static class Bar {}

}
