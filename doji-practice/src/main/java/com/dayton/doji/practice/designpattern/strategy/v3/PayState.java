package com.dayton.doji.practice.designpattern.strategy.v3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 支付状态的包装类
 * @author Martin Deng
 * @since 2020-08-24 21:43
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PayState {

	/** 支付状态 */
	private int code;
	/** 交易详情 */
	private Object data;
	/** 提示信息 */
	private String msg;

}
