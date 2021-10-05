/*
 * File: MainWindow.java
 * Created Date: 2021-09-24 22:18:18
 * Author: Madarász Dávid
 * Original Author: Sallai Andras
 * Github: https://github.com/afriyy
 * -----
 * Last Modified: 2021-10-05
 * Modified By: Madarász Dávid
 * -----
 * Copyright (c) 2021 Madarász Dávid
 * 
 * GNU GPL v2
 */

package views;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame {

    public JPanel controlPanel;
    public JPanel formPanel;
    public JPanel buttonPanel;

    public JLabel vehicleLabel;
    public JLabel ordinalLabel;
    public JLabel brandLabel;
    public JLabel yearLabel;

    public JTextField brandField;
    public JTextField ordinalField;
    public JTextField yearField;

    public JButton addButton;
    public JButton delButton;
    public JButton saveButton;

    public DefaultTableModel vehicleModel;
    public JTable vehicleTable;
    public JScrollPane vehicleScrollPane;

    public MainWindow() {
        initUI();
    }

    private void initUI() {
        initFields();
        initLabels();
        initButtons();
        initPanels();
        initTable();
        addToMainWindow();
        initMainWindow();
    }

    private void initControlPanel() {
        this.controlPanel = new JPanel();
        this.controlPanel.setLayout(new BoxLayout(this.controlPanel, BoxLayout.LINE_AXIS));
        this.controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.controlPanel.add(this.formPanel);
        this.controlPanel.add(this.buttonPanel);
    }

    private void initFormPanel() {
        this.formPanel = new JPanel();
        this.formPanel.setLayout(new GridLayout(3, 2));
        addToFormPanel();
    }

    private void addToFormPanel() {
        this.formPanel.add(this.ordinalLabel);
        this.formPanel.add(this.ordinalField);
        this.formPanel.add(this.brandLabel);
        this.formPanel.add(this.brandField);
        this.formPanel.add(this.yearLabel);
        this.formPanel.add(this.yearField);
    }

    private void initLabels() {
        initOrdinalLabel();
        initBrandLabel();
        initYearLabel();
        initVehicleLabel();
    }

    private void initOrdinalLabel() {
        this.ordinalLabel = new JLabel("Rendszám");
        this.ordinalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.ordinalLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
    }

    private void initBrandLabel() {
        this.brandLabel = new JLabel("Márka");
        this.brandLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.brandLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
    }

    private void initYearLabel() {
        this.yearLabel = new JLabel("Év");
        this.yearLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.yearLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
    }

    private void initVehicleLabel() {
        this.vehicleLabel = new JLabel("Járművek");
        this.vehicleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.vehicleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void initFields() {
        this.brandField = new JTextField();
        this.yearField = new JTextField();
        this.ordinalField = new JTextField();
    }

    private void initButtons() {
        this.addButton = new JButton("Hozzáadás");
        this.delButton = new JButton("Törlés");
        this.saveButton = new JButton("Mentés");
    }

    private void initButtonPanel() {
        this.buttonPanel = new JPanel();
        this.buttonPanel.setLayout(new BoxLayout(this.buttonPanel, BoxLayout.PAGE_AXIS));
        this.buttonPanel.add(this.addButton);
        this.buttonPanel.add(this.delButton);
        this.buttonPanel.add(this.saveButton);
    }

    private void initPanels() {
        initFormPanel();
        initButtonPanel();
        initControlPanel();
    }

    private void initTable() {
        this.vehicleModel = new DefaultTableModel();
        this.vehicleTable = new JTable(vehicleModel);
        this.vehicleScrollPane = new JScrollPane(this.vehicleTable);
        this.vehicleScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Object[] tableLabels = { "Rendszám", "Márka", "Év" };
        this.vehicleModel.setColumnIdentifiers(tableLabels);
    }

    private void addToMainWindow() {
        this.add(this.vehicleLabel);
        this.add(this.controlPanel);
        this.add(this.vehicleScrollPane);
    }

    private void initMainWindow() {
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
}
