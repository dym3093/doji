package com.dayton.doji.practice.multithread.chap08;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 银行流水处理服务类
 * @author Martin Deng
 * @since 2020-12-15 21:53
 */
public class BankWaterService implements Runnable{

	private CyclicBarrier c = new CyclicBarrier(4, this);

	/** 假设只有4个sheet，所以只启动4个线程 */
	private Executor executor = Executors.newFixedThreadPool(4);

	private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();
	
	private void count(){
		for (int i = 0; i < 4; i++) {
			executor.execute(() -> {
				sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
				try {
					c.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			});
		}	
	}

	@Override
	public void run() {
		int result = 0;
		// 汇总每个sheet计算结果
		for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()){
			result += sheet.getValue();
		}
		// 结果输出
		sheetBankWaterCount.put("result", result);
		System.out.println("汇总结果：" + result);
	}

	public static void main(String[] args) {
		BankWaterService bankWaterService = new BankWaterService();
		bankWaterService.count();
	}
}
