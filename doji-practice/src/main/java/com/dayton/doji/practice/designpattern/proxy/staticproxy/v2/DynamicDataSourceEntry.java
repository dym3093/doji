package com.dayton.doji.practice.designpattern.proxy.staticproxy.v2;

/**
 * 动态切换数据源
 * @author Martin Deng
 * @since 2020-08-12 22:34
 */
public class DynamicDataSourceEntry {

	public final static String DEFAULT_SOURCE = null;

	private final static ThreadLocal<String> local = new ThreadLocal<>();

	public DynamicDataSourceEntry() {}

	/**
	 * 清空数据库
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/12 22:36
	 */
	public static void clear(){
		local.remove();
	}

	/**
	 * 获取当前正在使用的数据源名字
	 * @return java.lang.String
	 * @author Martin Deng
	 * @since 2020/8/12 22:37
	 */
	public static String get(){
		return local.get();
	}

	/**
	 *  还原当前切换的数据源
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/12 22:38
	 */
	public static void restore(){
		local.set(DEFAULT_SOURCE);
	}

	/**
	 *  设置已知名字的数据源
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/12 22:40
	 */
	public static void set(String source){
		local.set(source);
	}

	/**
	 *  根据年份动态设置数据源
	 * @param year 年份
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/12 22:41
	 */
	public static void set(int year){
		local.set("DB_" + year);
	}

}
