package com.Micah.springframeworkdemo.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.Micah.springframeworkdemo.game")
public class GamingAppLauncherApplication {

//	        Spring must help us with object creation why are we still creating objects?
//		    Instead of using beans we can ask spring to create beans for us using @component
//		    so there's no need for the beans block below
//	@Bean
//	public GamingConsole game() {
//		var game = new PacmanGame();
//		return game;
//	}

//	@Bean
//	public GameRunner gameRunner(GamingConsole game) {
//		var gameRunner = new GameRunner(game);
//		return gameRunner;
//	}

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				GamingAppLauncherApplication.class)) {
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
	

	}

}
