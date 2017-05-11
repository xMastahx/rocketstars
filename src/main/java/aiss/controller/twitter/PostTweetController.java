package aiss.controller.twitter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.lol.Summoner;
import aiss.model.resources.TelegramResource;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Servlet implementation class IndexSearchController
 */
public class PostTweetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTweetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	String consumerKey = "T5t491RXfcv7rpruBMNaW2Pux";
        String consumerSecret = "H0HQjSRLjKMUnwXubeljy7JrxKOEqkkiP6077DEniy2KQj4Cva";
        String accessToken = "2387637578-pwujUuNBaibsmznthO4Tvx1fluLNH8zrAuG29h5";
        String accessSecret = "AWCTd5wC5Qi1Dn2zvmyqzYkw4ZdjbunVSNPF6G4Li3IYy";

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey(consumerKey)
            .setOAuthConsumerSecret(consumerSecret)
            .setOAuthAccessToken(accessToken)
            .setOAuthAccessTokenSecret(accessSecret);
        String tweet = "Hi";
        try 
        {
           TwitterFactory factory = new TwitterFactory(cb.build());
           Twitter twitter = factory.getInstance();

           System.out.println(twitter.getScreenName());
           Status status = twitter.updateStatus(tweet);
           System.out.println("Successfully updated the status to [" + status.getText() + "].");
            }catch (TwitterException te) {
               te.printStackTrace();
               System.exit(-1);
            }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
