package com.dayton.doji.practice.multithread.chap02.t6;

/**
 * @author Martin Deng
 * @since 2020-10-30 21:15
 */
public class Run {

	public static void main(String[] args) {
		Task task = new Task();
		MyThread1 thread1 = new MyThread1(task);
		thread1.start();
		MyThread2 thread2 = new MyThread2(task);
		thread2.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long beginTime = CommonUtils.beginTime2 < CommonUtils.beginTime1 ?
				CommonUtils.beginTime2 : CommonUtils.beginTime1;

		long endTime = CommonUtils.endTime2 > CommonUtils.endTime1 ?
				CommonUtils.endTime2 : CommonUtils.endTime1;

		System.out.println("耗时：" + (endTime - beginTime) + " ms");
	}

}
