package com.dayton.doji.practice.multithread.chap01.stop;

/**
 * @author Martin Deng
 * @since 2020-10-14 20:56
 */
public class SynchronizedObject {

	private String username = "a";
	private String password = "aa";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	synchronized public  void pringString(String username, String password){
		try {
			this.username = username;
			Thread.sleep(100000);
			this.password = password;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
