package gui;

import database.DBConnectionPool;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DataExtractModeDialogue extends javax.swing.JDialog {

    public boolean isOK = false;
    public boolean newFile = false;
    public File selectedDBDump;
    public boolean existingFile = false;
    private int dataExtractActionCommand = 0;
    private String finalDatabaseName = "";
    private DatabaseConnectionDialogue connectionDialogue;

    public DataExtractModeDialogue(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(MainWindow.backgroundColorPanel);
        this.btOK.setBackground(MainWindow.backgroundColorButton);
        this.setSize(380, 250);
        this.setResizable(false);
        setLocationRelativeTo(parent);
        this.setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgDatabase = new javax.swing.ButtonGroup();
        lbText = new javax.swing.JLabel();
        pnExistingFile = new javax.swing.JPanel();
        rbExistingDBFile = new javax.swing.JRadioButton();
        lbPlaceholder1 = new javax.swing.JLabel();
        pnNewFile = new javax.swing.JPanel();
        rbNewDBFile = new javax.swing.JRadioButton();
        lbPlaceholder4 = new javax.swing.JLabel();
        pnButton = new javax.swing.JPanel();
        btOK = new javax.swing.JButton();
        lbPlaceholder2 = new javax.swing.JLabel();
        lbPlaceholder5 = new javax.swing.JLabel();
        lbPlaceholder7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 230, 201));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(255, 230, 201));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        lbText.setBackground(new java.awt.Color(229, 229, 229));
        lbText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbText.setText("Choose Data Extract Mode");
        lbText.setOpaque(true);
        getContentPane().add(lbText);

        pnExistingFile.setBackground(new java.awt.Color(229, 229, 229));
        pnExistingFile.setLayout(new java.awt.BorderLayout());

        rbExistingDBFile.setBackground(new java.awt.Color(229, 229, 229));
        bgDatabase.add(rbExistingDBFile);
        rbExistingDBFile.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbExistingDBFile.setSelected(true);
        rbExistingDBFile.setText("existing Database file");
        rbExistingDBFile.setToolTipText("");
        rbExistingDBFile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnExistingFile.add(rbExistingDBFile, java.awt.BorderLayout.CENTER);

        lbPlaceholder1.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder1.setForeground(new java.awt.Color(240, 240, 240));
        lbPlaceholder1.setMaximumSize(new java.awt.Dimension(95, 2));
        lbPlaceholder1.setMinimumSize(new java.awt.Dimension(95, 2));
        lbPlaceholder1.setOpaque(true);
        lbPlaceholder1.setPreferredSize(new java.awt.Dimension(95, 2));
        pnExistingFile.add(lbPlaceholder1, java.awt.BorderLayout.LINE_START);

        getContentPane().add(pnExistingFile);

        pnNewFile.setBackground(new java.awt.Color(229, 229, 229));
        pnNewFile.setLayout(new java.awt.BorderLayout());

        rbNewDBFile.setBackground(new java.awt.Color(229, 229, 229));
        bgDatabase.add(rbNewDBFile);
        rbNewDBFile.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbNewDBFile.setText("new Database file");
        rbNewDBFile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnNewFile.add(rbNewDBFile, java.awt.BorderLayout.CENTER);

        lbPlaceholder4.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder4.setForeground(new java.awt.Color(240, 240, 240));
        lbPlaceholder4.setMaximumSize(new java.awt.Dimension(95, 2));
        lbPlaceholder4.setMinimumSize(new java.awt.Dimension(95, 2));
        lbPlaceholder4.setName(""); // NOI18N
        lbPlaceholder4.setOpaque(true);
        lbPlaceholder4.setPreferredSize(new java.awt.Dimension(95, 2));
        pnNewFile.add(lbPlaceholder4, java.awt.BorderLayout.WEST);

        getContentPane().add(pnNewFile);

        pnButton.setBackground(new java.awt.Color(229, 229, 229));
        pnButton.setLayout(new java.awt.BorderLayout(5, 0));

        btOK.setBackground(new java.awt.Color(229, 229, 229));
        btOK.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btOK.setText("OK");
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onOK(evt);
            }
        });
        pnButton.add(btOK, java.awt.BorderLayout.CENTER);

        lbPlaceholder2.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder2.setForeground(new java.awt.Color(240, 240, 240));
        lbPlaceholder2.setMaximumSize(new java.awt.Dimension(130, 20));
        lbPlaceholder2.setMinimumSize(new java.awt.Dimension(130, 20));
        lbPlaceholder2.setOpaque(true);
        lbPlaceholder2.setPreferredSize(new java.awt.Dimension(130, 20));
        pnButton.add(lbPlaceholder2, java.awt.BorderLayout.WEST);

        lbPlaceholder5.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder5.setForeground(new java.awt.Color(240, 240, 240));
        lbPlaceholder5.setMaximumSize(new java.awt.Dimension(130, 20));
        lbPlaceholder5.setMinimumSize(new java.awt.Dimension(130, 20));
        lbPlaceholder5.setName(""); // NOI18N
        lbPlaceholder5.setOpaque(true);
        lbPlaceholder5.setPreferredSize(new java.awt.Dimension(130, 20));
        pnButton.add(lbPlaceholder5, java.awt.BorderLayout.EAST);

        lbPlaceholder7.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder7.setMaximumSize(new java.awt.Dimension(0, 8));
        lbPlaceholder7.setMinimumSize(new java.awt.Dimension(0, 8));
        lbPlaceholder7.setOpaque(true);
        lbPlaceholder7.setPreferredSize(new java.awt.Dimension(0, 8));
        pnButton.add(lbPlaceholder7, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(pnButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void onOK(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onOK
        connectionDialogue = new DatabaseConnectionDialogue(null, true);
        isOK = true;
        if (rbNewDBFile.isSelected()) {
            connectionDialogue.setVisible(true);
            if (connectionDialogue.getNewConn()) {
                newFile = true;
            }
        } else {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose existing Database file");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Database .txt file", "txt");
            fileChooser.setFileFilter(filter);
            int userSelection = fileChooser.showOpenDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                selectedDBDump = fileChooser.getSelectedFile();
                existingFile = true;
                dispose();
            }
        }
        if (connectionDialogue.getNewConn() && isOK) 
        {
            finalDatabaseName = dataExtractActionCommand + connectionDialogue.getDatabaseName();
            dispose();
        } else {
            finalDatabaseName = "";
        }
    }//GEN-LAST:event_onOK

    public void newDatabaseConnDialogue(String user, String pw, String database_provider, String url, String database_name, String driver) {
        connectionDialogue = new DatabaseConnectionDialogue(null, true);
        connectionDialogue.ConnDialogueSetParameters(user, pw, database_provider, url, database_name, driver);
        DBConnectionPool.DB_USER = null;
        DBConnectionPool.DB_PASSWD = null;
        DBConnectionPool.DB_URL = null;
        DBConnectionPool.DB_NAME = null;
        DBConnectionPool.DB_DRIVER = null;
        connectionDialogue.setVisible(true);
        if(connectionDialogue.getNewConn())
        {
            finalDatabaseName = dataExtractActionCommand + connectionDialogue.getDatabaseName();
        }
        dispose();
    }

    public void setIsOK(boolean isOK) {
        this.isOK = isOK;
    }
    
    public File getSelectedDBDump() {
        return selectedDBDump;
    }

    public boolean isExistingFile() {
        return existingFile;
    }

    public void setDataExctractActionCommand(int dataextract) {
        this.dataExtractActionCommand = dataextract;
    }

    public String getFinalDatabaseName() {
        return finalDatabaseName;
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
            java.util.logging.Logger.getLogger(DataExtractModeDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataExtractModeDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataExtractModeDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataExtractModeDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DataExtractModeDialogue dialog = new DataExtractModeDialogue(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgDatabase;
    private javax.swing.JButton btOK;
    private javax.swing.JLabel lbPlaceholder1;
    private javax.swing.JLabel lbPlaceholder2;
    private javax.swing.JLabel lbPlaceholder4;
    private javax.swing.JLabel lbPlaceholder5;
    private javax.swing.JLabel lbPlaceholder7;
    private javax.swing.JLabel lbText;
    private javax.swing.JPanel pnButton;
    private javax.swing.JPanel pnExistingFile;
    private javax.swing.JPanel pnNewFile;
    private javax.swing.JRadioButton rbExistingDBFile;
    private javax.swing.JRadioButton rbNewDBFile;
    // End of variables declaration//GEN-END:variables
}
