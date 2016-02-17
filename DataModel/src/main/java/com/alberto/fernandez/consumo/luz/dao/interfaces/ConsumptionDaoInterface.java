package com.alberto.fernandez.consumo.luz.dao.interfaces;

import java.util.List;

import com.alberto.fernandez.consumo.luz.pojo.Consumption;

public interface ConsumptionDaoInterface {

	/**
	 * Gets a consumption by its <code>id</code>
	 * 
	 * @param id
	 *            {@code int} The id of a <code>Consumption</code> in the
	 *            database
	 * @return {@code User} If the <code>id</code> exists returns the
	 *         <code>Consumption</code>, else <code>null</code>
	 */
	Consumption getById(int id);

	/**
	 * Deletes a user by the given id
	 * 
	 * @param id
	 *            {@code int} the id of the user to delete
	 * @return {@cod boolean}
	 *         <ul>
	 *         <li><strong>true</strong> if the Consumption is deleted</li>
	 *         <li><strong>false</strong> if the Consumption is not deleted</li>
	 *         </ul>
	 */
	boolean deleteConsumption(int id);

	/**
	 * Lists all the consumptions of a user
	 * 
	 * @param userId
	 *            {@code int} the id of the user
	 * @return {@code List<Consumption>} a list with the consumption of the
	 *         user, if there are not consumption or that user en empty
	 *         {@code List<Consumption>}
	 */
	List<Consumption> getConsumptionByUser(int userId);

	/**
	 * Creates a new Consumpmition
	 * 
	 * @param userId
	 *            {@code int} the id of the user
	 * @param price
	 *            {@code float} the price of the consumption for each quantity
	 *            unit
	 * @param quantity
	 *            {@code float} the quantity consumed
	 * @param endingDate
	 *            {@code java.sql.Date} the ending date of the consumption
	 * @return {@cod int} the id of the new consumption, else -1
	 * 
	 */
	int insertConsumption(int userId, float price, float quantity,
			java.sql.Date endingDate);

	/**
	 * Updates the price of the quantity of a consumption
	 * 
	 * @param consumptionId
	 *            {@code int} the id of a consumption in the DataBase
	 * @param price
	 *            {@code float} the new price of the consumption for each
	 *            quantity unit
	 * @param quantity
	 *            {@code float} the new quantity consumed
	 * @return {@code boolea}<ul><li><strong>true</strong> If the Consumption is updated</li><li><strong>false</strong> If the Consumption is not updated</li></ul>
	 */
	boolean updateConsumption(int consumptionId, float price, float quantity);

}
