package com.dayton.doji.practice.multithread.chap02.twoStop;


/**
 * @author Martin Deng
 * @since 2020-11-03 21:42
 */
public class TowStopDemo {

	public static void main(String[] args) {
		Service service = new Service();
		ThreadApple apple = new ThreadApple(service);
		apple.start();
		ThreadBanana banana = new ThreadBanana(service);
		banana.start();
	}

}
