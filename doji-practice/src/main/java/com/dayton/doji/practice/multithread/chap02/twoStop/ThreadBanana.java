package com.dayton.doji.practice.multithread.chap02.twoStop;

/**
 * @author Martin Deng
 * @since 2020-11-03 21:40
 */
public class ThreadBanana extends Thread{

	private Service service;

	public ThreadBanana(Service service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.methodB();
	}

}
