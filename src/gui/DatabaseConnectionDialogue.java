package gui;

import database.DBConnectionPool;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DatabaseConnectionDialogue extends javax.swing.JDialog {

    private boolean newConn = false;
    public static File newDBDump;
    public static String selectedDB = "";
    private String databaseName = "";

    public DatabaseConnectionDialogue(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        this.getContentPane().setBackground(MainWindow.backgroundColorPanel);
        btCancel.setBackground(MainWindow.backgroundColorButton);
        btOK.setBackground(MainWindow.backgroundColorButton);
        setLocationRelativeTo(parent);
        selectedDB = "postgres";
        this.setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgGroup1 = new javax.swing.ButtonGroup();
        lbText = new javax.swing.JLabel();
        pnContainer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbUser = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        lbDatabase = new javax.swing.JLabel();
        lbDriver = new javax.swing.JLabel();
        lbCompanyName = new javax.swing.JLabel();
        lbUrlExam = new javax.swing.JLabel();
        lbUrl = new javax.swing.JLabel();
        lbSID = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tfUser = new javax.swing.JTextField();
        tfPassword = new javax.swing.JTextField();
        cbDatabase = new javax.swing.JComboBox();
        tfDriver = new javax.swing.JTextField();
        tfDatabaseName = new javax.swing.JTextField();
        tfUrlExam = new javax.swing.JTextField();
        tfUrl = new javax.swing.JTextField();
        tfSID = new javax.swing.JTextField();
        paButtons = new javax.swing.JPanel();
        btOK = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(450, 500));
        setMinimumSize(new java.awt.Dimension(450, 500));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(450, 500));
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(0, 15));

        lbText.setBackground(new java.awt.Color(229, 229, 229));
        lbText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbText.setText("Create Database Connection");
        lbText.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbText.setMaximumSize(new java.awt.Dimension(150, 40));
        lbText.setMinimumSize(new java.awt.Dimension(150, 40));
        lbText.setOpaque(true);
        lbText.setPreferredSize(new java.awt.Dimension(150, 40));
        getContentPane().add(lbText, java.awt.BorderLayout.PAGE_START);

        pnContainer.setBackground(new java.awt.Color(229, 229, 229));
        pnContainer.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(229, 229, 229));
        jPanel1.setLayout(new java.awt.GridLayout(8, 1, 15, 15));

        lbUser.setBackground(new java.awt.Color(229, 229, 229));
        lbUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbUser.setText("    User:");
        lbUser.setMaximumSize(new java.awt.Dimension(150, 40));
        lbUser.setMinimumSize(new java.awt.Dimension(150, 40));
        lbUser.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel1.add(lbUser);

        lbPassword.setBackground(new java.awt.Color(229, 229, 229));
        lbPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbPassword.setText("    Password: ");
        lbPassword.setMaximumSize(new java.awt.Dimension(150, 40));
        lbPassword.setMinimumSize(new java.awt.Dimension(150, 40));
        lbPassword.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel1.add(lbPassword);

        lbDatabase.setBackground(new java.awt.Color(229, 229, 229));
        lbDatabase.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbDatabase.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDatabase.setText("    Database:");
        lbDatabase.setMaximumSize(new java.awt.Dimension(150, 40));
        lbDatabase.setMinimumSize(new java.awt.Dimension(150, 40));
        lbDatabase.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel1.add(lbDatabase);

        lbDriver.setBackground(new java.awt.Color(229, 229, 229));
        lbDriver.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbDriver.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDriver.setText("    Driver: ");
        lbDriver.setMaximumSize(new java.awt.Dimension(150, 40));
        lbDriver.setMinimumSize(new java.awt.Dimension(150, 40));
        lbDriver.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel1.add(lbDriver);

        lbCompanyName.setBackground(new java.awt.Color(229, 229, 229));
        lbCompanyName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbCompanyName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCompanyName.setText("    Database name:");
        lbCompanyName.setMaximumSize(new java.awt.Dimension(150, 40));
        lbCompanyName.setMinimumSize(new java.awt.Dimension(150, 40));
        lbCompanyName.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel1.add(lbCompanyName);

        lbUrlExam.setBackground(new java.awt.Color(229, 229, 229));
        lbUrlExam.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        lbUrlExam.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbUrlExam.setText("    URL example:");
        lbUrlExam.setMaximumSize(new java.awt.Dimension(150, 40));
        lbUrlExam.setMinimumSize(new java.awt.Dimension(150, 40));
        lbUrlExam.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel1.add(lbUrlExam);

        lbUrl.setBackground(new java.awt.Color(229, 229, 229));
        lbUrl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbUrl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbUrl.setText("    URL:");
        lbUrl.setMaximumSize(new java.awt.Dimension(150, 40));
        lbUrl.setMinimumSize(new java.awt.Dimension(150, 40));
        lbUrl.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel1.add(lbUrl);

        lbSID.setBackground(new java.awt.Color(229, 229, 229));
        lbSID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbSID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSID.setMaximumSize(new java.awt.Dimension(150, 40));
        lbSID.setMinimumSize(new java.awt.Dimension(150, 40));
        lbSID.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel1.add(lbSID);

        pnContainer.add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setBackground(new java.awt.Color(229, 229, 229));
        jPanel2.setLayout(new java.awt.GridLayout(8, 1, 15, 15));

        tfUser.setBackground(new java.awt.Color(229, 229, 229));
        tfUser.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfUser.setMaximumSize(new java.awt.Dimension(150, 40));
        tfUser.setMinimumSize(new java.awt.Dimension(150, 40));
        tfUser.setNextFocusableComponent(tfPassword);
        tfUser.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel2.add(tfUser);

        tfPassword.setBackground(new java.awt.Color(229, 229, 229));
        tfPassword.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfPassword.setMaximumSize(new java.awt.Dimension(150, 40));
        tfPassword.setMinimumSize(new java.awt.Dimension(150, 40));
        tfPassword.setNextFocusableComponent(tfDriver);
        tfPassword.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel2.add(tfPassword);

        cbDatabase.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbDatabase.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Postgres", "Oracle", "MSSQL" }));
        cbDatabase.setNextFocusableComponent(tfDatabaseName);
        cbDatabase.setVerifyInputWhenFocusTarget(false);
        cbDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onNewDriver(evt);
            }
        });
        jPanel2.add(cbDatabase);

        tfDriver.setEditable(false);
        tfDriver.setBackground(new java.awt.Color(229, 229, 229));
        tfDriver.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfDriver.setText("org.postgresql.Driver");
        tfDriver.setToolTipText("");
        tfDriver.setMaximumSize(new java.awt.Dimension(150, 40));
        tfDriver.setMinimumSize(new java.awt.Dimension(150, 40));
        tfDriver.setNextFocusableComponent(cbDatabase);
        tfDriver.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel2.add(tfDriver);

        tfDatabaseName.setBackground(new java.awt.Color(229, 229, 229));
        tfDatabaseName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfDatabaseName.setMaximumSize(new java.awt.Dimension(150, 40));
        tfDatabaseName.setMinimumSize(new java.awt.Dimension(150, 40));
        tfDatabaseName.setNextFocusableComponent(tfUrl);
        tfDatabaseName.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel2.add(tfDatabaseName);

        tfUrlExam.setEditable(false);
        tfUrlExam.setBackground(new java.awt.Color(229, 229, 229));
        tfUrlExam.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        tfUrlExam.setText("jdbc:postgresql://localhost/");
        tfUrlExam.setMaximumSize(new java.awt.Dimension(150, 40));
        tfUrlExam.setMinimumSize(new java.awt.Dimension(150, 40));
        tfUrlExam.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel2.add(tfUrlExam);

        tfUrl.setBackground(new java.awt.Color(229, 229, 229));
        tfUrl.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfUrl.setText("jdbc:postgresql://localhost/");
        tfUrl.setMaximumSize(new java.awt.Dimension(150, 40));
        tfUrl.setMinimumSize(new java.awt.Dimension(150, 40));
        tfUrl.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel2.add(tfUrl);

        tfSID.setEditable(false);
        tfSID.setBackground(new java.awt.Color(229, 229, 229));
        tfSID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfSID.setMaximumSize(new java.awt.Dimension(150, 40));
        tfSID.setMinimumSize(new java.awt.Dimension(150, 40));
        tfSID.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel2.add(tfSID);

        pnContainer.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnContainer, java.awt.BorderLayout.CENTER);

        paButtons.setBackground(new java.awt.Color(229, 229, 229));
        paButtons.setLayout(new java.awt.GridLayout(1, 2, 15, 0));

        btOK.setBackground(new java.awt.Color(229, 229, 229));
        btOK.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btOK.setText("OK");
        btOK.setMaximumSize(new java.awt.Dimension(80, 40));
        btOK.setMinimumSize(new java.awt.Dimension(80, 40));
        btOK.setPreferredSize(new java.awt.Dimension(80, 40));
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onOK(evt);
            }
        });
        paButtons.add(btOK);

        btCancel.setBackground(new java.awt.Color(229, 229, 229));
        btCancel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btCancel.setText("Cancel");
        btCancel.setToolTipText("");
        btCancel.setMaximumSize(new java.awt.Dimension(80, 40));
        btCancel.setMinimumSize(new java.awt.Dimension(80, 40));
        btCancel.setPreferredSize(new java.awt.Dimension(80, 40));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCancel(evt);
            }
        });
        paButtons.add(btCancel);

        getContentPane().add(paButtons, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCancel
        dispose();
    }//GEN-LAST:event_onCancel

    private void onOK(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onOK
        MainWindow.pbExtractData1.setVisible(true);
        newConn = true;
        onNewDriver(evt);
        String user = tfUser.getText().trim();
        String password = tfPassword.getText().trim();
        String uRL = tfUrl.getText().trim();
        databaseName = tfDatabaseName.getText().trim();
        String driver = tfDriver.getText().trim();
        String database_Provider = (String) cbDatabase.getSelectedItem();
        if (user.isEmpty() || password.isEmpty() || uRL.isEmpty() || databaseName.isEmpty() || driver.isEmpty() || database_Provider.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please do not enter wrong values!");
        } else {
            dispose();
            DBConnectionPool.DB_DRIVER = driver;
            DBConnectionPool.DB_NAME = databaseName;
            DBConnectionPool.DB_SID = tfSID.getText();
            DBConnectionPool.DB_PASSWD = password;
            DBConnectionPool.DB_URL = uRL;
            DBConnectionPool.DB_USER = user;
        }
        
    }//GEN-LAST:event_onOK
    private void onNewDriver(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onNewDriver
        switch (cbDatabase.getSelectedIndex()) {
            case 0:
                selectedDB = "postgres";
                tfDriver.setText("org.postgresql.Driver");
                tfUrlExam.setText("jdbc:postgresql://localhost/");
                break;
            case 1:
                selectedDB = "oracle";
                tfDriver.setText("oracle.jdbc.driver.OracleDriver");
                tfUrlExam.setText("jdbc:oracle:thin:@localhost:1521:");
                lbSID.setText("    SID:");
                tfSID.setEditable(true);
                break;
            case 2:
                selectedDB = "mssql";
                tfDriver.setText("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                tfUrlExam.setText("jdbc:sqlserver://localhost:1433;");
                break;
        }
    }//GEN-LAST:event_onNewDriver

    public boolean getNewConn() {
        return newConn;
    }

    public String getDatabaseName() {
        return databaseName;
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
            java.util.logging.Logger.getLogger(DatabaseConnectionDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatabaseConnectionDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatabaseConnectionDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatabaseConnectionDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DatabaseConnectionDialogue dialog = new DatabaseConnectionDialogue(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup bgGroup1;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOK;
    private javax.swing.JComboBox cbDatabase;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbCompanyName;
    private javax.swing.JLabel lbDatabase;
    private javax.swing.JLabel lbDriver;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbSID;
    private javax.swing.JLabel lbText;
    private javax.swing.JLabel lbUrl;
    private javax.swing.JLabel lbUrlExam;
    private javax.swing.JLabel lbUser;
    private javax.swing.JPanel paButtons;
    private javax.swing.JPanel pnContainer;
    private javax.swing.JTextField tfDatabaseName;
    private javax.swing.JTextField tfDriver;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfSID;
    private javax.swing.JTextField tfUrl;
    private javax.swing.JTextField tfUrlExam;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
