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
public class PlayerSummaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerSummaryController() {
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
				SummonerSummary resumen = lol.getSummonerSummary(invocador.getId());
				ChampionMastery[] maestrias = lol.getChampionMastery(invocador.getId());
				//response.getWriter().append("hey "+maestrias[0].getChampionLevel()+"    "+maestrias[0].getChampionPoints());
				List<Champion> list = new ArrayList<Champion>();
				if(maestrias.length>=5){
					for(int i=0;i<5;i++){
						list.add(lol.getChampionData(maestrias[i].getChampionId(),true));
					}
				}
				//Champion campeon = lol.getChampionData(maestrias[0].getChampionId());
				//response.getWriter().append(campeon.toString());
			
				request.setAttribute("summoner",invocador);
				request.setAttribute("stats", resumen.getPlayerStatSummaries());
				request.setAttribute("masteries", maestrias);
				request.setAttribute("champions", list);
				
				
				//ILLO, vaya locura (Runas)
				RunesSummary runas = lol.getRunes(invocador.getId());
				List<Page> paginas = runas.getPages();
				Map<Integer,Integer> runeCount = new HashMap<Integer,Integer>();
				
				for(Page e:runas.getPages()){
					if(e.getCurrent()==true && e.getSlots()!=null){
						for(Slot s:e.getSlots()){
							Integer runeID = s.getRuneId();
							if(runeCount.containsKey(runeID)){
								runeCount.put(runeID, runeCount.get(runeID) + 1);
							}else{
								runeCount.put(runeID, 1);
							}
						}
					}
				}
				Map<RuneSummary, Integer> runes = new HashMap<RuneSummary,Integer>();
				if(!runeCount.isEmpty()){
					for(Integer a:runeCount.keySet()){
						RuneSummary r = lol.getRune(a);
						runes.put(r, runeCount.get(a));
					}
				}
				
				List<String> runeList = new ArrayList<String>();
				for (RuneSummary r : runes.keySet()) {
					String runeType = r.getRune().getType();
					String description = r.getDescription();
					Integer value = runes.get(r);
					String rune = formatRune(runeType) + ": " + description + "*"+ value;
					runeList.add(rune);
				}
				
				request.setAttribute("runes", runeList);
				
				rd = request.getRequestDispatcher("/summary.jsp");	
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

	private String formatRune(String runeType) {
		String res = "unknown";
		switch(runeType){
		case "red": res="Mark";
			break;
		case "yellow": res = "Seal";
			break;
		case "blue": res = "Glyph";
			break;
		case "black": res = "Quint";
		}
	return res;
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
