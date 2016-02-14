package com.alberto.fernandez.consumo.luz.hibernate;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure(new File(getFile())).buildSessionFactory();

		} catch (Throwable ex) {
			// Log exception!
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}

	public static String getFile() {
		ClassLoader classLoader = HibernateUtil.class.getClassLoader();
		return new File(classLoader.getResource("hibernate.cfg.xml").getFile()).getAbsolutePath();
	}
}
