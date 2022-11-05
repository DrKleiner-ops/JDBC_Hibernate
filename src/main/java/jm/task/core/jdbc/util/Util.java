package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

	Properties prop= new Properties();
	private static SessionFactory sessionFactory;
	Session session;


	public Util() {
		prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/test");
		//connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "Test", "123");
		//prop.setProperty("dialect", "org.hibernate.dialect.PostgresSQL");
		prop.setProperty("hibernate.connection.username", "Test");
		prop.setProperty("hibernate.connection.password", "123");
		sessionFactory = new Configuration().addProperties(prop)
				.addAnnotatedClass(User.class)
				.buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
