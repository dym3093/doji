package com.dayton.doji.practice.designpattern.adapter.v2;

import com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg;

/**
 * 第三方登录兼容接口
 * @author Martin Deng
 * @since 2020-08-29 22:06
 */
public interface IPassportForThird {

	/**
	 * QQ登录
	 * @param id	id
	 * @return com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg
	 * @author Martin Deng
	 * @since 2020/8/29 22:07
	 */
	ResultMsg loginForQQ(String id);

	/**
	 * 微信登录
	 * @param id	id
	 * @return com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg
	 * @author Martin Deng
	 * @since 2020/8/29 22:07
	 */
	ResultMsg loginForWechat(String id);
	
	/**
	 * token登录
	 * @param token	    token
	 * @return com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg
	 * @author Martin Deng
	 * @since 2020/8/29 22:08
	 */
	ResultMsg loginForToken(String token);

	/**
	 * 手机号登录
	 * @param telphone	    电话号码
	 * @param code          验证码
	 * @return com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg
	 * @author Martin Deng
	 * @since 2020/8/29 22:08
	 */
	ResultMsg loginForTelphone(String telphone, String code);

	/**
	 * 注册后自动登录
	 * @param username	
	 * @param passport
	 * @return com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg
	 * @author Martin Deng
	 * @since 2020/8/29 22:09
	 */
	ResultMsg loginForRegist(String username, String passport);

}
