package com.dayton.doji.practice.designpattern.abstractfactory.v1;

/**
 * 测试类
 * @author Martin Deng
 * @since 2020-08-07 11:17
 */
public class AbstractFactoryDemoV1 {

	public static void main(String[] args) {
		CourseFactory javaFactory = new JavaCourseFactory();
		javaFactory.createNote().edit();
		javaFactory.createVideo().record();
	}

}
