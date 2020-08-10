package com.dayton.doji.practice.designpattern.prototype.shallow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin Deng
 * @since 2020-08-10 21:09
 */
public class PrototypeTest {

	public static void main(String[] args) {
		ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
		// 填充属性，方便测试
		concretePrototype.setAge(18);
		concretePrototype.setName("prototype");
		List hobbies = new ArrayList();
		concretePrototype.setHobbies(hobbies);
		System.out.println(concretePrototype);

		// 创建 Client 对，准备开始克隆
		Client client = new Client(concretePrototype);
		ConcretePrototypeA concretePrototypeClone = (ConcretePrototypeA)
				client.startClone(concretePrototype);
		System.out.println(concretePrototypeClone);

		System.out.println("克隆对象中应用类型地址值：" + concretePrototypeClone
				.getHobbies());
		System.out.println("原对象中的应用类型地址值：" + concretePrototype.getHobbies());
		System.out.println("对象地址比较：" + (concretePrototypeClone.getHobbies() ==
				concretePrototype.getHobbies()) );
	}
}
