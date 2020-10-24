package com.dayton.doji.practice.multithread.chap02.synNotExtends;

/**
 * @author Martin Deng
 * @since 2020-10-24 21:52
 */
public class MyThreadA extends Thread{

	private Sub sub;

	public MyThreadA(Sub sub) {
		this.sub = sub;
	}

	@Override
	public void run() {
		sub.serviceMethod();
	}

}
