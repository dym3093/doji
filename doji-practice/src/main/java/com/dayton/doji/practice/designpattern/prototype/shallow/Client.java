package com.dayton.doji.practice.designpattern.prototype.shallow;

/**
 * @author Martin Deng
 * @since 2020-08-10 21:07
 */
public class Client {
	private Prototype prototype;

	public Client(Prototype prototype) {
		this.prototype = prototype;
	}

	public Prototype startClone(Prototype concretePrototype){
		return concretePrototype.clone();
	}

}
