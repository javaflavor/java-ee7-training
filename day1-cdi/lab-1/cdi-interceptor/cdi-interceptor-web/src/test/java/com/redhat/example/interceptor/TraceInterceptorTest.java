package com.redhat.example.interceptor;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.redhat.example.annotation.Trace;
import com.redhat.example.test.cdi.CDITestRunner;

@RunWith(CDITestRunner.class)
public class TraceInterceptorTest {

	@Inject Foo foo;
	
	@Test
	public void testTrace() {
		assertThat(foo, is(notNullValue()));
		foo.func("test");
		System.out.println("log messages: "+TestLogger.msgs);
		assertThat(TestLogger.msgs.size(), is(2));
		assertThat(TestLogger.msgs.get(0), is(startsWith("### START: ")));
		assertThat(TestLogger.msgs.get(1), is(startsWith("### END: ")));
	}

	@Trace
	static class Foo {
		String func(String msg) {
			return msg;
		}
	}
	
	
}
