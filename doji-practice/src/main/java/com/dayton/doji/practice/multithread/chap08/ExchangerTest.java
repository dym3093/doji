package com.dayton.doji.practice.multithread.chap08;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 两个Excel数据进行校对
 * @author Martin Deng
 * @since 2020-12-15 22:21
 */
public class ExchangerTest {

	public static final Exchanger<String> exgr = new Exchanger<>();

	public static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {

		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					// a录入银行流水数据
					String a = "银行流水a";
					exgr.exchange(a);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					String b = "银行流水b";
					String a = exgr.exchange("b");
					System.out.println("a和b数据是否一致： " + a.equals(b) +
					" , a录入的是: " + a + ", b录入的是: " + b);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		threadPool.shutdown();

	}

}
