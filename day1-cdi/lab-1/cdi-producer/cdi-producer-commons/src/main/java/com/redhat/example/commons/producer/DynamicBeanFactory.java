package com.redhat.example.commons.producer;

import java.util.Set;
import java.util.logging.Logger;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import com.redhat.example.commons.annotation.Candidate;

/**
 * 複数の選択候補から、目的の管理ビーンクラスを動的に決定するためのCDIプロデューサの雛形となる
 * ユーティリティクラスです。
 * 
 * @param <T> 選択候補のベースクラス
 */
public abstract class DynamicBeanFactory<T> {
	@Inject Logger log;
	@Inject BeanManager beanManager;

	/**
	 * 選択候補のベースクラス。
	 */
	protected Class<T> baseType;
	
	/**
	 * デフォルト実装のクラス
	 */
	public abstract Class<?> getDefaultType();

	/**
	 * コンストラクタ。可変長引数のコンストラクタだが、ベースクラスの型Tを取得するためのテクニック
	 * として定義しているだけであるため、このコンストラクタはデフォルトコンストラクタとして使用すること。
	 */
	public DynamicBeanFactory(T... dummy) {
		@SuppressWarnings("unchecked")
		Class<T> type = (Class<T>) dummy.getClass().getComponentType();
		baseType = type;
	}

	public T getQualifiedBean() {
		// ビーン<T>の候補を取得する。
		Set<Bean<?>> beans = beanManager.getBeans(baseType, new AnnotationLiteral<Candidate>(){});
		log.fine("### candidates = "+beans);
		T obj = null;
		for (Bean<?> bean : beans) {
			if (beans.size() == 1) {
				// 候補が１つなら確定。
				obj = getReference(bean);
				break;
			} else if (beans.size() == 2
					&& !bean.getBeanClass().equals(getDefaultType())) {
				// 候補が２つならdefaultTypeでない方に確定。
				obj = getReference(bean);
				break;
			}
		}
		if (obj == null) {
			throw new IllegalStateException(baseType.getSimpleName()
					+ " is ambiguous. candidates=" + beans);
		}
		log.fine("### selected = "+obj);
		return obj;
	}

	@SuppressWarnings("unchecked")
	T getReference(Bean<?> bean) {
		CreationalContext<?> cctx = beanManager.createCreationalContext(bean);
		return (T) beanManager.getReference(bean, baseType, cctx);
	}

}
