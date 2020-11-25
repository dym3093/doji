package com.dayton.doji.practice.multithread.chap04;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Martin Deng
 * @since 2020-11-25 11:06
 */
public class WaitNotify {

	private static Object lock = new Object();
	private static boolean flag = true;

	public static void main(String[] args) throws InterruptedException {
		Thread waitThread = new Thread(new Wait(), "WaitThread");
		waitThread.start();
		TimeUnit.SECONDS.sleep(2);
		Thread notifyThread = new Thread(new Notify(), "NotifyThread");
		notifyThread.start();
	}

	static class Wait implements Runnable{
		@Override
		public void run() {
			// 加锁，拥有lock的monitor
			synchronized (lock){
				// 当条件不满足时，继续wait，同时释放了lock的锁
				while (flag){
					try {
						System.out.println(Thread.currentThread() + " flag is " +
								flag + ". wait@ " + new SimpleDateFormat
								("HH:mm:ss").format(new Date()));
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread() + " flag is " +
						flag + ". wait@ " + new SimpleDateFormat
						("HH:mm:ss").format(new Date()));
			}
		}
	}

	static class Notify implements Runnable{

		@Override
		public void run() {
			// 加锁，拥有lock的monitor
			synchronized (lock)	{
				// 获取lock的锁，然后进行通知，通知时不会释放lock的锁，
				// 直到当前线程释放了lock后，WaitThread才能从wait方法中返回
				try {
					System.out.println(Thread.currentThread() + " hold lock " +
							".notify@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
					lock.notifyAll();
					flag = false;
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 再次加锁
			synchronized (lock){
				try {
					System.out.println(Thread.currentThread() + " hold lock " +
							"again. sleep@ " + new SimpleDateFormat
							("HH:mm:ss").format(new Date()));
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
