package com.dayton.doji.practice.designpattern.singleton.lazy;

/**
 * 懒汉式内部类单例模式 <br/>
 * 特点：屏蔽了饿汉式单例模式的内存浪费问题和synchronized的性能问题。<br/>
 * @author Martin Deng
 * @since 2020-08-08 21:29
 */
public class LazyInnerClassSingleton {
	// 使用 LazyInnerClassSingleton 的时候，默认会先初始化内部类
	// 如果没有使用，则内部类不会加载

	private LazyInnerClassSingleton(){
		// 避免反射方法调用构造器，破坏单例模式，调用时抛出异常
		if (LazyHolder.LAZY != null){
			throw new RuntimeException("不允许创建多个实例");
		}
	}

	/**
	 * static关键字是为了使单例的空间共享，保证这个方法不会被重写、重载
	 * @return com.dayton.doji.practice.designpattern.singleton.lazy.LazyInnerClassSingleton
	 * @author Martin Deng
	 * @since 2020/8/8 21:41
	 */
	public static final LazyInnerClassSingleton getInstance(){
		// 返回结果之前，一定会先加载内部类
		return LazyHolder.LAZY;
	}

	// 内部类默认不加载
	private static class LazyHolder{
		private static final LazyInnerClassSingleton LAZY = new
				LazyInnerClassSingleton();
	}

}
