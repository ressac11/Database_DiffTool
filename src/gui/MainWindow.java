/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import beans.Table;
import database.DBAccess;
import java.awt.Color;
import java.io.File;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import listModel.ColumnNamesLM;
import listModel.TableNamesLM;
/**
 *
 * @author Steffie
 */
public class MainWindow extends javax.swing.JFrame {
    /**
     * Creates new form DiffToolGui
     */
    public static final Color backgroundColorPanel = new Color(229, 229, 229);
    public static final Color backgroundColorButton = new Color(199, 199, 199);
    private TableNamesLM tnlmLeft;
    private TableNamesLM tnlmRight;
    private ColumnNamesLM cnlm;
    public DBAccess dba;
    private LinkedList<Table> liAllTablesLeftDB = new LinkedList<>();
    private LinkedList<Table> liAllTablesRightDB = new LinkedList<>();
    private int extractData;
    private boolean leftList;

    public MainWindow() 
    {
        initComponents();
        this.getContentPane().setBackground(backgroundColorPanel);
        btCompareData.setBackground(backgroundColorButton);
        btDownloadData.setBackground(backgroundColorButton);
        btExtractData1.setBackground(backgroundColorButton);
        btExtractData2.setBackground(backgroundColorButton);
        btShowDetails.setBackground(backgroundColorButton);
        this.setLocationRelativeTo(null);
        enableButtons(false);      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnButtonToolBar = new javax.swing.JPanel();
        btCompareData = new javax.swing.JButton();
        btShowDetails = new javax.swing.JButton();
        btDownloadData = new javax.swing.JButton();
        pnMain = new javax.swing.JPanel();
        pnFirstDatabase = new javax.swing.JPanel();
        pnShowAllTables1 = new javax.swing.JPanel();
        btExtractData1 = new javax.swing.JButton();
        spTables1 = new javax.swing.JScrollPane();
        liTables1 = new javax.swing.JList();
        pnDetails = new javax.swing.JPanel();
        lbPrincipalName = new javax.swing.JLabel();
        pnNamesCounts = new javax.swing.JPanel();
        pnTableColumn = new javax.swing.JPanel();
        pnCounts = new javax.swing.JPanel();
        lbColumnCount = new javax.swing.JLabel();
        lbColumnCountValue = new javax.swing.JLabel();
        lbWhiteSpace3 = new javax.swing.JLabel();
        lbDistinctionCount = new javax.swing.JLabel();
        pnTableName = new javax.swing.JPanel();
        lbTableName = new javax.swing.JLabel();
        lbTableNameValue = new javax.swing.JLabel();
        pnColumnNames = new javax.swing.JPanel();
        lbColumnNames = new javax.swing.JLabel();
        spColumnNames = new javax.swing.JScrollPane();
        liColumnNamesValue = new javax.swing.JList();
        pnSecondDatabase = new javax.swing.JPanel();
        pnShowAllTables2 = new javax.swing.JPanel();
        btExtractData2 = new javax.swing.JButton();
        spTables2 = new javax.swing.JScrollPane();
        liTablesC = new javax.swing.JList();
        pnDetails1 = new javax.swing.JPanel();
        lbCustomerName = new javax.swing.JLabel();
        pnNamesCounts1 = new javax.swing.JPanel();
        pnTableColumn1 = new javax.swing.JPanel();
        pnCounts1 = new javax.swing.JPanel();
        lbColumnCountC = new javax.swing.JLabel();
        lbColumnCountValueC = new javax.swing.JLabel();
        lbDistinctionCountValue = new javax.swing.JLabel();
        lbWhiteSpaceC = new javax.swing.JLabel();
        pnTableName1 = new javax.swing.JPanel();
        lbTableNameC = new javax.swing.JLabel();
        lbTableNameValueC = new javax.swing.JLabel();
        pnColumnNames1 = new javax.swing.JPanel();
        lbColumnNamesC = new javax.swing.JLabel();
        spColumnNames1 = new javax.swing.JScrollPane();
        liColumnNamesValueC = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Database Diff-Tool");
        setMaximumSize(new java.awt.Dimension(1100, 700));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(1100, 700));
        getContentPane().setLayout(new java.awt.BorderLayout(20, 5));

