package com.redhat.example.commons.producer;

import java.util.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * ロガーのファクトリクラスです。<br/>
 * CDIを利用することで注入先に応じたロガーが注入されます。
 */
@Dependent
public class LoggerFactory {
	
	@Produces
	public Logger getLogger(InjectionPoint injectionPoint) {
        // インジェクション・ポイントにおけるクラス名を取得する。
		String name = injectionPoint.getMember().getDeclaringClass().getName();
		return Logger.getLogger(name);
	}
}
