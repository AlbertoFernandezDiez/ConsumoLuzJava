package com.alberto.fernandez.consumo.luz.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.alberto.fernandez.consumo.luz.dao.interfaces.UserDaoInterface;
import com.alberto.fernandez.consumo.luz.hibernate.HibernateUtil;
import com.alberto.fernandez.consumo.luz.pojo.Consumption;
import com.alberto.fernandez.consumo.luz.pojo.User;

public class UserDao implements UserDaoInterface {

	protected static final Logger LOG = Logger.getLogger(UserDao.class);

	private Session session;
	private static UserDao myUserDao = null;

	public static UserDao getMyUserDao() {
		if (myUserDao == null) {
			myUserDao = new UserDao();
		}
		return myUserDao;
	}

	private UserDao() {
		super();
	}

	@Override
	public User getById(int id) {
		User result = null;

		session = HibernateUtil.getSession();
		session.beginTransaction();
		result = (User) session.get(User.class, id);

		if (result == null || result.getId() == -1) {
			result = null;
		}

		return result;
	}

	@Override
	public User login(String username, String password) {
		User result = null;

		session = HibernateUtil.getSession();
		session.beginTransaction();
		org.hibernate.Query query = session
				.createQuery("from User as u where u.name = :name and u.password = :password");
		query.setString("name", username);
		query.setString("password", password);
		result = (User) query.uniqueResult();

		if (result == null || result.getId() == -1) {
			result = null;
		}

		session.getTransaction().commit();
		return result;
	}

	@Override
	public boolean signIn(String username, String password) {
		User user = null;
		boolean result = false;

		session = HibernateUtil.getSession();

		session.beginTransaction();

		org.hibernate.Query query = session
				.createQuery("from User as u where u.name = :name");
		query.setString("name", username);
		user = (User) query.uniqueResult();

		if (user == null || user.getId() == -1) {
			user = new User();
			user.setName(username);
			user.setPassword(password);

			session.save(user);
			LOG.info("Usuario creado:\t" + user);
			if (user.getId() != -1) {
				result = true;
			}
		}

		session.getTransaction().commit();

		return result;
	}

	@Override
	public boolean checkName(String name) {
		User user = null;
		boolean result = false;

		session = HibernateUtil.getSession();

		session.beginTransaction();

		org.hibernate.Query query = session
				.createQuery("from User as u where u.name = :name");
		query.setString("name", name);
		user = (User) query.uniqueResult();

		if (user == null || user.getId() == -1) {

			result = true;

		}

		session.getTransaction().commit();

		return result;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean result = false;

		session = HibernateUtil.getSession();

		session.beginTransaction();

		User user = null;

		user = (User) session.get(User.class, id);

		if (user == null || user.getId() == -1) {
			LOG.error("User does not exist");
		} else {
			session.delete(user);
			user = null;

			user = (User) session.get(User.class, id);
			if (user == null || user.getId() == -1) {
				result = true;
			}
		}

		session.getTransaction().commit();

		return result;
	}

}
