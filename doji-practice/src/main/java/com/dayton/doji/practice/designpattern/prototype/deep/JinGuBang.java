package com.dayton.doji.practice.designpattern.prototype.deep;

import java.io.Serializable;

/**
 * 金箍棒
 * @author Martin Deng
 * @since 2020-08-10 21:20
 */
public class JinGuBang implements Serializable{

	private float h = 100;
	private float d = 10;

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public float getD() {
		return d;
	}

	public void setD(float d) {
		this.d = d;
	}

	public void big(){
		this.d *= 2;
		this.h *= 2;
	}

	public void small(){
		this.d /= 2;
		this.h /= 2;
	}

}
