package com.dayton.doji.practice.designpattern.adapter.v1;

import com.dayton.doji.practice.designpattern.template.v2.Member;


/**
 * 注册方法
 * @author Martin Deng
 * @since 2020-08-29 18:10
 */
public class SigninService {

	/**
	 * 注册方法
	 * @param username	用户名
	 * @param password  密码
	 * @return com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg
	 * @author Martin Deng
	 * @since 2020/8/29 18:12
	 */
	public ResultMsg regist(String username, String password){
		return new ResultMsg(200, "注册成功", new Member());
	}

	/**
	 * 登录方法
	 * @param username	用户名
	 * @param password  密码
	 * @return com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg
	 * @author Martin Deng
	 * @since 2020/8/29 18:11
	 */
	public ResultMsg login(String username, String password){
		return null;
	}

}
