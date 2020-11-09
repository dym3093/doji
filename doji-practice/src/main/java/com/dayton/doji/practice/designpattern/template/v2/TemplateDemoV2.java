package com.dayton.doji.practice.designpattern.template.v2;

import java.util.List;

/**
 * @author Martin Deng
 * @since 2020-08-27 21:51
 */
public class TemplateDemoV2 {

	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao(null);
		List<?> result = memberDao.selectAll();
		System.out.println(result);
	}

}
