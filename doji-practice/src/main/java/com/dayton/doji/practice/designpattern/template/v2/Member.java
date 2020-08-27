package com.dayton.doji.practice.designpattern.template.v2;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.Tolerate;

/**
 * @author Martin Deng
 * @since 2020-08-27 21:36
 */
@Data
@Builder
@FieldNameConstants(prefix = "")
public class Member {

	private String username;
	private String password;
	private String nickName;

	private int age;
	private String address;

	@Tolerate
	public Member() {}
}
