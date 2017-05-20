package aiss.controller.lol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub+
		RequestDispatcher rd = null;
		String summoner = request.getParameter("summoner");
		if (summoner != null) {
			LoLResource lol = new LoLResource();
			Summoner invocador = lol.getSummoner(summoner);
			if (invocador != null) {
				ChampionMastery[] maestrias = lol.getChampionMastery(invocador.getId());
				List<Champion> list = new ArrayList<Champion>();
				if (maestrias.length >= 1) {
					Integer counter = 0;
					Map<Integer, Integer> levels = new HashMap<Integer, Integer>();
					levels.put(1, 0);
					levels.put(2, 0);
					levels.put(3, 0);
					levels.put(4, 0);
					levels.put(5, 0);
					levels.put(6, 0);
					levels.put(7, 0);
					Long championLevelCounter = 0L;
					for (int i = 0; i < maestrias.length; i++) {
						Champion champ = lol.getChampionData(maestrias[i].getChampionId(), true);
						list.add(champ);
						championLevelCounter = championLevelCounter + maestrias[i].getChampionPoints();
						Integer level = maestrias[i].getChampionLevel().intValue();
						Integer updatedLevel = levels.get(level);
						updatedLevel++;
						levels.put(level, updatedLevel);
						counter++;
						if (counter >= 9) {
							try {
								Thread.sleep(12000);
								counter = 0;
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					Set<Integer> levelSet = levels.keySet();
					List<Integer> levelList = new ArrayList<Integer>(levelSet);
					Collection<Integer> levelAmmountCollection = levels.values();
					List<Integer> levelAmmount = new ArrayList<Integer>(levelAmmountCollection);

					// Lista a mostrar en champMasteries.jsp

					List<String> masteryInfo = new ArrayList<String>();

					// Añade información de cuantos campeones tiene el jugador
					// con cada nivel de maestría.

					for (int i = 0; i < levelList.size(); i++) {
						String s = "Número de campeones de nivel " + levelList.get(i) + ": " + levelAmmount.get(i);
						masteryInfo.add(s);
					}

					String suma = "Número total de puntos de maestría: " + championLevelCounter;
					masteryInfo.add(suma);

					request.setAttribute("masteryinfo", masteryInfo);

					/*
					 * Esta lista será la información mandada por tweet, no se
					 * mostrará en la web pero será mandada al controlador
					 * PostTweetMasteriesController, para mostrar la información
					 * sin tener que repetir peticiones a la API.
					 */

					List<String> tweetMasteryInfo = new ArrayList<String>();
					
					for (int i = 0; i<levelList.size(); i++){
						String s = "Nivel " + levelList.get(i) +": "+ levelAmmount.get(i);
						tweetMasteryInfo.add(s);
					}
					
					tweetMasteryInfo.add("Total: " + championLevelCounter + " puntos");
					
					request.setAttribute("tweetmasteryinfo", tweetMasteryInfo);

					
				}
				// Champion campeon =
				// lol.getChampionData(maestrias[0].getChampionId());
				// response.getWriter().append(campeon.toString());

				request.setAttribute("summoner", invocador);
				request.setAttribute("masteries", maestrias);
				request.setAttribute("champions", list);

				rd = request.getRequestDispatcher("/champMasteries.jsp");
			}
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}

		// response.getWriter().append("Served at: "+summoner + "
		// "+invocador.getAccountId()+"\n");
		//
		// for(PlayerStatSummary e:resumen.getPlayerStatSummaries()){
		// response.getWriter().append(e.getWins() + " partidas ganadas en "+
		// e.getPlayerStatSummaryType()+"\n");
		// }

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
