package com.dayton.doji.practice.designpattern.adapter.v1;

/**
 * 第三方登录
 * @author Martin Deng
 * @since 2020-08-29 18:13
 */
public class SigninForThirdService extends SigninService {

	/**
	 * QQ登录
	 * @param openId	openId
	 * @return com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg
	 * @author Martin Deng
	 * @since 2020/8/29 18:20
	 */
	public ResultMsg loginForQQ(String openId){
		// 1. openId是全局唯一的，可以把它当作一个用户名（加长）
		// 2. 密码默认为 QQ_EMPTY
		// 3. 注册（在原有系统里创建一个用户）
		// 4. 调用原来的登录方法
		return loginForRegist(openId, null);
	}

	/**
	 * 微信登录
	 * @param openId    openId
	 * @return com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg
	 * @author Martin Deng
	 * @since 2020/8/29 18:20
	 */
	public ResultMsg loginForWechat(String openId){
		return null;
	}

	public ResultMsg loginForToken(String token){
		// 通过 Token获取用户信息，然后重新登录一次
		return null;
	}

	/**
	 * 电话号码登录
	 * @param telphone	电话号码
	 * @param code      验证码
	 * @return com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg
	 * @author Martin Deng
	 * @since 2020/8/29 18:19
	 */
	public ResultMsg loginForTelphone(String telphone, String code){
		return null;
	}

	private ResultMsg loginForRegist(String username, String password) {
		super.regist(username, null);
		return super.login(username, null);
	}

}
