package com.Micah.springframeworkdemo.exercise;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class CalculationServiceLauncher {

	public static void main(String[] args) {
		

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				CalculationServiceLauncher.class)) {
			System.out.print(context.getBean(BusinessCalculationService.class).findMax());
		} 

	}

}