package com.dayton.doji.practice.multithread.chap03.pr;

/**
 * 生产者
 * @author Martin Deng
 * @since 2020-11-16 11:27
 */
public class Producer {

	private String lock;

	public Producer(String lock) {
		this.lock = lock;
	}

}
