package com.dayton.doji.practice.multithread.chap02.synNotExtends;

/**
 * @author Martin Deng
 * @since 2020-10-24 21:51
 */
public class SynNotExtendsDemo {

	public static void main(String[] args) {
		Sub subRef = new Sub();
		MyThreadA a = new MyThreadA(subRef);
		a.setName("a");
		a.start();
		MyThreadB b = new MyThreadB(subRef);
		b.setName("b");
		b.start();
	}

}
