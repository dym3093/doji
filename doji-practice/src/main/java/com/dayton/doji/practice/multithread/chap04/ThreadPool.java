package com.dayton.doji.practice.multithread.chap04;

/**
 * 线程池接口定义
 * @author Martin Deng
 * @since 2020-11-27 16:22
 */
public interface ThreadPool<Job extends Runnable> {

	/**
	 * 执行一个Job，该Job需要实现Runnable接口
	 * @param job	Runnable接口实现类
	 * @return void
	 * @author Martin Deng
	 * @since 2020/11/27 16:23
	 */
	void execute(Job job);

	/**
	 * 关闭线程池
	 * @return void
	 * @author Martin Deng
	 * @since 2020/11/27 16:24
	 */
	void shutdown();

	/**
	 * 增加工作线程数量
	 * @param num	 待增加的线程数量
	 * @return void
	 * @author Martin Deng
	 * @since 2020/11/27 16:25
	 */
	void addWorkers(int num);

	/**
	 * 减少指定工作线程的数量
	 * @param num	 待减少的工作线程数量
	 * @return void
	 * @author Martin Deng
	 * @since 2020/11/27 16:25
	 */
	void removeWorkers(int num);

	/**
	 * 获取正在等待执行的任务数量
	 * @return int
	 * @author Martin Deng
	 * @since 2020/11/27 16:26
	 */
	int getJobSize();

}
