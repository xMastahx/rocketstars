package aiss.controller.lol;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.lol.Summoner;
import aiss.model.lol.match.Match;
import aiss.model.lol.match.Participant;
import aiss.model.lol.match.ParticipantIdentity;
import aiss.model.lol.match.Stats;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;
		String summoner = request.getParameter("summoner");
		if (summoner != null) {
			LoLResource lol = new LoLResource();
			Summoner invocador = lol.getSummoner(summoner);
			Matchlist matches = lol.getMatchListV3(invocador.getAccountId());
			List<Match> partidas = new ArrayList<Match>();
			for (int i = 0; i < 5; i++) {
				Match match = lol.getMatchV3(matches.getMatches().get(i).getGameId());
				partidas.add(match);
			}

			List<Long> participantids = new ArrayList<Long>();

			for (Match m : partidas) {
				for (ParticipantIdentity p : m.getParticipantIdentities()) {
					Integer summid = p.getPlayer().getSummonerId().intValue();
					if (summid.equals(invocador.getId())) {
						Long participantId = p.getParticipantId();
						participantids.add(participantId);
					}
				}
			}

			List<Stats> stats = new ArrayList<Stats>();
			List<Long> championids = new ArrayList<Long>();

			for (int i = 0; i < participantids.size(); i++) {
				List<Participant> pl = partidas.get(i).getParticipants();
				for (Participant p : pl) {
					if (p.getParticipantId().equals(participantids.get(i))) {
						stats.add(p.getStats());
						championids.add(p.getChampionId());
					}
				}
			}

			List<Long> kills = new ArrayList<Long>();
			Double sumaKills = 0.;
			for (Stats s : stats) {
				kills.add(s.getKills());
				sumaKills = sumaKills + s.getKills().intValue();
			}

			request.setAttribute("kills", kills);

			List<Long> deaths = new ArrayList<Long>();
			Double sumaDeaths = 0.;
			for (Stats s : stats) {
				deaths.add(s.getDeaths());
				sumaDeaths = sumaDeaths + s.getDeaths().intValue();
			}

			request.setAttribute("deaths", deaths);

			List<Long> assists = new ArrayList<Long>();
			Double sumaAssists = 0.;
			for (Stats s : stats) {
				assists.add(s.getAssists());
				sumaAssists = sumaAssists + s.getAssists().intValue();
			}

			request.setAttribute("assists", assists);

			List<String> kda = new ArrayList<String>();

			for (int i = 0; i < stats.size(); i++) {
				String res;
				if (deaths.get(i).intValue() == 0) {
					res = "Perfect";
				} else {
					Double r = (kills.get(i).doubleValue() + assists.get(i).doubleValue())
							/ deaths.get(i).doubleValue();
					DecimalFormat df = new DecimalFormat("#.#");
					res = df.format(r);
				}
				kda.add(res);
			}

			request.setAttribute("kda", kda);

			DecimalFormat df = new DecimalFormat("#.#");
			String globalkda = df.format(sumaKills / 5) + "/" + df.format(sumaDeaths / 5) + "/"
					+ df.format(sumaAssists / 5);

			request.setAttribute("globalkda", globalkda);

			List<String> win = new ArrayList<String>();

			for (Stats s : stats) {
				if (s.getWin()) {
					win.add("Victoria");
				} else {
					win.add("Derrota");
				}
			}

			request.setAttribute("win", win);

			List<String> champions = new ArrayList<String>();

			for (Long l : championids) {
				String championName = lol.getChampionData(l, true).getName();
				champions.add(championName);
			}

			request.setAttribute("champions", champions);

			// HISTORIAL DONE //

			// TWITTER //

			List<String> tweet = new ArrayList<String>();

			Integer largestMultiKill = 0;
			for (Stats s : stats) {

				if (s.getLargestMultiKill() > largestMultiKill) {
					largestMultiKill = s.getLargestMultiKill().intValue();
				}

			}

			String multiKill;

			switch (largestMultiKill) {
			case 1:
				multiKill = "No has conseguido ningún asesinato múltiple :(";
				break;
			case 2:
				multiKill = "Double Kill. Podrías hacerlo mejor";
				break;
			case 3:
				multiKill = "Triple Kill. No está nada mal";
				break;
			case 4:
				multiKill = "Quadra Kill. Casi lo consigues";
				break;
			case 5:
				multiKill = "PENTAKILL";
				break;
			default:
				multiKill = "Error";
				break;
			}

			tweet.add("Summoner: " + invocador.getName());
			tweet.add("Tu KDA en las últimas 5 partidas es de " + globalkda);
			tweet.add(multiKill);

			request.setAttribute("tweet", tweet);

			// TELEGRAM //

			List<String> telegram = new ArrayList<String>();

			telegram.add("Summoner: " + invocador.getName());

			for (int i = 0; i < 5; i++) {
				telegram.add("Partida " + (i + 1) + ": \n");
				telegram.add("Campeón: " + champions.get(i) + ". Resultado" + kills.get(i) + "\\" + deaths.get(i) + "\\"
						+ assists.get(i));
				telegram.add("KDA " + kda.get(i));
			}

			request.setAttribute("telegram", telegram);

			request.setAttribute("stats", stats);
			request.setAttribute("summoner", invocador);
			rd = request.getRequestDispatcher("/history.jsp");
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
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
