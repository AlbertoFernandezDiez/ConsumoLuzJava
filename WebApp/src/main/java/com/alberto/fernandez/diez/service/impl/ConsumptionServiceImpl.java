package com.alberto.fernandez.diez.service.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alberto.fernandez.consumo.luz.dao.impl.ConsumptionDao;
import com.alberto.fernandez.consumo.luz.dao.interfaces.ConsumptionDaoInterface;
import com.alberto.fernandez.consumo.luz.pojo.Consumption;
import com.alberto.fernandez.diez.service.interfaces.ConsumptionServiceInterface;

@Path("/consumption")
@Api(value = "/consumption")
public class ConsumptionServiceImpl implements ConsumptionServiceInterface {

	private ConsumptionDaoInterface daoC = ConsumptionDao.getMyUserDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@ApiOperation(value = "getById", notes = "Devuelve un consumo dado su id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 204, message = "No-Content"),
			@ApiResponse(code = 500, message = "Error inexperado en el servidor") })
	@Override
	public Response getById(
			@ApiParam(value = "Identificador", required = true) @PathParam("id") int id) {
		Response resp;
		try {
			Consumption c = null;
			c = daoC.getById(id);

			if (c == null) {
				resp = Response.noContent().build();
			} else {
				resp = Response.ok(c).build();
			}

		} catch (Exception e) {
			resp = Response.serverError().build();
		}
		return resp;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@ApiOperation(value = "deleteConsumption", notes = "Elimina un consumo por su id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 204, message = "No-Content"),
			@ApiResponse(code = 500, message = "Error inexperado en el servidor") })
	@Override
	public Response deleteConsumption(
			@ApiParam(value = "Identificador", required = true) @PathParam("id") int id) {
		Response resp;
		try {
			Consumption c = null;
			c = daoC.getById(id);

			if (c == null) {
				resp = Response.noContent().build();
			} else {
				if (daoC.deleteConsumption(c.getConsumptionId())) {
					resp = Response.ok(c).build();
				} else {
					resp = Response.status(202).build();
				}
			}

		} catch (Exception e) {
			resp = Response.serverError().build();
		}
		return resp;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{userId}/all")
	@ApiOperation(value = "getConsumptionByUser", notes = "Devuelve los consumos de un usuario por su id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 204, message = "No-Content"),
			@ApiResponse(code = 500, message = "Error inexperado en el servidor") })
	@Override
	public Response getConsumptionByUser(
			@ApiParam(value = "Identificador", required = true) @PathParam("userId") int userId) {
		Response resp;
		try {
			List<Consumption> list = null;
			list = daoC.getConsumptionByUser(userId);

			if (list.size() == 0) {
				resp = Response.noContent().build();
			} else {
				resp = Response.ok(list).build();
			}

		} catch (Exception e) {
			resp = Response.serverError().build();
		}
		return resp;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{userid}/{price}/{quantity}/{date}")
	@ApiOperation(value = "insertConsumption", notes = "Inserta un nuevo consumo")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 202, message = "Accept - Aceptado pero no procesado"),
			@ApiResponse(code = 500, message = "Error inexperado en el servidor") })
	@Override
	public Response insertConsumption(
			@ApiParam(value = "Identificador", required = true) @PathParam("userid") int userId,
			@ApiParam(value = "Precio", required = true) @PathParam("price") float price,
			@ApiParam(value = "Cantidad", required = true) @PathParam("quantity") float quantity,
			@ApiParam(value = "Fecha fin de facturacion, formato yyyy-MM-dd", required = true) @PathParam("date") Date endingDate) {
		Response resp;
		try {
			Consumption c = null;
			int id = daoC
					.insertConsumption(userId, price, quantity, endingDate);

			if (id == -1) {
				resp = Response.noContent().build();
			} else {
				c = daoC.getById(id);
				if (c != null) {
					resp = Response.ok(c).build();
				} else {
					resp = Response.status(202).build();
				}
			}

		} catch (Exception e) {
			resp = Response.serverError().build();
		}
		return resp;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/{price}/{quantity}")
	@ApiOperation(value = "updateConsumption", notes = "Actualiza un consumo")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 202, message = "Accept - Aceptado pero no procesado"),
			@ApiResponse(code = 204, message = "No-Content"),
			@ApiResponse(code = 500, message = "Error inexperado en el servidor") })
	@Override
	public Response updateConsumption(
			@ApiParam(value = "Identificador", required = true) @PathParam("id") int consumptionId,
			@ApiParam(value = "Precio", required = true) @PathParam("price") float price,
			@ApiParam(value = "Cantidadd", required = true) @PathParam("quantity") float quantity) {
		Response resp;
		try {
			Consumption c = null;

			c = daoC.getById(consumptionId);

			if (c == null) {
				resp = Response.noContent().build();
			} else {

				if (daoC.updateConsumption(consumptionId, price, quantity)) {
					c = null;
					c = daoC.getById(consumptionId);
					if (c != null) {
						resp = Response.ok(c).build();
					} else {
						resp = Response.status(202).build();

					}
				} else {
					resp = Response.status(202).build();
				}

			}

		} catch (Exception e) {
			resp = Response.serverError().build();
		}
		return resp;
	}

}
