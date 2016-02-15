package com.alberto.fernandez.consumo.luz.dao.impl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alberto.fernandez.consumo.luz.dao.interfaces.ConsumptionDaoInterface;
import com.alberto.fernandez.consumo.luz.dao.interfaces.UserDaoInterface;
import com.alberto.fernandez.consumo.luz.pojo.Consumption;
import com.alberto.fernandez.consumo.luz.pojo.User;

public class ConsumptionDaoTest {

	private static int consumptionId;
	private static Consumption consumption;
	private static UserDaoInterface daoU;
	private static ConsumptionDaoInterface daoC;
	private static String time;
	private static User user;
	private static Float auxFloat;
	private static Date date;
	
	private static final double DELTA = 0.1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		daoC = ConsumptionDao.getMyUserDao();
		daoU = UserDao.getMyUserDao();
		time = Long.toString(System.currentTimeMillis());
		auxFloat = Float.parseFloat(time);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		consumption = null;
		time = null;
		user = null;
		daoC = null;
		daoU = null;
		time = null;
	}

	@Before
	public void setUp() throws Exception {
		user = new User();
		assertTrue(daoU.signIn(time, time));
		user = daoU.login(time, time);
		date = new Date(System.currentTimeMillis());
		consumptionId = daoC.insertConsumption(user.getId(), auxFloat,
				auxFloat, date);
		assertNotEquals(-1, consumptionId);
		consumption = daoC.getById(consumptionId);

	}

	@After
	public void tearDown() throws Exception {
		assertTrue(daoC.deleteConsumption(consumption.getConsumptionId()));
		assertTrue(daoU.deleteUser(user.getId()));
		user = null;
		consumption = null;
	}

	@Test
	public void testGetById() {
		Consumption auxConsumption = daoC.getById(-1);
		assertEquals(null, auxConsumption);
		auxConsumption = daoC.getById(consumptionId);
		assertEquals(consumption, auxConsumption);
	}

	@Test
	public void testDeleteConsumption() {
		Consumption auxConsumption = null;
		Date date2 = new Date(System.currentTimeMillis());
		date2.setYear(date2.getYear() - 3);
		int id = daoC
				.insertConsumption(user.getId(), auxFloat, auxFloat, date2);
		assertNotEquals(-1, id);
		auxConsumption = daoC.getById(id);
		
		assertNotNull(auxConsumption);
		
		assertTrue(daoC.deleteConsumption(auxConsumption.getConsumptionId()));
		
		auxConsumption = null;
		
		auxConsumption = daoC.getById(id);
		
		assertEquals(null, auxConsumption);
		
		 auxConsumption = null;
	}

	@Test
	public void testGetConsumptionByUser() {
	List<Consumption> aux = daoC.getConsumptionByUser(user.getId());
	
	assertEquals(1, aux.size());
	assertEquals(consumption, aux.get(0));
	
	aux = null;
	
	}

	@Test
	public void testInsertConsumption() {
		Consumption auxConsumption = null;
		Consumption auxConsumption2 = null;
		Date date2 = new Date(System.currentTimeMillis());
		date2.setYear(date2.getYear() - 2);
		int id = daoC
				.insertConsumption(user.getId(), auxFloat, auxFloat, date2);
		assertNotEquals(-1, id);
		
		auxConsumption2 = new Consumption();
		auxConsumption2.setConsumptionId(id);
		auxConsumption2.setEndingDate(date2);
		auxConsumption2.setQuantity(auxFloat);
		auxConsumption2.setPrice(auxFloat);
		auxConsumption2.setUserId(user.getId());
		
		auxConsumption = daoC.getById(id);

		
		assertEquals(auxConsumption2.getConsumptionId(), auxConsumption.getConsumptionId());
		assertEquals(auxConsumption2.getEndingDate().toString(), auxConsumption.getEndingDate().toString());
		
		assertTrue(daoC.deleteConsumption(id));
		auxConsumption = null;
	}

	@Test
	public void testUpdateConsumption() {
		consumption.setQuantity(0f);
		consumption.setPrice(0f);
	
		assertTrue(daoC.updateConsumption(consumption.getConsumptionId(), consumption.getPrice(), consumption.getQuantity()));
		
		Consumption auxConsumption = daoC.getById(consumptionId);
		assertEquals(consumption, auxConsumption);
		
		auxConsumption = null;
		
	}

}
