package com.dayton.doji.practice.multithread.chap04;

import java.util.concurrent.TimeUnit;

/**
 * @author Martin Deng
 * @since 2020-11-25 16:49
 */
public class Profiler {

	private static final ThreadLocal<Long> TIME_THREADLOCAL = new
			ThreadLocal<>();

	public static void begin(){
		TIME_THREADLOCAL.set(System.currentTimeMillis());
	}

	public static long end(){
		return System.currentTimeMillis() - TIME_THREADLOCAL.get();
	}

	public static void main(String[] args) throws InterruptedException {
		Profiler.begin();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("cost time: " + Profiler.end() + " ms");
	}

}
