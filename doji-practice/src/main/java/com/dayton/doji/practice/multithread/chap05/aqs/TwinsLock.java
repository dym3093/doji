package com.dayton.doji.practice.multithread.chap05.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author Martin Deng
 * @since 2020-12-07 22:30
 */
public class TwinsLock implements Lock{

	private static final int DEF_COUNT = 2;

	private final Sync sync = new Sync(DEF_COUNT);

	private static final class Sync extends AbstractQueuedSynchronizer{
			Sync(int count){
				if (count <= 0){
					throw new IllegalArgumentException("count must large than" +
							" zero.");
				}
				setState(count);
			}

			@Override
			public int tryAcquireShared(int reduceCount){
				for (;;){
					int current = getState();
					int newCount = current - reduceCount;
					if (newCount < 0 || compareAndSetState(current, newCount)){
						return newCount;
					}
				}
			}

			@Override
			public boolean tryReleaseShared(int returnCount){
				for (;;){
					int current = getState();
					int newCount = current + returnCount;
					if (compareAndSetState(current, newCount)){
						return true;
					}
				}
			}
	}

	@Override
	public void lock() {
		sync.acquireShared(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {

	}

	@Override
	public boolean tryLock() {
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return false;
	}

	@Override
	public void unlock() {
		sync.releaseShared(1);
	}

	@Override
	public Condition newCondition() {
		return null;
	}
}
