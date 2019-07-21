package com.fu.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {


	@Autowired
	ApplicationContext applicationContext;

	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void contextLoads() {
		System.out.println(applicationContext.getBean("helloService"));
	}

	@Test
	public void testLogger(){
		/* 下面几个级别是由低到高 */
		logger.trace("这是trace级别的日志");
		logger.debug("这是debug级别的日志");
		/* springboot默认从info级别的日志开始打印 */
		logger.info("这是info级别的日志");
		logger.warn("这是warn级别的日志");
		logger.error("这是error级别的日志");
	}

}
