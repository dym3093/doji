package com.dayton.doji.practice.designpattern.singleton.lazy;

/**
 * 双重检查锁的单例模式 <br/>
 * 特点：兼顾线程安全又提升程序性能。<br/>
 * @author Martin Deng
 * @since 2020-08-08 21:18
 */
public class LazyDoubleCheckSingleton {
	private volatile static LazyDoubleCheckSingleton lazy = null;

	private LazyDoubleCheckSingleton(){}

	public static LazyDoubleCheckSingleton getInstance(){
		if (lazy == null){
			synchronized (LazyDoubleCheckSingleton.class){
				if (lazy == null){
					lazy = new LazyDoubleCheckSingleton();
					// 1. 分屏内存给这个对象
					// 2. 初始化对象
					// 3. 设置lazy指向刚分屏的内存地址
				}
			}
		}
		return lazy;
	}
}
