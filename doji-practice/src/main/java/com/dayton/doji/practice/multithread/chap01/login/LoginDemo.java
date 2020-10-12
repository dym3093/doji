package com.dayton.doji.practice.multithread.chap01.login;

/**
 * @author Martin Deng
 * @since 2020-10-12 23:04
 */
public class LoginDemo {

	public static void main(String[] args) {
		ALogin a = new ALogin();
		a.start();
		BLogin b = new BLogin();
		b.start();
	}

}
