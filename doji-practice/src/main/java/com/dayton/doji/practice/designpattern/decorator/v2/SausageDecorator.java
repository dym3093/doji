package com.dayton.doji.practice.designpattern.decorator.v2;

/**
 * 香肠装饰者类
 * @author Martin Deng
 * @since 2020-08-31 19:16
 */
public class SausageDecorator extends BattercakeDecorator{

	public SausageDecorator(Battercake battercake) {
		super(battercake);
	}

	@Override
	protected void doSomething() {

	}

	@Override
	protected String getMsg() {
		return super.getMsg() + " + 1根香肠";
	}

	@Override
	protected int getPrice() {
		return super.getPrice() + 2;
	}

}
