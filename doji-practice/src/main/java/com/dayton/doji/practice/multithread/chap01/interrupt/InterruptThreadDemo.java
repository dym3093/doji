package com.dayton.doji.practice.multithread.chap01.interrupt;

/**
 * @author Martin Deng
 * @since 2020-10-13 21:08
 */
public class InterruptThreadDemo {
	public static void main(String[] args) {
		try {
			InterruptThread thread = new InterruptThread();
			thread.start();
			Thread.sleep(2000);
			thread.interrupt();
			System.out.println("是否停止1？ --> " + Thread.interrupted());
			System.out.println("是否停止2？ --> " + Thread.interrupted());
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
	}
}
