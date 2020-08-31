package com.dayton.doji.practice.designpattern.observer.v2;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * 监听器的一种包装，标准事件源格式的定义
 * @author Martin Deng
 * @since 2020-08-31 22:20
 */
public class Event {

	/** 事件源，事件由谁发起，保存起来*/
	private Object source;
	/** 事件触发，要通知谁 */
	private Object target;
	/** 事件触发，要做什么动作，回调 */
	private Method callback;
	/** 事件名称，触发的是什么事件 */
	private String trigger;
	/** 事件触发的时间 */
	private long time;

	public Event(Object target, Method callback) {
		this.target = target;
		this.callback = callback;
	}

	public Object getSource() {
		return source;
	}

	public Event setSource(Object source) {
		this.source = source;
		return this;
	}

	public Object getTarget() {
		return target;
	}

	public Event setTarget(Object target) {
		this.target = target;
		return this;
	}

	public Method getCallback() {
		return callback;
	}

	public void setCallback(Method callback) {
		this.callback = callback;
	}

	public String getTrigger() {
		return trigger;
	}

	public Event setTrigger(String trigger) {
		this.trigger = trigger;
		return this;
	}

	public long getTime() {
		return time;
	}

	public Event setTime(long time) {
		this.time = time;
		return this;
	}

	@Override
	public String toString() {
		return "Event{" +
				"source=" + source +
				", target=" + target +
				", callback=" + callback +
				", trigger='" + trigger + '\'' +
				", time=" + time +
				'}';
	}
}
