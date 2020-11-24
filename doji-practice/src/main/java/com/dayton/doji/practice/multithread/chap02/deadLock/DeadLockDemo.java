package com.dayton.doji.practice.multithread.chap02.deadLock;

/**
 * @author Martin Deng
 * @since 2020-11-03 21:51
 */
public class DeadLockDemo {

	public static void main(String[] args) {
		try {
			DeadThread t1 = new DeadThread();
			t1.setFlag("a");
			Thread thread1 = new Thread(t1);
			thread1.start();
			Thread.sleep(100);
			t1.setFlag("b");
			Thread thread2 = new Thread(t1);
			thread2.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
