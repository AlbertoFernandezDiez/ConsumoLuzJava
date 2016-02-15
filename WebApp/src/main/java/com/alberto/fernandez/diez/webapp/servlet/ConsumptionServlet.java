package com.alberto.fernandez.diez.webapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alberto.fernandez.consumo.luz.pojo.Consumption;
import com.alberto.fernandez.consumo.luz.pojo.User;
import com.alberto.fernandez.diez.webapp.Constantes;
import com.alberto.fernandez.diez.webapp.servlet.master.MasterServlet;

/**
 * Servlet implementation class ConsumptionServlet
 */
public class ConsumptionServlet extends MasterServlet {
	private static final long serialVersionUID = 1L;

	private static int operacion;
	private User user;

	/**
	 * Default constructor.
	 */
	public ConsumptionServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			user = null;
			user = (User) session.getAttribute(Constantes.SESSION_USER_LOGGED);
			
			if (user != null){
			
			// recoger parámetros a realizar
			if (request.getParameter("op") != null)
				operacion = Integer.parseInt(request.getParameter("op"));
			else
				operacion = Constantes.OP_LISTAR;

			// Realizar accion
			switch (operacion) {
			case Constantes.OP_LISTAR:
				listar(request);
				break;
			case Constantes.OP_DETALLE:
				detalle(request);
				break;
			case Constantes.OP_NUEVO:
				nuevo(request);
				break;
			case Constantes.OP_ELIMINAR:
				eliminar(request);
				break;
			case Constantes.OP_MODIFICAR:
				modificarCrear(request);
				break;
			default:
				listar(request);
				break;
			}
			}else{
				
				dispatch = request.getRequestDispatcher(Constantes.VIEW_LOGIN);
			}
			// request.setAttribute("msj", msj);
			/*
			 * forward para servir la jsp (lanzarlo). en forward hay que poner
			 * dos argumentos. doGet tiene dos request y response, al ser una
			 * petición interna, hay que poner los mismos
			 */
			dispatch.forward(request, response);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	private void modificarCrear(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	private void eliminar(HttpServletRequest request) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			if (daoC.deleteConsumption(id)) {
				LOG.info("Consumo eliminado con id:\t" + id);
				//msj = new Mensaje("Registro eliminado con éxito", Mensaje.TIPO_SUCCESS);
			} else {
				LOG.warn("Consumo no eliminado con id:\t" + id);
				//msj = new Mensaje("No se ha eliminado el registro", Mensaje.TIPO_DANGER);
			}
		} catch (Exception e) {
			//msj = new Mensaje("No se ha eliminado el registro", Mensaje.TIPO_DANGER);
			
			LOG.warn("Consumo no eliminado");
		}
		listar(request);
	}

	private void nuevo(HttpServletRequest request) {
		Consumption c = new Consumption();
		request.setAttribute(Constantes.SESSION_CONSUMPTION, c);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_CONSUMPTION_FORM);

	}

	private void detalle(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	private void listar(HttpServletRequest request) {
		List<Consumption> list = daoC.getConsumptionByUser(user.getId());
		
		request.setAttribute(Constantes.ATTRIBUTE_LIST, list);
		
		dispatch = request.getRequestDispatcher(Constantes.VIEW_CONSUMPTION_LIST);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
