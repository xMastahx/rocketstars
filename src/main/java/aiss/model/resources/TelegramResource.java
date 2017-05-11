package aiss.model.resources;

import java.io.UnsupportedEncodingException;

import org.restlet.resource.ClientResource;

import aiss.model.telegram.sendMessage.SendMessageResult;

public class TelegramResource {
	public static final String BOT_TOKEN = "271448575:AAHk4byV5mHYJUWQw_75Rrn1B_41nbQ8WXc";
	public static final String DEFAULT_CHAT_ID = "-1001100774770";
	
	public SendMessageResult sendMessage(String message)throws UnsupportedEncodingException {
		ClientResource cr = new ClientResource("https://api.telegram.org/bot"+BOT_TOKEN+"/sendMessage?chat_id="+DEFAULT_CHAT_ID+"&text="+message);
		SendMessageResult res = cr.get(SendMessageResult.class);
		return res;
		
	}
}
