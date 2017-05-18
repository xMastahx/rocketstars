package aiss.controller.lol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.lol.PlayerStatSummary;
import aiss.model.lol.Summoner;
import aiss.model.lol.SummonerSummary;
import aiss.model.lol.champion.Champion;
import aiss.model.lol.champion.ChampionMastery;
import aiss.model.lol.league.League;
import aiss.model.lol.rune.Rune;
import aiss.model.lol.rune.RuneSummary;
import aiss.model.lol.runes.Page;
import aiss.model.lol.runes.RunesSummary;
import aiss.model.lol.runes.Slot;
import aiss.model.resources.LoLResource;
import aiss.model.resources.TelegramResource;
import aiss.model.telegram.sendMessage.SendMessageResult;

/**
 * Servlet implementation class IndexSearchController
 */
public class ChampMasteriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChampMasteriesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub+
		RequestDispatcher rd = null;
		String summoner = request.getParameter("summoner");
		if(summoner!=null){
			LoLResource lol = new LoLResource();
			Summoner invocador = lol.getSummoner(summoner);
			if(invocador!=null){
				ChampionMastery[] maestrias = lol.getChampionMastery(invocador.getId());
				List<Champion> list = new ArrayList<Champion>();
				if(maestrias.length>=1){
					for(int i=0;i<maestrias.length;i++){
						//list.add(lol.getChampionData(maestrias[i].getChampionId()));
					}
				}
				//Champion campeon = lol.getChampionData(maestrias[0].getChampionId());
				//response.getWriter().append(campeon.toString());
			
				request.setAttribute("summoner",invocador);
				request.setAttribute("masteries", maestrias);
				request.setAttribute("champions", list);
				
				
				
				
				rd = request.getRequestDispatcher("/champMasteries.jsp");	
			}
		}else{
			rd = request.getRequestDispatcher("/error.jsp");
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
