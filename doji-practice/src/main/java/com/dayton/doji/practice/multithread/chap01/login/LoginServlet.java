package com.dayton.doji.practice.multithread.chap01.login;

/**
 * @author Martin Deng
 * @since 2020-10-12 23:01
 */
public class LoginServlet {

	private static String usernameRef;
	private static String passwordRef;

	public static synchronized void doPost(String username, String password){
		try {
			usernameRef = username;
			if ("a".equals(username)){
				Thread.sleep(5000);
			}
			passwordRef = password;
			System.out.println("username=" + usernameRef + " password=" +
					passwordRef);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
