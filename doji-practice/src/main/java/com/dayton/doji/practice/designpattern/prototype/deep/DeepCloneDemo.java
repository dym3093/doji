package com.dayton.doji.practice.designpattern.prototype.deep;

/**
 * 深克隆测试
 * @author Martin Deng
 * @since 2020-08-10 21:27
 */
public class DeepCloneDemo {

	public static void main(String[] args) {
		QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
		try {
			QiTianDaSheng clone = (QiTianDaSheng) qiTianDaSheng.clone();
			System.out.println("深克隆： " + (qiTianDaSheng.jinGuBang == clone
					.jinGuBang) );
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		QiTianDaSheng q = new QiTianDaSheng();
		QiTianDaSheng n = q.shallowClone(q);
		System.out.println("浅克隆： " + (q.jinGuBang == n.jinGuBang));
	}
}
