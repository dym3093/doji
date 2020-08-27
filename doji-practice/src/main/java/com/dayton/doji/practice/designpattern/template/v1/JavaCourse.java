package com.dayton.doji.practice.designpattern.template.v1;

/**
 * Java课程
 * @author Martin Deng
 * @since 2020-08-27 21:03
 */
public class JavaCourse extends NetworkCourse{

	@Override
	void checkHomework() {
		System.out.println("检查Java的架构作业");
	}

}
