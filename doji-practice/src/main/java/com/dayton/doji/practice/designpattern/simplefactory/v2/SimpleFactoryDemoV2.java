package com.dayton.doji.practice.designpattern.simplefactory.v2;

import com.dayton.doji.practice.designpattern.simplefactory.v1.ICourse;

/**
 * @author Martin Deng
 * @since 2020-08-06 20:04
 */
public class SimpleFactoryDemoV2 {

	public static void main(String[] args) {
		JavaCourseFactory javaCourseFactory = new JavaCourseFactory();
		ICourse javaCourse = javaCourseFactory.create();
		javaCourse.record();

		PythonCourseFactory pythonCourseFactory = new PythonCourseFactory();
		ICourse pythonCourse = pythonCourseFactory.create();
		pythonCourse.record();
	}
}
