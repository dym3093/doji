package com.dayton.doji.practice.designpattern.adapter.v1;

/**
 * @author Martin Deng
 * @since 2020-08-29 18:20
 */
public class SigninForThirdServiceDemo {

	public static void main(String[] args) {
		SigninForThirdService service = new SigninForThirdService();
		// 不改变原来的代码，也能够兼容新的需求，还可以再加一层策略模式
		service.loginForQQ("sdbadfafasdfasfaf");
	}
}
