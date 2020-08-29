package com.dayton.doji.practice.designpattern.adapter.v1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Martin Deng
 * @since 2020-08-27 22:35
 */
@AllArgsConstructor
@Data
public class ResultMsg {

	private int code;
	private String msg;
	private Object data;

}
