package aiss.controller.twitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.capabilities.CapabilitiesPb.CapabilityConfig.Status;

import aiss.model.lol.PlayerStatSummary;
import aiss.model.lol.Summoner;
import aiss.model.lol.SummonerSummary;
import aiss.model.lol.champion.Champion;
import aiss.model.lol.champion.ChampionMastery;
import aiss.model.lol.league.League;
import aiss.model.resources.LoLResource;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.conf.ConfigurationContext;

/**
 * Servlet implementation class IndexSearchController
 */
public class TweetSummaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TweetSummaryController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		RequestDispatcher rd = null;
		String summoner = request.getParameter("summoner");
		if(summoner!=null){
			LoLResource lol = new LoLResource();
			Summoner invocador = lol.getSummoner(summoner);
			if(invocador!=null){
				SummonerSummary resumen = lol.getSummonerSummary(invocador.getId());
				ChampionMastery[] maestrias = lol.getChampionMastery(invocador.getId());
				//response.getWriter().append("hey "+maestrias[0].getChampionLevel()+"    "+maestrias[0].getChampionPoints());
				List<Champion> list = new ArrayList<Champion>();
				for(int i=0;i<5;i++){
					list.add(lol.getChampionData(maestrias[i].getChampionId()));
				}
				//Champion campeon = lol.getChampionData(maestrias[0].getChampionId());
				//response.getWriter().append(campeon.toString());
				League liga = lol.getLeagueData(invocador.getId());
				
				String tweet = "Summoner: " + invocador;
				for(int i=0;i<5;i++){
					tweet = tweet + "/n" + list.get(i).getName() +": Maestría " + maestrias[i].getChampionLevel();
				}

				String consumerKey = "yourconsumerKey ";
			       String consumerSecret = "yourconsumerSecret";
			       String accessToken = "yourAccessToken";
			       String accessSecret = "yourAccessSecret";

			       ConfigurationBuilder cb = new ConfigurationBuilder();
			       cb.setDebugEnabled(true)
			           .setOAuthConsumerKey(consumerKey)
			           .setOAuthConsumerSecret(consumerSecret)
			           .setOAuthAccessToken(accessToken)
			           .setOAuthAccessTokenSecret(accessSecret);

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
				else{
					rd = request.getRequestDispatcher("/error.jsp");
				}
			}
		

		
//		response.getWriter().append("Served at: "+summoner + " "+invocador.getAccountId()+"\n");
//		
//		for(PlayerStatSummary e:resumen.getPlayerStatSummaries()){
//			response.getWriter().append(e.getWins() + " partidas ganadas en "+ e.getPlayerStatSummaryType()+"\n");
//		}
		
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
