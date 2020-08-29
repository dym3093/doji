package com.dayton.doji.practice.designpattern.adapter.v2;

import com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg;

/**
 * Token自动登录
 * @author Martin Deng
 * @since 2020-08-29 22:04
 */
public class LoginForTokenAdapter implements LoginAdapter{
	@Override
	public boolean support(Object adapter) {
		return adapter instanceof LoginForTokenAdapter;
	}

	@Override
	public ResultMsg login(String id, Object adapter) {
		return null;
	}

}
