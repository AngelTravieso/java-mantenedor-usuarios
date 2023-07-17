package org.travieso.com.repositories;

import org.travieso.com.models.User;
import org.travieso.com.models.utils.ConnectionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository<User> {

    private Connection getBDInstance() throws SQLException {
        return ConnectionBD.getConnection();
    }

    @Override
    public List<User> getUsers() {

        List<User> users = new ArrayList<>();

        try(
                Connection conn = getBDInstance();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");
                ) {

            while(rs.next()) {
                System.out.printf("%s \n", rs.getString("username"));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void deleteUser(Long id) {

    }
}
