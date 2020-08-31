package com.dayton.doji.practice.designpattern.observer.v1;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 问题类
 * @author Martin Deng
 * @since 2020-08-31 19:45
 */
@Data
@NoArgsConstructor
public class Question {

	private String userName;
	private String content;

}
