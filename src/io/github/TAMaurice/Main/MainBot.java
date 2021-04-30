package io.github.TAMaurice.Main;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.*;

public class MainBot extends ListenerAdapter {

	public static JDABuilder builder;

	public static String subtitle0;
	public static String text0;
	
	public static String subtitle1;
	public static String text1;
	
	public static String subtitle2;
	public static String text2;

	public static TextChannel channel;
	
	public static void startBot() throws LoginException, InterruptedException {
		
		builder = JDABuilder.createDefault(PrivateStrings.token);
		builder.setStatus(OnlineStatus.ONLINE);
		builder.setActivity(Activity.watching("the latest News!"));

		builder.addEventListeners(new MainBot());
		
		JDA jda = builder.build();
		jda.awaitReady();

		channel = jda.getTextChannelById(PrivateStrings.ChannelID);
		
		sendMessage();
	}
	
	public static void sendMessage() {
		
		EmbedBuilder info = new EmbedBuilder();
		
		info.setTitle(Variables.title);
		info.setAuthor(Variables.AuthorName, Variables.AuthorURL, Variables.AuthorIcon);
		info.addField(subtitle0, text0, false);
		info.addField(subtitle1, text1, false);
		info.addField(subtitle2, text2, false);
		info.setColor(0x4287f5);
		info.setFooter(Variables.footer);
		
	    channel.sendMessage(info.build()).queue();
	    info.clear();
	}
}