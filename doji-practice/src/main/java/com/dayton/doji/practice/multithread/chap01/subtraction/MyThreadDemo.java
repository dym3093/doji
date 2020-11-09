package com.dayton.doji.practice.multithread.chap01.subtraction;

/**
 * @author Martin Deng
 * @since 2020-10-13 10:25
 */
public class MyThreadDemo {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
	}

}
