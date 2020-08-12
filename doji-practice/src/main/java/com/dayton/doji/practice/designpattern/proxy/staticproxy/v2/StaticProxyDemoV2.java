package com.dayton.doji.practice.designpattern.proxy.staticproxy.v2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Martin Deng
 * @since 2020-08-12 22:47
 */
public class StaticProxyDemoV2 {

	public static void main(String[] args) {
		try {
			Order order = new Order();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date date = sdf.parse("2017/02/01");
			order.setCreateTime(date.getTime());

			IOrderService orderService = new OrderServiceStaticProxy(new
					OrderService());
			orderService.createOrder(order);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
