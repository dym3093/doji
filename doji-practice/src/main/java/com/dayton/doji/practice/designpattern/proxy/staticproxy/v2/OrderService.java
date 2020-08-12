package com.dayton.doji.practice.designpattern.proxy.staticproxy.v2;

/**
 * 订单服务
 * @author Martin Deng
 * @since 2020-08-12 22:30
 */
public class OrderService implements IOrderService{

	private OrderDao orderDao;

	public OrderService() {
		// 如果使用Spring应该是自动注入
		// 为了使用方便，微妙在构造方法中将orderDao直接初始化
		this.orderDao = new OrderDao();
	}

	@Override
	public int createOrder(Order order) {
		System.out.println("OrderService 调用 orderDao 创建订单");
		return orderDao.insert(order);
	}

}
