package com.Micah.springframeworkdemo.examples.b1;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;



@Component
class ClassA {

}


//The Lazy annotation prevent default initialization of bean when spring context is launched(at application startup)
@Component
@Lazy
class ClassB {
	private ClassA classA;
	
	@Autowired
	public ClassB(ClassA classA) {
		System.out.println("Some Initialization logic ");
		this.classA = classA;
	}

	public ClassA getClassA() {
		return classA;
	}
	
	public void doSomething() {
		System.out.println("Do Something");
	}

}

@Configuration
@ComponentScan
public class LazyInitializionLauncherApplication {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				 LazyInitializionLauncherApplication.class)) {
			System.out.println("Initialization of context is completed");
             context.getBean(ClassB.class).doSomething();
		}

	}

}