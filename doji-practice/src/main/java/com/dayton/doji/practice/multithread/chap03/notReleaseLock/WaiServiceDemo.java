package com.dayton.doji.practice.multithread.chap03.notReleaseLock;

/**
 * @author Martin Deng
 * @since 2020-11-16 10:29
 */
public class WaiServiceDemo {

	public static void main(String[] args) {
		try {
			Object lock = new Object();
			ThreadLockA a = new ThreadLockA(lock);
			a.start();
			Thread.sleep(5000);
			a.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
