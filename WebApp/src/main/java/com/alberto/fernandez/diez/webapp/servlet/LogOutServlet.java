package com.alberto.fernandez.diez.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alberto.fernandez.consumo.luz.pojo.Mensaje;
import com.alberto.fernandez.diez.webapp.Constantes;
import com.alberto.fernandez.diez.webapp.servlet.master.MasterServlet;

/**
 * Servlet implementation class LogOutServlet
 */
public class LogOutServlet extends MasterServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session.removeAttribute(Constantes.SESSION_USER_LOGGED);		
		session.invalidate();
		session = null;
		
		msj = new Mensaje("Gracias por su visita", Mensaje.TIPO_INFO);
		request.setAttribute("msj", msj);
		
		dispatch = request.getRequestDispatcher( Constantes.VIEW_LOGIN);
		dispatch.forward(request, response);
	}

}
