package com.dayton.doji.practice.multithread.chap03.notReleaseLock;

/**
 * @author Martin Deng
 * @since 2020-11-16 10:27
 */
public class ThreadLockB extends Thread{

	private Object lock;

	public ThreadLockB(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		super.run();
		WaitService service = new WaitService();
		service.testMethod(lock);
	}

}
