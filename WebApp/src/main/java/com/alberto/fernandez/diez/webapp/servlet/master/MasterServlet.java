package com.alberto.fernandez.diez.webapp.servlet.master;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.alberto.fernandez.consumo.luz.dao.impl.ConsumptionDao;
import com.alberto.fernandez.consumo.luz.dao.impl.UserDao;
import com.alberto.fernandez.consumo.luz.dao.interfaces.ConsumptionDaoInterface;
import com.alberto.fernandez.consumo.luz.dao.interfaces.UserDaoInterface;
import com.alberto.fernandez.consumo.luz.pojo.Mensaje;
import com.alberto.fernandez.diez.webapp.Constantes;

/**
 * Servlet implementation class MasterServlet
 */
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// DAOs
	protected static UserDaoInterface daoU;
	protected static ConsumptionDaoInterface daoC;
	protected static RequestDispatcher dispatch; // El que se encarga de
													// enrutar. Solo puede ir a
													// un sitio, no se puede
													// cargar dos veces
	protected static HttpSession session;
	protected ResourceBundle messages; // fichero de properties
	protected static Mensaje msj; // Mensaje a mostrar la usuario
	protected String idioma; // idioma session del usuario
	protected String language;
	protected String country;
	
	protected static final Logger LOG = Logger.getLogger(MasterServlet.class);

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoU = UserDao.getMyUserDao();
		daoC = ConsumptionDao.getMyUserDao();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		daoU = null;
		daoC = null;
		dispatch = null;
		session = null;
		msj = null;
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		msj = null;
		session = request.getSession();
	/*	idioma = (String) session
				.getAttribute(Constantes.SESSION_USER_LANGUAGE); */
		//language = idioma.split("_")[0];
		// country = idioma.split("_")[1];
		messages = null;
	/*	messages = ResourceBundle.getBundle("i18nmesages", new Locale(language,
				country));*/
		super.service(request, response);
	}

}
