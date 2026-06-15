package com.ube.proyintegrador.dao;

import com.ube.proyintegrador.db.DBManager;
import com.ube.proyintegrador.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public User findByCredentials(String username, String password) {
        String sql = "SELECT u.id, u.username, u.password, r.name AS role " +
                "FROM users u JOIN roles r ON u.role_id = r.id " +
                "WHERE u.username = ? AND u.password = ? LIMIT 1";
        try (Connection c = DBManager.getInstance().getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
