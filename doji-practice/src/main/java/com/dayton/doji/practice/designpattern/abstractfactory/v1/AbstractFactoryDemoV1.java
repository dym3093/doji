package com.dayton.doji.practice.designpattern.abstractfactory.v1;

import org.springframework.beans.BeanUtils;

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
		copyTest();
	}

	private static void copyTest(){
		Computer computer = Computer.builder()
				.cpu("骁龙865").ram("8G").rom("256G").gpu("MX150").build();
		Phone redmiK30 = new Phone();
		BeanUtils.copyProperties(computer, redmiK30);
		System.out.println(computer.toString());
		System.out.println(redmiK30.toString());
	}
}
