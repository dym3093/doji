package com.dayton.doji.practice.designpattern.abstractfactory.v1;

/**
 * java课程工厂
 * @author Martin Deng
 * @since 2020-08-07 11:11
 */
public class JavaCourseFactory implements CourseFactory{

	@Override
	public INote createNote() {
		return new JavaNote();
	}

	@Override
	public IVideo createVideo() {
		return new JavaVideo();
	}

}
