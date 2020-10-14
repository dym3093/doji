package com.dayton.doji.practice.multithread.chap01.stop;

/**
 * @author Martin Deng
 * @since 2020-10-14 20:58
 */
public class StopThread extends Thread{

	private SynchronizedObject object;

	public StopThread(SynchronizedObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		object.pringString("b", "bb");
	}
}
