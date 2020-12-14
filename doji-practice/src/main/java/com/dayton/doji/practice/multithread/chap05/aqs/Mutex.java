package com.dayton.doji.practice.multithread.chap05.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 独占锁实现
 * @author Martin Deng
 * @since 2020-11-28 14:28
 */
public class Mutex implements Lock{

	/** 解锁状态(解除同步) */
	public static final int RELEASE_STATE = 0;
	/** 上锁状态(同步) */
	public static final int LOCK_STATE = 1;

	/**
	 * 静态内部类，自定义同步器
	 * @author Martin Deng
	 * @since 2020/11/28 14:30
	 */
	private static class Sync extends AbstractQueuedSynchronizer{

		/**
		 * 当状态为0时获取锁
		 * @param arg   状态
		 * @return boolean
		 * @author Martin Deng
		 * @since 2020/11/28 14:50
		 */
		@Override
		protected boolean tryAcquire(int arg) {
			if (compareAndSetState(RELEASE_STATE, LOCK_STATE)){
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		/**
		 * 释放锁，将状态置为0
		 * @param arg	状态
		 * @return boolean
		 * @author Martin Deng
		 * @since 2020/11/28 14:51
		 */
		@Override
		protected boolean tryRelease(int arg) {
			if (getState() == RELEASE_STATE){
				throw new IllegalMonitorStateException();
			}
			setExclusiveOwnerThread(null);
			setState(RELEASE_STATE);
			return true;
		}

		/**
		 * 是否处于占用状态
		 * @return boolean
		 * @author Martin Deng
		 * @since 2020/11/28 14:49
		 */
		@Override
		protected boolean isHeldExclusively() {
			return getState() == LOCK_STATE;
		}

		/**
		 * 返回一个Condition，每个condition都包含了一个condition队列
		 * @return java.util.concurrent.locks.Condition
		 * @author Martin Deng
		 * @since 2020/11/28 14:53
		 */
		Condition newCondition(){
			return new ConditionObject();
		}

	}

	/** 仅需将操作代理到Sync上即可 */
	private final Sync sync = new Sync();

	@Override
	public void lock() {
		sync.acquire(LOCK_STATE);
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(LOCK_STATE);
	}

	@Override
	public void unlock() {
		sync.release(LOCK_STATE);
	}

	@Override
	public Condition newCondition() {
		return sync.newCondition();
	}

	public boolean isLocked(){
		return sync.isHeldExclusively();
	}

	public boolean hasQueuedThread(){
		return sync.hasQueuedThreads();
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(LOCK_STATE);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(LOCK_STATE, unit.toNanos(time));
	}

}
