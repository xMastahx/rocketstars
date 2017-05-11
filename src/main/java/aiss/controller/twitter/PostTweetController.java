package aiss.controller.twitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.lol.Summoner;
import aiss.model.lol.SummonerSummary;
import aiss.model.lol.champion.Champion;
import aiss.model.lol.champion.ChampionMastery;
import aiss.model.resources.LoLResource;
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

		RequestDispatcher rd = null;
			
		String summoner = request.getParameter("invotw");
			if(summoner!=null){
			LoLResource lol = new LoLResource();
			Summoner invocador = lol.getSummoner(summoner);

				ChampionMastery[] maestrias = lol.getChampionMastery(invocador.getId());
				//response.getWriter().append("hey "+maestrias[0].getChampionLevel()+"    "+maestrias[0].getChampionPoints());
				List<Champion> list = new ArrayList<Champion>();
				for(int i=0;i<5;i++){
					list.add(lol.getChampionData(maestrias[i].getChampionId()));
				}
				
				
				 String tweet = "Summoner: " + invocador.getName();
				 
				 Random randomGenerator = new Random();
			     int urfLevel = randomGenerator.nextInt(1000);
			     if (urfLevel == 666){
			    	 tweet = tweet + "\n URF. Level: There's not";
			     }
			     else{
			    	 for(int i=0;i<5;i++){
			    		 tweet = tweet + "\n" + list.get(i).getName() + ". Level: " + maestrias[i].getChampionLevel();
			    	 }
			     }
			
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("Uu4jzuV8D8DITGWQK2QOVmJ8B")
		  .setOAuthConsumerSecret("RLCbtAStfa9ZrH0Jb8aoy6FBxMBCJgGjJtccViqZf40iEheFrB")
		  .setOAuthAccessToken("2387637578-4fNSRuq954xHdH2g33eqUPOZxmXvx61VfxHKCVN")
		  .setOAuthAccessTokenSecret("gRJISVzofhuHwD5KZOHwuT4Ds5I7GuVR0DoaPBLTLXvyV");
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
		request.setAttribute("visibilidadtw", "true");

		rd = request.getRequestDispatcher("/");
		rd.forward(request, response);
			}else{
				rd = request.getRequestDispatcher("/error.jsp");

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
