package com.dayton.doji.practice.multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock样例
 * @author Martin Deng
 * @since 2020-12-08 15:12
 */
public class MyCache {

	static Map<String, Object> map = new HashMap<>();
	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	static Lock r = readWriteLock.readLock();
	static Lock w = readWriteLock.writeLock();

	/**
	 *  线程安全的取值
	 * @param key   键
	 * @return java.lang.Object
	 * @author Martin Deng
	 * @since 2020/12/8 15:16
	 */
	public static Object get(String key){
		r.lock();
		try {
			return map.get(key);
		} finally {
			r.unlock();
		}
	}

	/**
	 * 设置key对应的value，并返回旧的value
	 * @param key       键
	 * @param object    值
	 * @return java.lang.Object
	 * @author Martin Deng
	 * @since 2020/12/8 15:18
	 */
	public static Object put(String key, Object object){
		w.lock();
		try {
			return map.put(key, object);
		} finally {
			w.unlock();
		}
	}

	/**
	 * 清空
	 * @return void
	 * @author Martin Deng
	 * @since 2020/12/8 15:30
	 */
	public static void clear(){
		w.lock();
		try {
			map.clear();
		} finally {
			w.unlock();
		}
	}

}
