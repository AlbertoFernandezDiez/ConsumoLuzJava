package com.alberto.fernandez.diez.webapp.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alberto.fernandez.consumo.luz.pojo.Consumption;
import com.alberto.fernandez.consumo.luz.pojo.Mensaje;
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
		// op=0&quantity=0&price=0&endingdate=sadf
		String paramQuantity = null;
		String paramPrice = null;
		String paramDate = null;
		
		paramQuantity = request.getParameter("quantity");
		paramPrice = request.getParameter("price");
		paramDate = request.getParameter("endingdate");
		
		
		
		if (paramQuantity == null || paramPrice == null || paramDate == null){
			msj = new Mensaje("No se ha podido almacenar el registro", Mensaje.TIPO_WARNING);
		}else{
			try{
				float quantity = Float.parseFloat(paramQuantity);
				float price = Float.parseFloat(paramPrice);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				java.sql.Date date = new Date(sdf.parse(paramDate).getTime()); // Date.valueOf(paramDate);//(Date) DateFormat.getInstance().parse(paramDate);
				
				int idU = user.getId();
				
				if (daoC.insertConsumption(idU, price, quantity, date) == -1){
					msj = new Mensaje("No se ha podido almacenar el registro", Mensaje.TIPO_WARNING);
				}else{
					msj = new Mensaje("Se ha almacenado el registro", Mensaje.TIPO_SUCCESS);
				}
				
				
			}catch(Exception e){
				msj = new Mensaje("No se ha podido almacenar el registro", Mensaje.TIPO_WARNING);
			}
		}
		
		request.setAttribute(Constantes.SESSION_MESSAGE, msj);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_CONSUMPTION_LIST);

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
		request.setAttribute(Constantes.ATTRIBUTE_OPERATION, Constantes.OP_MODIFICAR);
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
doGet(request, response);
	}

}