        pnButtonToolBar.setBackground(new java.awt.Color(229, 229, 229));
        pnButtonToolBar.setLayout(new java.awt.GridLayout(1, 3, 10, 5));

        btCompareData.setBackground(new java.awt.Color(229, 229, 229));
        btCompareData.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btCompareData.setText("Compare Data");
        btCompareData.setMaximumSize(new java.awt.Dimension(180, 60));
        btCompareData.setMinimumSize(new java.awt.Dimension(180, 60));
        btCompareData.setPreferredSize(new java.awt.Dimension(180, 60));
        btCompareData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCompareData(evt);
            }
        });
        pnButtonToolBar.add(btCompareData);

        btShowDetails.setBackground(new java.awt.Color(229, 229, 229));
        btShowDetails.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btShowDetails.setText("Show Details");
        btShowDetails.setToolTipText("");
        btShowDetails.setEnabled(false);
        btShowDetails.setMaximumSize(new java.awt.Dimension(180, 60));
        btShowDetails.setMinimumSize(new java.awt.Dimension(180, 60));
        btShowDetails.setPreferredSize(new java.awt.Dimension(180, 60));
        btShowDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onShowDetails(evt);
            }
        });
        pnButtonToolBar.add(btShowDetails);

        btDownloadData.setBackground(new java.awt.Color(229, 229, 229));
        btDownloadData.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btDownloadData.setText("Download data as text");
        btDownloadData.setToolTipText("");
        btDownloadData.setEnabled(false);
        btDownloadData.setMaximumSize(new java.awt.Dimension(180, 60));
        btDownloadData.setMinimumSize(new java.awt.Dimension(180, 60));
        btDownloadData.setPreferredSize(new java.awt.Dimension(180, 60));
        btDownloadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onDownloadData(evt);
            }
        });
        pnButtonToolBar.add(btDownloadData);

        getContentPane().add(pnButtonToolBar, java.awt.BorderLayout.PAGE_START);

        pnMain.setBackground(new java.awt.Color(229, 229, 229));
        pnMain.setLayout(new java.awt.GridLayout(1, 2, 7, 0));

        pnFirstDatabase.setBackground(new java.awt.Color(229, 229, 229));
        pnFirstDatabase.setLayout(new java.awt.BorderLayout(5, 5));

        pnShowAllTables1.setBackground(new java.awt.Color(229, 229, 229));
        pnShowAllTables1.setMaximumSize(new java.awt.Dimension(200, 320));
        pnShowAllTables1.setMinimumSize(new java.awt.Dimension(100, 160));
        pnShowAllTables1.setPreferredSize(new java.awt.Dimension(200, 320));
        pnShowAllTables1.setLayout(new java.awt.BorderLayout(5, 2));

        btExtractData1.setBackground(new java.awt.Color(229, 229, 229));
        btExtractData1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btExtractData1.setText("Extract Data");
        btExtractData1.setToolTipText("");
        btExtractData1.setActionCommand("1");
        btExtractData1.setMaximumSize(new java.awt.Dimension(40, 55));
        btExtractData1.setMinimumSize(new java.awt.Dimension(40, 55));
        btExtractData1.setPreferredSize(new java.awt.Dimension(40, 55));
        btExtractData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onExtractDatas(evt);
            }
        });
        pnShowAllTables1.add(btExtractData1, java.awt.BorderLayout.PAGE_START);

        spTables1.setBackground(new java.awt.Color(229, 229, 229));
        spTables1.setMaximumSize(new java.awt.Dimension(100, 100));
        spTables1.setMinimumSize(new java.awt.Dimension(100, 100));
        spTables1.setPreferredSize(new java.awt.Dimension(100, 100));

        liTables1.setBackground(new java.awt.Color(229, 229, 229));
        liTables1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        liTables1.setMaximumSize(new java.awt.Dimension(80, 100));
        liTables1.setMinimumSize(new java.awt.Dimension(80, 100));
        liTables1.setPreferredSize(new java.awt.Dimension(80, 100));
        liTables1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                onNewSelectedItemLeft(evt);
            }
        });
        spTables1.setViewportView(liTables1);

        pnShowAllTables1.add(spTables1, java.awt.BorderLayout.CENTER);

        pnFirstDatabase.add(pnShowAllTables1, java.awt.BorderLayout.WEST);

        pnDetails.setBackground(new java.awt.Color(229, 229, 229));
        pnDetails.setLayout(new java.awt.BorderLayout(10, 0));

        lbPrincipalName.setBackground(new java.awt.Color(229, 229, 229));
        lbPrincipalName.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbPrincipalName.setText("Principal");
        lbPrincipalName.setMaximumSize(new java.awt.Dimension(40, 45));
        lbPrincipalName.setMinimumSize(new java.awt.Dimension(40, 45));
        lbPrincipalName.setPreferredSize(new java.awt.Dimension(40, 45));
        pnDetails.add(lbPrincipalName, java.awt.BorderLayout.PAGE_START);

        pnNamesCounts.setBackground(new java.awt.Color(229, 229, 229));
        pnNamesCounts.setLayout(new java.awt.BorderLayout(10, 0));

        pnTableColumn.setBackground(new java.awt.Color(229, 229, 229));
        pnTableColumn.setLayout(new java.awt.BorderLayout(10, 0));

        pnCounts.setBackground(new java.awt.Color(229, 229, 229));
        pnCounts.setLayout(new java.awt.GridLayout(2, 2, 10, 0));

        lbColumnCount.setBackground(new java.awt.Color(229, 229, 229));
        lbColumnCount.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        lbColumnCount.setText("Column Count:");
        lbColumnCount.setMaximumSize(new java.awt.Dimension(40, 45));
        lbColumnCount.setMinimumSize(new java.awt.Dimension(40, 45));
        lbColumnCount.setPreferredSize(new java.awt.Dimension(40, 45));
        pnCounts.add(lbColumnCount);

        lbColumnCountValue.setBackground(new java.awt.Color(229, 229, 229));
        lbColumnCountValue.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbColumnCountValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbColumnCountValue.setMaximumSize(new java.awt.Dimension(40, 45));
        lbColumnCountValue.setMinimumSize(new java.awt.Dimension(40, 45));
        lbColumnCountValue.setPreferredSize(new java.awt.Dimension(40, 45));
        pnCounts.add(lbColumnCountValue);

        lbWhiteSpace3.setBackground(new java.awt.Color(229, 229, 229));
        lbWhiteSpace3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lbWhiteSpace3.setMaximumSize(new java.awt.Dimension(40, 45));
        lbWhiteSpace3.setMinimumSize(new java.awt.Dimension(40, 45));
        lbWhiteSpace3.setPreferredSize(new java.awt.Dimension(40, 45));
        pnCounts.add(lbWhiteSpace3);

        lbDistinctionCount.setBackground(new java.awt.Color(229, 229, 229));
        lbDistinctionCount.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        lbDistinctionCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDistinctionCount.setText("Distinction Count:");
        lbDistinctionCount.setMaximumSize(new java.awt.Dimension(40, 45));
        lbDistinctionCount.setMinimumSize(new java.awt.Dimension(40, 45));
        lbDistinctionCount.setPreferredSize(new java.awt.Dimension(40, 45));
        pnCounts.add(lbDistinctionCount);

        pnTableColumn.add(pnCounts, java.awt.BorderLayout.SOUTH);

        pnTableName.setBackground(new java.awt.Color(229, 229, 229));
        pnTableName.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        lbTableName.setBackground(new java.awt.Color(229, 229, 229));
        lbTableName.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        lbTableName.setText("Table name:");
        lbTableName.setMaximumSize(new java.awt.Dimension(40, 45));
        lbTableName.setMinimumSize(new java.awt.Dimension(40, 45));
        lbTableName.setPreferredSize(new java.awt.Dimension(40, 45));
        pnTableName.add(lbTableName);

        lbTableNameValue.setBackground(new java.awt.Color(229, 229, 229));
        lbTableNameValue.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbTableNameValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTableNameValue.setMaximumSize(new java.awt.Dimension(40, 45));
        lbTableNameValue.setMinimumSize(new java.awt.Dimension(40, 45));
        lbTableNameValue.setPreferredSize(new java.awt.Dimension(40, 45));
        pnTableName.add(lbTableNameValue);

        pnTableColumn.add(pnTableName, java.awt.BorderLayout.NORTH);

        pnColumnNames.setBackground(new java.awt.Color(229, 229, 229));
        pnColumnNames.setLayout(new java.awt.BorderLayout(10, 0));

        lbColumnNames.setBackground(new java.awt.Color(229, 229, 229));
        lbColumnNames.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        lbColumnNames.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbColumnNames.setText("Column Names:");
        lbColumnNames.setMaximumSize(new java.awt.Dimension(40, 45));
        lbColumnNames.setMinimumSize(new java.awt.Dimension(40, 45));
        lbColumnNames.setPreferredSize(new java.awt.Dimension(40, 45));
        pnColumnNames.add(lbColumnNames, java.awt.BorderLayout.NORTH);

        spColumnNames.setBackground(new java.awt.Color(229, 229, 229));

        liColumnNamesValue.setBackground(new java.awt.Color(229, 229, 229));
        liColumnNamesValue.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        spColumnNames.setViewportView(liColumnNamesValue);

        pnColumnNames.add(spColumnNames, java.awt.BorderLayout.CENTER);

        pnTableColumn.add(pnColumnNames, java.awt.BorderLayout.CENTER);

        pnNamesCounts.add(pnTableColumn, java.awt.BorderLayout.CENTER);

        pnDetails.add(pnNamesCounts, java.awt.BorderLayout.CENTER);

        pnFirstDatabase.add(pnDetails, java.awt.BorderLayout.CENTER);

        pnMain.add(pnFirstDatabase);

        pnSecondDatabase.setBackground(new java.awt.Color(229, 229, 229));
        pnSecondDatabase.setLayout(new java.awt.BorderLayout(5, 5));

        pnShowAllTables2.setBackground(new java.awt.Color(229, 229, 229));
        pnShowAllTables2.setMaximumSize(new java.awt.Dimension(200, 320));
        pnShowAllTables2.setMinimumSize(new java.awt.Dimension(100, 160));
        pnShowAllTables2.setPreferredSize(new java.awt.Dimension(200, 320));
        pnShowAllTables2.setLayout(new java.awt.BorderLayout(5, 2));

        btExtractData2.setBackground(new java.awt.Color(229, 229, 229));
        btExtractData2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btExtractData2.setText("Extract Data");
        btExtractData2.setToolTipText("");
        btExtractData2.setActionCommand("2");
        btExtractData2.setMaximumSize(new java.awt.Dimension(40, 55));
        btExtractData2.setMinimumSize(new java.awt.Dimension(40, 55));
        btExtractData2.setPreferredSize(new java.awt.Dimension(40, 55));
        btExtractData2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onExtractDatas(evt);
            }
        });
        pnShowAllTables2.add(btExtractData2, java.awt.BorderLayout.PAGE_START);

        spTables2.setBackground(new java.awt.Color(229, 229, 229));
        spTables2.setMaximumSize(new java.awt.Dimension(100, 100));
        spTables2.setMinimumSize(new java.awt.Dimension(100, 100));
        spTables2.setPreferredSize(new java.awt.Dimension(100, 100));

        liTablesC.setBackground(new java.awt.Color(229, 229, 229));
        liTablesC.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        liTablesC.setMaximumSize(new java.awt.Dimension(80, 100));
        liTablesC.setMinimumSize(new java.awt.Dimension(80, 100));
        liTablesC.setPreferredSize(new java.awt.Dimension(80, 100));
        liTablesC.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                onNewSelectedItemRight(evt);
            }
        });
        spTables2.setViewportView(liTablesC);

        pnShowAllTables2.add(spTables2, java.awt.BorderLayout.CENTER);

        pnSecondDatabase.add(pnShowAllTables2, java.awt.BorderLayout.EAST);

        pnDetails1.setBackground(new java.awt.Color(229, 229, 229));
        pnDetails1.setLayout(new java.awt.BorderLayout());

        lbCustomerName.setBackground(new java.awt.Color(229, 229, 229));
        lbCustomerName.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbCustomerName.setText("Customer");
        lbCustomerName.setMaximumSize(new java.awt.Dimension(40, 45));
        lbCustomerName.setMinimumSize(new java.awt.Dimension(40, 45));
        lbCustomerName.setPreferredSize(new java.awt.Dimension(40, 45));
        pnDetails1.add(lbCustomerName, java.awt.BorderLayout.PAGE_START);

        pnNamesCounts1.setBackground(new java.awt.Color(229, 229, 229));
        pnNamesCounts1.setLayout(new java.awt.BorderLayout());

        pnTableColumn1.setBackground(new java.awt.Color(229, 229, 229));
        pnTableColumn1.setLayout(new java.awt.BorderLayout());

        pnCounts1.setBackground(new java.awt.Color(229, 229, 229));
        pnCounts1.setLayout(new java.awt.GridLayout(2, 2));

        lbColumnCountC.setBackground(new java.awt.Color(229, 229, 229));
        lbColumnCountC.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        lbColumnCountC.setText("Column Count:");
        lbColumnCountC.setMaximumSize(new java.awt.Dimension(40, 45));
        lbColumnCountC.setMinimumSize(new java.awt.Dimension(40, 45));
        lbColumnCountC.setPreferredSize(new java.awt.Dimension(40, 45));
        pnCounts1.add(lbColumnCountC);

        lbColumnCountValueC.setBackground(new java.awt.Color(229, 229, 229));
        lbColumnCountValueC.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbColumnCountValueC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbColumnCountValueC.setMaximumSize(new java.awt.Dimension(40, 45));
        lbColumnCountValueC.setMinimumSize(new java.awt.Dimension(40, 45));
        lbColumnCountValueC.setPreferredSize(new java.awt.Dimension(40, 45));
        pnCounts1.add(lbColumnCountValueC);

        lbDistinctionCountValue.setBackground(new java.awt.Color(229, 229, 229));
        lbDistinctionCountValue.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbDistinctionCountValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDistinctionCountValue.setMaximumSize(new java.awt.Dimension(40, 45));
        lbDistinctionCountValue.setMinimumSize(new java.awt.Dimension(40, 45));
        lbDistinctionCountValue.setPreferredSize(new java.awt.Dimension(40, 45));
        pnCounts1.add(lbDistinctionCountValue);

        lbWhiteSpaceC.setBackground(new java.awt.Color(229, 229, 229));
        lbWhiteSpaceC.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lbWhiteSpaceC.setMaximumSize(new java.awt.Dimension(40, 45));
        lbWhiteSpaceC.setMinimumSize(new java.awt.Dimension(40, 45));
        lbWhiteSpaceC.setPreferredSize(new java.awt.Dimension(40, 45));
        pnCounts1.add(lbWhiteSpaceC);

        pnTableColumn1.add(pnCounts1, java.awt.BorderLayout.SOUTH);

        pnTableName1.setBackground(new java.awt.Color(229, 229, 229));
        pnTableName1.setLayout(new java.awt.GridLayout(1, 2));

        lbTableNameC.setBackground(new java.awt.Color(229, 229, 229));
        lbTableNameC.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        lbTableNameC.setText("Table name:");
        lbTableNameC.setMaximumSize(new java.awt.Dimension(40, 45));
        lbTableNameC.setMinimumSize(new java.awt.Dimension(40, 45));
        lbTableNameC.setPreferredSize(new java.awt.Dimension(40, 45));
        pnTableName1.add(lbTableNameC);

        lbTableNameValueC.setBackground(new java.awt.Color(229, 229, 229));
        lbTableNameValueC.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbTableNameValueC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTableNameValueC.setMaximumSize(new java.awt.Dimension(40, 45));
        lbTableNameValueC.setMinimumSize(new java.awt.Dimension(40, 45));
        lbTableNameValueC.setPreferredSize(new java.awt.Dimension(40, 45));
        pnTableName1.add(lbTableNameValueC);

        pnTableColumn1.add(pnTableName1, java.awt.BorderLayout.NORTH);

        pnColumnNames1.setBackground(new java.awt.Color(229, 229, 229));
        pnColumnNames1.setLayout(new java.awt.BorderLayout());

        lbColumnNamesC.setBackground(new java.awt.Color(229, 229, 229));
        lbColumnNamesC.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        lbColumnNamesC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbColumnNamesC.setText("Column Names:");
        lbColumnNamesC.setMaximumSize(new java.awt.Dimension(40, 45));
        lbColumnNamesC.setMinimumSize(new java.awt.Dimension(40, 45));
        lbColumnNamesC.setPreferredSize(new java.awt.Dimension(40, 45));
        pnColumnNames1.add(lbColumnNamesC, java.awt.BorderLayout.NORTH);

        spColumnNames1.setBackground(new java.awt.Color(229, 229, 229));

        liColumnNamesValueC.setBackground(new java.awt.Color(229, 229, 229));
        liColumnNamesValueC.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        spColumnNames1.setViewportView(liColumnNamesValueC);

        pnColumnNames1.add(spColumnNames1, java.awt.BorderLayout.CENTER);

        pnTableColumn1.add(pnColumnNames1, java.awt.BorderLayout.CENTER);

        pnNamesCounts1.add(pnTableColumn1, java.awt.BorderLayout.CENTER);

        pnDetails1.add(pnNamesCounts1, java.awt.BorderLayout.CENTER);

        pnSecondDatabase.add(pnDetails1, java.awt.BorderLayout.CENTER);

        pnMain.add(pnSecondDatabase);

        getContentPane().add(pnMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onCompareData(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCompareData
        DataSelectionModesDialogue selectDialogue = new DataSelectionModesDialogue(this, true);
        selectDialogue.setVisible(true);
        enableButtons(selectDialogue.isOK());
    }//GEN-LAST:event_onCompareData

    private void onShowDetails(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onShowDetails
        DetailsDialogue detailsDialogue = new DetailsDialogue(this, true);
        detailsDialogue.setVisible(true);
    }//GEN-LAST:event_onShowDetails

    private void onDownloadData(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onDownloadData
        SelectDownloadModeDialogue downloadDialogue = new SelectDownloadModeDialogue(this, true);
        downloadDialogue.setVisible(true);
    }//GEN-LAST:event_onDownloadData

    private void onNewSelectedItemLeft(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_onNewSelectedItemLeft
        leftList = true;
        onNewSelectedItem();
    }//GEN-LAST:event_onNewSelectedItemLeft

    private void onNewSelectedItemRight(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_onNewSelectedItemRight
        leftList = false;
        onNewSelectedItem();       
    }//GEN-LAST:event_onNewSelectedItemRight

    private void onExtractDatas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onExtractDatas
        DataExtractModeDialogue dataExtractDialogue = new DataExtractModeDialogue(this, true);
        dataExtractDialogue.setVisible(true);
        extractData=Integer.parseInt(evt.getActionCommand());       
        try 
        {
            dba = DBAccess.getTheInstance();
            if(dataExtractDialogue.isExistingFile())
            {
                if(dataExtractDialogue.getSelectedDBDump() != null)
                {
                    if (extractData == 1) 
                    {
                        liTables1.removeAll();
                        liAllTablesLeftDB.clear();
                        liAllTablesLeftDB = dba.loadData(dataExtractDialogue.getSelectedDBDump());
                        tnlmLeft = new TableNamesLM(dba.getAllTables(liAllTablesLeftDB));
                        liTables1.setModel(tnlmLeft);
                        liTables1.setSelectedIndex(0);
                    } 
                    else if (extractData == 2) 
                    {
                        
                        liAllTablesRightDB.clear();
                        liTablesC.removeAll();
                        liAllTablesRightDB = dba.loadData(dataExtractDialogue.getSelectedDBDump());
                        tnlmRight = new TableNamesLM(dba.getAllTables(liAllTablesRightDB));       
                        liTablesC.setModel(tnlmRight);
                        liTablesC.setSelectedIndex(0);
                    }
                }
            }
            else
            {
                onExtractData();
                int i = JOptionPane.showConfirmDialog(null, "Do you want to save the Database Extract as file?", "Save Database Extract", JOptionPane.YES_NO_OPTION);
                if(i == JOptionPane.OK_OPTION)
                {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogType(JFileChooser.SAVE_DIALOG); 
                    fileChooser.setDialogTitle("Choose directory to save Database file");   
                    int userSelection = fileChooser.showSaveDialog(null);

                    if (userSelection == JFileChooser.APPROVE_OPTION) 
                    {
                        File path = fileChooser.getSelectedFile();
                        if(!path.getPath().endsWith(".txt"))
                        {
                            String pathNew = path.getPath()+".txt";
                            path = new File(pathNew);
                        }
                        dba.saveDatabaseFile(path);
    //                        DownloadDialogue downloadDialogue = new DownloadDialogue(null, true);
    //                        downloadDialogue.setVisible(true);
                    }
                }
            }
        } 
        catch (Exception ex) 
        {
            System.out.println("Main Window : onExtractDatas : "+ex.toString());
        } 
    }//GEN-LAST:event_onExtractDatas

    public void onExtractData() 
    {
        try 
        {
            
            if (extractData == 1) 
            {
                liTables1.removeAll();
                liAllTablesLeftDB.clear();
                tnlmLeft = new TableNamesLM(dba.getAllTables(liAllTablesLeftDB));
                liTables1.setModel(tnlmLeft);
                liTables1.setSelectedIndex(0);
            } 
            else if (extractData == 2) 
            {
                liTablesC.setModel(tnlmRight);
                liAllTablesRightDB.clear();
                liTablesC.removeAll();
                tnlmRight = new TableNamesLM(dba.getAllTables(liAllTablesRightDB));        
                liTablesC.setSelectedIndex(0);
            }
        } 
        catch (Exception ex) 
        {
            System.out.println("Main Window : onExtractData : "+ex.toString());
        } 
    }

    public void onNewSelectedItem() 
    {
        if (leftList) 
        {
            lbTableNameValue.setText(liAllTablesLeftDB.get(liTables1.getSelectedIndex()).getTableName());
            cnlm = new ColumnNamesLM(liAllTablesLeftDB.get(liTables1.getSelectedIndex()).getColumnNames());
            liColumnNamesValue.setModel(cnlm);
            lbColumnCountValue.setText("" + cnlm.getSize());
        }
        else
        {
            lbTableNameValueC.setText(liAllTablesRightDB.get(liTablesC.getSelectedIndex()).getTableName());
            cnlm = new ColumnNamesLM(liAllTablesRightDB.get(liTablesC.getSelectedIndex()).getColumnNames());
            liColumnNamesValueC.setModel(cnlm);
            lbColumnCountValueC.setText("" + cnlm.getSize());
        }
    }

    public void enableButtons(boolean b) 
    {
        btShowDetails.setEnabled(false);
        btDownloadData.setEnabled(b);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCompareData;
    private javax.swing.JButton btDownloadData;
    private javax.swing.JButton btExtractData1;
    private javax.swing.JButton btExtractData2;
    private javax.swing.JButton btShowDetails;
    private javax.swing.JLabel lbColumnCount;
    private javax.swing.JLabel lbColumnCountC;
    private javax.swing.JLabel lbColumnCountValue;
    private javax.swing.JLabel lbColumnCountValueC;
    private javax.swing.JLabel lbColumnNames;
    private javax.swing.JLabel lbColumnNamesC;
    private javax.swing.JLabel lbCustomerName;
    private javax.swing.JLabel lbDistinctionCount;
    private javax.swing.JLabel lbDistinctionCountValue;
    private javax.swing.JLabel lbPrincipalName;
    private javax.swing.JLabel lbTableName;
    private javax.swing.JLabel lbTableNameC;
    private javax.swing.JLabel lbTableNameValue;
    private javax.swing.JLabel lbTableNameValueC;
    private javax.swing.JLabel lbWhiteSpace3;
    private javax.swing.JLabel lbWhiteSpaceC;
    private javax.swing.JList liColumnNamesValue;
    private javax.swing.JList liColumnNamesValueC;
    private javax.swing.JList liTables1;
    private javax.swing.JList liTablesC;
    private javax.swing.JPanel pnButtonToolBar;
    private javax.swing.JPanel pnColumnNames;
    private javax.swing.JPanel pnColumnNames1;
    private javax.swing.JPanel pnCounts;
    private javax.swing.JPanel pnCounts1;
    private javax.swing.JPanel pnDetails;
    private javax.swing.JPanel pnDetails1;
    private javax.swing.JPanel pnFirstDatabase;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnNamesCounts;
    private javax.swing.JPanel pnNamesCounts1;
    private javax.swing.JPanel pnSecondDatabase;
    private javax.swing.JPanel pnShowAllTables1;
    private javax.swing.JPanel pnShowAllTables2;
    private javax.swing.JPanel pnTableColumn;
    private javax.swing.JPanel pnTableColumn1;
    private javax.swing.JPanel pnTableName;
    private javax.swing.JPanel pnTableName1;
    private javax.swing.JScrollPane spColumnNames;
    private javax.swing.JScrollPane spColumnNames1;
    private javax.swing.JScrollPane spTables1;
    private javax.swing.JScrollPane spTables2;
    // End of variables declaration//GEN-END:variables
}
