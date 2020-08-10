package com.dayton.doji.practice.designpattern.singleton.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器式单例模式<br/>
 * 特性：非线程安全。
 * @author Martin Deng
 * @since 2020-08-10 19:05
 */
public class ContainerSingleton {

	private ContainerSingleton(){}

	private static Map<String, Object> ioc = new ConcurrentHashMap<>();

	public static Object getBean(String className){
		if (!ioc.containsKey(className)){
			Object obj = null;
			try {
				obj = Class.forName(className).newInstance();
				ioc.put(className, obj);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return obj;
		}else {
			return ioc.get(className);
		}
	}
}
