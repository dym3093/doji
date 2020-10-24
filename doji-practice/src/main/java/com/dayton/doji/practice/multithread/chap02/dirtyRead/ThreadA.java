package com.dayton.doji.practice.multithread.chap02.dirtyRead;

/**
 * @author Martin Deng
 * @since 2020-10-20 22:41
 */
public class ThreadA extends Thread{

	private PublicVar publicVar;

	public ThreadA(PublicVar publicVar) {
		super();
		this.publicVar = publicVar;
	}

	@Override
	public void run() {
		super.run();
		publicVar.setValue("B", "BB");
	}

}
