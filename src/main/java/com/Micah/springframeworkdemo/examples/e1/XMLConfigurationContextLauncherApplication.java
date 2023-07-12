package com.Micah.springframeworkdemo.examples.e1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Micah.springframeworkdemo.game.GameRunner;

public class XMLConfigurationContextLauncherApplication {

	public static void main(String[] args) {

		try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {

			var beans = context.getBeanDefinitionNames();
			for (String bean : beans)
				System.out.println(bean);
			
			context.getBean(GameRunner.class).run();

		}

	}

}