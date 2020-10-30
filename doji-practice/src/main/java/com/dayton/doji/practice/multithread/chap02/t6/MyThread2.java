package com.dayton.doji.practice.multithread.chap02.t6;

/**
 * @author Martin Deng
 * @since 2020-10-30 21:12
 */
public class MyThread2 extends Thread{

	private Task task;

	public MyThread2(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run(){
		super.run();
		CommonUtils.beginTime2 = System.currentTimeMillis();
		task.doLongTimeTask();
		CommonUtils.endTime2 = System.currentTimeMillis();
	}

}
