package com.dayton.doji.practice.designpattern.proxy.dynamicproxy.v2;

import java.lang.reflect.Method;

/**
 * @author Martin Deng
 * @since 2020-08-19 21:38
 */
public interface GPInvocationHandler {
	Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
