package com.dayton.doji.practice.designpattern.abstractfactory.v1;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author Martin Deng
 * @since 2020-08-07 15:27
 */
@Data
@Builder
public class Computer {

	private String cpu;
	private String ram;
	private String rom;
	private String gpu;

	@Tolerate
	public Computer() {}

}
