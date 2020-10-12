package com.dayton.doji.practice.multithread.chap01.subtraction;

/**
 * 测试共享变量的线程安全
 * @author Martin Deng
 * @since 2020-10-12 22:54
 */
public class SubtractionThreadDemo {

	public static void main(String[] args) {
		SubtractionThread subtractionThread = new SubtractionThread();
		Thread a = new Thread(subtractionThread, "a");
		Thread b = new Thread(subtractionThread, "b");
		Thread c = new Thread(subtractionThread, "c");
		Thread d = new Thread(subtractionThread, "d");
		Thread e = new Thread(subtractionThread, "e");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}
}
