package com.redhat.example.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.redhat.example.annotation.Trace;

@Interceptor
@Trace
@Priority(Interceptor.Priority.APPLICATION)
public class TraceInterceptor {
	@Inject Logger log;

	@AroundInvoke
	public Object trace(InvocationContext context) throws Exception {
		String targetClass = getTargetClass(context.getTarget()).getSimpleName();
		String method = context.getMethod().getName();
		String params = Stream.of(context.getParameters()).map(e -> e.toString()).collect(Collectors.joining(", "));
		try {
			log.info(String.format("### START: %s.%s(%s)", targetClass, method, params));
			
			// ターゲットのメソッドを実行する。
			Object ret = context.proceed();
			
			log.info(String.format("### END: %s.%s(%s) -> %s", targetClass, method, params, ret));
			return ret;
		} catch (Exception e) {
			log.info(String.format("### ERROR: %s.%s(%s) : %s", targetClass, method, params, e));
			throw e;
		}
	}
	
	Class<?> getTargetClass(Object target) {
		Class<?> c = target.getClass();
		// CDIのプロキシーでラップされている場合は、オリジナルのクラスが出るまで親クラスを取り出す。
		for (; c.getName().contains("$Proxy$"); c = c.getSuperclass())
			;
		return c;
	}

}
