package com.dayton.doji.practice.multithread.chap03.waitAndNotify;

/**
 * @author Martin Deng
 * @since 2020-11-12 14:48
 */
public class MyThreadTwo extends Thread{

	private Object lock;

	public MyThreadTwo(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		super.run();
		synchronized (lock){
			System.out.println("线程：" + Thread.currentThread().getName()
					+ "开始 notify " + "time = " + System.currentTimeMillis());
			// 等待锁
			lock.notify();
			System.out.println("线程：" + Thread.currentThread().getName()
					+ "结束 notify " + "time = " + System.currentTimeMillis());
		}
	}

}
