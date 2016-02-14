package com.alberto.fernandez.consumo.luz.dao.impl;

import org.hibernate.Session;

import com.alberto.fernandez.consumo.luz.hibernate.HibernateUtil;
import com.alberto.fernandez.consumo.luz.pojo.Consumption;

public class main {

	public static void main(String[] args) {
	Session session = HibernateUtil.getSession();
	session.get(Consumption.class, 1);
	}

}
