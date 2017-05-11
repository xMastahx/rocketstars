package aiss.controller.telegram;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.lol.Summoner;
import aiss.model.resources.TelegramResource;

/**
 * Servlet implementation class IndexSearchController
 */
public class TelegramController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TelegramController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;
		String res = request.getParameter("invo");
		if(res!="null" && res !=null){
			TelegramResource tg = new TelegramResource();
			tg.sendMessage(res);
			request.setAttribute("visibilidadtg", "true");
		}
		//Summoner sumQueNoSuma = (Summoner) request.getAttribute("pene");
		//message = message + sumQueNoSuma.getName();
		
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
