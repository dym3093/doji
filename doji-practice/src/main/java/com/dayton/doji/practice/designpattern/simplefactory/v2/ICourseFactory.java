package com.dayton.doji.practice.designpattern.simplefactory.v2;

import com.dayton.doji.practice.designpattern.simplefactory.v1.ICourse;

/**
 * 抽象工厂
 * @author Martin Deng
 * @since 2020-08-06 20:01
 */
public interface ICourseFactory {

	ICourse create();
}
