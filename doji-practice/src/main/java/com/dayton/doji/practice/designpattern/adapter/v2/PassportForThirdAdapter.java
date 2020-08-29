package com.dayton.doji.practice.designpattern.adapter.v2;

import com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg;
import com.dayton.doji.practice.designpattern.adapter.v1.SigninService;

/**
 * 第三方登录自由适配
 * @author Martin Deng
 * @since 2020-08-29 22:10
 */
public class PassportForThirdAdapter extends SigninService implements IPassportForThird{

	@Override
	public ResultMsg loginForQQ(String id) {
		return null;
	}

	@Override
	public ResultMsg loginForWechat(String id) {
		return null;
	}

	@Override
	public ResultMsg loginForToken(String token) {
		return null;
	}

	@Override
	public ResultMsg loginForTelphone(String telphone, String code) {
		return null;
	}

	@Override
	public ResultMsg loginForRegist(String username, String passport) {
		return null;
	}

	private ResultMsg processLogin(String key, Class<? extends LoginAdapter>
			clazz){
		try {
			LoginAdapter adapter = clazz.newInstance();
			if (adapter.support(adapter)){
				return adapter.login(key, adapter);
			}else {
				return null;
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
