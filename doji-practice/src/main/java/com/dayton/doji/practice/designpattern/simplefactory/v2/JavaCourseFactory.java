package com.dayton.doji.practice.designpattern.simplefactory.v2;

import com.dayton.doji.practice.designpattern.simplefactory.v1.ICourse;
import com.dayton.doji.practice.designpattern.simplefactory.v1.JavaCourse;

/**
 * Java课程工厂
 * @author Martin Deng
 * @since 2020-08-06 20:02
 */
public class JavaCourseFactory implements ICourseFactory{

	@Override
	public ICourse create() {
		return new JavaCourse();
	}

}
