package com.dayton.doji.practice.designpattern.adapter.v2;

import com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg;

/**
 * QQ登录
 * @author Martin Deng
 * @since 2020-08-29 22:01
 */
public class LoginForQQAdapter implements LoginAdapter{

	@Override
	public boolean support(Object adapter) {
		return adapter instanceof LoginForQQAdapter;
	}

	@Override
	public ResultMsg login(String id, Object adapter) {
		return null;
	}

}
