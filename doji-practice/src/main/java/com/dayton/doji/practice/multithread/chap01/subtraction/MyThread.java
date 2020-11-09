package com.dayton.doji.practice.multithread.chap01.subtraction;

/**
 * @author Martin Deng
 * @since 2020-10-13 10:23
 */
public class MyThread extends Thread{

	public MyThread() {
		System.out.println("构造方法的打印：" + Thread.currentThread().getName());
	}

	@Override
	public void run() {
		System.out.println("run方法的打印：" + Thread.currentThread().getName());
	}

}
