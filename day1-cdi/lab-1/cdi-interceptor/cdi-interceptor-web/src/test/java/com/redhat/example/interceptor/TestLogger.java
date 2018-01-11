package com.redhat.example.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import java.util.logging.Filter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class TestLogger extends Logger {
	Logger delegate;
	
	public static List<String> msgs = new ArrayList<>();
	
	public TestLogger(Logger delegate) {
		super(delegate.getName(), null);
		this.delegate = delegate;
	}
	
	public void info(String msg) {
		msgs.add(msg);	// 出力したメッセージを保持。
		delegate.info(msg);
	}

	public int hashCode() {
		return delegate.hashCode();
	}

	public boolean equals(Object obj) {
		return delegate.equals(obj);
	}

	public String toString() {
		return delegate.toString();
	}

	public ResourceBundle getResourceBundle() {
		return delegate.getResourceBundle();
	}

	public String getResourceBundleName() {
		return delegate.getResourceBundleName();
	}

	public void setFilter(Filter newFilter) throws SecurityException {
		delegate.setFilter(newFilter);
	}

	public Filter getFilter() {
		return delegate.getFilter();
	}

	public void log(LogRecord record) {
		delegate.log(record);
	}

	public void log(Level level, String msg) {
		delegate.log(level, msg);
	}

	public void log(Level level, Supplier<String> msgSupplier) {
		delegate.log(level, msgSupplier);
	}

	public void log(Level level, String msg, Object param1) {
		delegate.log(level, msg, param1);
	}

	public void log(Level level, String msg, Object[] params) {
		delegate.log(level, msg, params);
	}

	public void log(Level level, String msg, Throwable thrown) {
		delegate.log(level, msg, thrown);
	}

	public void log(Level level, Throwable thrown, Supplier<String> msgSupplier) {
		delegate.log(level, thrown, msgSupplier);
	}

	public void logp(Level level, String sourceClass, String sourceMethod, String msg) {
		delegate.logp(level, sourceClass, sourceMethod, msg);
	}

	public void logp(Level level, String sourceClass, String sourceMethod, Supplier<String> msgSupplier) {
		delegate.logp(level, sourceClass, sourceMethod, msgSupplier);
	}

	public void logp(Level level, String sourceClass, String sourceMethod, String msg, Object param1) {
		delegate.logp(level, sourceClass, sourceMethod, msg, param1);
	}

	public void logp(Level level, String sourceClass, String sourceMethod, String msg, Object[] params) {
		delegate.logp(level, sourceClass, sourceMethod, msg, params);
	}

	public void logp(Level level, String sourceClass, String sourceMethod, String msg, Throwable thrown) {
		delegate.logp(level, sourceClass, sourceMethod, msg, thrown);
	}

	public void logp(Level level, String sourceClass, String sourceMethod, Throwable thrown,
			Supplier<String> msgSupplier) {
		delegate.logp(level, sourceClass, sourceMethod, thrown, msgSupplier);
	}

	public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg) {
		delegate.logrb(level, sourceClass, sourceMethod, bundleName, msg);
	}

	public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg,
			Object param1) {
		delegate.logrb(level, sourceClass, sourceMethod, bundleName, msg, param1);
	}

	public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg,
			Object[] params) {
		delegate.logrb(level, sourceClass, sourceMethod, bundleName, msg, params);
	}

	public void logrb(Level level, String sourceClass, String sourceMethod, ResourceBundle bundle, String msg,
			Object... params) {
		delegate.logrb(level, sourceClass, sourceMethod, bundle, msg, params);
	}

	public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg,
			Throwable thrown) {
		delegate.logrb(level, sourceClass, sourceMethod, bundleName, msg, thrown);
	}

	public void logrb(Level level, String sourceClass, String sourceMethod, ResourceBundle bundle, String msg,
			Throwable thrown) {
		delegate.logrb(level, sourceClass, sourceMethod, bundle, msg, thrown);
	}

	public void entering(String sourceClass, String sourceMethod) {
		delegate.entering(sourceClass, sourceMethod);
	}

	public void entering(String sourceClass, String sourceMethod, Object param1) {
		delegate.entering(sourceClass, sourceMethod, param1);
	}

	public void entering(String sourceClass, String sourceMethod, Object[] params) {
		delegate.entering(sourceClass, sourceMethod, params);
	}

	public void exiting(String sourceClass, String sourceMethod) {
		delegate.exiting(sourceClass, sourceMethod);
	}

	public void exiting(String sourceClass, String sourceMethod, Object result) {
		delegate.exiting(sourceClass, sourceMethod, result);
	}

	public void throwing(String sourceClass, String sourceMethod, Throwable thrown) {
		delegate.throwing(sourceClass, sourceMethod, thrown);
	}

	public void severe(String msg) {
		delegate.severe(msg);
	}

	public void warning(String msg) {
		delegate.warning(msg);
	}

	public void config(String msg) {
		delegate.config(msg);
	}

	public void fine(String msg) {
		delegate.fine(msg);
	}

	public void finer(String msg) {
		delegate.finer(msg);
	}

	public void finest(String msg) {
		delegate.finest(msg);
	}

	public void severe(Supplier<String> msgSupplier) {
		delegate.severe(msgSupplier);
	}

	public void warning(Supplier<String> msgSupplier) {
		delegate.warning(msgSupplier);
	}

	public void info(Supplier<String> msgSupplier) {
		delegate.info(msgSupplier);
	}

	public void config(Supplier<String> msgSupplier) {
		delegate.config(msgSupplier);
	}

	public void fine(Supplier<String> msgSupplier) {
		delegate.fine(msgSupplier);
	}

	public void finer(Supplier<String> msgSupplier) {
		delegate.finer(msgSupplier);
	}

	public void finest(Supplier<String> msgSupplier) {
		delegate.finest(msgSupplier);
	}

	public void setLevel(Level newLevel) throws SecurityException {
		delegate.setLevel(newLevel);
	}

	public Level getLevel() {
		return delegate.getLevel();
	}

	public boolean isLoggable(Level level) {
		return delegate.isLoggable(level);
	}

	public String getName() {
		return delegate.getName();
	}

	public void addHandler(Handler handler) throws SecurityException {
		delegate.addHandler(handler);
	}

	public void removeHandler(Handler handler) throws SecurityException {
		delegate.removeHandler(handler);
	}

	public Handler[] getHandlers() {
		return delegate.getHandlers();
	}

	public void setUseParentHandlers(boolean useParentHandlers) {
		delegate.setUseParentHandlers(useParentHandlers);
	}

	public boolean getUseParentHandlers() {
		return delegate.getUseParentHandlers();
	}

	public void setResourceBundle(ResourceBundle bundle) {
		delegate.setResourceBundle(bundle);
	}

	public Logger getParent() {
		return delegate.getParent();
	}

	public void setParent(Logger parent) {
		delegate.setParent(parent);
	}

}
