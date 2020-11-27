package com.dayton.doji.practice.multithread.chap04;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 默认线程池
 * @author Martin Deng
 * @since 2020-11-27 16:27
 */
@Slf4j
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job>{

	/** 线程池最大线程数量 */
	public static final int MAX_WORKER_NUMERS = 10;

	/** 线程池默认线程数量 */
	public static final int DEFAULT_WORKER_NUMBERS = 5;

	/** 线程池最小线程数量 */
	public static final int MIN_WORKER_NUMBERS = 1;

	/** 工作队列 */
	private final LinkedList<Job> jobs = new LinkedList<>();

	/** 工作者列表 */
	private final List<Worker> workers = Collections.synchronizedList(new
			ArrayList<Worker>());

	/** 工作者线程的数量 */
	private int workerNum = DEFAULT_WORKER_NUMBERS;

	/** 线程编号生成 */
	private AtomicLong threadNum = new AtomicLong();

	public DefaultThreadPool() {
		initializeWorkers(DEFAULT_WORKER_NUMBERS);
	}

	/**
	 * 根据指定数量初始化线程池
	 * @param num   指定的线程数量
	 * @author Martin Deng
	 */
	public DefaultThreadPool(int num) {
		workerNum = num > MAX_WORKER_NUMERS ? MAX_WORKER_NUMERS
				: ( num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num);
		initializeWorkers(workerNum);
	}

	@Override
	public void execute(Job job) {
		if (job != null){
			// 添加一个工作线程，进行通知
			synchronized (jobs){
				jobs.add(job);
				jobs.notify();
			}
		}
	}

	@Override
	public void shutdown() {
		for (Worker worker : workers){
			worker.shutdown();
		}
	}

	@Override
	public void addWorkers(int num) {
		synchronized (jobs){
			// 限制新增的worker数量不能超过最大线程数量
			if (num + this.workerNum > MAX_WORKER_NUMERS){
				num = MAX_WORKER_NUMERS - this.workerNum;
			}
			initializeWorkers(num);
			this.workerNum += num;
		}
	}

	@Override
	public void removeWorkers(int num) {
		synchronized (jobs){
			// 超出工作者线程数量，抛除异常
			if (num > this.workerNum){
				throw new IllegalArgumentException("Beyond WorkNum");
			}
			// 按照给定的线程数量停止Worker
			int count = 0;
			while (count < num){
				Worker worker = workers.get(count);
				if (workers.remove(worker)){
					// 移出后关闭worker线程
					worker.shutdown();
					count ++;
				}
			}
			this.workerNum -= count;
		}
	}

	@Override
	public int getJobSize() {
		return jobs.size();
	}

	/**
	 * 初始化线程工作者
	 * @param num	    初始化数量
	 * @return void
	 * @author Martin Deng
	 * @since 2020/11/27 16:47
	 */
	private void initializeWorkers(int num){
		for (int i = 0; i < num; i++) {
			Worker worker = new Worker();
			workers.add(worker);
			Thread thread = new Thread(worker, "ThreadPool-Worker-" +
					threadNum.incrementAndGet());
			thread.start();
		}
	}

	/** 工作者，负责消费线程 */
	class Worker implements Runnable{

		/** 是否工作 */
		private volatile boolean running = true;

		@Override
		public void run() {
			while (running){
				Job job;
				synchronized(jobs){
					while (jobs.isEmpty()){
						try {
							jobs.wait();
						} catch (InterruptedException e) {
							log.error(e.getMessage());
							// 感知到外部对WorkThread的终端操作，返回
							Thread.currentThread().interrupt();
							return;
						}
					}
					// 取出一个Job
					job = jobs.removeFirst();
				}
				if (job != null){
					try {
						job.run();
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				}
			}
		}

		/**
		 * 关闭工作者
		 * @return void
		 * @author Martin Deng
		 * @since 2020/11/27 16:43
		 */
		public void shutdown(){
			running = false;
		}
	}
}
