package com.dayton.doji.practice.designpattern.proxy.dynamicproxy.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Martin Deng
 * @since 2020-08-13 11:37
 */
public class JDKMeipo implements InvocationHandler{

	/** 被代理的对象，把引用保存下来 */
	private Object target;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return null;
	}

}
