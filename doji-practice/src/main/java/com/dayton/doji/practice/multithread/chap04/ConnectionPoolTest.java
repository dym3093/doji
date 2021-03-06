package com.dayton.doji.practice.multithread.chap04;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池测试
 * @author Martin Deng
 * @since 2020-11-25 22:00
 */
public class ConnectionPoolTest {

	static ConnectionPool pool = new ConnectionPool(10);
	/** 保证所有的ConnectionRunner能够同时开始 */
	static CountDownLatch start = new CountDownLatch(1);
	/** main线程将会等待所有ConnectionRunner结束后才能继续执行 */
	static CountDownLatch end;

	public static void main(String[] args) throws InterruptedException {
		// 线程数量，可以修改线程数量进行观察
		int threadCount = 10;
		end = new CountDownLatch(threadCount);
		int count = 20;
		AtomicInteger got = new AtomicInteger();
		AtomicInteger notGot = new AtomicInteger();
		for (int i = 0; i < threadCount; i++) {
			Runnable target = new ConnectionRunner(count, got, notGot);
			Thread thread = new Thread(target, "ConnectionRunnerThread");
			thread.start();
		}
		start.countDown();
		end.await();
		System.out.println("total invoke: " + (threadCount * count));
		System.out.println("got connection: " + got);
		System.out.println("notGot connection: " + notGot);
	}

	static class ConnectionRunner implements Runnable{
		int count;
		AtomicInteger got;
		AtomicInteger notGot;

		public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
			this.count = count;
			this.got = got;
			this.notGot = notGot;
		}

		@Override
		public void run() {
			try {
				start.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (count > 0){
				// 从线程池中获取连接，如果1000ms内无法获取到，将会返回null
				// 分布统计连接获取的数量got和未获取到的数量notGot
				try {
					Connection connection = pool.fetchConnection(1000);
					if (connection != null){
						try {
							connection.createStatement();
							connection.commit();
						} finally {
							pool.releaseConnection(connection);
							got.incrementAndGet();
						}
					} else {
						notGot.incrementAndGet();
					}
				} catch (InterruptedException | SQLException e) {
					e.printStackTrace();
				}finally {
					count--;
				}
			}
			end.countDown();
		}

	}
}
