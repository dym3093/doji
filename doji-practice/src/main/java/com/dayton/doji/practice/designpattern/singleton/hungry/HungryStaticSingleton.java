package com.dayton.doji.practice.designpattern.singleton.hungry;

/**
 * 饿汉式静态块单例模式
 * @author Martin Deng
 * @since 2020-08-08 21:06
 */
public class HungryStaticSingleton {

	private static final HungryStaticSingleton HUNGER_STATIC_SINGLETON;

	static {
		HUNGER_STATIC_SINGLETON = new HungryStaticSingleton();
	}

	private HungryStaticSingleton() {
	}

	public static HungryStaticSingleton getInstance(){
		return HUNGER_STATIC_SINGLETON;
	}
}
