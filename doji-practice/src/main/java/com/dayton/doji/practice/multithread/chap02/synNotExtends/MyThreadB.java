package com.dayton.doji.practice.multithread.chap02.synNotExtends;

/**
 * @author Martin Deng
 * @since 2020-10-24 21:53
 */
public class MyThreadB extends Thread{

	private Sub sub;

	public MyThreadB(Sub sub) {
		this.sub = sub;
	}

	@Override
	public void run() {
		sub.serviceMethod();
	}

}
