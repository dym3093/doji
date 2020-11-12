package com.dayton.doji.practice.multithread.chap03.twoThreadTransData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin Deng
 * @since 2020-11-12 10:46
 */
public class MyList {

	private List<String> list = new ArrayList<>();

	public void add(){
		list.add("孙悟空");
	}

	public int size(){
		return list.size();
	}

}
