package com.dayton.doji.practice.designpattern.strategy.v3;

/**
 * 定义支付规范和支付逻辑的类
 * @author Martin Deng
 * @since 2020-08-24 21:45
 */
public abstract class Payment {

	/**
	 * 支付类型
	 * @return java.lang.String
	 * @author Martin Deng
	 * @since 2020/8/24 21:46
	 */
	public abstract String getName();

	/**
	 * 查询余额
	 * @param uid       查询id
	 * @return double   余额
	 * @author Martin Deng
	 * @since 2020/8/24 21:47
	 */
	protected abstract double queryBalance(String uid);

	/**
	 * 扣款支付
	 * @param uid	    查询id
	 * @param amount    余额
	 * @return com.dayton.doji.practice.designpattern.strategy.v3.PayState
	 * @author Martin Deng
	 * @since 2020/8/24 21:48
	 */
	public PayState pay(String uid, double amount){
		if (queryBalance(uid) < amount){
			return new PayState(500, "支付失败", "余额不足");
		}
		return new PayState(200, "支付成功", "支付金额：" + amount);
	}

}
