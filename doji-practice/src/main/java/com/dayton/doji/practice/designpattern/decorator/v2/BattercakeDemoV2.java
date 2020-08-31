package com.dayton.doji.practice.designpattern.decorator.v2;

/**
 * @author Martin Deng
 * @since 2020-08-31 19:18
 */
public class BattercakeDemoV2 {

	public static void main(String[] args) {
		Battercake battercake = new BaseBattercake();
		// 加1个鸡蛋
		battercake = new EggDecorator(battercake);
		// 加1根香肠
		battercake = new SausageDecorator(battercake);
		// 再加一根香肠
		battercake = new SausageDecorator(battercake);

		// 跟静态代理最大的区别就是职责不同
		// 静态代理不一定满足 is-a 的关系
		// 静态代理会做功能增强，使同一职责变得不一样

		// 装饰者模式更多考虑扩展
		System.out.println(battercake.getMsg() + ", 总价：" + battercake.getPrice());

	}

}
