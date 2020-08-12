package com.dayton.doji.practice.designpattern.proxy.staticproxy.v1;

/**
 * 儿子要找对象
 * @author Martin Deng
 * @since 2020-08-12 22:21
 */
public class Son implements Person{

	@Override
	public void findLove() {
		//我没有时间，工作忙
		System.out.println("儿子要求：肤白貌美大长腿");
	}

}
