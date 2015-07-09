/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.ImageIcon;

/**
 *
 * @author Steffie
 */
public class DatabaseConnectionDialogue extends javax.swing.JDialog {

    /**
     * Creates new form DatabaseConnectionDialogue
     */
    private boolean newConn = false;
    public DatabaseConnectionDialogue(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        this.getContentPane().setBackground(MainWindow.backgroundColorPanel);
        btCancel.setBackground(MainWindow.backgroundColorButton);
        btOK.setBackground(MainWindow.backgroundColorButton);
        setLocationRelativeTo(parent);
        this.setIconImage(new ImageIcon(getClass().getResource("jhlogo.jpg")).getImage()); 
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
        lbCompanyName = new javax.swing.JLabel();
        tfCompanyName = new javax.swing.JTextField();
        paButtons = new javax.swing.JPanel();
        btOK = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(400, 400));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(400, 400));
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
        pnContainer.setLayout(new java.awt.GridLayout(4, 2, 20, 20));

        lbUser.setBackground(new java.awt.Color(229, 229, 229));
        lbUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUser.setText("User: ");
        lbUser.setMaximumSize(new java.awt.Dimension(150, 40));
        lbUser.setMinimumSize(new java.awt.Dimension(150, 40));
        lbUser.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(lbUser);

        tfUser.setBackground(new java.awt.Color(229, 229, 229));
        tfUser.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfUser.setMaximumSize(new java.awt.Dimension(150, 40));
        tfUser.setMinimumSize(new java.awt.Dimension(150, 40));
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
        tfPassword.setMaximumSize(new java.awt.Dimension(150, 40));
        tfPassword.setMinimumSize(new java.awt.Dimension(150, 40));
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
        tfDriver.setMaximumSize(new java.awt.Dimension(150, 40));
        tfDriver.setMinimumSize(new java.awt.Dimension(150, 40));
        tfDriver.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(tfDriver);

        lbCompanyName.setBackground(new java.awt.Color(229, 229, 229));
        lbCompanyName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbCompanyName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCompanyName.setText("Company name:");
        lbCompanyName.setMaximumSize(new java.awt.Dimension(150, 40));
        lbCompanyName.setMinimumSize(new java.awt.Dimension(150, 40));
        lbCompanyName.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(lbCompanyName);

        tfCompanyName.setBackground(new java.awt.Color(229, 229, 229));
        tfCompanyName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfCompanyName.setMaximumSize(new java.awt.Dimension(150, 40));
        tfCompanyName.setMinimumSize(new java.awt.Dimension(150, 40));
        tfCompanyName.setPreferredSize(new java.awt.Dimension(150, 40));
        pnContainer.add(tfCompanyName);

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
        DataSelectionModesDialogue dataSelectDialogue = new DataSelectionModesDialogue(null, true);
        dataSelectDialogue.setVisible(true);
        dispose();
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
    private javax.swing.JLabel lbCompanyName;
    private javax.swing.JLabel lbDriver;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbText;
    private javax.swing.JLabel lbUser;
    private javax.swing.JPanel paButtons;
    private javax.swing.JPanel pnContainer;
    private javax.swing.JTextField tfCompanyName;
    private javax.swing.JTextField tfDriver;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
