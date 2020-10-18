package com.dayton.doji.practice.multithread.chap02.twoObjectTwoLock;

/**
 * @author Martin Deng
 * @since 2020-10-18 18:09
 */
public class ThreadA extends Thread{

	private HasSelfPrivateNum numRef;

	public ThreadA(HasSelfPrivateNum numRef) {
		this.numRef = numRef;
	}

	@Override
	public void run(){
		super.run();
		numRef.addI("a");
	}
}
