package jda;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter implements EventListener {
	private static boolean STOP_CHAT = false;
	private static String SET_CHANNEL_NAME;
	
	public void onMessageReceived(MessageReceivedEvent event) {
		getCommands(event);
	}
	/**
	 * Runs all the methods
	 */
	public static void getCommands(MessageReceivedEvent event) {
		botToChat(event);
		chatLog(event);
		stopChatStatus(STOP_CHAT, event);
		
		if(event.getMessage().getContentRaw().equalsIgnoreCase("ding")) {
			dingDong(event);
		}
		if(event.getMessage().getContentRaw().equalsIgnoreCase("nerd") ||(event.getMessage().getContentRaw().equalsIgnoreCase("nerd"))){
			nerdle(event);
		}
		if(event.getMessage().getContentRaw().equalsIgnoreCase("cool")) {
					cool(event);
		}
		if(event.getMessage().getContentRaw().equalsIgnoreCase(".stopchat") ||event.getMessage().getContentRaw().equalsIgnoreCase(".startchat")) {
			startStopChat(event);
		}
		
		if(event.getMessage().getContentRaw().equals(".set")) {
			set(event);
		}
	}
	//The following methods are phrases
	
	/**
	 * user enters "ding". returns "dong"
	 */
	public static void dingDong(MessageReceivedEvent event) {
		event.getChannel().sendMessage("dong").queue();
	}
	/*
	 * user enters "nerd". returns "specified message"
	 */
	public static void nerdle(MessageReceivedEvent event) {
		event.getChannel().sendMessage("No " + event.getAuthor().getName() + " you're the nerd!").queue();
	}
	/**
	 * user enters cool. returns "specified message"
	 */
	public static void cool(MessageReceivedEvent event) {
		boolean ignoreCase = true;
		event.getChannel().sendMessage(
				"I'm pretty sure " + event.getJDA().getUsersByName("Ice", ignoreCase).get(0).getAsMention()
						+ " is much colder than you are.").queue();
	}
	
	//The following methods are active commands
	
	/**
	 * user enters ".startchat" / ".stopchat". Toggles capability of deleting all sent messages.
	 */
	public static void startStopChat(MessageReceivedEvent event) {
		//.startchat
		if (event.getMessage().getContentRaw().equalsIgnoreCase(".startchat")) {
			if ((event.getMember().getRoles().get(1).getName().equalsIgnoreCase("admins") || event.getMember().isOwner())) {
				STOP_CHAT = false;
			}
		//.stopchat
		}else{
			if ((event.getMember().getRoles().get(1).getName().equalsIgnoreCase("admins") || event.getMember().isOwner())) {
				STOP_CHAT = true;
			}
			
		}
	}
	/**
	 * Allows user to set the channel botToChat uses
	 */
	public static void set(MessageReceivedEvent event){
		SET_CHANNEL_NAME = event.getChannel().getName();
	}
	//The following methods are passive commands
	/**
	 * -in testing-
	 */
	public static void botToChat(MessageReceivedEvent event) {
		
	}
	
	/**
	 * -logs the chat in the specified channel name "logs"
	 */
	
	/**
	 * Checks STOP_CHAT. If true, deletes messages 
	 */
	
	public static void stopChatStatus(boolean STOP_CHAT, MessageReceivedEvent event) {
		if(STOP_CHAT == true) {
			event.getMessage().delete().queue();;
		}
	}
	public static void chatLog(MessageReceivedEvent event) {
		if (!(event.getAuthor().isBot())) {
			for (int i = 0; i < event.getJDA().getTextChannels().size(); i++) {
				if (event.getJDA().getTextChannels().get(i).getName().equals("logs")) {
					event.getJDA().getTextChannels().get(i).sendMessage(event.getChannel().getName() + ": "
							+ event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay()).queue();
				}
			}
		} else {
			//skip
		}
	}
	
	public static void chatToConsole(MessageReceivedEvent event) {
		if (!(event.getAuthor().isBot())) {
			System.out.println(event.getChannel().getName() + ": " + event.getAuthor().getName() + ": "
					+ event.getMessage().getContentDisplay());
		}

	}
}
