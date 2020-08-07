package com.dayton.doji.practice.designpattern.abstractfactory.v2;

import lombok.experimental.FieldNameConstants;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 自定义连接池 getInstance()，返回Pool的唯一实例，第一次调用时将执行构造函数<br/>
 * 构造函数Pool()调用驱动装载loadDrivers()函数；createPool()函数创建连接池，
 * loadDrivers()装载驱动, getConnection()返回一个连接实例，getConnection(long time)
 * 添加时间限制，freeConnection(Connection conn)将conn连接实例返回连接池， getNum()返回
 * 空闲连接数, getNumActive()返回当前使用的连接数
 * @author Martin Deng
 * @since 2020-08-07 21:20
 */
@Slf4j
@FieldNameConstants(prefix = "")
public abstract class Pool {
	/** 连接配置属性 */
	public String propertiesName = "connection-INF.properties";
	/** 定义唯一实例 */
	public static Pool instance = null;
	/** 最大连接数 */
	protected int maxConnect = 100;
	/** 保持连接数 */
	protected int normalConnect = 10;
	/** 驱动名称 */
	private String driverName;
	/** 驱动变量 */
	protected Driver driver;

	/** 私有构造器，不允许外界访问 */
	Pool(){

	}

	/**
	 * 初始化所有从配置文件中读取的成员变量
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/7 21:30
	 */
	private void init() throws IOException {
		InputStream is = Pool.class.getResourceAsStream(propertiesName);
		Properties p = new Properties();
		p.load(is);
		this.driverName = p.getProperty(Pool.DRIVER_NAME);
		this.maxConnect = Integer.parseInt(p.getProperty(Pool.MAX_CONNECT,
				"100"));
		this.normalConnect = Integer.parseInt(p.getProperty(Pool
				.NORMAL_CONNECT, "10"));
	}

	/**
	 *  装载和注册所有JDBC驱动程序
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/7 21:33
	 */
	protected void loadDriver(String driverName){
		try {
			driver = (Driver) Class.forName(driverName).newInstance();
			DriverManager.registerDriver(driver);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建连接池
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/7 21:35
	 */
	public abstract void createPool();

	public static synchronized Pool getInstance() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
		if (instance == null){
			instance.init();
			instance = (Pool) Class.forName("org.e_book.sqlhelp.Pool").newInstance();
		}
		return instance;
	}

	/**
	 * 获取一个可用连接，如果没有则创建一个连接，且小于最大连接限制
	 * @return java.sql.Connection
	 * @author Martin Deng
	 * @since 2020/8/7 21:43
	 */
	public abstract Connection getConnection();

	/**
	 * 获取一个有超时时间的可用连接，如果没有则创建一个连接，且小于最大连接限制
	 * @param time 超时时间
	 * @return java.sql.Connection
	 * @author Martin Deng
	 * @since 2020/8/7 21:44
	 */
	public abstract Connection getConnection(long time);

	/**
	 * 释放连接<br/>
	 * 将连接对象返回给连接池
	 * @param conn	连接
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/7 21:45
	 */
	public abstract void freeConnection(Connection conn);

	/**
	 * 返回当前空闲连接数
	 * @return int 空闲连接数
	 * @author Martin Deng
	 * @since 2020/8/7 21:45
	 */
	public abstract int getNum();

	/**
	 * 返回当前工作的连接数
	 * @return int 当前工作的连接数
	 * @author Martin Deng
	 * @since 2020/8/7 21:46
	 */
	public abstract int getNumActive();

	/**
	 *  释放
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/7 21:47
	 */
	protected synchronized void release(){
		// 撤销驱动
		try {
			DriverManager.deregisterDriver(driver);
			log.info("撤销JDBC驱动程序" + driver.getClass().getName());
		} catch (SQLException e) {
			log.error("无法撤销JDBC驱动程序" + driver.getClass().getName());
		}
	}
	
}
