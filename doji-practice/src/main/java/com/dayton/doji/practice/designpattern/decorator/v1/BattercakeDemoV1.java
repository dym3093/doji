package com.dayton.doji.practice.designpattern.decorator.v1;

/**
 * @author Martin Deng
 * @since 2020-08-31 18:59
 */
public class BattercakeDemoV1 {

	public static void main(String[] args) {
		Battercake battercake = new Battercake();
		System.out.println(battercake.getMsg() + ", 总价格：" + battercake.getPrice());

		Battercake battercakeWithEgg = new BattercakeWithEgg();
		System.out.println(battercakeWithEgg.getMsg() + ", 总价格：" + battercakeWithEgg
				.getPrice());

		Battercake battercakeWithEggAndSausage = new BattercakeWithEggAndSausage();
		System.out.println(battercakeWithEggAndSausage.getMsg() + ", 总价格：" +
				battercakeWithEggAndSausage.getPrice());

	}
}
