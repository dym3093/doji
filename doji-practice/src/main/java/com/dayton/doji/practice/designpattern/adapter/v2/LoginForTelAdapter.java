package com.dayton.doji.practice.designpattern.adapter.v2;

import com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg;

/**
 * 手机登录
 * @author Martin Deng
 * @since 2020-08-29 22:03
 */
public class LoginForTelAdapter implements LoginAdapter{

	@Override
	public boolean support(Object adapter) {
		return adapter instanceof LoginForTelAdapter;
	}

	@Override
	public ResultMsg login(String id, Object adapter) {
		return null;
	}

}
