package com.dayton.doji.practice.designpattern.template.v1;

/**
 * 网络课程
 * @author Martin Deng
 * @since 2020-08-27 20:56
 */
public abstract class NetworkCourse {

	protected final void createCourse(){
		// 分发预习资料
		this.postPreResource();
		// 制作课件PPT
		this.createPPT();
		// 在线直播
		this.liveVideo();
		// 提交课堂笔记
		this.postNote();
		// 提交源码
		this.postSource();

		// 布置作业，有些课有作业，有些课没有
		if (needHomework()){
			checkHomework();
		}
	}

	/**
	 * 检查作业
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/27 21:02
	 */
	abstract void checkHomework();

	/**
	 * 钩子方法：实现流程的微调
	 * @return boolean
	 * @author Martin Deng
	 * @since 2020/8/27 20:57
	 */
	protected boolean needHomework(){
		return false;
	}

	/**
	 * 提交源码
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/27 21:02
	 */
	final void postSource(){
		System.out.println("提交源代码");
	}

	/**
	 * 提交课件和笔记
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/27 21:02
	 */
	final void postNote(){
		System.out.println("提交课件和笔记");
	}

	/**
	 * 直播授课
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/27 21:02
	 */
	final void liveVideo(){
		System.out.println("直播授课");
	}

	/**
	 * 创建备课PPT
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/27 21:02
	 */
	final void createPPT(){
		System.out.println("创建备课PPT");
	}

	/**
	 * 分发预习资料
	 * @return void
	 * @author Martin Deng
	 * @since 2020/8/27 21:02
	 */
	final void postPreResource(){
		System.out.println("分发预习资料");
	}

}
