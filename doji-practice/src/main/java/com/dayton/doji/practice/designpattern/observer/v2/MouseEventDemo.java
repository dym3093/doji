package com.dayton.doji.practice.designpattern.observer.v2;

/**
 * @author Martin Deng
 * @since 2020-08-31 23:23
 */
public class MouseEventDemo {

	public static void main(String[] args) {
		MouseEventCallback callback = new MouseEventCallback();

		// 注册事件
		Mouse mouse = new Mouse();
		mouse.addListener(MouseEventType.ON_CLICK, callback);
		mouse.addListener(MouseEventType.ON_MOVE, callback);
		mouse.addListener(MouseEventType.ON_WHEEL, callback);
		mouse.addListener(MouseEventType.ON_OVER, callback);

		// 调用方法
		mouse.click();
		// 失去焦点事件
		mouse.blur();
	}
}
