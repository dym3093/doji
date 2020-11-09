package com.dayton.doji.practice.multithread.chap02.t99;

/**
 * @author Martin Deng
 * @since 2020-11-09 16:47
 */
public class PrintStringDemo {

	public static void main(String[] args) {
		PrintString ps = new PrintString();
		ps.printStringMethod();
		System.out.println("停止他， ThreadName = " + Thread.currentThread().getName());
		ps.setContinuePrint(false);
	}

}
