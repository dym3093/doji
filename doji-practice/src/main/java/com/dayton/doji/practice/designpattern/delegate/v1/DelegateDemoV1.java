package com.dayton.doji.practice.designpattern.delegate.v1;

/**
 * @author Martin Deng
 * @since 2020-08-19 22:19
 */
public class DelegateDemoV1 {

	public static void main(String[] args) {
		new Boss().command("登录", new Leader());
	}
}
