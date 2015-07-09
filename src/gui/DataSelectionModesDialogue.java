/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.ImageIcon;

/**
 *
 * @author Sarah
 */
public class DataSelectionModesDialogue extends javax.swing.JDialog {

    /**
     * Creates new form DataSelectionModesDialogue
     */
    private boolean ok = false;
    
    public DataSelectionModesDialogue(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(MainWindow.backgroundColorPanel);
        btCancel.setBackground(MainWindow.backgroundColorButton);
        btOK.setBackground(MainWindow.backgroundColorButton);
        this.setIconImage(new ImageIcon(getClass().getResource("jhlogo.jpg")).getImage()); 
        this.setLocationRelativeTo(null);
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgGroup1 = new javax.swing.ButtonGroup();
        pnCompanyName = new javax.swing.JPanel();
        lbCompanyName = new javax.swing.JLabel();
        pnOptions = new javax.swing.JPanel();
        pnRadioButton = new javax.swing.JPanel();
        lbWhiteSpace1 = new javax.swing.JLabel();
        rbParticularTables = new javax.swing.JRadioButton();
        lbWhiteSpace2 = new javax.swing.JLabel();
        lbWhiteSpace3 = new javax.swing.JLabel();
        rbEntireDB = new javax.swing.JRadioButton();
        lbWhiteSpace4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btOK = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnCompanyName.setBackground(new java.awt.Color(229, 229, 229));
        pnCompanyName.setLayout(new java.awt.GridLayout(1, 1));

        lbCompanyName.setBackground(new java.awt.Color(229, 229, 229));
        lbCompanyName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbCompanyName.setText("Company Name");
        lbCompanyName.setMaximumSize(new java.awt.Dimension(40, 45));
        lbCompanyName.setMinimumSize(new java.awt.Dimension(40, 45));
        lbCompanyName.setPreferredSize(new java.awt.Dimension(40, 45));
        pnCompanyName.add(lbCompanyName);

        getContentPane().add(pnCompanyName, java.awt.BorderLayout.NORTH);

        pnOptions.setBackground(new java.awt.Color(229, 229, 229));
        pnOptions.setLayout(new java.awt.BorderLayout(20, 30));

        pnRadioButton.setBackground(new java.awt.Color(229, 229, 229));
        pnRadioButton.setLayout(new java.awt.GridLayout(2, 3, 0, 15));

        lbWhiteSpace1.setBackground(new java.awt.Color(229, 229, 229));
        pnRadioButton.add(lbWhiteSpace1);

        rbParticularTables.setBackground(new java.awt.Color(229, 229, 229));
        bgGroup1.add(rbParticularTables);
        rbParticularTables.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbParticularTables.setSelected(true);
        rbParticularTables.setText("particular Tables");
        rbParticularTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onParticularTables(evt);
            }
        });
        pnRadioButton.add(rbParticularTables);

        lbWhiteSpace2.setBackground(new java.awt.Color(229, 229, 229));
        pnRadioButton.add(lbWhiteSpace2);

        lbWhiteSpace3.setBackground(new java.awt.Color(229, 229, 229));
        pnRadioButton.add(lbWhiteSpace3);

        rbEntireDB.setBackground(new java.awt.Color(229, 229, 229));
        bgGroup1.add(rbEntireDB);
        rbEntireDB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbEntireDB.setText("entire Database");
        rbEntireDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onEntireDatabase(evt);
            }
        });
        pnRadioButton.add(rbEntireDB);

        lbWhiteSpace4.setBackground(new java.awt.Color(229, 229, 229));
        pnRadioButton.add(lbWhiteSpace4);

        pnOptions.add(pnRadioButton, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(229, 229, 229));
        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        btOK.setBackground(new java.awt.Color(229, 229, 229));
        btOK.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btOK.setText("OK");
        btOK.setMaximumSize(new java.awt.Dimension(50, 40));
        btOK.setMinimumSize(new java.awt.Dimension(50, 40));
        btOK.setPreferredSize(new java.awt.Dimension(50, 40));
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onOK(evt);
            }
        });
        jPanel1.add(btOK);

        btCancel.setBackground(new java.awt.Color(229, 229, 229));
        btCancel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btCancel.setText("Cancel");
        btCancel.setMaximumSize(new java.awt.Dimension(50, 40));
        btCancel.setMinimumSize(new java.awt.Dimension(50, 40));
        btCancel.setPreferredSize(new java.awt.Dimension(50, 40));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCancel(evt);
            }
        });
        jPanel1.add(btCancel);

        pnOptions.add(jPanel1, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnOptions, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onParticularTables(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onParticularTables
        // TODO add your handling code here:
    }//GEN-LAST:event_onParticularTables

    private void onEntireDatabase(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onEntireDatabase
        // TODO add your handling code here:
    }//GEN-LAST:event_onEntireDatabase

    private void onOK(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onOK
        ok = true;
        TableDialogue tableDialogue = new TableDialogue(null, true);
        if(rbParticularTables.isSelected())
        {           
            tableDialogue.setVisible(true);
        }
        else
        {
            dispose();
            DownloadDialogue downloadDialogue = new DownloadDialogue(null, true);
            downloadDialogue.setVisible(true);
        }
        if(tableDialogue.getOK() && ok)
        {
            dispose();
        }
        
    }//GEN-LAST:event_onOK

    private void onCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCancel
        dispose();
    }//GEN-LAST:event_onCancel

    public boolean isOK() 
    {
        return ok;
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
            java.util.logging.Logger.getLogger(DataSelectionModesDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataSelectionModesDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataSelectionModesDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataSelectionModesDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DataSelectionModesDialogue dialog = new DataSelectionModesDialogue(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCompanyName;
    private javax.swing.JLabel lbWhiteSpace1;
    private javax.swing.JLabel lbWhiteSpace2;
    private javax.swing.JLabel lbWhiteSpace3;
    private javax.swing.JLabel lbWhiteSpace4;
    private javax.swing.JPanel pnCompanyName;
    private javax.swing.JPanel pnOptions;
    private javax.swing.JPanel pnRadioButton;
    private javax.swing.JRadioButton rbEntireDB;
    private javax.swing.JRadioButton rbParticularTables;
    // End of variables declaration//GEN-END:variables
}
