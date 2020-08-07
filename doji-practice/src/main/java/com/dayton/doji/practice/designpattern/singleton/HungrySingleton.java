package com.dayton.doji.practice.designpattern.singleton;

/**
 * 饿汉单例模式 <br/>
 * 适用于单例对象较少的情况 <br/>
 * @author Martin Deng
 * @since 2020-08-07 22:49
 */
public class HungrySingleton {
	// 先静态、后动态
	// 先熟悉、后方法
	// 先上后下
	/** 单例对象 */
	private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

	private HungrySingleton(){}

	public static HungrySingleton getInstance(){
		return HUNGRY_SINGLETON;
	}
}
