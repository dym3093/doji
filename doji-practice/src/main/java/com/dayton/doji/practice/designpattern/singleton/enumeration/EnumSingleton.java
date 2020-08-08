package com.dayton.doji.practice.designpattern.singleton.enumeration;

/**
 * 枚举类单例模式 <br/>
 * 特点：控制更加简洁，无偿地提供了序列化的机制，并由JVM从根本上提供保障，
 * 绝对防止多次实例化，是更简洁、高效、安全的实现单例的方式。
 * @author Martin Deng
 * @since 2020-08-08 21:44
 */
public enum EnumSingleton {

	/** 定义一个枚举的元素，就代表了Singleton的一个实例 */
	UNIQUE_INSTANCE;

	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static EnumSingleton getInstance(){
		return UNIQUE_INSTANCE;
	}

	public void singletonOperation(){
		System.out.println("推荐安全简洁的单例模式-->枚举类型单例模式!");
	}

}
