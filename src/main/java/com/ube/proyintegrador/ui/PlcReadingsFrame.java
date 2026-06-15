package com.ube.proyintegrador.ui;

import com.ube.proyintegrador.dao.PlcReadingDAO;
import com.ube.proyintegrador.models.PlcReading;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PlcReadingsFrame extends JFrame {
    private DefaultTableModel model;
    private TableRowSorter<DefaultTableModel> sorter;
    private JTextField txtTagFilter;
    private JComboBox<String> cmbStatusFilter;

    public PlcReadingsFrame() {
        setTitle("Monitoreo de PLC emulado");
        setSize(860, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filterPanel.add(new JLabel("Filtrar Tag:"));
        txtTagFilter = new JTextField(12);
        filterPanel.add(txtTagFilter);
        filterPanel.add(new JLabel("Estado:"));
        cmbStatusFilter = new JComboBox<>(new String[]{"TODOS", "OK", "ALERT", "ERROR"});
        filterPanel.add(cmbStatusFilter);

        JButton btnClear = new JButton("Limpiar filtros");
        btnClear.addActionListener(e -> {
            txtTagFilter.setText("");
            cmbStatusFilter.setSelectedIndex(0);
            applyFilter();
        });
        filterPanel.add(btnClear);

        add(filterPanel, BorderLayout.NORTH);

        String[] columns = {"ID", "Timestamp", "Tag", "Valor", "Estado", "Descripción"};
        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        try {
            List<PlcReading> readings = new PlcReadingDAO().findAll();
            for (PlcReading item : readings) {
                model.addRow(new Object[]{
                        item.getId(),
                        item.getTimestamp(),
                        item.getTag(),
                        item.getValue(),
                        item.getStatus(),
                        item.getDescription()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar lecturas PLC: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        DocumentListener listener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { applyFilter(); }
            @Override
            public void removeUpdate(DocumentEvent e) { applyFilter(); }
            @Override
            public void changedUpdate(DocumentEvent e) { applyFilter(); }
        };
        txtTagFilter.getDocument().addDocumentListener(listener);
        cmbStatusFilter.addActionListener(e -> applyFilter());
    }

    private void applyFilter() {
        List<RowFilter<Object, Object>> filters = new ArrayList<>();
        String tagText = txtTagFilter.getText().trim();
        if (!tagText.isEmpty()) {
            filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(tagText), 2));
        }
        String status = (String) cmbStatusFilter.getSelectedItem();
        if (status != null && !"TODOS".equalsIgnoreCase(status)) {
            filters.add(RowFilter.regexFilter("^" + Pattern.quote(status) + "$", 4));
        }
        sorter.setRowFilter(filters.isEmpty() ? null : RowFilter.andFilter(filters));
    }
}
