package com.dayton.doji.practice.designpattern.proxy.staticproxy.v1;

/**
 * 父亲帮儿子相亲
 * @author Martin Deng
 * @since 2020-08-12 22:20
 */
public class Father {

	private Son son;

	public Father(Son son){
		this.son = son;
	}

	public void findLove(){
		System.out.println("父亲物色对象");
		this.son.findLove();
		System.out.println("双方同意交往，确立关系");
	}

}
