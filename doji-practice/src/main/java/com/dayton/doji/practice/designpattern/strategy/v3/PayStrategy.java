package com.dayton.doji.practice.designpattern.strategy.v3;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付策略
 * @author Martin Deng
 * @since 2020-08-24 21:53
 */
public class PayStrategy {

	public static final String ALI_PAY = "AliPay";
	public static final String JD_PAY = "JdPay";
	public static final String UNION_PAY = "UnionPay";
	public static final String WECHAT_PAY = "WechatPay";
	public static final String DEFAULT_PAY = "AliPay";

	private static Map<String, Payment> payStrategy = new HashMap<>();

	static {
		payStrategy.put(ALI_PAY, new AliPay());
		payStrategy.put(WECHAT_PAY, new WechatPay());
		payStrategy.put(UNION_PAY, new UnionPay());
		payStrategy.put(JD_PAY, new JDPay());
	}

	public static Payment get(String payKey){
		return payStrategy.containsKey(payKey) ?
				payStrategy.get(payKey) : payStrategy.get(DEFAULT_PAY);
	}

}
