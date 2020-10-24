package com.dayton.doji.practice.multithread.chap02.dirtyRead;

/**
 * 脏读
 * @author Martin Deng
 * @since 2020-10-20 22:38
 */
public class PublicVar {

	public String username = "A";
	public String password = "AA";

	synchronized public void setValue(String username, String password){
		try {
			this.username = username;
			Thread.sleep(5000);
			this.password = password;
			System.out.println("setValue method thread name=" +
			Thread.currentThread().getName() + " username = " + username
			+ " password = " + password);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized public void getValue(){
		System.out.println("setValue method thread name=" +
		Thread.currentThread().getName() + " username = " + username
				+ " password = " + password);
	}

}
