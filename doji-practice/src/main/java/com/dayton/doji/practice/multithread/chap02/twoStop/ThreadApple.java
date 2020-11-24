package com.dayton.doji.practice.multithread.chap02.twoStop;

/**
 * @author Martin Deng
 * @since 2020-11-03 21:38
 */
public class ThreadApple extends Thread{

	private Service service;

	public ThreadApple(Service service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.methodA();
	}

}
