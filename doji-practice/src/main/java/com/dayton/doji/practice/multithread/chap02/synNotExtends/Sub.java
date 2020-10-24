package com.dayton.doji.practice.multithread.chap02.synNotExtends;

/**
 * @author Martin Deng
 * @since 2020-10-24 21:50
 */
public class Sub extends Main{

	@Override
	synchronized public void serviceMethod(){
		try {
			System.out.println("int sub 下一步 sleep begin threadName = "
					+ Thread.currentThread().getName() + " time = "
					+ System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int sub 下一步 sleep end threadName = "
					+ Thread.currentThread().getName() + " time = "
					+ System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
