package com.dayton.doji.practice.designpattern.proxy.dynamicproxy.v1;

import com.dayton.doji.practice.designpattern.proxy.staticproxy.v1.Person;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Martin Deng
 * @since 2020-08-13 21:13
 */
public class DynamicProxyDemoV1 {

	public static void main(String[] args) {
		Person person = (Person) new JDKMeipo().getInstance(new Customer());
		person.findLove();
		jdkProxyTest();
	}

	public static void jdkProxyTest(){
		try {
			Person obj = (Person) new JDKMeipo().getInstance(new Customer());
			obj.findLove();

			byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new
					Class[]{Person.class});
			FileOutputStream fos = new FileOutputStream
					("F:\\test\\java\\$Proxy0.class");
			fos.write(bytes);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
