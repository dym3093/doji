package com.dayton.doji.practice.designpattern.proxy.staticproxy.v2;

import lombok.Data;

/**
 * @author Martin Deng
 * @since 2020-08-12 22:25
 */
@Data
public class Order {

	private Object orderInfo;
	private Long createTime;
	private String id;

}
