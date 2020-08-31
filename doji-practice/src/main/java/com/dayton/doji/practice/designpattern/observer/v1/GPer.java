package com.dayton.doji.practice.designpattern.observer.v1;

import java.util.Observable;

/**
 * @author Martin Deng
 * @since 2020-08-31 19:42
 */
public class GPer extends Observable{

	private String name = "GPer生态圈";
	private static GPer gPer = null;
	private GPer(){}

	public static GPer getInstance(){
		if (null == gPer){
			gPer = new GPer();
		}
		return gPer;
	}

	public String getName(){
		return name;
	}

	public void publishQuestion(Question question){
		System.out.println(question.getUserName() + "在" + this.name +
				"提交了一个问题。");
		setChanged();
		notifyObservers(question);
	}

}
