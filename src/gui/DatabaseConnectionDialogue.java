/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Steffie
 */
public class DatabaseConnectionDialogue extends javax.swing.JDialog {

    /**
     * Creates new form DatabaseConnectionDialogue
     */
    private boolean newConn = false;
    public static File newDBDump;
    
    public DatabaseConnectionDialogue(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        this.getContentPane().setBackground(MainWindow.backgroundColorPanel);
        btCancel.setBackground(MainWindow.backgroundColorButton);
        btOK.setBackground(MainWindow.backgroundColorButton);
        setLocationRelativeTo(parent);
        
        
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbText = new javax.swing.JLabel();
        pnContainer = new javax.swing.JPanel();
        lbUser = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        lbPassword = new javax.swing.JLabel();
        tfPassword = new javax.swing.JTextField();
        lbDriver = new javax.swing.JLabel();
        tfDriver = new javax.swing.JTextField();
        lbDatabase = new javax.swing.JLabel();
        cbDatabase = new javax.swing.JComboBox();
        lbCompanyName = new javax.swing.JLabel();
        tfCompanyName = new javax.swing.JTextField();
        lbUrl = new javax.swing.JLabel();
        tfUrl = new javax.swing.JTextField();
        paButtons = new javax.swing.JPanel();
        btOK = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(400, 400));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(400, 400));
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
        pnContainer.setLayout(new java.awt.GridLayout(6, 2, 20, 20));

        lbUser.setBackground(new java.awt.Color(229, 229, 229));
        lbUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUser.setText("User:");
        lbUser.setMaximumSize(new java.awt.Dimension(150, 40));
        lbUser.setMinimumSize(new java.awt.Dimension(150, 40));
        lbUser.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(lbUser);

        tfUser.setBackground(new java.awt.Color(229, 229, 229));
        tfUser.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfUser.setText("postgres");
        tfUser.setMaximumSize(new java.awt.Dimension(150, 40));
        tfUser.setMinimumSize(new java.awt.Dimension(150, 40));
        tfUser.setNextFocusableComponent(tfPassword);
        tfUser.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(tfUser);

        lbPassword.setBackground(new java.awt.Color(229, 229, 229));
        lbPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPassword.setText("Password: ");
        lbPassword.setMaximumSize(new java.awt.Dimension(150, 40));
        lbPassword.setMinimumSize(new java.awt.Dimension(150, 40));
        lbPassword.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(lbPassword);

        tfPassword.setBackground(new java.awt.Color(229, 229, 229));
        tfPassword.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfPassword.setText("postgres");
        tfPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfPassword.setMaximumSize(new java.awt.Dimension(150, 40));
        tfPassword.setMinimumSize(new java.awt.Dimension(150, 40));
        tfPassword.setNextFocusableComponent(tfDriver);
        tfPassword.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(tfPassword);

        lbDriver.setBackground(new java.awt.Color(229, 229, 229));
        lbDriver.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbDriver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDriver.setText("Driver: ");
        lbDriver.setMaximumSize(new java.awt.Dimension(150, 40));
        lbDriver.setMinimumSize(new java.awt.Dimension(150, 40));
        lbDriver.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(lbDriver);

        tfDriver.setBackground(new java.awt.Color(229, 229, 229));
        tfDriver.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfDriver.setText("org.postgresql.Driver");
        tfDriver.setMaximumSize(new java.awt.Dimension(150, 40));
        tfDriver.setMinimumSize(new java.awt.Dimension(150, 40));
        tfDriver.setNextFocusableComponent(cbDatabase);
        tfDriver.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(tfDriver);

        lbDatabase.setBackground(new java.awt.Color(229, 229, 229));
        lbDatabase.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbDatabase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDatabase.setText("Database:");
        lbDatabase.setMaximumSize(new java.awt.Dimension(150, 40));
        lbDatabase.setMinimumSize(new java.awt.Dimension(150, 40));
        lbDatabase.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(lbDatabase);

        cbDatabase.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbDatabase.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Oracle", "MSSQL" }));
        cbDatabase.setNextFocusableComponent(tfCompanyName);
        cbDatabase.setVerifyInputWhenFocusTarget(false);
        pnContainer.add(cbDatabase);

        lbCompanyName.setBackground(new java.awt.Color(229, 229, 229));
        lbCompanyName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbCompanyName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCompanyName.setText("Database name:");
        lbCompanyName.setMaximumSize(new java.awt.Dimension(150, 40));
        lbCompanyName.setMinimumSize(new java.awt.Dimension(150, 40));
        lbCompanyName.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(lbCompanyName);

        tfCompanyName.setBackground(new java.awt.Color(229, 229, 229));
        tfCompanyName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfCompanyName.setText("testdb");
        tfCompanyName.setMaximumSize(new java.awt.Dimension(150, 40));
        tfCompanyName.setMinimumSize(new java.awt.Dimension(150, 40));
        tfCompanyName.setNextFocusableComponent(tfUrl);
        tfCompanyName.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(tfCompanyName);

        lbUrl.setBackground(new java.awt.Color(229, 229, 229));
        lbUrl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbUrl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUrl.setText("URL:");
        lbUrl.setMaximumSize(new java.awt.Dimension(150, 40));
        lbUrl.setMinimumSize(new java.awt.Dimension(150, 40));
        lbUrl.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(lbUrl);

        tfUrl.setBackground(new java.awt.Color(229, 229, 229));
        tfUrl.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfUrl.setText("jdbc:postgresql://localhost/");
        tfUrl.setMaximumSize(new java.awt.Dimension(150, 40));
        tfUrl.setMinimumSize(new java.awt.Dimension(150, 40));
        tfUrl.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(tfUrl);

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
        newConn=true;
        dispose();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose directory to save Database file");   
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Database file", "txt");
        fileChooser.setFileFilter(filter);
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) 
        {
            newDBDump = fileChooser.getSelectedFile();
//                System.out.println("Selected file: " + selectedDBDump.getAbsolutePath());
            DownloadDialogue downloadDialogue = new DownloadDialogue(null, true);
            downloadDialogue.setVisible(true);
        }
    }//GEN-LAST:event_onOK

    public boolean getNewConn()
    {
        return newConn;
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
            java.util.logging.Logger.getLogger(DatabaseConnectionDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatabaseConnectionDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatabaseConnectionDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatabaseConnectionDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
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
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOK;
    private javax.swing.JComboBox cbDatabase;
    private javax.swing.JLabel lbCompanyName;
    private javax.swing.JLabel lbDatabase;
    private javax.swing.JLabel lbDriver;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbText;
    private javax.swing.JLabel lbUrl;
    private javax.swing.JLabel lbUser;
    private javax.swing.JPanel paButtons;
    private javax.swing.JPanel pnContainer;
    private javax.swing.JTextField tfCompanyName;
    private javax.swing.JTextField tfDriver;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfUrl;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
