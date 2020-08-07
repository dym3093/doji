package com.dayton.doji.practice.designpattern.abstractfactory.v2;

import lombok.experimental.FieldNameConstants;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * 数据库链接池管理类
 * @author Martin Deng
 * @since 2020-08-07 21:49
 */
@Slf4j
@FieldNameConstants(prefix = "")
public final class DBConnectionPool extends Pool{

	/** 正在使用的连接数 */
	private int checkedOut;
	/** 存放产生的连接对象容器 */
	private List<Connection> freeConnections = Collections.synchronizedList
			(new ArrayList<>());
	/** 密码 */
	private String passWord;
	/** url连接 */
	private String url;
	/** 用户名 */
	private String userName;
	/** 驱动名称 */
	private String driverName;
	/** 空闲连接数 */
	private static int num = 0;
	/** 当前可用的连接数 */
	private static int numActive = 0;
	/** 连接池实例变量 */
	private static DBConnectionPool pool = null;

	/**
	 * 获取数据连接池
	 * @return com.dayton.doji.practice.designpattern.abstractfactory.v2.DBConnectionPool
	 * @author Martin Deng
	 * @since 2020/8/7 21:56
	 */
	public static synchronized DBConnectionPool getInstance(){
		if (pool == null){
			pool = new DBConnectionPool();
		}
		return pool;
	}

	private DBConnectionPool(){
		super();
		try {
			init();
			for (int i = 0; i < normalConnect; i++) {
				Connection conn = newConnection();
				if (conn != null){
					// 往容器中添加一个连接对象
					freeConnections.add(conn);
					// 记录总连接数
					num++;
				}

			}
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * 初始化线程池
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/7 22:01
	 */
	private void init() throws IOException {
		InputStream is = DBConnectionPool.class.getResourceAsStream(propertiesName);
		Properties p = new Properties();
		p.load(is);
		this.userName = p.getProperty(DBConnectionPool.USER_NAME);
		this.passWord = p.getProperty(DBConnectionPool.PASS_WORD);
		this.driverName = p.getProperty(DBConnectionPool.DRIVER_NAME);
		this.maxConnect = Integer.parseInt(p.getProperty(DBConnectionPool
				.MAX_CONNECT));
		this.normalConnect = Integer.parseInt(p.getProperty(DBConnectionPool
				.NORMAL_CONNECT));
	}

	@Override
	public void createPool() {

	}

	@Override
	public Connection getConnection() {
		Connection conn = null;
		// 还有空闲的连接
		if(freeConnections.size() > 0 ){
			num--;
			conn = freeConnections.get(0);
			freeConnections.remove(0);
			try {
				if (conn.isClosed()){
					log.info("从连接池中删除一个无效连接");
					conn = getConnection();
				}
			} catch (SQLException e) {
				log.error(e.getMessage());
				conn = getConnection();
			}
		} else if (maxConnect == 0 || checkedOut < maxConnect){
			conn = newConnection();
		}
		// 当前连接数加1
		if (null != conn){
			checkedOut++;
		}
		numActive++;
		return conn;
	}

	@Override
	public Connection getConnection(long timeOut) {
		long startTime = new Date().getTime();
		Connection conn;
		while ((conn = getConnection()) == null){
			try {
				// 线程等待
				wait(timeOut);
			} catch (InterruptedException e) {
				log.error(e.getMessage());
			}
			if ((new Date().getTime() - startTime) >= timeOut){
				// 如果超时，返回null
				return null;
			}
		}
		return conn;
	}

	@Override
	public void freeConnection(Connection conn) {
		freeConnections.add(conn);
		num++;
		checkedOut--;
		numActive--;
		// 解锁
		notifyAll();
	}

	/**
	 * 创建一个新连接
	 * @return java.sql.Connection
	 * @author Martin Deng
	 * @since 2020/8/7 22:18
	 */
	private Connection newConnection(){
		Connection conn = null;
		try {
			// 用户名、密码都为空
			if (userName == null){
				conn = DriverManager.getConnection(url);
			} else {
				conn = DriverManager.getConnection(url, userName, passWord);
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			return null;
		}
		return conn;
	}

	/**
	 * 返回当前空闲连接数
	 * @return int
	 * @author Martin Deng
	 * @since 2020/8/7 22:21
	 */
	@Override
	public int getNum() {
		return num;
	}

	/**
	 * 返回当前连接数
	 * @return int
	 * @author Martin Deng
	 * @since 2020/8/7 22:21
	 */
	@Override
	public int getNumActive() {
		return numActive;
	}


}
