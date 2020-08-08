package com.dayton.doji.practice.designpattern.singleton.hungry;

/**
 * 饿汉单例模式 <br/>
 * 适用于单例对象较少的情况 <br/>
 * 优点：没有加任何锁、执行效率比较高，用户体验比懒汉式单例模式更好。 <br/>
 * 缺点：类加载时就初始化，不管用不用都占用空间，浪费内存。<br/>
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
