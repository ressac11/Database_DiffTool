package gui;

import beans.Table;
import bl.BLOperations;
import database.DBAccess;
import database.DBConnectionPool;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import listModel.TableNamesLM;
import renderer.TableRenderer;
import tableModel.TableContentTM;

public class MainWindow extends javax.swing.JFrame {

    public static final Color backgroundColorPanel = new Color(229, 229, 229);
    public static final Color backgroundColorButton = new Color(199, 199, 199);
    private TableNamesLM tnlmLeft;
    private TableNamesLM tnlmRight;
    private TableContentTM tctmL = null;
    private TableContentTM tctmR = null;
    public DBAccess dba;
    public LinkedList<Table> liTablesLeft = new LinkedList<>();
    public LinkedList<Table> liTablesRight = new LinkedList<>();
    private int extractData;
    private boolean leftList;
    private File savedFile1 = null;
    private File savedFile2 = null;
    private File existingFile1 = null;
    private File existingFile2 = null;
    private boolean enableItemSelect1 = false;
    private boolean enableItemSelect2 = false;
    private String databaseName1 = "";
    private String databaseName2 = "";
    private boolean automaticallySelectingTables = false;
    private BLOperations bl = new BLOperations();
    private boolean enableCompareButton1 = false;
    private boolean enableCompareButton2 = false;
    private boolean downloadEnabled = false;
    private boolean newDataL = false;
    private boolean newDataR = false;
    private String downloadButtonText = "Open downloaded file";
    public static boolean existingData = false;
    private File downloadedFile;
    private int counter = 0;
    private LinkedList<Table> liSaveListLeft = new LinkedList<>();
    private LinkedList<Table> liSaveListRight = new LinkedList<>();
    public static boolean e = false;
    private File newHTMLFile1 = null;
    private File newHTMLFile2 = null;
    private Task task;
    private String progressBarLoader;
    private LinkedList<String> nullValue;
    public static boolean newPartTable;
    private int indexOfSelectedTable;
    private DataExtractModeDialogue dataExtractDialogue;

    public MainWindow() {
        initComponents();
        this.getContentPane().setBackground(backgroundColorPanel);
        btCompareData.setBackground(backgroundColorButton);
        btDownloadData.setBackground(backgroundColorButton);
        btExtractData1.setBackground(backgroundColorButton);
        btExtractData2.setBackground(backgroundColorButton);
        btOpenDBFile1.setBackground(backgroundColorButton);
        btOpenDBFile2.setBackground(backgroundColorButton);
        btOpenHTMLFile1.setBackground(backgroundColorButton);
        btOpenHTMLFile2.setBackground(backgroundColorButton);
        this.setLocationRelativeTo(null);
        btDownloadData.setEnabled(false);
        liTablesLeft.clear();
        liTablesRight.clear();
        liTables1.removeAll();
        liTablesC.removeAll();
        tbTableContent1.setName("tbTableContent1");
        tbTableContent2.setName("tbTableContent2");
        tbTableContent1.setDefaultRenderer(Object.class, new TableRenderer());
        tbTableContent2.setDefaultRenderer(Object.class, new TableRenderer());
        btOpenDBFile1.setEnabled(false);
        btCompareData.setEnabled(true);
        btOpenDBFile2.setEnabled(false);
        btOpenHTMLFile1.setEnabled(false);
        btOpenHTMLFile2.setEnabled(false);
        liTables1.add(pmSelectTables);
        liTables1.setComponentPopupMenu(pmSelectTables);
        liTablesC.add(pmSelectTablesC);
        liTablesC.setComponentPopupMenu(pmSelectTablesC);
        this.setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        lbDate.setText(sdf.format(today));
    }

    @SuppressWarnings("unchecked")

