package jda;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.hooks.EventListener;

public class Runner extends Commands implements Runnable, EventListener{
	public static Bot MAIN_BOT = new Bot();
	public static Commands COMMAND_LIST = new Commands();
	public static Runner COMMAND_RUNNER = new Runner(){
		public void run() {
			MAIN_BOT.build.setToken(MAIN_BOT.token);
			MAIN_BOT.build.addEventListener(COMMAND_LIST);
			try {
				MAIN_BOT.build.buildAsync();
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		void onEvent(){
			System.out.println("hello");
		}
	};

	@Override
	public void run() {
		
	}
}
