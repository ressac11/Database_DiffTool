/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author Steffie
 */
public class DataExtractModeDialogue extends javax.swing.JDialog {

    /**
     * Creates new form DataExtractModeDialogue
     */
    
    public boolean isOK = false;
    public DataExtractModeDialogue(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(MainWindow.backgroundColorPanel);
        this.btOK.setBackground(MainWindow.backgroundColorButton);
        this.setSize(380, 250);
        this.setResizable(false);
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

        bgDatabase = new javax.swing.ButtonGroup();
        lbText = new javax.swing.JLabel();
        pnExistingDump = new javax.swing.JPanel();
        rbExistingDBDump = new javax.swing.JRadioButton();
        lbPlaceholder1 = new javax.swing.JLabel();
        pnNewDump = new javax.swing.JPanel();
        rbNewDBDump = new javax.swing.JRadioButton();
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

        pnExistingDump.setBackground(new java.awt.Color(229, 229, 229));
        pnExistingDump.setLayout(new java.awt.BorderLayout());

        rbExistingDBDump.setBackground(new java.awt.Color(229, 229, 229));
        bgDatabase.add(rbExistingDBDump);
        rbExistingDBDump.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbExistingDBDump.setSelected(true);
        rbExistingDBDump.setText("existing Database dump");
        rbExistingDBDump.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rbExistingDBDump.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onExistingDBDump(evt);
            }
        });
        pnExistingDump.add(rbExistingDBDump, java.awt.BorderLayout.CENTER);

        lbPlaceholder1.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder1.setForeground(new java.awt.Color(240, 240, 240));
        lbPlaceholder1.setMaximumSize(new java.awt.Dimension(95, 2));
        lbPlaceholder1.setMinimumSize(new java.awt.Dimension(95, 2));
        lbPlaceholder1.setOpaque(true);
        lbPlaceholder1.setPreferredSize(new java.awt.Dimension(95, 2));
        pnExistingDump.add(lbPlaceholder1, java.awt.BorderLayout.LINE_START);

        getContentPane().add(pnExistingDump);

        pnNewDump.setBackground(new java.awt.Color(229, 229, 229));
        pnNewDump.setLayout(new java.awt.BorderLayout());

        rbNewDBDump.setBackground(new java.awt.Color(229, 229, 229));
        bgDatabase.add(rbNewDBDump);
        rbNewDBDump.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbNewDBDump.setText("new Database dump");
        rbNewDBDump.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rbNewDBDump.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onNewDBDump(evt);
            }
        });
        pnNewDump.add(rbNewDBDump, java.awt.BorderLayout.CENTER);

        lbPlaceholder4.setBackground(new java.awt.Color(229, 229, 229));
        lbPlaceholder4.setForeground(new java.awt.Color(240, 240, 240));
        lbPlaceholder4.setMaximumSize(new java.awt.Dimension(95, 2));
        lbPlaceholder4.setMinimumSize(new java.awt.Dimension(95, 2));
        lbPlaceholder4.setName(""); // NOI18N
        lbPlaceholder4.setOpaque(true);
        lbPlaceholder4.setPreferredSize(new java.awt.Dimension(95, 2));
        pnNewDump.add(lbPlaceholder4, java.awt.BorderLayout.WEST);

        getContentPane().add(pnNewDump);

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

    private void onNewDBDump(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onNewDBDump
        
        
    }//GEN-LAST:event_onNewDBDump

    private void onExistingDBDump(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onExistingDBDump
        // TODO add your handling code here:
    }//GEN-LAST:event_onExistingDBDump

    private void onOK(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onOK
        DatabaseConnectionDialogue connectionDialogue = new DatabaseConnectionDialogue(null, true);
        isOK=true;
        if(rbNewDBDump.isSelected())
        {
            connectionDialogue.setVisible(true);
        }
        else
        {
            dispose();
            DownloadDialogue downloadDialogue = new DownloadDialogue(null, true);
            downloadDialogue.setVisible(true);
        }
        
        if(connectionDialogue.getNewConn() && isOK)
        {
            dispose();
        }
        
        
    }//GEN-LAST:event_onOK

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
            java.util.logging.Logger.getLogger(DataExtractModeDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataExtractModeDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataExtractModeDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataExtractModeDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
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
    private javax.swing.JPanel pnExistingDump;
    private javax.swing.JPanel pnNewDump;
    private javax.swing.JRadioButton rbExistingDBDump;
    private javax.swing.JRadioButton rbNewDBDump;
    // End of variables declaration//GEN-END:variables
}
