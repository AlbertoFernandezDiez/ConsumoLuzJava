package com.alberto.fernandez.diez.service.listener;

import javax.ws.rs.core.Response;

public interface ConsumptionServiceInterface {

	
	
	Response  getById(int id);

	
	Response  deleteConsumption(int id);

	
	Response getConsumptionByUser(int userId);

	
	Response  insertConsumption(int userId, float price, float quantity,
			java.sql.Date endingDate);


	Response updateConsumption(int consumptionId, float price, float quantity);
	
}
