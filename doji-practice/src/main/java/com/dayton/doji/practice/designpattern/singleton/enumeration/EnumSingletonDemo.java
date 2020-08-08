package com.dayton.doji.practice.designpattern.singleton.enumeration;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Martin Deng
 * @since 2020-08-08 21:48
 */
public class EnumSingletonDemo {

	public static void main(String[] args) {
		EnumSingleton.UNIQUE_INSTANCE.singletonOperation();
		seriableDestory();
//		destroySingleton();
	}

	public static void seriableDestory(){
		EnumSingleton s1;
		EnumSingleton s2 = EnumSingleton.getInstance();
		s2.setData(new Object());

		FileOutputStream fos;
		try {
			fos = new FileOutputStream("EnumSingleton.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(s2);
			oos.flush();
			oos.close();

			FileInputStream fis = new FileInputStream("EnumSingleton.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			s1 = (EnumSingleton) ois.readObject();
			ois.close();
			System.out.println("s1.getData() --> " + s1.getData());
			System.out.println("s2.getData() --> " + s2.getData());
			System.out.println("Is the same object ? " + (s1 == s2));
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 反射破坏单例测试方法
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/8 22:01
	 */
	public static void destroySingleton() {
		try {
			Class<?> clazz = EnumSingleton.class;
			// 通过反射获取私有构造器
			Constructor c = clazz.getDeclaredConstructor(null);
			// 强制访问
			c.setAccessible(true);
			// 暴力初始化
			Object obj1 = c.newInstance();
			// 调用两次构造方法，相当于"new”了两次
			Object obj2 = c.newInstance();
			System.out.println("obj1 --> " + obj1);
			System.out.println("obj2 --> " + obj2);
			// 判断是否一致
			System.out.println(obj1 == obj2);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
			e.printStackTrace();
		}
	}
}
