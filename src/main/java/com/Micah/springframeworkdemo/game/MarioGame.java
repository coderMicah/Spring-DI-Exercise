package com.Micah.springframeworkdemo.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole {
   public void up() {
	   System.out.println("Up");
   }
   public void down() {
	   System.out.println("Crawl");
   }
   public void left() {
	   System.out.println("Go back");
   }
   public void right() {
	   System.out.println("Accelerate");
   }
}
