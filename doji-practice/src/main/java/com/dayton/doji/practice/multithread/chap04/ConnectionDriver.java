package com.dayton.doji.practice.multithread.chap04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * 连接驱动
 * @author Martin Deng
 * @since 2020-11-25 21:43
 */
public class ConnectionDriver {

	static class ConnectionHandler implements InvocationHandler{

		static final String COMMIT = "commit";

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (COMMIT.equals(method.getName())){
				TimeUnit.SECONDS.sleep(100);
			}
			return null;
		}

	}

	/**
	 * 创建一个connection的代理，在commit时休眠100ms
	 * @return java.sql.Connection
	 * @author Martin Deng
	 * @since 2020/11/25 21:51
	 */
	public static Connection createConnection(){
		return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader()
				, new Class<?>[]{Connection.class},
				new ConnectionHandler());
	}
}
