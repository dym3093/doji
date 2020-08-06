package com.dayton.doji.practice.designpattern.simplefactory.v1;


/**
 * 课程工厂
 * @author Martin Deng
 * @since 2020-08-06 19:06
 */
public class CourseFactory {

	/**
	 * 课程列表信息
	 * @author Martin Deng
	 * @since 2020/8/6 19:19
	 */
	public enum CourseList{
		/** java */
		JAVA("java"),
		/** python */
		PYTHON("python");

		private final String value;

		CourseList(String value) {
			this.value = value;
		}
		public String value(){
			return this.value;
		}
	}

	/**
	 * 创建课程
	 * @param name	课程名称
	 * @return com.dayton.doji.practice.designpattern.simplefactory.v1.ICourse
	 * @author Martin Deng
	 * @since 2020/8/6 19:06
	 */
	public static ICourse create(CourseList name){
		ICourse course = null;
		switch (name)	{
			case JAVA:
				course = new JavaCourse();
				break;
			case PYTHON:
				course = new PythonCourse();
				break;
			default:
		}
		return course;
	}

}
