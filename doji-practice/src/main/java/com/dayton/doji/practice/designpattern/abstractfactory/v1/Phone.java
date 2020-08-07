package com.dayton.doji.practice.designpattern.abstractfactory.v1;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author Martin Deng
 * @since 2020-08-07 15:26
 */
@Data
@Builder
public class Phone {

	private String cpu;
	private String ram;
	private String rom;
	private String camera;
	private String battery;

	@Tolerate
	public Phone() {
	}

}
