package com.dayton.doji.practice.multithread.chap03.waitAndNotify;

/**
 * @author Martin Deng
 * @since 2020-11-12 14:56
 */
public class WaitAndNotifyDemo {

	public static void main(String[] args) {
		try {
			String lock = "lock";
			MyThreadOne one = new MyThreadOne(lock);
			one.setName("one");
			one.start();
			Thread.sleep(3000);
			MyThreadTwo two = new MyThreadTwo(lock);
			two.setName("two");
			two.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
