package com.alberto.fernandez.diez.webapp;

public class Constantes {
	/**
	 * Constructor por defecto
	 */
	private Constantes() {
		super();
	}

	// Generales
	public static final String APP_NAME = "Consumo Luz";
	// public static final String SERVER = "http://localhost:8080/";
	public static final String ROOT = /* SERVER + */"/" + APP_NAME + "/";

	// Variables session
	public static final String SESSION_USER_LOGGED = "userlogged";
	public static final String SESSION_USER_LANGUAGE = "userLanguage";
	public static final String SESSION_CONSUMPTION = "consumption";
	public static final String SESSION_MESSAGE = "msj";

	// OPERACIONES CONTROLADORES
	public static final int OP_NUEVO = 0;
	public static final int OP_DETALLE = 1;
	public static final int OP_LISTAR = 2;
	public static final int OP_MODIFICAR = 3;
	public static final int OP_ELIMINAR = 4;

	// CONTROLADORES
	public static final String CONTROLLER_LOGIN = "login";
	public static final String CONTROLLER_LOGOUT = "back/logout";

	public static final String CONTROLLER_USUARIOS_LOGEADOS = "back/loggeduser";

	public static final String CONTROLLER_USUARIOS = "back/usuarios";
	public static final String CONTROLLER_ROLES = "back/roles";
	public static final String CONTROLLER_SEARCH = "back/search";
	public static final String CONTROLLER_SIGN_IN = "back/signin";
	public static final String CONTROLLER_CONSUMPTION = "back/consumption";

	// VISTAS
	public static final String VIEW_LOGIN = "/login.jsp";
	public static final String VIEW_INDEX = "/pages/index.jsp";
	public static final String VIEW_SIGN_IN = "/signin.jsp";

	public static final String VIEW_CONSUMPTION_LIST = "pages/consumption.jsp";
	public static final String VIEW_CONSUMPTION_FORM = "pages/consumptionDetail.jsp";

	public static final String ATTRIBUTE_LIST = "consumptionlist";
}
