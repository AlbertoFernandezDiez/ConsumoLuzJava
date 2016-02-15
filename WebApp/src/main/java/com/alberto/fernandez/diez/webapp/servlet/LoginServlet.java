package com.alberto.fernandez.diez.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alberto.fernandez.consumo.luz.dao.impl.UserDao;
import com.alberto.fernandez.consumo.luz.pojo.User;
import com.alberto.fernandez.diez.webapp.Constantes;
import com.alberto.fernandez.diez.webapp.listener.InitListener;
import com.alberto.fernandez.diez.webapp.servlet.master.MasterServlet;
import com.mysql.jdbc.log.Log;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends MasterServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = null;
		String password = null;
		
		if (session.getAttribute(Constantes.SESSION_USER_LOGGED) == null) {
		
			userName = request.getParameter("username");
			password = request.getParameter("password");
			
			session = request.getSession();
			
			if (userName != null && password != null ){
				User user = daoU.login(userName, password);
				
				if (user != null){
					session.setAttribute(Constantes.SESSION_USER_LOGGED, user);
			 		LOG.info("Usuario loggeado:\t" + user.toString());
					dispatch = request
							.getRequestDispatcher(Constantes.VIEW_INDEX);
					
				}else{
					LOG.info("Intento de loggin con los datos:\t" + userName + "\t" + password);
					dispatch = request
							.getRequestDispatcher(Constantes.VIEW_LOGIN);
				}
				
			}else{
				LOG.info("Paremetros de inicio no recibidos");
				request
				.getRequestDispatcher(Constantes.VIEW_INDEX);
			}
		}else{
			LOG.info("Usuario ya logeado" + session.getAttribute(Constantes.SESSION_USER_LOGGED));
		}
		dispatch.forward(request, response);
	}

}
