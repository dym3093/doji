package com.dayton.doji.practice.designpattern.strategy.v1;

/**
 * @author Martin Deng
 * @since 2020-08-19 22:58
 */
public class StrategyDemoV1 {

	public static void main(String[] args) {
		PromotionActivity activity618 = new PromotionActivity(new
				CuponStrategy());
		PromotionActivity activity1111 = new PromotionActivity(new
				CashbackStrategy());
		activity618.execute();
		activity1111.execute();
	}
}
