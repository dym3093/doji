package com.dayton.doji.practice.multithread.chap03.waitAndNotify;

/**
 * @author Martin Deng
 * @since 2020-11-12 14:48
 */
public class MyThreadOne extends Thread{

	private Object lock;

	public MyThreadOne(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		super.run();
		try {
			synchronized (lock){
				System.out.println("线程：" + Thread.currentThread().getName()
						+ "开始 wait " + "time = " + System.currentTimeMillis());
				// 等待锁
				lock.wait();
				System.out.println("线程：" + Thread.currentThread().getName()
						+ "结束 wait " + "time = " + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
