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
import aiss.model.resources.TwitterResource;
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
		
		String display = request.getParameter("tweet");
		String[] displayArray = display.split(", ");
		List<String> displayList = new ArrayList<String>();
		for (String s : displayArray){
			displayList.add(s.trim());
		}
		
		String res = "";
		for (String s : displayList){
			res = res + "\n" + s;
		}
		res = res.replaceAll("\\[", "").replaceAll("\\]","");

		 TwitterResource tw = new TwitterResource();
	     tw.postTweet(res);
		request.setAttribute("visibilidadtw", "true");

		rd = request.getRequestDispatcher("/");
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
