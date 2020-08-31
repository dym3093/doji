package com.dayton.doji.practice.designpattern.decorator.v2;

/**
 * 基本煎饼类
 * @author Martin Deng
 * @since 2020-08-31 19:12
 */
public class BaseBattercake extends Battercake{

	@Override
	protected String getMsg() {
		return "煎饼";
	}

	@Override
	protected int getPrice() {
		return 5;
	}

}
