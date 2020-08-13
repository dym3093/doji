package com.dayton.doji.practice.designpattern.proxy.dynamicproxy.v1;

import com.dayton.doji.practice.designpattern.proxy.staticproxy.v1.Person;

/**
 * @author Martin Deng
 * @since 2020-08-13 21:13
 */
public class DynamicProxyDemoV1 {

	public static void main(String[] args) {
		Person person = (Person) new JDKMeipo().getInstance(new Customer());
		person.findLove();
	}
}
