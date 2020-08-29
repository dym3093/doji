package com.dayton.doji.practice.designpattern.adapter.v2;

/**
 * @author Martin Deng
 * @since 2020-08-29 22:12
 */
public class PassportTest {

	public static void main(String[] args) {
		IPassportForThird passportForThird = new PassportForThirdAdapter();
		passportForThird.loginForQQ("");
	}

}
