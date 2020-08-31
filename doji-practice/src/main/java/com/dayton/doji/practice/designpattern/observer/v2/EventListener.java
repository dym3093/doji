package com.dayton.doji.practice.designpattern.observer.v2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 监听器，它就是观察者的桥梁
 * @author Martin Deng
 * @since 2020-08-31 22:23
 */
public class EventListener{

	/** JDK 底层的Listener通常也是这样设计 */
	protected Map<String, Event> events = new HashMap<>();

	/**
	 * 通过事件名称和一个目标对象来触发事件
	 * @param eventType	    事件类型
	 * @param target        目标对象
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/31 22:26
	 */
	public void addListener(String eventType, Object target){
		try {
			this.addListener(eventType, target,
					target.getClass().getMethod("on" + toUpperFirstCase
							(eventType), Event.class));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	public void addListener(String eventType, Object target, Method callback){
		// 注册事件
		events.put(eventType, new Event(target, callback));
	}

	/**
	 * 触发，只要有动作就触发
	 * @param event     事件
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/31 22:28
	 */
	private void trigger(Event event){
		event.setSource(this);
		event.setTime(System.currentTimeMillis());

		try {
			// 发起回调
			if (event.getCallback() != null){
				// 用反射调用它的回调函数
				event.getCallback().invoke(event.getTarget(), event);
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 事件名称触发
	 * @param trigger	触发的事件名称
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/31 22:35
	 */
	protected void trigger(String trigger){
		if (!this.events.containsKey(trigger)){
			return;
		}
		trigger(this.events.get(trigger).setTrigger(trigger));
	}

	/**
	 * 首字母大写
	 * @param str	传入的字符串
	 * @return java.lang.String
	 * @author Martin Deng
	 * @since 2020/8/31 22:36
	 */
	private String toUpperFirstCase(String str){
		char[] chars = str.toCharArray();
		chars[0] -= 32;
		return String.valueOf(chars);
	}

}
