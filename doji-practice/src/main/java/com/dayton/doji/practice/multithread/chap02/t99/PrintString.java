package com.dayton.doji.practice.multithread.chap02.t99;

/**
 * @author Martin Deng
 * @since 2020-11-09 16:39
 */
public class PrintString {

	private boolean isContinuePrint = true;


	public boolean isContinuePrint() {
		return isContinuePrint;
	}

	public void setContinuePrint(boolean continuePrint) {
		isContinuePrint = continuePrint;
	}

	public void printStringMethod(){
		try {
			while(isContinuePrint){
				System.out.println("run printStringMethod() threadName = " +
						Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
