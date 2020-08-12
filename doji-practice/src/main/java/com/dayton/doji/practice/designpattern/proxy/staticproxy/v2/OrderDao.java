package com.dayton.doji.practice.designpattern.proxy.staticproxy.v2;

/**
 * @author Martin Deng
 * @since 2020-08-12 22:28
 */
public class OrderDao {

	public int insert(Order order){
		System.out.println("OrderDao 创建 Order 成功！");
		return 1;
	}

}
