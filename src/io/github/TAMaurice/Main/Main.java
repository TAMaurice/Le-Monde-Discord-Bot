package io.github.TAMaurice.Main;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.*;

public class Main extends ListenerAdapter {

	public static JDABuilder builder;
	public static String prefix = "~";
	
	public String title = "Le Monde - The weekly newspaper of the Republic!";
	
	public String subtitle0 = "What is <<Le Monde>>?";
	public String text0 = "Le Monde is one of the biggest Newspapers in France, so Maurice decided to make a bot who will give informations named <<Le Monde>>.";
	
	public String subtitle1 = "NOW HIRING:";
	public String text1 = "Le Monde is searching for: Writers and Editors so it's not a 1 Man Operation and ensure it's neutrality";
	
	public String subtitle2 = "Jokes";
	public String text2 = "Nintendo Wii - Or how they in France say: Nintendo Yes";
	
	public String AuthorName = "Le Monde";
	public String AuthorIcon = "https://cdn.discordapp.com/attachments/836976203223138325/837002428682338354/unnamed.png";
	public String AuthorURL = "https://cdn.discordapp.com/attachments/836976203223138325/837002428682338354/unnamed.png";
	
	public static void main(String[] args) throws LoginException {
		
		
		builder = JDABuilder.createDefault(PrivateStrings.token);
		builder.setStatus(OnlineStatus.ONLINE);
		builder.setActivity(Activity.watching("the latest News!"));

		builder.addEventListeners(new Main());
		
		builder.build();

	}
	
	public void onMessageReceived(MessageReceivedEvent event) {
		if(event.getMessage().getContentRaw().equals("!news")) {
			System.out.println("News Request by " + event.getAuthor().getName());
		
			EmbedBuilder info = new EmbedBuilder();
			
			info.setTitle(title);
			info.setAuthor(AuthorName, AuthorURL, AuthorIcon);
			info.addField(subtitle0, text0, false);
			info.addField(subtitle1, text1, false);
			info.addField(subtitle2, text2, false);
			info.setColor(0x4287f5);
			info.setFooter("Your Le Monde");
			event.getJDA().getGuildById(PrivateStrings.ServerID).getTextChannelById(PrivateStrings.ChannelID).sendMessage(info.build()).queue();
			info.clear();
		}
	}
}