package com.dayton.doji.practice.concurrentPrograming.chap01.demo01;

/**
 * @author Martin Deng
 * @since 2020-11-16 20:58
 */
public class ConcurrencyTest {

	private static final long COUNT = 10000*10000L;

	public static void main(String[] args) throws InterruptedException {
		concurrency();
		serial();
	}

	/**
	 * 并发执行
	 * @return void
	 * @author Martin Deng
	 * @since 2020/11/16 21:05
	 */
	private static void concurrency() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread thread = new Thread(() -> {
			int a = 0;
			for (int i = 0; i < COUNT; i++) {
				a += 5;
			}
		});
		thread.start();
		int b = 0;
		for (int i = 0; i < COUNT; i++) {
			b--;
		}
		long time = System.currentTimeMillis() - start;
		thread.join();
		System.out.println("concurrency : " + time + " ms, b=" + b );
	}

	/**
	 *  串行执行
	 * @return void
	 * @author Martin Deng
	 * @since 2020/11/16 21:05
	 */
	private static void serial(){
		long start = System.currentTimeMillis();
		int a = 0;
		for (int i = 0; i < COUNT; i++) {
			a += 5;
		}
		int b = 0;
		for (int i = 0; i < COUNT; i++) {
			b--;
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("serial : " + time + " ms, b=" + b + ", a=" + a);
	}
}
