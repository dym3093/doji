package com.dayton.doji.practice.designpattern.template.v1;

/**
 * 大数据课程
 * @author Martin Deng
 * @since 2020-08-27 21:04
 */
public class BigDataCourse extends NetworkCourse{

	private boolean needHomeworkFlag = false;

	public BigDataCourse(boolean needHomeworkFlag) {
		this.needHomeworkFlag = needHomeworkFlag;
	}

	@Override
	void checkHomework(){
		System.out.println("检查大数据的课后作业");
	}

	@Override
	protected boolean needHomework() {
		return this.needHomeworkFlag;
	}

}
