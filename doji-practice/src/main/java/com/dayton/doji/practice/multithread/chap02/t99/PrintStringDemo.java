package com.dayton.doji.practice.multithread.chap02.t99;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * @author Martin Deng
 * @since 2020-11-09 16:47
 */
public class PrintStringDemo {

	public static void main(String[] args) {
//		PrintString ps = new PrintString();
//		ps.printStringMethod();
//		System.out.println("停止他， ThreadName = " + Thread.currentThread().getName());
//		ps.setContinuePrint(false);
		add();
	}

	private static void add(){
		int[] num = new int[]{1,3,5,7,9};
		OptionalInt total = Arrays.stream(num).reduce( (a, b) -> a+b);
		System.out.println("total: " + total);
	}

}
