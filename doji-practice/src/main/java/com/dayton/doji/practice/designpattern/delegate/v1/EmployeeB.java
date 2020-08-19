package com.dayton.doji.practice.designpattern.delegate.v1;

/**
 * @author Martin Deng
 * @since 2020-08-19 22:12
 */
public class EmployeeB implements IEmployee{

	@Override
	public void doing(String command) {
		System.out.println("我是员工B，我现在开始干" + command + "工作");
	}

}
