package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.postgresql.core.Query;
import org.postgresql.core.SqlCommand;

import java.util.List;
import java.util.Queue;

public class UserDaoHibernateImpl extends Util implements UserDao {
	public UserDaoHibernateImpl() {

	}


	@Override
	public void createUsersTable() {
		Session session = Util.getSessionFactory().openSession();
		String str = "CREATE TABLE users " +
				"(id SERIAL PRIMARY KEY, name TEXT, lastName TEXT, age INTEGER)";
		Query query = (Query) session.createSQLQuery(str);
		Transaction tx1 = session.beginTransaction();
		tx1.commit();
		session.close();
	}

	@Override
	public void dropUsersTable() {

	}

	@Override
	public void saveUser(String name, String lastName, byte age) {
		User user = new User(name, lastName, age);
		Session session = Util.getSessionFactory().openSession();
		Transaction tx1 = session.beginTransaction();
		session.save(user);
		tx1.commit();
		session.close();

	}

	@Override
	public void removeUserById(long id) {

	}

	@Override
	public List<User> getAllUsers() {
		return null;
	}

	@Override
	public void cleanUsersTable() {

	}
}
