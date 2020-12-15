package com.dayton.doji.practice.multithread.chap08;

/**
 * @author Martin Deng
 * @since 2020-12-15 21:06
 */
public class JoinCountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		Thread p1 = new Thread(() -> System.out.println("p1 finish"));
		Thread p2 = new Thread(() -> System.out.println("p2 finish"));
		p1.start();
		p2.start();
		p1.join();
		p2.join();
		System.out.println("all parser finish");
	}
}
