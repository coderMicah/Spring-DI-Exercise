package com.Micah.springframeworkdemo.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private Dependency1 dependency;

	public SomeClass(Dependency1 dependency) {
		super();
		this.dependency = dependency;
		System.out.println("All Dependencies Are Ready");
	}

	public Dependency1 getDependency() {
		return dependency;
	}
	
	
//	The PostConstruct annotation is used on a method that needs to be executed after
//	dependency injection is done to perform any initialization.
//	As soon as the dependency are auto wired spring will call the postconstruct methods, the method
//	is invoked b4 class is put to service on application startup
	@PostConstruct
	public void initialize() {
		dependency.getReady();
	}
	
	
//	b4 bean is removed from the context
	@PreDestroy
	public void Cleanup() {
		System.out.println("Cleanup");
	}

}

@Component
class Dependency1 {

	public void getReady() {
		System.out.println("Some logic using Dependency1 bean");
	}

}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				PrePostAnnotationsContextLauncherApplication.class)) {

			var beans = context.getBeanDefinitionNames();
			for (String bean : beans)
				System.out.println(bean);
		}

	}

}