package com.dayton.doji.practice.designpattern.proxy.staticproxy.v2;

/**
 * @author Martin Deng
 * @since 2020-08-12 22:29
 */
public interface IOrderService {

	/**
	 * 创建订单
	 * @param order	 订单
	 * @return int   创建成功次数
	 * @author Martin Deng
	 * @since 2020/8/12 22:29
	 */
	int createOrder(Order order);

}
