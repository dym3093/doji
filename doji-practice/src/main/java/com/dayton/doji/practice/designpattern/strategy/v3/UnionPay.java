package com.dayton.doji.practice.designpattern.strategy.v3;

/**
 * 银联支付
 * @author Martin Deng
 * @since 2020-08-24 21:51
 */
public class UnionPay extends Payment{

	@Override
	public String getName() {
		return "银联支付";
	}

	@Override
	protected double queryBalance(String uid) {
		return 120;
	}

}
