package com.dayton.doji.practice.designpattern.simplefactory.v1;


/**
 * Java课程
 * @author Martin Deng
 * @since 2020-08-06 19:04
 */
public class JavaCourse implements ICourse{

	@Override
	public void record() {
		System.out.println("录制Java课程");
	}

}
