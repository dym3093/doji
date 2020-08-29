package com.dayton.doji.practice.designpattern.adapter.v2;

import com.dayton.doji.practice.designpattern.adapter.v1.ResultMsg;

/**
 * @author Martin Deng
 * @since 2020-08-29 22:00
 */
public interface LoginAdapter {

	boolean support(Object adapter);

	ResultMsg login(String id, Object adapter);

}
