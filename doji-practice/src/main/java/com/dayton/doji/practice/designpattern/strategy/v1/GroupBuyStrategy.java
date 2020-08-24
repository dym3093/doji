package com.dayton.doji.practice.designpattern.strategy.v1;

/**
 * 团购优惠促销
 * @author Martin Deng
 * @since 2020-08-19 22:53
 */
public class GroupBuyStrategy implements PromotionStrategy{
	@Override
	public void doPromotion() {
		System.out.println("拼团，满20人成团，全团享受团购价7折！");
	}

}
