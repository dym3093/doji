package com.dayton.doji.practice.designpattern.strategy.v1;

/**
 * 无促销
 * @author Martin Deng
 * @since 2020-08-19 22:56
 */
public class EmptyStrategy implements PromotionStrategy{

	@Override
	public void doPromotion() {
		System.out.println("无促销活动");
	}

}
