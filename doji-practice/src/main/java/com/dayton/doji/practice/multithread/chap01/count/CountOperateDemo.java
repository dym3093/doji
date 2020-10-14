package com.dayton.doji.practice.multithread.chap01.count;

/**
 * @author Martin Deng
 * @since 2020-10-13 20:21
 */
public class CountOperateDemo {

	public static void main(String[] args) throws InterruptedException {
//		testAlive();
		showName();
	}

	public static void testAlive() throws InterruptedException {
		CountOperate c = new CountOperate();
		System.out.println("begin == " + c.isAlive());
		c.start();
		Thread.sleep(1000);
		System.out.println("end == " + c.isAlive());
	}

	public static void showName(){
		CountOperate c = new CountOperate();
		Thread t1 = new Thread(c);
		System.out.println("main begin t1 isAlive = " + t1.isAlive());
		System.out.println("getId() = " + t1.getId());
		t1.setName("a");
		t1.start();
		System.out.println("main end t1 isAlive = " + t1.isAlive());
	}

}
