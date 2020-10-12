package com.dayton.doji.practice.multithread.chap01.login;

/**
 * @author Martin Deng
 * @since 2020-10-12 23:04
 */
public class BLogin extends Thread{

	@Override
	public void run(){
		LoginServlet.doPost("b", "bb");
	}

}
