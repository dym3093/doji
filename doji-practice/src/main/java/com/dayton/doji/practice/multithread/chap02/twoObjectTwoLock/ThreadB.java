package com.dayton.doji.practice.multithread.chap02.twoObjectTwoLock;

/**
 * @author Martin Deng
 * @since 2020-10-18 18:10
 */
public class ThreadB extends Thread{
	private HasSelfPrivateNum numRef;

	public ThreadB(HasSelfPrivateNum numRef) {
		this.numRef = numRef;
	}

	@Override
	public void run(){
		super.run();
		numRef.addI("b");
	}
}
