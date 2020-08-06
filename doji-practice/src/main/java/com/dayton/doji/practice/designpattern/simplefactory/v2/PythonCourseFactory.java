package com.dayton.doji.practice.designpattern.simplefactory.v2;

import com.dayton.doji.practice.designpattern.simplefactory.v1.ICourse;
import com.dayton.doji.practice.designpattern.simplefactory.v1.PythonCourse;

/**
 * Python课程工厂
 * @author Martin Deng
 * @since 2020-08-06 20:03
 */
public class PythonCourseFactory implements ICourseFactory{

	@Override
	public ICourse create() {
		return new PythonCourse();
	}

}
