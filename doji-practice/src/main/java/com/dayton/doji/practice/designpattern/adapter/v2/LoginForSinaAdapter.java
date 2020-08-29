package com.dayton.doji.practice.designpattern.adapter.v2;

import com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg;

/**
 * 新浪微博登录
 * @author Martin Deng
 * @since 2020-08-29 22:02
 */
public class LoginForSinaAdapter implements LoginAdapter{

	@Override
	public boolean support(Object adapter) {
		return adapter instanceof LoginForSinaAdapter;
	}

	@Override
	public ResultMsg login(String id, Object adapter) {
		return null;
	}

}
