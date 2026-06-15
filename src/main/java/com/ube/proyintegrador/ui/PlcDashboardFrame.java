package com.ube.proyintegrador.ui;

import com.ube.proyintegrador.dao.PlcReadingDAO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PlcDashboardFrame extends JFrame {

    public PlcDashboardFrame() {
        setTitle("Panel de métricas PLC");
        setSize(850, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initUI();
    }

    private void initUI() {

        PlcReadingDAO dao = new PlcReadingDAO();
        Map<String, Integer> counts = dao.countByStatus();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        counts.forEach((status, total) ->
                dataset.addValue(total, "Lecturas", status)
        );

        JFreeChart chart = ChartFactory.createBarChart(
                "Lecturas PLC por Estado",
                "Estado",
                "Cantidad de Lecturas",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true);

        setContentPane(chartPanel);
    }
}