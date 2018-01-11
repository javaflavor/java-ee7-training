package com.redhat.example.logger;

import javax.annotation.Priority;
import javax.annotation.Resource;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.Marker;

import com.redhat.example.model.LoginUser;

@Decorator
@Priority(javax.interceptor.Interceptor.Priority.APPLICATION)
public class CustomLogger implements Logger {
	
	@Inject @Delegate Logger delegate;
	
	/** アプリケーション名 */
	@Resource(lookup="java:app/AppName")
    String appName;
	
	/** ログインユーザ */
	@Inject LoginUser loginUser;
	
	/**
	 * 引数のログメッセージにカスタムのプリフィックスをつける。
	 * @param msg オリジナルのメッセージ
	 * @return カスタマイズされたメッセージ
	 */
	String custom(String msg) {
		final String PREFIX = "### App:[ %s ], User:[ %s ] ### ";
		return String.format(PREFIX+msg, appName, loginUser.getId());
	}
	
	public String getName() {
		return delegate.getName();
	}

	public boolean isTraceEnabled() {
		return delegate.isTraceEnabled();
	}

	public void trace(String msg) {
		delegate.trace(custom(msg));
	}

	public void trace(String format, Object arg) {
		delegate.trace(custom(format), arg);
	}

	public void trace(String format, Object arg1, Object arg2) {
		delegate.trace(custom(format), arg1, arg2);
	}

	public void trace(String format, Object... arguments) {
		delegate.trace(custom(format), arguments);
	}

	public void trace(String msg, Throwable t) {
		delegate.trace(custom(msg), t);
	}

	public boolean isTraceEnabled(Marker marker) {
		return delegate.isTraceEnabled(marker);
	}

	public void trace(Marker marker, String msg) {
		delegate.trace(marker, custom(msg));
	}

	public void trace(Marker marker, String format, Object arg) {
		delegate.trace(marker, custom(format), arg);
	}

	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		delegate.trace(marker, custom(format), arg1, arg2);
	}

	public void trace(Marker marker, String format, Object... argArray) {
		delegate.trace(marker, custom(format), argArray);
	}

	public void trace(Marker marker, String msg, Throwable t) {
		delegate.trace(marker, custom(msg), t);
	}

	public boolean isDebugEnabled() {
		return delegate.isDebugEnabled();
	}

	public void debug(String msg) {
		delegate.debug(custom(msg));
	}

	public void debug(String format, Object arg) {
		delegate.debug(custom(format), arg);
	}

	public void debug(String format, Object arg1, Object arg2) {
		delegate.debug(custom(format), arg1, arg2);
	}

	public void debug(String format, Object... arguments) {
		delegate.debug(custom(format), arguments);
	}

	public void debug(String msg, Throwable t) {
		delegate.debug(custom(msg), t);
	}

	public boolean isDebugEnabled(Marker marker) {
		return delegate.isDebugEnabled(marker);
	}

	public void debug(Marker marker, String msg) {
		delegate.debug(marker, custom(msg));
	}

	public void debug(Marker marker, String format, Object arg) {
		delegate.debug(marker, custom(format), arg);
	}

	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		delegate.debug(marker, custom(format), arg1, arg2);
	}

	public void debug(Marker marker, String format, Object... arguments) {
		delegate.debug(marker, custom(format), arguments);
	}

	public void debug(Marker marker, String msg, Throwable t) {
		delegate.debug(marker, custom(msg), t);
	}

	public boolean isInfoEnabled() {
		return delegate.isInfoEnabled();
	}

	public void info(String msg) {
		delegate.info(custom(msg));
	}

	public void info(String format, Object arg) {
		delegate.info(custom(format), arg);
	}

	public void info(String format, Object arg1, Object arg2) {
		delegate.info(custom(format), arg1, arg2);
	}

	public void info(String format, Object... arguments) {
		delegate.info(custom(format), arguments);
	}

	public void info(String msg, Throwable t) {
		delegate.info(custom(msg), t);
	}

	public boolean isInfoEnabled(Marker marker) {
		return delegate.isInfoEnabled(marker);
	}

	public void info(Marker marker, String msg) {
		delegate.info(marker, custom(msg));
	}

	public void info(Marker marker, String format, Object arg) {
		delegate.info(marker, custom(format), arg);
	}

	public void info(Marker marker, String format, Object arg1, Object arg2) {
		delegate.info(marker, custom(format), arg1, arg2);
	}

	public void info(Marker marker, String format, Object... arguments) {
		delegate.info(marker, custom(format), arguments);
	}

	public void info(Marker marker, String msg, Throwable t) {
		delegate.info(marker, custom(msg), t);
	}

	public boolean isWarnEnabled() {
		return delegate.isWarnEnabled();
	}

	public void warn(String msg) {
		delegate.warn(custom(msg));
	}

	public void warn(String format, Object arg) {
		delegate.warn(custom(format), arg);
	}

	public void warn(String format, Object... arguments) {
		delegate.warn(custom(format), arguments);
	}

	public void warn(String format, Object arg1, Object arg2) {
		delegate.warn(custom(format), arg1, arg2);
	}

	public void warn(String msg, Throwable t) {
		delegate.warn(custom(msg), t);
	}

	public boolean isWarnEnabled(Marker marker) {
		return delegate.isWarnEnabled(marker);
	}

	public void warn(Marker marker, String msg) {
		delegate.warn(marker, custom(msg));
	}

	public void warn(Marker marker, String format, Object arg) {
		delegate.warn(marker, custom(format), arg);
	}

	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		delegate.warn(marker, custom(format), arg1, arg2);
	}

	public void warn(Marker marker, String format, Object... arguments) {
		delegate.warn(marker, custom(format), arguments);
	}

	public void warn(Marker marker, String msg, Throwable t) {
		delegate.warn(marker, custom(msg), t);
	}

	public boolean isErrorEnabled() {
		return delegate.isErrorEnabled();
	}

	public void error(String msg) {
		delegate.error(custom(msg));
	}

	public void error(String format, Object arg) {
		delegate.error(custom(format), arg);
	}

	public void error(String format, Object arg1, Object arg2) {
		delegate.error(custom(format), arg1, arg2);
	}

	public void error(String format, Object... arguments) {
		delegate.error(custom(format), arguments);
	}

	public void error(String msg, Throwable t) {
		delegate.error(custom(msg), t);
	}

	public boolean isErrorEnabled(Marker marker) {
		return delegate.isErrorEnabled(marker);
	}

	public void error(Marker marker, String msg) {
		delegate.error(marker, custom(msg));
	}

	public void error(Marker marker, String format, Object arg) {
		delegate.error(marker, custom(format), arg);
	}

	public void error(Marker marker, String format, Object arg1, Object arg2) {
		delegate.error(marker, custom(format), arg1, arg2);
	}

	public void error(Marker marker, String format, Object... arguments) {
		delegate.error(marker, custom(format), arguments);
	}

	public void error(Marker marker, String msg, Throwable t) {
		delegate.error(marker, custom(msg), t);
	}

}
