package com.dayton.doji.practice.designpattern.decorator.v1;

/**
 * 既有鸡蛋又加香肠的煎饼
 * @author Martin Deng
 * @since 2020-08-31 18:57
 */
public class BattercakeWithEggAndSausage extends BattercakeWithEgg{

	@Override
	protected String getMsg() {
		return super.getMsg() + " + 1根香肠";
	}

	@Override
	public int getPrice() {
		return super.getPrice() + 2;
	}

}
