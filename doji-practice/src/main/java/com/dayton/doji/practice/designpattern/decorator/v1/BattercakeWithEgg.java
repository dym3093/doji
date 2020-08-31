package com.dayton.doji.practice.designpattern.decorator.v1;

/**
 * 煎饼加鸡蛋
 * @author Martin Deng
 * @since 2020-08-31 18:56
 */
public class BattercakeWithEgg extends Battercake{

	@Override
	protected String getMsg() {
		return super.getMsg() + " + 1个鸡蛋";
	}

	@Override
	public int getPrice() {
		return super.getPrice() + 1;
	}

}
