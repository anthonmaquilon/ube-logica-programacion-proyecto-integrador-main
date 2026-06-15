package com.ube.proyintegrador.ui;

import com.ube.proyintegrador.dao.UserDAO;
import com.ube.proyintegrador.models.User;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;

    public LoginFrame() {
        setTitle("Login - Proyecto Integrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360,200);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel p = new JPanel(new GridLayout(3,2,8,8));
        p.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        p.add(new JLabel("Usuario:"));
        txtUser = new JTextField();
        p.add(txtUser);
        p.add(new JLabel("Contraseña:"));
        txtPass = new JPasswordField();
        p.add(txtPass);
        JButton btn = new JButton("Ingresar");
        btn.addActionListener(e -> doLogin());
        p.add(new JLabel());
        p.add(btn);
        add(p);
    }

    private void doLogin() {
        String user = txtUser.getText().trim();
        String pass = new String(txtPass.getPassword());
        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese usuario y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        UserDAO dao = new UserDAO();
        User u = dao.findByCredentials(user, pass);
        if (u == null) {
            JOptionPane.showMessageDialog(this, "Credenciales inválidas", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // abrir ventana principal
        SwingUtilities.invokeLater(() -> {
            MainFrame main = new MainFrame(u);
            main.setVisible(true);
        });
        dispose();
    }
}
