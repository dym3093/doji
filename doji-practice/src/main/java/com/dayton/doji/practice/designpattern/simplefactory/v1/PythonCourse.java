package com.dayton.doji.practice.designpattern.simplefactory.v1;

/**
 * Python课程
 * @author Martin Deng
 * @since 2020-08-06 19:05
 */
public class PythonCourse implements ICourse{

	@Override
	public void record() {
		System.out.println("录制Python课程");
	}

}
