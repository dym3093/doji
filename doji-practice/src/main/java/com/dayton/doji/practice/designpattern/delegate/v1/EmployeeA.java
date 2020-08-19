package com.dayton.doji.practice.designpattern.delegate.v1;

/**
 * @author Martin Deng
 * @since 2020-08-19 22:10
 */
public class EmployeeA implements IEmployee{

	@Override
	public void doing(String command) {
		System.out.println("我是员工A，我现在开始干" + command + "工作");
	}

}
