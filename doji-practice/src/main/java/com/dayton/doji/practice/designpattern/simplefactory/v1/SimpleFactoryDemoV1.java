package com.dayton.doji.practice.designpattern.simplefactory.v1;

/**
 * 测试
 * @author Martin Deng
 * @since 2020-08-06 19:08
 */
public class SimpleFactoryDemoV1 {

	public static void main(String[] args) {
		ICourse course = CourseFactory.create(CourseFactory.CourseList.JAVA);
		course.record();
		ICourse reCourse = ReflectCourseFactory.create(PythonCourse.class);
		if (null != reCourse) {
			reCourse.record();
		}
	}

}
