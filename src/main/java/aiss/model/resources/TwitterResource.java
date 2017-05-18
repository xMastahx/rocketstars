package aiss.model.resources;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterResource {
	public void postTweet(String tweet){
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("GSVbFWBC1eiIYWs3xE3QXqud0")
		  .setOAuthConsumerSecret("9aGQRb3pTmHu2oXF2oMw93JrcUsEjRFTHixm575lVtg3GvYWOF")
		  .setOAuthAccessToken("865182711270576128-GaoE9qixpNBxiy8aFaLCRNtig3Tb8KY")
		  .setOAuthAccessTokenSecret("4E08lNMDAaUOljPKgnPcYUUzG8dlERkJnTmUYKYkbIwI7");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		 Status status;
		 
		try {
			status = twitter.updateStatus(tweet);
		    System.out.println("Successfully updated the status to [" + status.getText() + "].");
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
