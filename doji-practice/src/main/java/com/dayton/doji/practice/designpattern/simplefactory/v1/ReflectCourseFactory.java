package com.dayton.doji.practice.designpattern.simplefactory.v1;

/**
 * 反射工厂
 * @author Martin Deng
 * @since 2020-08-06 19:22
 */
public class ReflectCourseFactory {

	/**
	 * 反射方法创建类
	 * @param clazz	类类型
	 * @return com.dayton.doji.practice.designpattern.simplefactory.v1.ICourse
	 * @author Martin Deng
	 * @since 2020/8/6 19:23
	 */
	public static ICourse create(Class<? extends ICourse> clazz){
		try {
			if (null != clazz){
				return clazz.newInstance();
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
