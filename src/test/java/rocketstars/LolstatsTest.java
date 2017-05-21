package rocketstars;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.junit.Test;

import com.google.appengine.api.channel.ChannelServicePb.SendMessageRequest;

import aiss.model.lol.Summoner;
import aiss.model.resources.LoLResource;
import aiss.model.resources.TelegramResource;
import aiss.model.resources.TwitterResource;
import aiss.model.telegram.sendMessage.SendMessageResult;
import junit.framework.Assert;

public class LolstatsTest {

	@Test
	public void testgetSummoner() throws UnsupportedEncodingException{
		LoLResource r = new LoLResource();
		Summoner summoner = r.getSummoner("Rayoken");
		assertNotNull(summoner);;
	}
	
	@Test
	public void testTelegram() throws UnsupportedEncodingException{
		TelegramResource r = new TelegramResource();
		String message = "Telegram test";
		SendMessageResult result = r.sendMessage(message);
		assertEquals(result.getResult().getText(), message);
	}
	
	@Test
	public void testTwitter(){
		TwitterResource r = new TwitterResource();
		Random random = new Random();
		Integer i = random.nextInt(100000000);
		String message = "Test: " + i;
		r.postTweet(message);
	}
}
