package com.dayton.doji.practice.designpattern.singleton.seriable;

import java.io.*;

/**
 * @author Martin Deng
 * @since 2020-08-08 22:05
 */
public class SeriableSingletonDemo {

	public static void main(String[] args) {
		seriableDestory();
	}

	public static void seriableDestory(){
		SeriableSingleton s1;
		SeriableSingleton s2 = SeriableSingleton.getInstance();

		FileOutputStream fos;
		try {
			fos = new FileOutputStream("SeriableSingleton.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(s2);
			oos.flush();
			oos.close();

			FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			s1 = (SeriableSingleton) ois.readObject();
			ois.close();
			System.out.println("s1 --> " + s1);
			System.out.println("s2 --> " + s2);
			System.out.println("Is the same object ? " + (s1 == s2));
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
