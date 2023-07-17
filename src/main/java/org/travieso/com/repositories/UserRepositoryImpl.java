package org.travieso.com.repositories;

import org.travieso.com.models.User;
import org.travieso.com.utils.ConnectionBD;

import java.sql.*;
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
                User user = createUser(rs);
                users.add(user);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getUser(Long id) {
        User user = null;

        try(
                Connection conn = getBDInstance();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuarios WHERE id=?")
                ) {

            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    user = createUser(rs);
                }
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void createUser(User user) {
        try(
                Connection conn = getBDInstance();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuarios (username, password, email) VALUES(?,?,?)")
                ) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.printf("User %s created...", user.getUsername());
    }

    @Override
    public void deleteUser(Long id) {
        try(
                Connection conn = getBDInstance();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM usuarios WHERE id=?");
                ) {
            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        System.out.println("User deleted...");

    }

    public User createUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}
