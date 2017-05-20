package aiss.controller.telegram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.lol.Summoner;
import aiss.model.lol.champion.Champion;
import aiss.model.lol.champion.ChampionMastery;
import aiss.model.lol.rune.RuneSummary;
import aiss.model.lol.runes.Page;
import aiss.model.lol.runes.RunesSummary;
import aiss.model.lol.runes.Slot;
import aiss.model.resources.LoLResource;
import aiss.model.resources.TelegramResource;
import aiss.model.resources.TwitterResource;

/**
 * Servlet implementation class IndexSearchController
 */
public class TelegramHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TelegramHistoryController() {
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
		String display = request.getParameter("telegram");
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

		TelegramResource tg = new TelegramResource();
		tg.sendMessage(res);
		request.setAttribute("visibilidadtg", "true");

		rd = request.getRequestDispatcher("/");
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
