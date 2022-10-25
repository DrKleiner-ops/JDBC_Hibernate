package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Util.createTable();
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Jora", "Vareny", (byte) 23));
        users.add(new User("Perqw", "S", (byte) 65));
        users.add(new User("Jfdsf", "Vrewr", (byte) 212));
        users.add(new User("Jfda", "EWfdsf", (byte) 1));
        for (User us : users) {
            userService.saveUser(us.getName(),us.getLastName(),us.getAge());
            System.out.println(us.getName() + " done");
        }
        userService.getAllUsers();
        userService.removeUserById(3);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
