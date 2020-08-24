package com.dayton.doji.practice.designpattern.strategy.v3;

/**
 * 测试DemoV3
 * @author Martin Deng
 * @since 2020-08-24 22:02
 */
public class StrategyDemoV3 {

	public static void main(String[] args) {
		Order order = new Order("1", "202008242202", 324.45);
		System.out.println(order.pay(PayStrategy.UNION_PAY));
	}

}
