package com.Micah.springframeworkdemo.examples.a1;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {
	Dependency1 dependency1;
	Dependency2 dependency2;

//	Using constructor-based injection
//	Spring team  prefers the use of constructor based injection 
//	No @Autowired annotation required here to specify the dependency injection
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor based Injection");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

//	Using field injection
//	@Autowired
//	Dependency1 dependency1;
//	
//	@Autowired
//	Dependency2 dependency2;

//	Using setter-based injection
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter based Injection - Dependency1");
//		this.dependency1 = dependency1;
//	}
//	
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter based Injection - Dependency1");
//		this.dependency2 = dependency2;
//	}

	@Override
	public String toString() {
		return "[dependency1=" + dependency1 + ", dependency2=" + dependency2 + "]";
	}

}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DepInjectionLauncherApplication.class)) {
			System.out.print(context.getBean(YourBusinessClass.class).toString());

		}

	}

}