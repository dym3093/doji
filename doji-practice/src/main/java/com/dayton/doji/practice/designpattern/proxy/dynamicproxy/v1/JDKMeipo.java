package com.dayton.doji.practice.designpattern.proxy.dynamicproxy.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Martin Deng
 * @since 2020-08-13 11:37
 */
public class JDKMeipo implements InvocationHandler{

	/** 被代理的对象，把引用保存下来 */
	private Object target;

	public Object getInstance(Object target){
		this.target = target;
		Class<?> clazz = target.getClass();
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz
				.getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object object = method.invoke(this.target, args);
		after();
		return object;
	}

	public void before(){
		System.out.println("我是媒婆：我要给你找对象，现在已经确认你的需求");
		System.out.println("开始物色对象");
	}

	public void after(){
		System.out.println("如果合适的话，就准备办事");
	}

}
