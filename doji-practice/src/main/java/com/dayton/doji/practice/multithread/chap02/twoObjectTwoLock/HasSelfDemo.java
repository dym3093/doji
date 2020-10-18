package com.dayton.doji.practice.multithread.chap02.twoObjectTwoLock;

/**
 * @author Martin Deng
 * @since 2020-10-18 18:11
 */
public class HasSelfDemo {

	public static void main(String[] args) {
		HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
		HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
		ThreadA a = new ThreadA(numRef1);
		a.start();
		ThreadB b = new ThreadB(numRef2);
		b.start();
	}
}
