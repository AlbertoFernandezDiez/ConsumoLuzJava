package com.alberto.fernandez.consumo.luz.dao.impl;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.alberto.fernandez.consumo.luz.dao.interfaces.ConsumptionDaoInterface;
import com.alberto.fernandez.consumo.luz.hibernate.HibernateUtil;
import com.alberto.fernandez.consumo.luz.pojo.Consumption;
import com.alberto.fernandez.consumo.luz.pojo.User;

public class ConsumptionDao implements ConsumptionDaoInterface {

	private Session session;
	private static ConsumptionDao myConsumptionDao = null;

	public static ConsumptionDao getMyUserDao() {
		if (myConsumptionDao == null) {
			myConsumptionDao = new ConsumptionDao();
		}
		return myConsumptionDao;
	}

	private ConsumptionDao() {
		super();
	}

	@Override
	public Consumption getById(int id) {
		Consumption result = null;

		session = HibernateUtil.getSession();
		// session.beginTransaction();

		result = (Consumption) session.get(Consumption.class, id);

		return result;
	}

	@Override
	public boolean deleteConsumption(int id) {
		boolean result = false;

		Consumption aux = null;

		session = HibernateUtil.getSession();

		session.beginTransaction();

		aux = (Consumption) session.get(Consumption.class, id);

		if (aux == null || aux.getConsumptionId() == -1) {
			System.err.println("Consumption does not exist");
			session.getTransaction().rollback();

		} else {
			session.delete(aux);
			aux = null;

			aux = (Consumption) session.get(Consumption.class, id);
			if (aux == null || aux.getConsumptionId() == -1) {
				result = true;
				session.getTransaction().commit();
			} else {
				session.getTransaction().rollback();
			}
		}


		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Consumption> getConsumptionByUser(int userId) {
		List<Consumption> list =null;

		session = HibernateUtil.getSession();

		Query query = session
				.createQuery("from Consumption as c where c.userId = :id");
		query.setInteger("id", userId);

		list = query.list();

		return list;
	}

	@Override
	public int insertConsumption(int userId, float price, float quantity,
			Date endingDate) {
		int result = -1;

		Consumption consumption = new Consumption();

		consumption.setEndingDate(endingDate);
		consumption.setPrice(price);
		consumption.setQuantity(quantity);
		consumption.setUserId(userId);

		session = HibernateUtil.getSession();

		session.beginTransaction();

		session.save(consumption);

		if (consumption.getConsumptionId() != -1) {
			result = consumption.getConsumptionId();
			session.getTransaction().commit();
		} else {
			session.getTransaction().rollback();
		}

		return result;
	}

	@Override
	public boolean updateConsumption(int consumptionId, float price,
			float quantity) {
		boolean result = false;

		session = HibernateUtil.getSession();

		session.beginTransaction();

		Consumption aux = null;

		aux = (Consumption) session.get(Consumption.class, consumptionId);

		if (aux == null || aux.getConsumptionId() == -1) {
			result = false;
		} else {
			aux.setPrice(price);
			aux.setQuantity(quantity);

			session.update(aux);

			Consumption aux2 = null;

			aux2 = (Consumption) session.get(Consumption.class, consumptionId);

			if (aux2 == null || aux2.getConsumptionId() == -1) {
				result = false;
				session.getTransaction().rollback();
			} else {
				if (aux2.getPrice() == price && aux2.getQuantity() == quantity) {
					result = true;
					session.getTransaction().commit();
				} else {
					result = false;
					session.getTransaction().rollback();

				}

			}
		}

		return result;
	}
}
