package com.khabali.capdevchallenge.spark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		new WebConfig(context.getBean(MessageService.class));
		((AbstractApplicationContext) context).registerShutdownHook();

	}

}
