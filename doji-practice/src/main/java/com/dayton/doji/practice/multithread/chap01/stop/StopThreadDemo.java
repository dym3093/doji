package com.dayton.doji.practice.multithread.chap01.stop;

/**
 * @author Martin Deng
 * @since 2020-10-14 20:59
 */
public class StopThreadDemo {

	public static void main(String[] args) {
		try {
			SynchronizedObject object = new SynchronizedObject();
			StopThread thread = new StopThread(object);
			thread.start();
			Thread.sleep(500);
			thread.stop();
			System.out.println(object.getUsername() + " --> " +
			object.getPassword());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
