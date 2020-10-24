package com.dayton.doji.practice.multithread.chap02.dirtyRead;

/**
 * @author Martin Deng
 * @since 2020-10-20 22:43
 */
public class Test {

	public static void main(String[] args) {
		try {
			PublicVar publicVarRef = new PublicVar();
			ThreadA threadA = new ThreadA(publicVarRef);
			threadA.start();
			Thread.sleep(200);
			publicVarRef.getValue();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
