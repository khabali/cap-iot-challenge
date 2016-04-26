package com.capgemini.ito.spark;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.capgemini.ito.spark.config.WebConfig;
import com.capgemini.ito.spark.service.impl.MessageService;

@Configuration
@ComponentScan({ "com.capgemini.ito.spark" })
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
		new WebConfig(ctx.getBean(MessageService.class));
		ctx.registerShutdownHook();
		
	}

}
