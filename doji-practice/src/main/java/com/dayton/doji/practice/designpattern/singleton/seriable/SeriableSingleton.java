package com.dayton.doji.practice.designpattern.singleton.seriable;

import java.io.Serializable;

/**
 * 反序列化导致破坏单例模式 <br/>
 * @author Martin Deng
 * @since 2020-08-08 21:57
 */
public class SeriableSingleton implements Serializable{
	// 序列化：就是把内存中的状态通过转换为字节码的形式
	// 从而转换一个I/O流，写入其他地方（可以是磁盘、网络I/O）
	// 内存中的状态会被永久保存下来

	// 反序列化：将已经持久化的字节码内容转换为I/O流
	// 通过 I/O 流的读取，进而将读取的内容转换为JAVA对象
	// 在转换过程中会重新创建对象 new

	public final static SeriableSingleton INSTANCE = new SeriableSingleton();

	private SeriableSingleton(){}

	public static SeriableSingleton getInstance(){
		return INSTANCE;
	}

	/**
	 * 通过readResolve()方法避免反序列化破坏单例
	 * @return java.lang.Object
	 * @author Martin Deng
	 * @since 2020/8/8 22:11
	 */
	private Object readResolve(){
		return INSTANCE;
	}

}
