package com.ube.proyintegrador.dao;

import com.ube.proyintegrador.db.DBManager;
import com.ube.proyintegrador.models.PlcReading;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlcReadingDAO {

    public List<PlcReading> findAll() {
        String sql = "SELECT id, timestamp, tag, value, status, description FROM plc_readings ORDER BY timestamp DESC";
        List<PlcReading> readings = new ArrayList<>();
        try (Connection c = DBManager.getInstance().getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                readings.add(new PlcReading(
                        rs.getInt("id"),
                        rs.getTimestamp("timestamp"),
                        rs.getString("tag"),
                        rs.getDouble("value"),
                        rs.getString("status"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readings;
    }

    public boolean insertReading(PlcReading reading) {
        String sql = "INSERT INTO plc_readings (timestamp, tag, value, status, description) VALUES (?, ?, ?, ?, ?)";
        try (Connection c = DBManager.getInstance().getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setTimestamp(1, new java.sql.Timestamp(reading.getTimestamp().getTime()));
            ps.setString(2, reading.getTag());
            ps.setDouble(3, reading.getValue());
            ps.setString(4, reading.getStatus());
            ps.setString(5, reading.getDescription());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public java.util.Map<String, Integer> countByStatus() {
        String sql = "SELECT status, COUNT(*) AS total FROM plc_readings GROUP BY status";
        java.util.Map<String, Integer> result = new java.util.HashMap<>();
        try (Connection c = DBManager.getInstance().getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.put(rs.getString("status"), rs.getInt("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