    public void setCompareStatus(int value) {
        pbLoad.setValue(value);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgTableGroup = new javax.swing.ButtonGroup();
        pmSelectTables = new javax.swing.JPopupMenu();
        miSelectTables = new javax.swing.JMenuItem();
        miRemoveFilter = new javax.swing.JMenuItem();
        pmSelectTablesC = new javax.swing.JPopupMenu();
        miSelectTablesC = new javax.swing.JMenuItem();
        miRemoveFilterC = new javax.swing.JMenuItem();
        pnButtonToolBar = new javax.swing.JPanel();
        pnCompareButton = new javax.swing.JPanel();
        btCompareData = new javax.swing.JButton();
        lbPlaceholder9 = new javax.swing.JLabel();
        lbPlaceholder10 = new javax.swing.JLabel();
        lbPlaceholder15 = new javax.swing.JLabel();
        pnDownloadButton = new javax.swing.JPanel();
        btDownloadData = new javax.swing.JButton();
        lbPlaceholder11 = new javax.swing.JLabel();
        lbPlaceholder12 = new javax.swing.JLabel();
        lbPlaceholder16 = new javax.swing.JLabel();
        pnTableDisplayOptions = new javax.swing.JPanel();
        lbPlaceholder14 = new javax.swing.JLabel();
        pnRadioButtonsTable = new javax.swing.JPanel();
        rbTableBothAuto = new javax.swing.JRadioButton();
        rbTableSeperate = new javax.swing.JRadioButton();
        lbPlaceholder13 = new javax.swing.JLabel();
        pnProgressBarDate = new javax.swing.JPanel();
        pbLoad = new javax.swing.JProgressBar();
        pnDownLeft = new javax.swing.JPanel();
        lbWhitespace = new javax.swing.JLabel();
        lbWhitespace1 = new javax.swing.JLabel();
        pnDownRight = new javax.swing.JPanel();
        lbWhitespace2 = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        pnMain = new javax.swing.JPanel();
        pnFirstDatabase = new javax.swing.JPanel();
        pnShowAllTables1 = new javax.swing.JPanel();
        paExtractData = new javax.swing.JPanel();
        btExtractData1 = new javax.swing.JButton();
        paButton = new javax.swing.JPanel();
        lbPlaceholder = new javax.swing.JLabel();
        lbPlaceholder2 = new javax.swing.JLabel();
        lbPlaceholder3 = new javax.swing.JLabel();
        lbPlaceholder4 = new javax.swing.JLabel();
        pnViewButtons = new javax.swing.JPanel();
        btOpenDBFile1 = new javax.swing.JButton();
        btOpenHTMLFile1 = new javax.swing.JButton();
        spTable1 = new javax.swing.JScrollPane();
        liTables1 = new javax.swing.JList();
        pnDetails = new javax.swing.JPanel();
        lbDatabaseName1 = new javax.swing.JLabel();
        spTableContent1 = new javax.swing.JScrollPane();
        tbTableContent1 = new javax.swing.JTable();
        pnSecondDatabase = new javax.swing.JPanel();
        pnShowAllTables2 = new javax.swing.JPanel();
        pnExtractData = new javax.swing.JPanel();
        btExtractData2 = new javax.swing.JButton();
        pnButton1 = new javax.swing.JPanel();
        lbPlaceholder1 = new javax.swing.JLabel();
        lbPlaceholder5 = new javax.swing.JLabel();
        lbPlaceholder6 = new javax.swing.JLabel();
        lbPlaceholder7 = new javax.swing.JLabel();
        pnViewButtons2 = new javax.swing.JPanel();
        btOpenDBFile2 = new javax.swing.JButton();
        btOpenHTMLFile2 = new javax.swing.JButton();
        spTableC = new javax.swing.JScrollPane();
        liTablesC = new javax.swing.JList();
        pnDetails1 = new javax.swing.JPanel();
        lbDatabaseName2 = new javax.swing.JLabel();
        spTableContent2 = new javax.swing.JScrollPane();
        tbTableContent2 = new javax.swing.JTable();

        miSelectTables.setText("Table Filter");
        miSelectTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onFilter1(evt);
            }
        });
        pmSelectTables.add(miSelectTables);

        miRemoveFilter.setText("Remove Filter");
        miRemoveFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onRemove1(evt);
            }
        });
        pmSelectTables.add(miRemoveFilter);

        miSelectTablesC.setText("Table Filter");
        miSelectTablesC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onFilterC(evt);
            }
        });
        pmSelectTablesC.add(miSelectTablesC);

        miRemoveFilterC.setText("Remove Filter");
        miRemoveFilterC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onRemoveC(evt);
            }
        });
        pmSelectTablesC.add(miRemoveFilterC);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Database Diff-Tool");
        setMaximumSize(new java.awt.Dimension(1280, 800));
        setMinimumSize(new java.awt.Dimension(1280, 800));
        setPreferredSize(new java.awt.Dimension(1280, 800));
        getContentPane().setLayout(new java.awt.BorderLayout(20, 5));

        pnButtonToolBar.setBackground(new java.awt.Color(229, 229, 229));
        pnButtonToolBar.setLayout(new java.awt.BorderLayout());

        pnCompareButton.setBackground(new java.awt.Color(229, 229, 229));
        pnCompareButton.setMaximumSize(new java.awt.Dimension(490, 100));
        pnCompareButton.setMinimumSize(new java.awt.Dimension(4900, 100));
        pnCompareButton.setPreferredSize(new java.awt.Dimension(490, 100));
        pnCompareButton.setLayout(new java.awt.BorderLayout(15, 6));

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
        pnCompareButton.add(btCompareData, java.awt.BorderLayout.CENTER);

        lbPlaceholder9.setBackground(new java.awt.Color(229, 229, 229));
        pnCompareButton.add(lbPlaceholder9, java.awt.BorderLayout.LINE_START);

        lbPlaceholder10.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder10.setMaximumSize(new java.awt.Dimension(100, 10));
        lbPlaceholder10.setMinimumSize(new java.awt.Dimension(100, 510));
        lbPlaceholder10.setPreferredSize(new java.awt.Dimension(100, 10));
        pnCompareButton.add(lbPlaceholder10, java.awt.BorderLayout.PAGE_START);

        lbPlaceholder15.setMaximumSize(new java.awt.Dimension(100, 5));
        lbPlaceholder15.setMinimumSize(new java.awt.Dimension(100, 5));
        lbPlaceholder15.setPreferredSize(new java.awt.Dimension(100, 5));
        pnCompareButton.add(lbPlaceholder15, java.awt.BorderLayout.PAGE_END);

        pnButtonToolBar.add(pnCompareButton, java.awt.BorderLayout.LINE_START);

        pnDownloadButton.setBackground(new java.awt.Color(229, 229, 229));
        pnDownloadButton.setMaximumSize(new java.awt.Dimension(490, 100));
        pnDownloadButton.setMinimumSize(new java.awt.Dimension(4900, 100));
        pnDownloadButton.setPreferredSize(new java.awt.Dimension(490, 100));
        pnDownloadButton.setLayout(new java.awt.BorderLayout(15, 6));

        btDownloadData.setBackground(new java.awt.Color(229, 229, 229));
        btDownloadData.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btDownloadData.setText("Download Comparison Output as .xml file");
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
        pnDownloadButton.add(btDownloadData, java.awt.BorderLayout.CENTER);

        lbPlaceholder11.setBackground(new java.awt.Color(229, 229, 229));
        pnDownloadButton.add(lbPlaceholder11, java.awt.BorderLayout.LINE_END);

        lbPlaceholder12.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder12.setMaximumSize(new java.awt.Dimension(100, 10));
        lbPlaceholder12.setMinimumSize(new java.awt.Dimension(100, 510));
        lbPlaceholder12.setPreferredSize(new java.awt.Dimension(100, 10));
        pnDownloadButton.add(lbPlaceholder12, java.awt.BorderLayout.PAGE_START);

        lbPlaceholder16.setMaximumSize(new java.awt.Dimension(100, 5));
        lbPlaceholder16.setMinimumSize(new java.awt.Dimension(100, 5));
        lbPlaceholder16.setPreferredSize(new java.awt.Dimension(100, 5));
        pnDownloadButton.add(lbPlaceholder16, java.awt.BorderLayout.PAGE_END);

        pnButtonToolBar.add(pnDownloadButton, java.awt.BorderLayout.LINE_END);

        pnTableDisplayOptions.setBackground(new java.awt.Color(229, 229, 229));
        pnTableDisplayOptions.setMaximumSize(new java.awt.Dimension(220, 100));
        pnTableDisplayOptions.setMinimumSize(new java.awt.Dimension(220, 100));
        pnTableDisplayOptions.setPreferredSize(new java.awt.Dimension(220, 100));
        pnTableDisplayOptions.setLayout(new java.awt.BorderLayout(10, -15));

        lbPlaceholder14.setMaximumSize(new java.awt.Dimension(100, 23));
        lbPlaceholder14.setMinimumSize(new java.awt.Dimension(100, 203));
        lbPlaceholder14.setPreferredSize(new java.awt.Dimension(100, 23));
        pnTableDisplayOptions.add(lbPlaceholder14, java.awt.BorderLayout.PAGE_START);

        pnRadioButtonsTable.setBackground(new java.awt.Color(229, 229, 229));
        pnRadioButtonsTable.setMaximumSize(new java.awt.Dimension(75, 50));
        pnRadioButtonsTable.setMinimumSize(new java.awt.Dimension(75, 50));
        pnRadioButtonsTable.setPreferredSize(new java.awt.Dimension(75, 50));
        pnRadioButtonsTable.setLayout(new java.awt.GridLayout(2, 1, 5, -12));

        rbTableBothAuto.setBackground(new java.awt.Color(229, 229, 229));
        bgTableGroup.add(rbTableBothAuto);
        rbTableBothAuto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbTableBothAuto.setText("Table choosing automatically");
        rbTableBothAuto.setActionCommand("2");
        rbTableBothAuto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rbTableBothAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onTableDisplayOption(evt);
            }
        });
        pnRadioButtonsTable.add(rbTableBothAuto);

        rbTableSeperate.setBackground(new java.awt.Color(229, 229, 229));
        bgTableGroup.add(rbTableSeperate);
        rbTableSeperate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbTableSeperate.setSelected(true);
        rbTableSeperate.setText("Table choosing seperate");
        rbTableSeperate.setActionCommand("1");
        rbTableSeperate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rbTableSeperate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onTableDisplayOption(evt);
            }
        });
        pnRadioButtonsTable.add(rbTableSeperate);

        pnTableDisplayOptions.add(pnRadioButtonsTable, java.awt.BorderLayout.CENTER);

        lbPlaceholder13.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder13.setMaximumSize(new java.awt.Dimension(40, 50));
        lbPlaceholder13.setMinimumSize(new java.awt.Dimension(40, 50));
        lbPlaceholder13.setPreferredSize(new java.awt.Dimension(40, 50));
        pnTableDisplayOptions.add(lbPlaceholder13, java.awt.BorderLayout.LINE_START);

        pnButtonToolBar.add(pnTableDisplayOptions, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnButtonToolBar, java.awt.BorderLayout.PAGE_START);

        pnProgressBarDate.setBackground(new java.awt.Color(229, 229, 229));
        pnProgressBarDate.setLayout(new java.awt.BorderLayout());

        pbLoad.setBackground(new java.awt.Color(229, 229, 229));
        pbLoad.setForeground(new java.awt.Color(0, 0, 0));
        pbLoad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pbLoad.setMaximumSize(new java.awt.Dimension(100, 14));
        pbLoad.setMinimumSize(new java.awt.Dimension(100, 14));
        pbLoad.setPreferredSize(new java.awt.Dimension(100, 14));
        pnProgressBarDate.add(pbLoad, java.awt.BorderLayout.CENTER);

        pnDownLeft.setBackground(new java.awt.Color(229, 229, 229));
        pnDownLeft.setLayout(new java.awt.GridLayout(1, 2));

        lbWhitespace.setBackground(new java.awt.Color(229, 229, 229));
        lbWhitespace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbWhitespace.setMaximumSize(new java.awt.Dimension(100, 14));
        lbWhitespace.setMinimumSize(new java.awt.Dimension(100, 14));
        lbWhitespace.setName(""); // NOI18N
        lbWhitespace.setPreferredSize(new java.awt.Dimension(100, 14));
        pnDownLeft.add(lbWhitespace);

        lbWhitespace1.setBackground(new java.awt.Color(229, 229, 229));
        lbWhitespace1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbWhitespace1.setMaximumSize(new java.awt.Dimension(100, 14));
        lbWhitespace1.setMinimumSize(new java.awt.Dimension(100, 14));
        lbWhitespace1.setName(""); // NOI18N
        lbWhitespace1.setPreferredSize(new java.awt.Dimension(100, 14));
        pnDownLeft.add(lbWhitespace1);

        pnProgressBarDate.add(pnDownLeft, java.awt.BorderLayout.WEST);

        pnDownRight.setBackground(new java.awt.Color(229, 229, 229));
        pnDownRight.setLayout(new java.awt.GridLayout(1, 2));

        lbWhitespace2.setBackground(new java.awt.Color(229, 229, 229));
        lbWhitespace2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbWhitespace2.setMaximumSize(new java.awt.Dimension(100, 25));
        lbWhitespace2.setMinimumSize(new java.awt.Dimension(100, 25));
        lbWhitespace2.setName(""); // NOI18N
        lbWhitespace2.setPreferredSize(new java.awt.Dimension(100, 25));
        pnDownRight.add(lbWhitespace2);

        lbDate.setBackground(new java.awt.Color(229, 229, 229));
        lbDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDate.setMaximumSize(new java.awt.Dimension(100, 14));
        lbDate.setMinimumSize(new java.awt.Dimension(100, 14));
        lbDate.setName(""); // NOI18N
        lbDate.setPreferredSize(new java.awt.Dimension(100, 14));
        pnDownRight.add(lbDate);

        pnProgressBarDate.add(pnDownRight, java.awt.BorderLayout.EAST);

        getContentPane().add(pnProgressBarDate, java.awt.BorderLayout.PAGE_END);

        pnMain.setBackground(new java.awt.Color(229, 229, 229));
        pnMain.setLayout(new java.awt.GridLayout(1, 2, 7, 0));

        pnFirstDatabase.setBackground(new java.awt.Color(229, 229, 229));
        pnFirstDatabase.setLayout(new java.awt.BorderLayout(5, 5));

        pnShowAllTables1.setBackground(new java.awt.Color(229, 229, 229));
        pnShowAllTables1.setMaximumSize(new java.awt.Dimension(200, 320));
        pnShowAllTables1.setMinimumSize(new java.awt.Dimension(100, 160));
        pnShowAllTables1.setPreferredSize(new java.awt.Dimension(200, 320));
        pnShowAllTables1.setLayout(new java.awt.BorderLayout(5, 2));

        paExtractData.setBackground(new java.awt.Color(229, 229, 229));
        paExtractData.setLayout(new java.awt.BorderLayout());

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
        paExtractData.add(btExtractData1, java.awt.BorderLayout.CENTER);

        paButton.setBackground(new java.awt.Color(229, 229, 229));
        paButton.setLayout(new java.awt.BorderLayout());

        lbPlaceholder.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder.setMaximumSize(new java.awt.Dimension(50, 5));
        lbPlaceholder.setMinimumSize(new java.awt.Dimension(50, 5));
        lbPlaceholder.setPreferredSize(new java.awt.Dimension(50, 5));
        paButton.add(lbPlaceholder, java.awt.BorderLayout.PAGE_START);

        lbPlaceholder2.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder2.setMaximumSize(new java.awt.Dimension(30, 30));
        lbPlaceholder2.setMinimumSize(new java.awt.Dimension(30, 30));
        lbPlaceholder2.setPreferredSize(new java.awt.Dimension(30, 30));
        paButton.add(lbPlaceholder2, java.awt.BorderLayout.LINE_END);

        lbPlaceholder3.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder3.setMaximumSize(new java.awt.Dimension(50, 5));
        lbPlaceholder3.setMinimumSize(new java.awt.Dimension(50, 5));
        lbPlaceholder3.setPreferredSize(new java.awt.Dimension(50, 5));
        paButton.add(lbPlaceholder3, java.awt.BorderLayout.PAGE_END);

        lbPlaceholder4.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder4.setMaximumSize(new java.awt.Dimension(30, 30));
        lbPlaceholder4.setMinimumSize(new java.awt.Dimension(30, 30));
        lbPlaceholder4.setPreferredSize(new java.awt.Dimension(30, 30));
        paButton.add(lbPlaceholder4, java.awt.BorderLayout.LINE_START);

        pnViewButtons.setBackground(new java.awt.Color(229, 229, 229));
        pnViewButtons.setLayout(new java.awt.GridLayout(2, 1, 0, 4));

        btOpenDBFile1.setBackground(new java.awt.Color(229, 229, 229));
        btOpenDBFile1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btOpenDBFile1.setText("View file as .txt");
        btOpenDBFile1.setActionCommand("1");
        btOpenDBFile1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btOpenDBFile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onViewFileTXT(evt);
            }
        });
        pnViewButtons.add(btOpenDBFile1);

        btOpenHTMLFile1.setText("View file in HTML");
        btOpenHTMLFile1.setActionCommand("1");
        btOpenHTMLFile1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btOpenHTMLFile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onViewFileHTML(evt);
            }
        });
        pnViewButtons.add(btOpenHTMLFile1);

        paButton.add(pnViewButtons, java.awt.BorderLayout.CENTER);

        paExtractData.add(paButton, java.awt.BorderLayout.PAGE_END);

        pnShowAllTables1.add(paExtractData, java.awt.BorderLayout.PAGE_START);

        liTables1.setBackground(new java.awt.Color(229, 229, 229));
        liTables1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onSelectTableItemLeft(evt);
            }
        });
        spTable1.setViewportView(liTables1);

        pnShowAllTables1.add(spTable1, java.awt.BorderLayout.CENTER);

        pnFirstDatabase.add(pnShowAllTables1, java.awt.BorderLayout.WEST);

        pnDetails.setBackground(new java.awt.Color(229, 229, 229));
        pnDetails.setLayout(new java.awt.BorderLayout(10, 20));

        lbDatabaseName1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbDatabaseName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDatabaseName1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbDatabaseName1.setMaximumSize(new java.awt.Dimension(70, 40));
        lbDatabaseName1.setMinimumSize(new java.awt.Dimension(70, 40));
        lbDatabaseName1.setPreferredSize(new java.awt.Dimension(70, 40));
        pnDetails.add(lbDatabaseName1, java.awt.BorderLayout.PAGE_START);

        spTableContent1.setBackground(new java.awt.Color(229, 229, 229));
        spTableContent1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        spTableContent1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        spTableContent1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tbTableContent1.setBackground(new java.awt.Color(229, 229, 229));
        tbTableContent1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", ""
            }
        ));
        tbTableContent1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        spTableContent1.setViewportView(tbTableContent1);

        pnDetails.add(spTableContent1, java.awt.BorderLayout.CENTER);

        pnFirstDatabase.add(pnDetails, java.awt.BorderLayout.CENTER);

        pnMain.add(pnFirstDatabase);

        pnSecondDatabase.setBackground(new java.awt.Color(229, 229, 229));
        pnSecondDatabase.setLayout(new java.awt.BorderLayout(5, 5));

        pnShowAllTables2.setBackground(new java.awt.Color(229, 229, 229));
        pnShowAllTables2.setMaximumSize(new java.awt.Dimension(200, 320));
        pnShowAllTables2.setMinimumSize(new java.awt.Dimension(100, 160));
        pnShowAllTables2.setPreferredSize(new java.awt.Dimension(200, 320));
        pnShowAllTables2.setLayout(new java.awt.BorderLayout(5, 2));

        pnExtractData.setBackground(new java.awt.Color(229, 229, 229));
        pnExtractData.setLayout(new java.awt.BorderLayout());

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
        pnExtractData.add(btExtractData2, java.awt.BorderLayout.CENTER);

        pnButton1.setBackground(new java.awt.Color(229, 229, 229));
        pnButton1.setLayout(new java.awt.BorderLayout());

        lbPlaceholder1.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder1.setMaximumSize(new java.awt.Dimension(50, 5));
        lbPlaceholder1.setMinimumSize(new java.awt.Dimension(50, 5));
        lbPlaceholder1.setPreferredSize(new java.awt.Dimension(50, 5));
        pnButton1.add(lbPlaceholder1, java.awt.BorderLayout.PAGE_START);

        lbPlaceholder5.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder5.setMaximumSize(new java.awt.Dimension(30, 30));
        lbPlaceholder5.setMinimumSize(new java.awt.Dimension(30, 30));
        lbPlaceholder5.setPreferredSize(new java.awt.Dimension(30, 30));
        pnButton1.add(lbPlaceholder5, java.awt.BorderLayout.LINE_END);

        lbPlaceholder6.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder6.setMaximumSize(new java.awt.Dimension(50, 5));
        lbPlaceholder6.setMinimumSize(new java.awt.Dimension(50, 5));
        lbPlaceholder6.setPreferredSize(new java.awt.Dimension(50, 5));
        pnButton1.add(lbPlaceholder6, java.awt.BorderLayout.PAGE_END);

        lbPlaceholder7.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder7.setMaximumSize(new java.awt.Dimension(30, 30));
        lbPlaceholder7.setMinimumSize(new java.awt.Dimension(30, 30));
        lbPlaceholder7.setPreferredSize(new java.awt.Dimension(30, 30));
        pnButton1.add(lbPlaceholder7, java.awt.BorderLayout.LINE_START);

        pnViewButtons2.setBackground(new java.awt.Color(229, 229, 229));
        pnViewButtons2.setLayout(new java.awt.GridLayout(2, 1, 0, 4));

        btOpenDBFile2.setBackground(new java.awt.Color(229, 229, 229));
        btOpenDBFile2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btOpenDBFile2.setText("View file as .txt ");
        btOpenDBFile2.setActionCommand("2");
        btOpenDBFile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onViewFileTXT(evt);
            }
        });
        pnViewButtons2.add(btOpenDBFile2);

        btOpenHTMLFile2.setText("View file in HTML");
        btOpenHTMLFile2.setActionCommand("2");
        btOpenHTMLFile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onViewFileHTML(evt);
            }
        });
        pnViewButtons2.add(btOpenHTMLFile2);

        pnButton1.add(pnViewButtons2, java.awt.BorderLayout.CENTER);

        pnExtractData.add(pnButton1, java.awt.BorderLayout.PAGE_END);

        pnShowAllTables2.add(pnExtractData, java.awt.BorderLayout.PAGE_START);

        liTablesC.setBackground(new java.awt.Color(229, 229, 229));
        liTablesC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onSelectTableItemRight(evt);
            }
        });
        spTableC.setViewportView(liTablesC);

        pnShowAllTables2.add(spTableC, java.awt.BorderLayout.CENTER);

        pnSecondDatabase.add(pnShowAllTables2, java.awt.BorderLayout.EAST);

        pnDetails1.setBackground(new java.awt.Color(229, 229, 229));
        pnDetails1.setLayout(new java.awt.BorderLayout(10, 20));

        lbDatabaseName2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbDatabaseName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDatabaseName2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbDatabaseName2.setMaximumSize(new java.awt.Dimension(70, 40));
        lbDatabaseName2.setMinimumSize(new java.awt.Dimension(70, 40));
        lbDatabaseName2.setPreferredSize(new java.awt.Dimension(70, 40));
        pnDetails1.add(lbDatabaseName2, java.awt.BorderLayout.PAGE_START);

        spTableContent2.setBackground(new java.awt.Color(229, 229, 229));
        spTableContent2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        spTableContent2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        spTableContent2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tbTableContent2.setBackground(new java.awt.Color(229, 229, 229));
        tbTableContent2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", ""
            }
        ));
        tbTableContent2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbTableContent2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        spTableContent2.setViewportView(tbTableContent2);

        pnDetails1.add(spTableContent2, java.awt.BorderLayout.CENTER);

        pnSecondDatabase.add(pnDetails1, java.awt.BorderLayout.CENTER);

        pnMain.add(pnSecondDatabase);

        getContentPane().add(pnMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void onCompareData(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCompareData
        progressBarLoader = "compare";
        task = new Task(evt, this);
        task.execute();
    }//GEN-LAST:event_onCompareData

    private void onDownloadData(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onDownloadData
        try {
            if (!btDownloadData.getText().equals(downloadButtonText)) {
                String pathNew = "";
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
                fileChooser.setDialogTitle("Choose directory to save XML-file");
                FileNameExtensionFilter filter = new FileNameExtensionFilter(".xml file", "xml");
                fileChooser.setFileFilter(filter);
                int userSelection = fileChooser.showSaveDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    downloadedFile = fileChooser.getSelectedFile();
                    if (!downloadedFile.getPath().endsWith(".xml")) {
                        pathNew = downloadedFile.getPath().concat(".xml");
                        downloadedFile = new File(pathNew);
                    }
                    if(downloadedFile.getPath().endsWith(".xml"))
                    {
                        pathNew = downloadedFile.getPath().substring(0, (downloadedFile.getPath().length()-3)).concat(".xml");
                        downloadedFile = new File(pathNew);
                    }
                    bl.downloadDifferencesAsXML(pathNew);
                    Desktop.getDesktop().open(downloadedFile);
                    btDownloadData.setText(this.downloadButtonText);
                }
            } else {
                Desktop.getDesktop().open(downloadedFile);
            }
        } catch (Exception ec) {
            System.out.println("Main Window : onDownloadData : " + ec.toString());
        }
    }//GEN-LAST:event_onDownloadData

    private void onExtractDatas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onExtractDatas
        progressBarLoader = "extract";
        task = new Task(evt, this);
        task.execute();
        //task.doInBackground();
        TableRenderer.newColsLeft.clear();
        TableRenderer.newColsRight.clear();
        TableRenderer.newRowLeft.clear();
        TableRenderer.newRowRight.clear();
        TableRenderer.newCellsLeft.clear();
        TableRenderer.newCellsRight.clear();
        tbTableContent1.repaint();
        tbTableContent2.repaint();
    }//GEN-LAST:event_onExtractDatas
    private void onViewFileTXT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onViewFileTXT
        try {
            String openFileLeftOrRight = evt.getActionCommand();
            if (Integer.parseInt(openFileLeftOrRight) == 1) {
                if (existingData) {
                    Desktop.getDesktop().open(existingFile1);
                } else {
                    Desktop.getDesktop().open(savedFile1);
                }
            } else if (Integer.parseInt(openFileLeftOrRight) == 2) {
                if (existingData) {
                    Desktop.getDesktop().open(existingFile2);
                } else {
                    Desktop.getDesktop().open(savedFile2);
                }
            }
        } catch (Exception e) {
            System.out.println("Main Window : openDatabaseFile : " + e.toString());
        }
    }//GEN-LAST:event_onViewFileTXT
    private void onTableDisplayOption(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onTableDisplayOption
        switch (evt.getActionCommand()) {
            case "1":
                automaticallySelectingTables = false;
                break;
            case "2":
                automaticallySelectingTables = true;
                break;
            default:
                break;
        }
    }//GEN-LAST:event_onTableDisplayOption
    private void onSelectTableItemLeft(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onSelectTableItemLeft
        if (enableItemSelect1) {
            leftList = true;
            newDataL = false;
            newDataR = false;
            counter = 0;
            onNewSelectedItem();
        }
    }//GEN-LAST:event_onSelectTableItemLeft
    private void onSelectTableItemRight(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onSelectTableItemRight
        if (enableItemSelect2) {
            leftList = false;
            newDataL = false;
            newDataR = false;
            counter = 0;
            onNewSelectedItem();
        }
    }//GEN-LAST:event_onSelectTableItemRight

    private void onFilter1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onFilter1
        try {
            liSaveListLeft = (LinkedList<Table>) liTablesLeft.clone();
            TableDialogue.selectedList = "left";
            Collections.sort(liSaveListLeft);
            TableDialogue td = new TableDialogue(this, true);
            td.setLiAllTables(liTablesLeft);
            td.setVisible(true);
            if (td.isOK()) {
                if (rbTableBothAuto.isSelected()) {
                    if (!liTablesRight.isEmpty()) {
                        Collections.sort(liTablesRight);
                        liSaveListRight = (LinkedList<Table>) liTablesRight.clone();
                        liTablesRight = (LinkedList<Table>) TableDialogue.selectedTables.clone();
                        liTablesC.setModel(new TableNamesLM(liTablesRight));
                        liTablesC.setSelectedIndex(0);
                        automaticallySelectingTables = true;
                    }
                }
                liTablesLeft = (LinkedList<Table>) TableDialogue.selectedTables.clone();
                Collections.sort(liTablesLeft);
                liTables1.setModel(new TableNamesLM(liTablesLeft));
                liTables1.setSelectedIndex(0);
                leftList = true;
                counter = 0;
                onNewSelectedItem();
            } else {
                return;
            }
        } catch (Exception ex) {
            System.out.println("Main Window : onFilterTables1 : " + ex.toString());
        }
    }//GEN-LAST:event_onFilter1

    private void onFilterC(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onFilterC
        try {
            liSaveListRight = (LinkedList<Table>) liTablesRight.clone();
            TableDialogue.selectedList = "right";
            Collections.sort(liSaveListRight);
            TableDialogue td = new TableDialogue(this, true);
            td.setLiAllTables(liTablesRight);
            td.setVisible(true);
            counter = 0;
            if (td.isOK()) {
                if (rbTableBothAuto.isSelected()) {
                    if (!liTablesLeft.isEmpty()) {
                        liSaveListLeft = (LinkedList<Table>) liTablesLeft.clone();
                        liTablesLeft = (LinkedList<Table>) TableDialogue.selectedTables.clone();
                        Collections.sort(liTablesLeft);
                        liTables1.setModel(new TableNamesLM(liTablesLeft));
                        liTables1.setSelectedIndex(0);
                        leftList = true;
                        automaticallySelectingTables = true;
                    }
                }
                liTablesRight = (LinkedList<Table>) TableDialogue.selectedTables.clone();
                Collections.sort(liTablesRight);
                liTablesC.setModel(new TableNamesLM(liTablesRight));
                liTablesC.setSelectedIndex(0);
                onNewSelectedItem();
            } else {
                return;
            }
        } catch (Exception ex) {
            System.out.println("Main Window : onFilterTablesC : " + ex.toString());
        }
    }//GEN-LAST:event_onFilterC

    private void onRemove1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onRemove1
        try {
            if (liTablesLeft.size() > 0) {
                liTablesLeft = (LinkedList<Table>) liSaveListLeft.clone();
                counter = 0;
                leftList = true;
                if (rbTableBothAuto.isSelected()) {
                    if (!liTablesRight.isEmpty()) {
                        liTablesRight = (LinkedList<Table>) liSaveListRight.clone();
                        Collections.sort(liTablesRight);
                        liTablesC.setModel(new TableNamesLM(liTablesRight));
                        automaticallySelectingTables = true;
                    }
                }
                Collections.sort(liTablesLeft);
                liTables1.setModel(new TableNamesLM(liTablesLeft));
                liTables1.setSelectedIndex(0);
                onNewSelectedItem();
            }
        } catch (Exception ex) {
            System.out.println("Main Window : onRemoveFilter1 : " + ex.toString());
        }
    }//GEN-LAST:event_onRemove1

    private void onViewFileHTML(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onViewFileHTML
        int viewFileLeftOrRight = Integer.parseInt(evt.getActionCommand());
        try {
            viewFileLeftOrRight = Integer.parseInt(evt.getActionCommand());
            if (viewFileLeftOrRight == 1) {
                if (newHTMLFile1 == null) 
                {
                    newHTMLFile1 = saveHTMLFile();
                    
                    if (newHTMLFile1 != null) 
                    {
                        bl.viewDatabaseFileHTML(databaseName1, liTablesLeft, newHTMLFile1);
                    }
                }
                Desktop.getDesktop().browse(newHTMLFile1.toURI());
                
            } 
            else {
                if (newHTMLFile2 == null) {
                    newHTMLFile2 = saveHTMLFile();
                    if (newHTMLFile2 != null) {
                        bl.viewDatabaseFileHTML(databaseName2, liTablesRight, newHTMLFile2);
                    }
                }
                Desktop.getDesktop().browse(newHTMLFile2.toURI());
            }
        } 
        catch(Exception ex)
        {
            if(ex instanceof IOException || ex instanceof FileNotFoundException)
            {
                JOptionPane.showMessageDialog(this, "Error - saving .html file has failed.");
                if (viewFileLeftOrRight == 1) 
                {
                    newHTMLFile1 = null;
                }
                else
                {
                    newHTMLFile2 = null;
                }
            }
        }
    }//GEN-LAST:event_onViewFileHTML

    private void onRemoveC(java.awt.event.ActionEvent evt) {
        try {
            if (liTablesRight.size() > 0) {
                liTablesRight = (LinkedList<Table>) liSaveListRight.clone();
                counter = 0;
                leftList = false;
                if (rbTableBothAuto.isSelected()) {
                    if (!liTablesLeft.isEmpty()) {
                        liTablesLeft = (LinkedList<Table>) liSaveListLeft.clone();
                        Collections.sort(liTablesLeft);
                        liTables1.setModel(new TableNamesLM(liTablesLeft));
                        automaticallySelectingTables = true;
                    }
                }
                Collections.sort(liTablesRight);
                liTablesC.setModel(new TableNamesLM(liTablesRight));
                liTablesC.setSelectedIndex(0);
                onNewSelectedItem();
            }
        } catch (Exception ex) {
            System.out.println("Main Window : onRemoveFilter1 : " + ex.toString());
        }
    }

    /**
     * The aim of this method is to find i suitable place where the HTML file is
     * going to get saved and where to load it from.
     *
     * @return File
     */
    public File saveHTMLFile()  
    {
        File f = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
        chooser.setDialogTitle("Choose directory to save HTML file");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".html file", "html");
        chooser.setFileFilter(filter);
        int userSelection = chooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) 
        {
            f = chooser.getSelectedFile();
            if (!f.getPath().endsWith(".html")) 
            {
                String pathNew = f.getPath().concat(".html");
                f = new File(pathNew);
            }
            return f;
            
        }
        return f;
    }

    /**
     * This method is called at the onExtraxtDatas Method, which task is it to
     * extract the data either from an existing file (.txt file) or to read the
     * datas from the databse.
     *
     * @param newFile
     * @throws Exception
     */
    private void extractData1(boolean newFile, LinkedList<String> liAllSelectedTables) throws Exception {
        counter = 0;
        newDataL = true;
        liTables1.removeAll();
        liTablesLeft.clear();
        if (newFile) {
            LinkedList<Table> helpList = new LinkedList<>();
            helpList = (LinkedList<Table>) dba.getSpecificTables(liAllSelectedTables, helpList).clone();
            liTablesLeft = (LinkedList<Table>) helpList.clone();
            dba.getSpecificTables(liAllSelectedTables, helpList).clear();
        } else {
            LinkedList<Table> helpList = bl.loadData(existingFile1);
            liTablesLeft = (LinkedList<Table>) helpList.clone();
            databaseName1 = bl.getDatabaseName();
            lbDatabaseName1.setText(databaseName1);
        }
        Collections.sort(liTablesLeft);
        tnlmLeft = new TableNamesLM(liTablesLeft);
        liTables1.setModel(tnlmLeft);
        leftList = true;
        onNewSelectedItem();
        btOpenDBFile1.setEnabled(false);

    }

    /**
     * This method is called at the onExtraxtDatas Method, which task is it to
     * extract the data either from an existing file (.txt file) or to read the
     * datas from the databse.
     *
     * @param newFile
     * @throws Exception
     */
    private void extractData2(boolean newFile, LinkedList<String> liAllSelectedTables) throws Exception {
        counter = 0;
        newDataR = true;
        liTablesC.removeAll();
        liTablesRight.clear();
        if (newFile) {
            LinkedList<Table> helpList = new LinkedList<>();
            helpList = (LinkedList<Table>) dba.getSpecificTables(liAllSelectedTables, helpList).clone();
            liTablesRight = (LinkedList<Table>) helpList.clone();
            dba.getSpecificTables(liAllSelectedTables, helpList).clear();
        } else {
            LinkedList<Table> helpList = bl.loadData(existingFile2);
            liTablesRight = (LinkedList<Table>) helpList.clone();
            databaseName2 = bl.getDatabaseName();
            lbDatabaseName2.setText(databaseName2);
        }
        Collections.sort(liTablesRight);
        tnlmRight = new TableNamesLM(liTablesRight);
        liTablesC.setModel(tnlmRight);
        leftList = false;
        onNewSelectedItem();
        btOpenDBFile2.setEnabled(false);
    }

    /**
     * Because of this method we are able to select the first value at the shown
     * lists automatically after the loading. Additionally it shows the values
     * of the selected table.
     */
    private void onNewSelectedItem() {
        if (counter == 0) {
            if (automaticallySelectingTables) {
                int count = 0;
                if (leftList) {
                    indexOfSelectedTable = this.liTables1.getSelectedIndex();
                    Table tL = liTablesLeft.get(indexOfSelectedTable);
                    TableRenderer.selectedTable = tL.getTableName();
                    if (!liTablesRight.isEmpty()) {
                        for (int i = 0; i < liTablesRight.size(); i++) {
                            Table tR = liTablesRight.get(i);
                            if (tR.getTableName().equals(tL.getTableName())) {
                                count++;
                                tctmL = new TableContentTM(tL.getColumnNames(), tL.getAttributes());
                                tctmR = new TableContentTM(tR.getColumnNames(), tR.getAttributes());
                                tbTableContent1.setModel(tctmL);
                                this.liTablesC.setSelectedIndex(i);
                                tbTableContent2.setModel(tctmR);
                            }
                        }
                    }
                } else {
                    int index = this.liTablesC.getSelectedIndex();
                    Table tR = liTablesRight.get(index);
                    TableRenderer.selectedTable = tR.getTableName();
                    if (!liTablesLeft.isEmpty()) {
                        for (int i = 0; i < liTablesLeft.size(); i++) {

                            Table tL = liTablesLeft.get(i);
                            if (tL.getTableName().equals(tR.getTableName())) {
                                count++;
                                tctmL = new TableContentTM(tL.getColumnNames(), tL.getAttributes());
                                tctmR = new TableContentTM(tR.getColumnNames(), tR.getAttributes());
                                tbTableContent2.setModel(tctmR);
                                this.liTables1.setSelectedIndex(i);
                                tbTableContent1.setModel(tctmL);
                            }
                        }
                    }
                }
            } else {
                if (newDataL) {
                    Table t = liTablesLeft.get(0);
                    TableRenderer.selectedTable = t.getTableName();
                    tbTableContent1.setModel(new TableContentTM(t.getColumnNames(), t.getAttributes()));
                    newDataL = false;
                    counter = -1;
                } else if (newDataR) {
                    Table table = liTablesRight.get(0);
                    TableRenderer.selectedTable = table.getTableName();
                    tbTableContent2.setModel(new TableContentTM(table.getColumnNames(), table.getAttributes()));
                    newDataR = false;
                    counter = -1;
                } else {
                    if (leftList) {
                        Table table1 = (Table) this.liTables1.getSelectedValue();
                        TableRenderer.selectedTable = table1.getTableName();
                        tctmL = new TableContentTM(table1.getColumnNames(), table1.getAttributes());
                        tbTableContent1.setModel(tctmL);

                    } else {
                        Table table2 = (Table) this.liTablesC.getSelectedValue();
                        TableRenderer.selectedTable = table2.getTableName();
                        tctmR = new TableContentTM(table2.getColumnNames(), table2.getAttributes());
                        tbTableContent2.setModel(tctmR);
                    }
                }
            }
        }
        counter = -1;
    }

    class Task extends SwingWorker<Void, Void> {

        private java.awt.event.ActionEvent evt;
        MainWindow mw;

        public Task(java.awt.event.ActionEvent evt, MainWindow mw) {
            this.evt = evt;
            this.mw = mw;
        }

        @Override
        public Void doInBackground() {
            if (progressBarLoader.equals("extract")) {
                extractData();
            } else if (progressBarLoader.equals("compare")) {
                compareData();
            }

            return null;
        }}

        private void compareData() {
            pbLoad.setValue(0);
            pbLoad.setVisible(true);
            pbLoad.setIndeterminate(false);
            DataSelectionModesDialogue selectDialogue = new DataSelectionModesDialogue(null, true);
            selectDialogue.setLabelText("     " + databaseName1 + "  -  " + databaseName2);
            selectDialogue.setLiAllEqualTables(bl.getEqualTables(liSaveListLeft, liSaveListRight));
            selectDialogue.setVisible(true);

             try {
            if (selectDialogue.isOK()) {

                if (selectDialogue.isEntireDB()) {
                    bl.compareDatabases(databaseName1, databaseName2, liSaveListLeft, liSaveListRight, mw);
                } else if (selectDialogue.tableOK) {
                    LinkedList<Table> allEqualTables = (LinkedList<Table>) TableDialogue.selectedTables.clone();
                    LinkedList<Table> liLeft = new LinkedList<>();
                    LinkedList<Table> liRight = new LinkedList<>();

                    for (Table tL : allEqualTables) {
                        for (Table tLTemp : liTablesLeft) {
                            if (tL.getTableName().equals(tLTemp.getTableName())) {
                                liLeft.add(tLTemp);
                            }
                        }
                    }
                    for (Table tR : allEqualTables) {
                        for (Table tRTemp : liTablesRight) {
                            if (tR.getTableName().equals(tRTemp.getTableName())) {
                                liRight.add(tRTemp);
                            }
                        }
                    }
                    bl.compareDatabases(databaseName1, databaseName2, liLeft, liRight, mw);
                }               
                if (bl.differencesOccuring()) {
                    btDownloadData.setText("Download Comparison Output as .xml file");
                    rbTableBothAuto.setSelected(true);
                    automaticallySelectingTables = true;
                    downloadEnabled = true;
                    String actTable = bl.getTableofFirstDiff();
                    TableRenderer.selectedTable = actTable;
                    int index = 0;
                    for (Table t : liTablesLeft) {
                        if (t.getTableName().equals(actTable)) {
                            index = liTablesLeft.indexOf(t);
                            liTables1.setSelectedIndex(index);
                            break;
                        }
                    }
                    leftList = true;
                    counter = 0;
                    onNewSelectedItem();
                    if (downloadEnabled) {
                        btDownloadData.setEnabled(true);
                    } else {
                        btDownloadData.setEnabled(false);
                    }
                    enableCompareButton1 = false;
                    enableCompareButton2 = false;
                    TableRenderer.newColsLeft = bl.getAllNewColsLeft();
                    TableRenderer.newColsRight = bl.getAllNewColsRight();
                    TableRenderer.newRowLeft = bl.getAllNewRowsLeft();
                    TableRenderer.newRowRight = bl.getAllNewRowsRight();
                    TableRenderer.newCellsLeft = bl.getAllNewCellsLeft();
                    TableRenderer.newCellsRight = bl.getAllNewCellsRight();
                    tbTableContent1.repaint();
                    tbTableContent2.repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "There is no difference occuring");
                }
                pbLoad.setVisible(false);
            }

        } catch (Exception e) {
            System.out.println("Main Window : onCompareData : " + e.toString() + "\n");
            pbLoad.setVisible(false);
        }
            pbLoad.setVisible(false);
        }

        private void extractData() 
        {
            dataExtractDialogue = null;
            String selectedDB = "";
            try {
                extractData = Integer.parseInt(evt.getActionCommand());
                int count = 0;
                bl.clearCompareOutputLists();
                rbTableSeperate.setSelected(true);
                automaticallySelectingTables = false;
                dataExtractDialogue = new DataExtractModeDialogue(null, true);
                dataExtractDialogue.setDataExctractActionCommand(extractData);
                dataExtractDialogue.setVisible(true);

                System.out.println("extract dialogue okee "+dataExtractDialogue.isOK); 
                System.out.println("conn dialog is okee "+dataExtractDialogue.newFile);
                
                if (dataExtractDialogue.isExistingFile() && dataExtractDialogue.isOK) {
                    existingData = true;
                    pbLoad.setVisible(true);
                    pbLoad.setIndeterminate(false);
                    pbLoad.setValue(10);
                    pbLoad.setStringPainted(false);
                    if (extractData == 1) {
                        pbLoad.setValue(20);
                        existingFile1 = dataExtractDialogue.getSelectedDBDump();
                        pbLoad.setValue(50);
                        savedFile1 = null;
                        extractData1(false, nullValue);
                        enableCompareButton1 = true;
                        btOpenDBFile1.setEnabled(true);
                        btOpenHTMLFile1.setEnabled(true);
                        enableItemSelect1 = true;
                        pbLoad.setValue(75);
                    } else if (extractData == 2) {
                        pbLoad.setValue(20);
                        existingFile2 = dataExtractDialogue.getSelectedDBDump();
                        pbLoad.setValue(50);
                        savedFile2 = null;
                        extractData2(false, nullValue);
                        enableCompareButton2 = true;
                        btOpenDBFile2.setEnabled(true);
                        btOpenHTMLFile2.setEnabled(true);
                        enableItemSelect2 = true;
                        pbLoad.setValue(75);
                    }
                    pbLoad.setValue(80);
                    onNewSelectedItem();
                    pbLoad.setValue(90);
                } 
                else if (dataExtractDialogue.isOK && dataExtractDialogue.newFile) 
                {
                    newPartTable = true;
                    existingData = false;
                    System.out.println("in extract data in main window");
                    selectedDB = DatabaseConnectionDialogue.selectedDB;
                    DataSelectionModesDialogue dsmd = new DataSelectionModesDialogue(null, true);
                    dsmd.setAlwaysOnTop(true);
                    TableDialogue td = new TableDialogue(null, true);
                    dba = DBAccess.getTheInstance();
                    td.setLiAllTableNames(dba.getAllTableNames());

                    if (dataExtractDialogue.getFinalDatabaseName().startsWith("1")) {
                        databaseName1 = dataExtractDialogue.getFinalDatabaseName().substring(1);
                        dsmd.setLabelText("  " + databaseName1);
                    } else {
                        databaseName2 = dataExtractDialogue.getFinalDatabaseName().substring(1);
                        dsmd.setLabelText("  " + databaseName2);
                    }
                    dsmd.setVisible(true);
                    if (dsmd.isOK()) {
                        pbLoad.setVisible(true);
                        pbLoad.setIndeterminate(false);
                        pbLoad.setValue(0);
                        pbLoad.setStringPainted(false);
                        count = 1;
                        pbLoad.setValue(5);
                        if (count != 0) {
                            if (dsmd.isEntireDB()) {
                                if (extractData == 1) {
                                    extractData1(true, dba.getAllTableNames());
                                    pbLoad.setValue(75);
                                } else {
                                    extractData2(true, dba.getAllTableNames());
                                    pbLoad.setValue(75);
                                }
                            } else {
                                if (extractData == 1) {
                                    extractData1(true, td.liSelectedTableNames);
                                    pbLoad.setValue(75);
                                } else {
                                    extractData2(true, td.liSelectedTableNames);
                                    pbLoad.setValue(75);
                                }
                            }
                            //set database name on each label
                            if (dataExtractDialogue.getFinalDatabaseName().startsWith("1")) {
                                databaseName1 = dataExtractDialogue.getFinalDatabaseName().substring(1);
                                lbDatabaseName1.setText(databaseName1);
                            } else {
                                databaseName2 = dataExtractDialogue.getFinalDatabaseName().substring(1);
                                lbDatabaseName2.setText(databaseName2);
                            }
                            pbLoad.setValue(80);
                            int i = JOptionPane.showConfirmDialog(null, "Do you want to save the Database Extract as file?", "Save Database Extract", JOptionPane.YES_NO_OPTION);
                            if (i == JOptionPane.OK_OPTION) {
                                JFileChooser fileChooser = new JFileChooser();
                                fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
                                fileChooser.setDialogTitle("Choose directory to save Database file");
                                FileNameExtensionFilter filter = new FileNameExtensionFilter("Database .txt file", "txt");
                                fileChooser.setFileFilter(filter);
                                int userSelection = fileChooser.showSaveDialog(null);
                                if (userSelection == JFileChooser.APPROVE_OPTION) {
                                    File f = fileChooser.getSelectedFile();
                                    if (!f.getPath().endsWith(".txt")) {
                                        String pathNew = f.getPath() + ".txt";
                                        f = new File(pathNew);
                                    }
                                    if (extractData == 1) {
                                        pbLoad.setValue(80);
                                        savedFile1 = f;
                                        existingFile1 = null;
                                        bl.saveDatabaseFile(f, liTablesLeft, databaseName1);
                                        pbLoad.setValue(85);
                                        btOpenDBFile1.setEnabled(true);
                                        btOpenHTMLFile1.setEnabled(true);
                                        enableCompareButton1 = true;
                                        enableItemSelect1 = true;

                                    } else {
                                        pbLoad.setValue(80);
                                        savedFile2 = f;
                                        existingFile2 = null;
                                        bl.saveDatabaseFile(f, liTablesRight, databaseName2);
                                        pbLoad.setValue(85);
                                        btOpenDBFile2.setEnabled(true);
                                        btOpenHTMLFile2.setEnabled(true);
                                        enableCompareButton2 = true;
                                        enableItemSelect2 = true;
                                    }
                                }
                                pbLoad.setValue(90);
                            } else {

                                if (extractData == 1) {
                                    existingFile1 = null;
                                    enableCompareButton1 = true;
                                    btOpenDBFile1.setEnabled(false);
                                    btOpenHTMLFile1.setEnabled(true);
                                    enableItemSelect1 = true;
                                }
                                if (extractData == 2) {
                                    existingFile2 = null;
                                    btOpenDBFile2.setEnabled(false);
                                    enableCompareButton2 = true;
                                    btOpenHTMLFile2.setEnabled(true);
                                    enableItemSelect2 = true;
                                }
                                pbLoad.setValue(100);
                            }
                        }
                    }
                    if (enableCompareButton1 && enableCompareButton2) {
                        btCompareData.setEnabled(true);
                    }
                }
                liSaveListLeft = (LinkedList<Table>) liTablesLeft.clone();
                liSaveListRight = (LinkedList<Table>) liTablesRight.clone();
                pbLoad.setValue(100);
                pbLoad.setVisible(false);
            }catch (IOException ex) {
                System.out.println("Main Window : extractData : " + ex.toString());
                pbLoad.setVisible(false);
            } catch (SQLException ex) {
                System.out.println("Main Window : extractData : " + ex.toString());
                pbLoad.setVisible(false);
            } catch (NullPointerException ex) 
            {
                String output = "<html><font size='4'><b>Database connection could not be established.</b></font><br><font size='3'>Hint: Check username, password or database name.</font></html>";
                JOptionPane.showMessageDialog(null, output);
                dataExtractDialogue.setIsOK(true);
                dataExtractDialogue.newDatabaseConnDialogue(DBConnectionPool.DB_USER, DBConnectionPool.DB_PASSWD, selectedDB, DBConnectionPool.DB_URL, DBConnectionPool.DB_NAME, DBConnectionPool.DB_DRIVER);
                afterConnFailed();
                pbLoad.setVisible(false);
            } catch (IndexOutOfBoundsException ex) {
                String output = "<html><font size='4'>Please choose a compatible txt file.</font></html>";
                JOptionPane.showMessageDialog(null, output);
                pbLoad.setVisible(false);
            } catch (Exception ex) {
                System.out.println("Main Window : extractData : " + ex.toString());
                pbLoad.setVisible(false);
            }

            newPartTable = false;
            pbLoad.setVisible(false);
        }

    public void afterConnFailed()
    {
         String selectedDB = "";
        try
        {
           
            int count = 0;
                bl.clearCompareOutputLists();
                rbTableSeperate.setSelected(true);
                automaticallySelectingTables = false;
        if (dataExtractDialogue.isOK && dataExtractDialogue.newFile) 
                {
                    newPartTable = true;
                    existingData = false;
                    System.out.println("in extract data in main window");
                    selectedDB = DatabaseConnectionDialogue.selectedDB;
                    DataSelectionModesDialogue dsmd = new DataSelectionModesDialogue(null, true);
                    dsmd.setAlwaysOnTop(true);
                    TableDialogue td = new TableDialogue(null, true);
                    dba = DBAccess.getTheInstance();
                    td.setLiAllTableNames(dba.getAllTableNames());

                    if (dataExtractDialogue.getFinalDatabaseName().startsWith("1")) {
                        databaseName1 = dataExtractDialogue.getFinalDatabaseName().substring(1);
                        dsmd.setLabelText("  " + databaseName1);
                    } else {
                        databaseName2 = dataExtractDialogue.getFinalDatabaseName().substring(1);
                        dsmd.setLabelText("  " + databaseName2);
                    }
                    dsmd.setVisible(true);
                    if (dsmd.isOK()) {
                        pbLoad.setVisible(true);
                        pbLoad.setIndeterminate(false);
                        pbLoad.setValue(0);
                        pbLoad.setStringPainted(false);
                        count = 1;
                        pbLoad.setValue(5);
                        if (count != 0) {
                            if (dsmd.isEntireDB()) {
                                if (extractData == 1) {
                                    extractData1(true, dba.getAllTableNames());
                                    pbLoad.setValue(75);
                                } else {
                                    extractData2(true, dba.getAllTableNames());
                                    pbLoad.setValue(75);
                                }
                            } else {
                                if (extractData == 1) {
                                    extractData1(true, td.liSelectedTableNames);
                                    pbLoad.setValue(75);
                                } else {
                                    extractData2(true, td.liSelectedTableNames);
                                    pbLoad.setValue(75);
                                }
                            }
                            //set database name on each label
                            if (dataExtractDialogue.getFinalDatabaseName().startsWith("1")) {
                                databaseName1 = dataExtractDialogue.getFinalDatabaseName().substring(1);
                                lbDatabaseName1.setText(databaseName1);
                            } else {
                                databaseName2 = dataExtractDialogue.getFinalDatabaseName().substring(1);
                                lbDatabaseName2.setText(databaseName2);
                            }
                            pbLoad.setValue(80);
                            int i = JOptionPane.showConfirmDialog(null, "Do you want to save the Database Extract as file?", "Save Database Extract", JOptionPane.YES_NO_OPTION);
                            if (i == JOptionPane.OK_OPTION) {
                                JFileChooser fileChooser = new JFileChooser();
                                fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
                                fileChooser.setDialogTitle("Choose directory to save Database file");
                                FileNameExtensionFilter filter = new FileNameExtensionFilter("Database .txt file", "txt");
                                fileChooser.setFileFilter(filter);
                                int userSelection = fileChooser.showSaveDialog(null);
                                if (userSelection == JFileChooser.APPROVE_OPTION) {
                                    File f = fileChooser.getSelectedFile();
                                    if (!f.getPath().endsWith(".txt")) {
                                        String pathNew = f.getPath() + ".txt";
                                        f = new File(pathNew);
                                    }
                                    if (extractData == 1) {
                                        pbLoad.setValue(80);
                                        savedFile1 = f;
                                        existingFile1 = null;
                                        bl.saveDatabaseFile(f, liTablesLeft, databaseName1);
                                        pbLoad.setValue(85);
                                        btOpenDBFile1.setEnabled(true);
                                        btOpenHTMLFile1.setEnabled(true);
                                        enableCompareButton1 = true;
                                        enableItemSelect1 = true;

                                    } else {
                                        pbLoad.setValue(80);
                                        savedFile2 = f;
                                        existingFile2 = null;
                                        bl.saveDatabaseFile(f, liTablesRight, databaseName2);
                                        pbLoad.setValue(85);
                                        btOpenDBFile2.setEnabled(true);
                                        btOpenHTMLFile2.setEnabled(true);
                                        enableCompareButton2 = true;
                                        enableItemSelect2 = true;
                                    }
                                }
                                pbLoad.setValue(90);
                            } else {

                                if (extractData == 1) {
                                    existingFile1 = null;
                                    enableCompareButton1 = true;
                                    btOpenDBFile1.setEnabled(false);
                                    btOpenHTMLFile1.setEnabled(true);
                                    enableItemSelect1 = true;
                                }
                                if (extractData == 2) {
                                    existingFile2 = null;
                                    btOpenDBFile2.setEnabled(false);
                                    enableCompareButton2 = true;
                                    btOpenHTMLFile2.setEnabled(true);
                                    enableItemSelect2 = true;
                                }
                                pbLoad.setValue(100);
                            }
                        }
                    }
                    if (enableCompareButton1 && enableCompareButton2) {
                        btCompareData.setEnabled(true);
                    }
                }
                liSaveListLeft = (LinkedList<Table>) liTablesLeft.clone();
                liSaveListRight = (LinkedList<Table>) liTablesRight.clone();
                pbLoad.setValue(100);
                pbLoad.setVisible(false);
            }catch (IOException ex) {
                System.out.println("Main Window : extractData : " + ex.toString());
                pbLoad.setVisible(false);
            } catch (SQLException ex) {
                System.out.println("Main Window : extractData : " + ex.toString());
                pbLoad.setVisible(false);
            } catch (NullPointerException ex) 
            {
                String output = "<html><font size='4'><b>Database connection could not be established.</b></font><br><font size='3'>Hint: Check username, password or database name.</font></html>";
                JOptionPane.showMessageDialog(null, output);
                dataExtractDialogue.setIsOK(true);
                dataExtractDialogue.newDatabaseConnDialogue(DBConnectionPool.DB_USER, DBConnectionPool.DB_PASSWD, selectedDB, DBConnectionPool.DB_URL, DBConnectionPool.DB_NAME, DBConnectionPool.DB_DRIVER);
                afterConnFailed();
                pbLoad.setVisible(false);
            } catch (IndexOutOfBoundsException ex) {
                String output = "<html><font size='4'>Please choose a compatible txt file.</font></html>";
                JOptionPane.showMessageDialog(null, output);
                pbLoad.setVisible(false);
            } catch (Exception ex) {
                System.out.println("Main Window : extractData : " + ex.toString());
                pbLoad.setVisible(false);
            }

            newPartTable = false;
            pbLoad.setVisible(false);
        
    }
        
    
    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgTableGroup;
    private javax.swing.JButton btCompareData;
    private javax.swing.JButton btDownloadData;
    private javax.swing.JButton btExtractData1;
    private javax.swing.JButton btExtractData2;
    private javax.swing.JButton btOpenDBFile1;
    private javax.swing.JButton btOpenDBFile2;
    private javax.swing.JButton btOpenHTMLFile1;
    private javax.swing.JButton btOpenHTMLFile2;
    private javax.swing.JLabel lbDatabaseName1;
    private javax.swing.JLabel lbDatabaseName2;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbPlaceholder;
    private javax.swing.JLabel lbPlaceholder1;
    private javax.swing.JLabel lbPlaceholder10;
    private javax.swing.JLabel lbPlaceholder11;
    private javax.swing.JLabel lbPlaceholder12;
    private javax.swing.JLabel lbPlaceholder13;
    private javax.swing.JLabel lbPlaceholder14;
    private javax.swing.JLabel lbPlaceholder15;
    private javax.swing.JLabel lbPlaceholder16;
    private javax.swing.JLabel lbPlaceholder2;
    private javax.swing.JLabel lbPlaceholder3;
    private javax.swing.JLabel lbPlaceholder4;
    private javax.swing.JLabel lbPlaceholder5;
    private javax.swing.JLabel lbPlaceholder6;
    private javax.swing.JLabel lbPlaceholder7;
    private javax.swing.JLabel lbPlaceholder9;
    private javax.swing.JLabel lbWhitespace;
    private javax.swing.JLabel lbWhitespace1;
    private javax.swing.JLabel lbWhitespace2;
    private javax.swing.JList liTables1;
    private javax.swing.JList liTablesC;
    private javax.swing.JMenuItem miRemoveFilter;
    private javax.swing.JMenuItem miRemoveFilterC;
    private javax.swing.JMenuItem miSelectTables;
    private javax.swing.JMenuItem miSelectTablesC;
    private javax.swing.JPanel paButton;
    private javax.swing.JPanel paExtractData;
    private javax.swing.JProgressBar pbLoad;
    private javax.swing.JPopupMenu pmSelectTables;
    private javax.swing.JPopupMenu pmSelectTablesC;
    private javax.swing.JPanel pnButton1;
    private javax.swing.JPanel pnButtonToolBar;
    private javax.swing.JPanel pnCompareButton;
    private javax.swing.JPanel pnDetails;
    private javax.swing.JPanel pnDetails1;
    private javax.swing.JPanel pnDownLeft;
    private javax.swing.JPanel pnDownRight;
    private javax.swing.JPanel pnDownloadButton;
    private javax.swing.JPanel pnExtractData;
    private javax.swing.JPanel pnFirstDatabase;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnProgressBarDate;
    private javax.swing.JPanel pnRadioButtonsTable;
    private javax.swing.JPanel pnSecondDatabase;
    private javax.swing.JPanel pnShowAllTables1;
    private javax.swing.JPanel pnShowAllTables2;
    private javax.swing.JPanel pnTableDisplayOptions;
    private javax.swing.JPanel pnViewButtons;
    private javax.swing.JPanel pnViewButtons2;
    private javax.swing.JRadioButton rbTableBothAuto;
    private javax.swing.JRadioButton rbTableSeperate;
    private javax.swing.JScrollPane spTable1;
    private javax.swing.JScrollPane spTableC;
    private javax.swing.JScrollPane spTableContent1;
    private javax.swing.JScrollPane spTableContent2;
    private javax.swing.JTable tbTableContent1;
    private javax.swing.JTable tbTableContent2;
    // End of variables declaration//GEN-END:variables
}
