package com.dayton.doji.practice.designpattern.abstractfactory.v1;

/**
 * python课程工厂
 * @author Martin Deng
 * @since 2020-08-07 11:16
 */
public class PythonCourseFactory implements CourseFactory{

	@Override
	public INote createNote() {
		return new PythonNote();
	}

	@Override
	public IVideo createVideo() {
		return new PythonVideo();
	}

}
