package com.dayton.doji.practice.designpattern.prototype.deep;

import java.io.*;
import java.util.Date;

/**
 * @author Martin Deng
 * @since 2020-08-10 21:22
 */
public class QiTianDaSheng extends Monkey implements Cloneable, Serializable{

	public JinGuBang jinGuBang;

	public QiTianDaSheng() {
		this.birthday = new Date();
		this.jinGuBang = new JinGuBang();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return deepClone();
	}

	/**
	 * 深克隆
	 * @return java.lang.Object
	 * @author Martin Deng
	 * @since 2020/8/10 21:31
	 */
	public Object deepClone(){
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(this);

			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);

			QiTianDaSheng copy = (QiTianDaSheng) ois.readObject();
			copy.birthday = new Date();
			return copy;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 浅克隆
	 * @param target	待克隆对象
	 * @return com.dayton.doji.practice.designpattern.prototype.deep.QiTianDaSheng
	 * @author Martin Deng
	 * @since 2020/8/10 21:29
	 */
	public QiTianDaSheng shallowClone(QiTianDaSheng target){
		QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
		qiTianDaSheng.height = target.height;
		qiTianDaSheng.weight = target.weight;

		qiTianDaSheng.jinGuBang = target.jinGuBang;
		qiTianDaSheng.birthday = new Date();

		return qiTianDaSheng;
	}

}
