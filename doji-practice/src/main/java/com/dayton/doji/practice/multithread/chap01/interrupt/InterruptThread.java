package com.dayton.doji.practice.multithread.chap01.interrupt;

/**
 * @author Martin Deng
 * @since 2020-10-13 21:07
 */
public class InterruptThread extends Thread{

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 500000; i++) {
			System.out.println("i=" + (i+1));
		}
	}

}
