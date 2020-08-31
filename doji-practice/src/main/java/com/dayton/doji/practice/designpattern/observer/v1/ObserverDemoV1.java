package com.dayton.doji.practice.designpattern.observer.v1;

/**
 * @author Martin Deng
 * @since 2020-08-31 19:52
 */
public class ObserverDemoV1 {

	public static void main(String[] args) {
		GPer gPer = GPer.getInstance();
		Teacher tom = new Teacher("Tom");
		Teacher mic = new Teacher("Mic");

		gPer.addObserver(tom);
		gPer.addObserver(mic);

		// 业务逻辑代码
		Question question = new Question();
		question.setUserName("大明");
		question.setContent("观察者设计模式适用于哪些场景？");
		gPer.publishQuestion(question);
	}
}
