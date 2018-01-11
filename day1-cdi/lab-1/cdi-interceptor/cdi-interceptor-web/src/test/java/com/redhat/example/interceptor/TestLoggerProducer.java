package com.redhat.example.interceptor;

import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.interceptor.Interceptor;

@Alternative
@Priority(Interceptor.Priority.PLATFORM_AFTER)
public class TestLoggerProducer {

	@Produces
	static Logger getLogger(InjectionPoint injectionPoint) {
		String name = injectionPoint.getMember().getDeclaringClass().getName();
		Logger logger = Logger.getLogger(name);
		logger.info("### getLogger() called");
		return new TestLogger(logger);
	}

}
