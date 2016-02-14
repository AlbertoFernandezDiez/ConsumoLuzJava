package com.alberto.fernandez.consumo.luz.dao.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alberto.fernandez.consumo.luz.dao.interfaces.UserDaoInterface;
import com.alberto.fernandez.consumo.luz.pojo.User;

public class UserDaoTest {

	private Long id;
	private static User user;
	private static UserDaoInterface dao;
	private static String time;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = UserDao.getMyUserDao();
		time = Long.toString(System.currentTimeMillis());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
		user = null;
	}

	@Before
	public void setUp() throws Exception {

		assertTrue(dao.signIn(time, time));
		user = dao.login(time, time);
		assertNotEquals(null, user);
	}

	@After
	public void tearDown() throws Exception {
		assertTrue(dao.deleteUser(user.getId()));
		user = null;
	}

	@Test
	public void testGetById() {
		User auxUser = null;
		auxUser = dao.getById(user.getId());
		assertEquals(user, auxUser);

		auxUser = null;
		auxUser = dao.getById(-1);
		assertEquals(null, auxUser);
	}

	@Test
	public void testLogin() {
		String aux = Long.toString(System.currentTimeMillis());
		User auxUser = null;
		auxUser = dao.login(time, time);
		assertEquals(user, auxUser);

		auxUser = null;
		auxUser = dao.login(aux, time);
		assertEquals(null, auxUser);

		auxUser = null;
		auxUser = dao.login(time, aux);
		assertEquals(null, auxUser);

		auxUser = null;
		auxUser = dao.login(aux, aux);
		assertEquals(null, auxUser);

		aux = null;
		auxUser = null;
	}

	@Test
	public void testSignIn() {
		String auxTime = Long.toString(System.currentTimeMillis());

		assertTrue(dao.signIn(auxTime, auxTime));

		User auxUser = dao.login(auxTime, auxTime);

		assertEquals(auxTime, auxUser.getName());

		assertEquals(auxTime, auxUser.getPassword());

		assertTrue(dao.deleteUser(auxUser.getId()));

		auxTime = null;
		auxUser = null;

	}

	@Test
	public void testCheckName() {
		String auxTime = Long.toString(System.currentTimeMillis());

		assertTrue(dao.signIn(auxTime, auxTime));

		User auxUser = dao.login(auxTime, auxTime);

		assertEquals(auxTime, auxUser.getName());

		assertEquals(auxTime, auxUser.getPassword());

		assertFalse(dao.checkName(auxTime));

		assertTrue(dao.deleteUser(auxUser.getId()));

		assertTrue(dao.checkName(auxTime));

		auxUser = null;
		auxTime = null;
	}

	@Test
	public void testDeleteUser() {
		String auxTime = Long.toString(System.currentTimeMillis());
		int id = 0;
		assertTrue(dao.signIn(auxTime, auxTime));

		User auxUser = dao.login(auxTime, auxTime);

		assertEquals(auxTime, auxUser.getName());

		assertEquals(auxTime, auxUser.getPassword());

		assertFalse(dao.checkName(auxTime));

		id = auxUser.getId();

		assertTrue(dao.deleteUser(auxUser.getId()));

		assertTrue(dao.checkName(auxTime));

		auxUser = null;

		assertEquals(null, dao.getById(id));

		auxTime = null;

	}

}
