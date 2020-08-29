package com.dayton.doji.practice.designpattern.adapter.v2;

import com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg;

/**
 * 微信登录
 * @author Martin Deng
 * @since 2020-08-29 22:05
 */
public class LoginForWechatAdapter implements LoginAdapter{

	@Override
	public boolean support(Object adapter) {
		return adapter instanceof LoginForWechatAdapter;
	}

	@Override
	public ResultMsg login(String id, Object adapter) {
		return null;
	}

}
