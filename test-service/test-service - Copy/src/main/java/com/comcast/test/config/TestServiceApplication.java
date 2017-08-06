package com.comcast.test.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//import com.comcast.test.controllers.JavaObjectDifference;
import com.comcast.xsp.boot.XspApplication;

@Configuration
@ComponentScan({"com.comcast.test"})
public class TestServiceApplication  extends XspApplication {

	public static void main(String[] args) {
		XspApplication.run(TestServiceApplication.class, args);
	}

}
