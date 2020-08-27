package com.dayton.doji.practice.designpattern.template.v1;

/**
 * @author Martin Deng
 * @since 2020-08-27 21:08
 */
public class NetworkCourseDemoV1 {

	public static void main(String[] args) {
		test();
	}

	public static void test(){
		System.out.println("------ Java 架构师课程 ------");
		NetworkCourse javaCourse = new JavaCourse();
		javaCourse.createCourse();

		System.out.println("------ 大数据课程 ------");
		NetworkCourse bigDataCourse = new BigDataCourse(true);
		bigDataCourse.createCourse();
	}

}
