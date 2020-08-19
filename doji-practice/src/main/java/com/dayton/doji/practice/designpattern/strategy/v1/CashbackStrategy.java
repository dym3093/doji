package com.dayton.doji.practice.designpattern.strategy.v1;

/**
 * 返现促销
 * @author Martin Deng
 * @since 2020-08-19 22:51
 */
public class CashbackStrategy implements PromotionStrategy{

	@Override
	public void doPromotion() {
		System.out.println("返现促销，返回的金额转到支付宝账号");
	}

}
