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
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends MasterServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = null;
		String password = null;
		
		
			userName = request.getParameter("username");
			password = request.getParameter("password");
			
			dispatch = request
					.getRequestDispatcher(Constantes.VIEW_LOGIN);
			
			
			
			if(daoU.signIn(userName, password)){
				msj = new Mensaje("Usuario creado correctamente", Mensaje.TIPO_SUCCESS);
				LOG.info("Se ha creado el nuevo usuario:\t" + userName);
			}else{
				msj = new Mensaje("Usuario no creado", Mensaje.TIPO_DANGER);
				LOG.warn("No se ha creado el usuario:\t" + userName);
			}
			
			request.setAttribute(Constantes.SESSION_MESSAGE, msj);
			
			dispatch.forward(request, response);
				
	}

}
