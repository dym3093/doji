package com.dayton.doji.practice.designpattern.singleton.lazy;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 懒汉式单例模式 <br/>
 * 特点：被外部类调用时，内部类才会加载。<br/>
 * @author Martin Deng
 * @since 2020-08-08 21:10
 */
public class LazySimpleSingleton {

	private static ReentrantLock lock = new ReentrantLock();

	private LazySimpleSingleton(){}

	private static LazySimpleSingleton lazy = null;

	public static LazySimpleSingleton getInstance(){
		lock.lock();
		try {
			if (lazy == null){
				lazy = new LazySimpleSingleton();
			}
		} finally {
			lock.unlock();
		}
		return lazy;
	}

}
