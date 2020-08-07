package com.dayton.doji.practice.designpattern.abstractfactory.v1;

/**
 * 课程的抽象工厂
 * @author Martin Deng
 * @since 2020-08-07 11:01
 */
public interface CourseFactory {

	/**
	 *  创建笔记
	 * @return com.dayton.doji.practice.designpattern.abstractfactory.v1.INote
	 * @author Martin Deng
	 * @since 2020/8/7 11:01
	 */
	INote createNote();

	/**
	 * 创建视频
	 * @return com.dayton.doji.practice.designpattern.abstractfactory.v1.IVideo
	 * @author Martin Deng
	 * @since 2020/8/7 11:01
	 */
	IVideo createVideo();

}
