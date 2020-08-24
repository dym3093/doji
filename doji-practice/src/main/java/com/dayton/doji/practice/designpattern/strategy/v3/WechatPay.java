package com.dayton.doji.practice.designpattern.strategy.v3;

/**
 * @author Martin Deng
 * @since 2020-08-24 21:51
 */
public class WechatPay extends Payment{

	@Override
	public String getName() {
		return "微信支付";
	}

	@Override
	protected double queryBalance(String uid) {
		return 256;
	}

}
