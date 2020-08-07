package com.dayton.doji.practice.designpattern.abstractfactory.v1;

/**
 * python视频
 * @author Martin Deng
 * @since 2020-08-07 11:13
 */
public class PythonVideo implements IVideo{

	@Override
	public void record() {
		System.out.println("录制Python视频");
	}

}
