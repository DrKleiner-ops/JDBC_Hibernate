package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        String query = "CREATE TABLE users " +
                "(id SERIAL PRIMARY KEY, name TEXT, lastName TEXT, age INTEGER)";
        executeUpdate(query);

    }

    public void dropUsersTable() throws SQLException {
        String query = "DROP TABLE users";
        executeUpdate(query);
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String query = "INSERT INTO users VALUES (DEFAULT, '" +
                name + "', '"	+
                lastName + "', " +
                (int) age +")";
        executeUpdate(query);
    }

    public void removeUserById(long id) throws SQLException {
        String query = "DELETE FROM users WHERE id = " + id;
        executeUpdate(query);
    }

    public List<User> getAllUsers() throws SQLException {
        Statement statement = Util.getConnection().createStatement();
        ResultSet result = statement.executeQuery(
                "SELECT * FROM users");
        List<User> users = new ArrayList<>();

        while (result.next()) {

            int id = result.getInt("id");
            String name =  result.getString("name");
            String lastName =  result.getString("lastName");
            byte age =  result.getByte("age");
            User user = new User(name, lastName, age);
            assert false;
            users.add(user);
            //System.out.println(id + "|" + name + "|" + lastName + "|" + age);
        }
        return users;
    }

    public void cleanUsersTable() throws SQLException {
        String query = "TRUNCATE TABLE users";
        executeUpdate(query);
    }

    private static void executeUpdate(String query) throws SQLException {

        Statement statement = Util.getConnection().createStatement();
        statement.executeUpdate(query);
    }
}
