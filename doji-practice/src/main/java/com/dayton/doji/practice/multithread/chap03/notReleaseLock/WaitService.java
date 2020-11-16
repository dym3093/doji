package com.dayton.doji.practice.multithread.chap03.notReleaseLock;

/**
 * @author Martin Deng
 * @since 2020-11-16 10:24
 */
public class WaitService {

	public void testMethod(Object lock){
		try {
			System.out.println(Thread.currentThread().getName() + " begin " +
					"wait()...");
			lock.wait();
			System.out.println(Thread.currentThread().getName() + " end wait()!!!");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("出现异常，wai状态被interrupted中断...");
		}
	}

}
