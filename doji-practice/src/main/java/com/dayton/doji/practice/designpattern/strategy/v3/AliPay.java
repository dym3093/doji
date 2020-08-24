package com.dayton.doji.practice.designpattern.strategy.v3;

/**
 * 支付宝支付类
 * @author Martin Deng
 * @since 2020-08-24 21:50
 */
public class AliPay extends Payment{

	@Override
	public String getName() {
		return "支付宝";
	}

	@Override
	protected double queryBalance(String uid) {
		return 900;
	}

}
