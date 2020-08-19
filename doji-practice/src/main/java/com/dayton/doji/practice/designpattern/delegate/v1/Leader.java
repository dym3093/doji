package com.dayton.doji.practice.designpattern.delegate.v1;

import java.util.HashMap;
import java.util.Map;

/**
 * 经理
 * @author Martin Deng
 * @since 2020-08-19 22:13
 */
public class Leader implements IEmployee{

	private Map<String, IEmployee> targets = new HashMap<>();

	public Leader() {
		targets.put("加密", new EmployeeA());
		targets.put("登录", new EmployeeB());
	}

	/**
	 * 项目经理指定别人干活
	 * @param command	
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/19 22:16
	 */
	@Override
	public void doing(String command) {
		targets.get(command).doing(command);
	}

}
