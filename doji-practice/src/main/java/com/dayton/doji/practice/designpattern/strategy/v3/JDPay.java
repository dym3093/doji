package com.dayton.doji.practice.designpattern.strategy.v3;

/**
 * 京东白条支付类
 * @author Martin Deng
 * @since 2020-08-24 21:45
 */
public class JDPay extends Payment{

	@Override
	public String getName() {
		return "京东白条";
	}

	@Override
	protected double queryBalance(String uid) {
		return 500;
	}

}
