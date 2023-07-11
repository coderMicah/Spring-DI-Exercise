package com.Micah.springframeworkdemo.examples.c1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
class NormalClass{}


//We can specify how we want to get the bean: if we want to have a new instance every time a bean is instantiated
//we use the scope Prototype but if we want to use the same instance each time we can just leave the ordinary normal class
// Without specifying the scope annotation(by default every bean is in singleton scope)

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope(value="prototype")
class PrototypeClass{}


@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				BeanScopesLauncherApplication.class)) {

			System.out.println("The Normal class will have SAME hashcode indicating SAME instance of bean is used");
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));

			   System.out.println("The Prototype class will have DIFFERENT hashcode indicating DIFF instance of beans were used");
               System.out.println(context.getBean(PrototypeClass.class));
               System.out.println(context.getBean(PrototypeClass.class));
               System.out.println(context.getBean(PrototypeClass.class));
               System.out.println(context.getBean(PrototypeClass.class));
		}

	}

}