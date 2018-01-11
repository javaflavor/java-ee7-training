package com.redhat.example.test.cdi;

import javax.enterprise.inject.spi.CDI;

import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.unbound.UnboundLiteral;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class CDITestRunner extends BlockJUnit4ClassRunner {

	public CDITestRunner(Class<?> klass) throws InitializationError {
		super(klass);
		// Weldを初期化
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		// RequestScopedを使えるようにする。
		RequestContext context = container.instance().select(RequestContext.class, UnboundLiteral.INSTANCE).get();
		context.activate();

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			weld.shutdown();
		}));

	}

	/* (非 Javadoc)
	 * @see org.junit.runners.BlockJUnit4ClassRunner#createTest()
	 */
	@Override
	protected Object createTest() throws Exception {
		// テストケースをCDIビーンとして生成。
		final Class<?> test = getTestClass().getJavaClass();
		return CDI.current().select(test).get();
	}

}
