package com.dayton.doji.practice.multithread.chap01.subtraction;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 减法线程<br/>
 * 测试：共享数据的情况，就是多个线程可以访问同一个变量
 * @author Martin Deng
 * @since 2020-10-12 22:50
 */
public class SubtractionThread extends Thread{

	private int count = 5;

	private static ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		// 通过加锁实现线程安全，也可以通过在方法上添加synchronized关键字实现
		lock.lock();
		try {
			super.run();
			count--;
			System.out.println("由[" + Thread.currentThread().getName() + "]计算， " +
					"count=" + count);
		} finally {
			lock.unlock();
		}
	}

}
