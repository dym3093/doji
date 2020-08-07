package com.dayton.doji.practice.designpattern.abstractfactory.v1;

/**
 * Java笔记
 * @author Martin Deng
 * @since 2020-08-07 11:04
 */
public class JavaNote implements INote{

	@Override
	public void edit() {
		System.out.println("记录Java笔记");
	}

}
