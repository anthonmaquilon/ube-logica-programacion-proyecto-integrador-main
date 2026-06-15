package com.ube.proyintegrador.ui;

import com.ube.proyintegrador.models.User;
import com.ube.proyintegrador.ui.PlcDashboardFrame;
import com.ube.proyintegrador.ui.PlcReadingsFrame;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private User user;

    public MainFrame(User user) {
        this.user = user;
        setTitle("Panel Principal - Usuario: " + user.getUsername());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        init();
    }

    private void init() {
        JPanel top = new JPanel(new BorderLayout());
        top.add(new JLabel("Bienvenido: " + user.getUsername() + "   Rol: " + user.getRole()), BorderLayout.WEST);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JButton btnManage = new JButton("Gestión PLC (Admin/Operador)");
        JButton btnReports = new JButton("Reportes filtrados");
        JButton btnDashboard = new JButton("Panel de métricas");

        // Habilitar según rol
        String role = user.getRole();
        btnManage.setEnabled("ADMIN".equalsIgnoreCase(role) || "OPERATOR".equalsIgnoreCase(role));
        btnReports.setEnabled(true);
        btnDashboard.setEnabled(true);

        btnManage.addActionListener(e -> {
            PlcReadingFormFrame frame = new PlcReadingFormFrame();
            frame.setVisible(true);
        });

        btnReports.addActionListener(e -> {
            PlcReadingsFrame frame = new PlcReadingsFrame();
            frame.setVisible(true);
        });

        btnDashboard.addActionListener(e -> {
            PlcDashboardFrame frame = new PlcDashboardFrame();
            frame.setVisible(true);
        });

        center.add(btnManage);
        center.add(Box.createRigidArea(new Dimension(0,8)));
        center.add(btnReports);
        center.add(Box.createRigidArea(new Dimension(0,8)));
        center.add(btnDashboard);

        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
    }
}
