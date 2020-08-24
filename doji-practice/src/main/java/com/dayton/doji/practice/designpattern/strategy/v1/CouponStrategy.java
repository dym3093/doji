package com.dayton.doji.practice.designpattern.strategy.v1;

/**
 * 优惠券促销
 * @author Martin Deng
 * @since 2020-08-19 22:58
 */
public class CouponStrategy implements PromotionStrategy{
	@Override
	public void doPromotion() {
		System.out.println("领取优惠券，课程的价格直接减免优惠券面值抵扣");
	}

}
