package com.ube.proyintegrador.ui;

import com.ube.proyintegrador.dao.PlcReadingDAO;
import com.ube.proyintegrador.models.PlcReading;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class PlcReadingFormFrame extends JFrame {
    private JTextField txtTag;
    private JSpinner spnValue;
    private JComboBox<String> cmbStatus;
    private JTextField txtDescription;

    public PlcReadingFormFrame() {
        setTitle("Formulario de lecturas PLC emulado");
        setSize(420, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6,6,6,6);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(new JLabel("Tag:"), gbc);
        gbc.gridx = 1;
        txtTag = new JTextField(20);
        panel.add(txtTag, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Valor:"), gbc);
        gbc.gridx = 1;
        spnValue = new JSpinner(new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1));
        panel.add(spnValue, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Estado:"), gbc);
        gbc.gridx = 1;
        cmbStatus = new JComboBox<>(new String[]{"OK", "ALERT", "ERROR"});
        panel.add(cmbStatus, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Descripción:"), gbc);
        gbc.gridx = 1;
        txtDescription = new JTextField(20);
        panel.add(txtDescription, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton btnSave = new JButton("Guardar lectura");
        btnSave.addActionListener(e -> doSave());
        panel.add(btnSave, gbc);

        add(panel);
    }

    private void doSave() {
        String tag = txtTag.getText().trim();
        double value = ((Number) spnValue.getValue()).doubleValue();
        String status = (String) cmbStatus.getSelectedItem();
        String description = txtDescription.getText().trim();

        if (tag.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El tag es obligatorio", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (status == null || status.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un estado", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        PlcReading reading = new PlcReading(0, new Date(), tag, value, status, description);
        boolean inserted = new PlcReadingDAO().insertReading(reading);
        if (inserted) {
            JOptionPane.showMessageDialog(this, "Lectura creada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            txtTag.setText("");
            spnValue.setValue(0.0);
            cmbStatus.setSelectedIndex(0);
            txtDescription.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo guardar la lectura", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
