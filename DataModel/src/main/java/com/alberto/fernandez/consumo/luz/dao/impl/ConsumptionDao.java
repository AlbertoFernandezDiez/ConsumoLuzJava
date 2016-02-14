package com.alberto.fernandez.consumo.luz.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;

import com.alberto.fernandez.consumo.luz.dao.interfaces.ConsumptionDaoInterface;
import com.alberto.fernandez.consumo.luz.hibernate.HibernateUtil;
import com.alberto.fernandez.consumo.luz.pojo.Consumption;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Consumption> getConsumptionByUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertConsumption(int userId, float price, float quantity, Date endingDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateConsumption(int consumptionId, float price, float quantity) {
		// TODO Auto-generated method stub
		return false;
	}
}
