package com.dayton.doji.practice.designpattern.prototype.shallow;


import java.util.List;

/**
 * 浅克隆
 * @author Martin Deng
 * @since 2020-08-10 21:02
 */
public class ConcretePrototypeA implements Prototype{

	private int age;
	private String name;
	private List hobbies;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getHobbies() {
		return hobbies;
	}

	public void setHobbies(List hobbies) {
		this.hobbies = hobbies;
	}

	/**
	 * 浅克隆
	 * @return com.dayton.doji.practice.designpattern.prototype.Prototype
	 * @author Martin Deng
	 * @since 2020/8/10 21:17
	 */
	@Override
	public Prototype clone() {
		ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
		concretePrototypeA.setAge(this.age);
		concretePrototypeA.setName(this.name);
		concretePrototypeA.setHobbies(this.hobbies);
		return concretePrototypeA;
	}
}
