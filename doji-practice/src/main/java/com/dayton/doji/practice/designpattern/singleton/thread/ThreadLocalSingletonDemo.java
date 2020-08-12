package com.dayton.doji.practice.designpattern.singleton.thread;

/**
 * @author Martin Deng
 * @since 2020-08-12 22:17
 */
public class ThreadLocalSingletonDemo {

	public static void main(String[] args) {
		System.out.println(ThreadLocalSingleton.getInstance());
		System.out.println(ThreadLocalSingleton.getInstance());
		System.out.println(ThreadLocalSingleton.getInstance());
		System.out.println(ThreadLocalSingleton.getInstance());
		System.out.println(ThreadLocalSingleton.getInstance());
	}
}
