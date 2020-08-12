package com.dayton.doji.practice.designpattern.singleton.thread;

/**
 * 线程单例 <br/>
 * 特点：不能保证其创建的对象是全局唯一的，但能保证在单个线程中是唯一的，天生是线程安全。
 * @author Martin Deng
 * @since 2020-08-12 20:58
 */
public class ThreadLocalSingleton {

	private static final ThreadLocal<ThreadLocalSingleton> THREAD_LOCAL_INSTANCE
			= ThreadLocal.withInitial(ThreadLocalSingleton::new);

	private ThreadLocalSingleton(){}

	public static ThreadLocalSingleton getInstance(){
		return THREAD_LOCAL_INSTANCE.get();
	}

}
