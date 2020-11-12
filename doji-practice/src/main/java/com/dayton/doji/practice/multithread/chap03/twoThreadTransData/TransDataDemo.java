package com.dayton.doji.practice.multithread.chap03.twoThreadTransData;

/**
 * @author Martin Deng
 * @since 2020-11-12 11:00
 */
public class TransDataDemo {

	public static void main(String[] args) {
		MyList service = new MyList();
		ThreadA a = new ThreadA(service);
		a.setName("a");
		a.start();
		ThreadB b = new ThreadB(service);
		b.setName("b");
		b.start();
	}

}
