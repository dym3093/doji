package com.dayton.doji.practice.designpattern.proxy.staticproxy.v1;

/**
 * @author Martin Deng
 * @since 2020-08-12 22:23
 */
public class StaticProxyDemoV1 {

	public static void main(String[] args) {
		// 只能帮儿子找对象，不能帮表妹、不能帮陌生人
		Father father = new Father(new Son());
		father.findLove();
	}

}
