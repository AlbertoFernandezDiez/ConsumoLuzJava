package com.alberto.fernandez.consumo.luz.dao.impl;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

	
	private Long id;
	private static Consumption consumption;
	private static UserDaoInterface daoU;
	private static ConsumptionDaoInterface daoC;
	private static String time;
	private static User user;
	private static Float auxFloat;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		daoC = ConsumptionDao.getMyUserDao();
		daoU = UserDao.getMyUserDao();
		time = Long.toString(System.currentTimeMillis());
		auxFloat = Float.parseFloat(time);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
		time = null;
	}

	@Before
	public void setUp() throws Exception {
		assertTrue(dao.signIn(time, time));
		user = dao.login(time, time);
		assertNotEquals(null, user);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteConsumption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetConsumptionByUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertConsumption() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateConsumption() {
		fail("Not yet implemented");
	}

}
