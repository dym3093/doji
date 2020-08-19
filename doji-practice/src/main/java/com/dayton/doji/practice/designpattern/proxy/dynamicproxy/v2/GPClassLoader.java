package com.dayton.doji.practice.designpattern.proxy.dynamicproxy.v2;

import lombok.SneakyThrows;

import java.io.*;

/**
 * @author Martin Deng
 * @since 2020-08-19 21:41
 */
public class GPClassLoader extends ClassLoader {

	private File classPathFile;

	public GPClassLoader() {
		String classPath = GPClassLoader.class.getResource("").getPath();
		this.classPathFile = new File(classPath);
	}

	@Override
	protected Class<?> findClass(String name) {
		String className = GPClassLoader.class.getPackage().getName() + "." +
				name;
		FileInputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			if (classPathFile != null){
				File classFile = new File(classPathFile,
						name.replace("\\.", "/") + ".class");
				if (classFile.exists()){
					in = new FileInputStream(classPathFile);
					out = new ByteArrayOutputStream();
					byte[] buff = new byte[1024];
					int len;
					while ((len = in.read(buff)) != -1){
						out.write(buff, 0, len);
					}
					return defineClass(className, out.toByteArray(), 0, out
							.size());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (null != in){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
