package com.dayton.doji.practice.designpattern.proxy.dynamicproxy.v1;

import com.dayton.doji.practice.designpattern.proxy.staticproxy.v1.Person;

/**
 * 单身客户类
 * @author Martin Deng
 * @since 2020-08-13 21:12
 */
public class Customer implements Person{

	@Override
	public void findLove() {
		System.out.println("高富帅");
		System.out.println("身高180cm");
		System.out.println("8块腹肌");
	}

}
