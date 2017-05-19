package aiss.controller.lol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.lol.Summoner;
import aiss.model.lol.match.Match;
import aiss.model.lol.matchlist.Matchlist;
import aiss.model.resources.LoLResource;

/**
 * Servlet implementation class HistoryController
 */
public class HistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryController() {
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
			Matchlist matches = lol.getMatchListV3(invocador.getAccountId());
			List<Match> partidas = new ArrayList<Match>();
			for(int i=0;i<5;i++){
				Match match = lol.getMatchV3(matches.getMatches().get(i).getGameId());
				partidas.add(match);
			}
			request.setAttribute("matches", partidas);
			rd = request.getRequestDispatcher("/history.jsp");
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
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
