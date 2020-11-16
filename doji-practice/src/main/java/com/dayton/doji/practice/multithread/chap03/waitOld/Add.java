package com.dayton.doji.practice.multithread.chap03.waitOld;


/**
 * @author Martin Deng
 * @since 2020-11-16 10:57
 */
public class Add {

	private String lock;

	public Add(String lock) {
		this.lock = lock;
	}

	public void add(){
		synchronized (lock){
			ValueObject.list.add("One more thing");
			lock.notifyAll();
		}
	}
}
