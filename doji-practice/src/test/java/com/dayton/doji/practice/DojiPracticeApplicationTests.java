package com.dayton.doji.practice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DojiPracticeApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void forTest(){
		for (int i=0; i<5; i++) {
			for (int j=0; j<20; j++ ){
				log.info("i = {}, j = {}", i, j);
				if (i==j){
					log.info("i =j = {}", j);
					break;
				}
			}
		}
	}

}
