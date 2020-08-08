package com.dayton.doji.practice.designpattern.singleton.lazy;

import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式单例模式执行线程
 * @author Martin Deng
 * @since 2020-08-08 21:12
 */
@Slf4j
public class LazySingletonThread implements Runnable{

	@Override
	public void run() {
		LazySimpleSingleton simpleSingleton = LazySimpleSingleton.getInstance();
		log.info(Thread.currentThread().getName() + ": " + simpleSingleton);
	}

}
