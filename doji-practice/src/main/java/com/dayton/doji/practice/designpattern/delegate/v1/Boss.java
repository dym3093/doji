package com.dayton.doji.practice.designpattern.delegate.v1;

/**
 * 老板类指定经理干活
 * @author Martin Deng
 * @since 2020-08-19 22:16
 */
public class Boss {

	public void command(String command, Leader leader){
		leader.doing(command);
	}

}
