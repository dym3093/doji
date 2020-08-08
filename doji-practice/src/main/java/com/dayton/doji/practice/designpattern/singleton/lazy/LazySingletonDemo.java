package com.dayton.doji.practice.designpattern.singleton.lazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Martin Deng
 * @since 2020-08-08 21:14
 */
public class LazySingletonDemo {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new LazySingletonThread());
		Thread thread2 = new Thread(new LazySingletonThread());
		thread1.start();
		thread2.start();
		destroySingleton();
	}

	public static void destroySingleton(){
		try {
			Class<?> clazz = LazyInnerClassSingleton.class;
			// 通过反射获取私有构造器
			Constructor c = clazz.getDeclaredConstructor(null);
			// 强制访问
			c.setAccessible(true);
			// 暴力初始化
			Object obj1 = c.newInstance();
			// 调用两次构造方法，相当于"new”了两次
			Object obj2 = c.newInstance();
			System.out.println("obj1 --> " + obj1);
			System.out.println("obj2 --> " + obj2);
			// 判断是否一致
			System.out.println(obj1 == obj2);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
			e.printStackTrace();
		}
	}

}
