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
public class WIP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WIP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub+
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/WIP.html");
		
		
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
