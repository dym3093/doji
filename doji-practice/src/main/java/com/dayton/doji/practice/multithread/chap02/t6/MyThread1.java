package com.dayton.doji.practice.multithread.chap02.t6;

/**
 * @author Martin Deng
 * @since 2020-10-30 21:12
 */
public class MyThread1 extends Thread{

	private Task task;

	public MyThread1(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run(){
		super.run();
		CommonUtils.beginTime1 = System.currentTimeMillis();
		task.doLongTimeTask();
		CommonUtils.endTime1 = System.currentTimeMillis();
	}

}
