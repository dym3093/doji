package com.dayton.doji.practice.designpattern.decorator.v2;

/**
 * @author Martin Deng
 * @since 2020-08-31 19:15
 */
public class EggDecorator extends BattercakeDecorator{

	public EggDecorator(Battercake battercake) {
		super(battercake);
	}

	@Override
	protected void doSomething() {

	}

	@Override
	protected String getMsg() {
		return super.getMsg() + " + 1个鸡蛋";
	}

	@Override
	protected int getPrice() {
		return super.getPrice() + 1;
	}

}
