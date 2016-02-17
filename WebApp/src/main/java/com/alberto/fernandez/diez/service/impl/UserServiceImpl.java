package com.alberto.fernandez.diez.service.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alberto.fernandez.consumo.luz.dao.impl.UserDao;
import com.alberto.fernandez.consumo.luz.dao.interfaces.UserDaoInterface;
import com.alberto.fernandez.consumo.luz.pojo.Consumption;
import com.alberto.fernandez.consumo.luz.pojo.User;
import com.alberto.fernandez.diez.service.listener.UserServiceInterface;

@Path("/user")
@Api(value = "/user")
public class UserServiceImpl implements UserServiceInterface {

	private UserDaoInterface daoU = UserDao.getMyUserDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@ApiOperation(value = "getById", notes = "Devuelve un usuario dado su id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 204, message = "No-Content"),
			@ApiResponse(code = 500, message = "Error inexperado en el servidor") })
	@Override
	public Response getById(
			@ApiParam(value = "Identificador", required = true) @PathParam("id") int id) {
	Response resp = null;
		try {
			User u = null;
			
			u = daoU.getById(id);
			
			if (u != null){
				resp = Response.ok(u).build();
			}else{
				resp = Response.noContent().build();
			}

		} catch (Exception e) {
			resp = Response.serverError().build();
		}
		
		return resp;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{name}/check")
	@ApiOperation(value = "checkName", notes = "Comprueba si el nombre de usuario esta siendo utilizado")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 451, message = "Unavailable for Legal Reasons - Nombre en uso"),
			@ApiResponse(code = 500, message = "Error inexperado en el servidor") })
	@Override
	public Response checkName(
			@ApiParam(value = "Nombre", required = true) @PathParam("name") String name) {
		Response resp = null;
		try {
			if (daoU.checkName(name)){
				resp = Response.status(451).build();
			}else{
				resp = Response.ok().build();
			}

		} catch (Exception e) {
			resp = Response.serverError().build();
		}
		
		return resp;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{name}/{password}")
	@ApiOperation(value = "login", notes = "Devuelve el usuario que se corresponde al nombre y contraseña")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 204, message = "No-Content"),
			@ApiResponse(code = 500, message = "Error inexperado en el servidor") })
	@Override
	public Response login(
			@ApiParam(value = "Nombre", required = true) @PathParam("name") String username,
			@ApiParam(value = "Contraseña", required = true) @PathParam("password") String password) {
		Response resp = null;
		try {
			User u = null;
			
			u = daoU.login(username, password);
			
			if (u != null){
				resp = Response.ok(u).build();
			}else{
				resp = Response.noContent().build();
			}

		} catch (Exception e) {
			resp = Response.serverError().build();
		}
		
		return resp;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{name}/{password}")
	@ApiOperation(value = "signIn", notes = "Da de alta a un nuevo usuario")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 202, message = "Accept - Aceptado pero no procesado"),
			@ApiResponse(code = 500, message = "Error inexperado en el servidor") })
	@Override
	public Response signIn(@ApiParam(value = "Nombre", required = true) @PathParam("name") String username,
			@ApiParam(value = "Contraseña", required = true) @PathParam("password") String password) {
		Response resp = null;
		try {
			
			
			;
			
			if (daoU.signIn(username, password)){
				resp = Response.status(201).build();
			}else{
				resp = Response.status(202).build();
			}

		} catch (Exception e) {
			resp = Response.serverError().build();
		}
		
		return resp;
	}

}
