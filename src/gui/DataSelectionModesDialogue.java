package gui;

import beans.Table;
import database.DBAccess;
import static gui.MainWindow.newPartTable;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class DataSelectionModesDialogue extends javax.swing.JDialog {

    private boolean ok = false;
    private boolean entireDB = false;
    private LinkedList<Table> liAllEqualTables = new LinkedList<>();
    public boolean tableOK = false;

    public DataSelectionModesDialogue(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(MainWindow.backgroundColorPanel);
        btCancel.setBackground(MainWindow.backgroundColorButton);
        btOK.setBackground(MainWindow.backgroundColorButton);
        this.setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
        this.setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgGroup1 = new javax.swing.ButtonGroup();
        pnCompanyName = new javax.swing.JPanel();
        lbCompanyName = new javax.swing.JLabel();
        pnOptions = new javax.swing.JPanel();
        pnContent = new javax.swing.JPanel();
        pnRadioButton1 = new javax.swing.JPanel();
        lbWhiteSpace1 = new javax.swing.JLabel();
        rbParticularTables = new javax.swing.JRadioButton();
        lbWhiteSpace2 = new javax.swing.JLabel();
        pnRadioButton = new javax.swing.JPanel();
        lbWhiteSpace3 = new javax.swing.JLabel();
        rbEntireDB = new javax.swing.JRadioButton();
        lbWhiteSpace4 = new javax.swing.JLabel();
        pnButtons = new javax.swing.JPanel();
        btOK = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(350, 230));
        setMinimumSize(new java.awt.Dimension(350, 230));
        setPreferredSize(new java.awt.Dimension(350, 230));
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(0, -10));

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
        pnOptions.setLayout(new java.awt.BorderLayout());

        pnContent.setLayout(new java.awt.GridLayout(2, 1, -5, -25));

        pnRadioButton1.setBackground(new java.awt.Color(229, 229, 229));
        pnRadioButton1.setLayout(new java.awt.BorderLayout());

        lbWhiteSpace1.setBackground(new java.awt.Color(229, 229, 229));
        lbWhiteSpace1.setMaximumSize(new java.awt.Dimension(80, 60));
        lbWhiteSpace1.setMinimumSize(new java.awt.Dimension(80, 60));
        lbWhiteSpace1.setOpaque(true);
        lbWhiteSpace1.setPreferredSize(new java.awt.Dimension(80, 60));
        pnRadioButton1.add(lbWhiteSpace1, java.awt.BorderLayout.EAST);

        rbParticularTables.setBackground(new java.awt.Color(229, 229, 229));
        bgGroup1.add(rbParticularTables);
        rbParticularTables.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbParticularTables.setSelected(true);
        rbParticularTables.setText("particular Tables");
        rbParticularTables.setActionCommand("1");
        pnRadioButton1.add(rbParticularTables, java.awt.BorderLayout.CENTER);

        lbWhiteSpace2.setBackground(new java.awt.Color(229, 229, 229));
        lbWhiteSpace2.setMaximumSize(new java.awt.Dimension(80, 60));
        lbWhiteSpace2.setMinimumSize(new java.awt.Dimension(80, 60));
        lbWhiteSpace2.setOpaque(true);
        lbWhiteSpace2.setPreferredSize(new java.awt.Dimension(80, 60));
        pnRadioButton1.add(lbWhiteSpace2, java.awt.BorderLayout.WEST);

        pnContent.add(pnRadioButton1);

        pnRadioButton.setBackground(new java.awt.Color(229, 229, 229));
        pnRadioButton.setLayout(new java.awt.BorderLayout());

        lbWhiteSpace3.setBackground(new java.awt.Color(229, 229, 229));
        lbWhiteSpace3.setMaximumSize(new java.awt.Dimension(80, 60));
        lbWhiteSpace3.setMinimumSize(new java.awt.Dimension(80, 60));
        lbWhiteSpace3.setPreferredSize(new java.awt.Dimension(80, 60));
        pnRadioButton.add(lbWhiteSpace3, java.awt.BorderLayout.WEST);

        rbEntireDB.setBackground(new java.awt.Color(229, 229, 229));
        bgGroup1.add(rbEntireDB);
        rbEntireDB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbEntireDB.setText("entire Database");
        rbEntireDB.setActionCommand("2");
        pnRadioButton.add(rbEntireDB, java.awt.BorderLayout.CENTER);

        lbWhiteSpace4.setBackground(new java.awt.Color(229, 229, 229));
        lbWhiteSpace4.setMaximumSize(new java.awt.Dimension(80, 60));
        lbWhiteSpace4.setMinimumSize(new java.awt.Dimension(80, 60));
        lbWhiteSpace4.setPreferredSize(new java.awt.Dimension(80, 60));
        pnRadioButton.add(lbWhiteSpace4, java.awt.BorderLayout.EAST);

        pnContent.add(pnRadioButton);

        pnOptions.add(pnContent, java.awt.BorderLayout.CENTER);

        pnButtons.setBackground(new java.awt.Color(229, 229, 229));
        pnButtons.setLayout(new java.awt.GridLayout(1, 2));

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
        pnButtons.add(btOK);

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
        pnButtons.add(btCancel);

        pnOptions.add(pnButtons, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnOptions, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onOK(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onOK
        ok = true;
        TableDialogue tableDialogue = new TableDialogue(null, true);
        if (rbParticularTables.isSelected()) {
            entireDB = false;
            if (MainWindow.newPartTable) {
                tableDialogue.setVisible(true);
                try {
                    tableDialogue.setLiAllTableNames(DBAccess.getTheInstance().getAllTableNames());
                } catch (Exception ex) {
                    Logger.getLogger(DataSelectionModesDialogue.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                tableDialogue.setLiAllTables(liAllEqualTables);
                tableDialogue.setVisible(true);
                if (tableDialogue.isOK()) {
                    tableOK = true;
                }
            }

        } else {
            entireDB = true;
            dispose();
        }
        if (tableDialogue.isOK() && ok) {

            dispose();
        }
    }//GEN-LAST:event_onOK

    private void onCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCancel
        ok = false;
        dispose();
    }//GEN-LAST:event_onCancel

    public boolean isOK() {
        return ok;
    }

    public boolean isEntireDB() {
        return entireDB;
    }

    public void setLiAllEqualTables(LinkedList<Table> liAllEqualTables) {
        this.liAllEqualTables = liAllEqualTables;
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
            java.util.logging.Logger.getLogger(DataSelectionModesDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataSelectionModesDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataSelectionModesDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataSelectionModesDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private javax.swing.JLabel lbCompanyName;
    private javax.swing.JLabel lbWhiteSpace1;
    private javax.swing.JLabel lbWhiteSpace2;
    private javax.swing.JLabel lbWhiteSpace3;
    private javax.swing.JLabel lbWhiteSpace4;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnCompanyName;
    private javax.swing.JPanel pnContent;
    private javax.swing.JPanel pnOptions;
    private javax.swing.JPanel pnRadioButton;
    private javax.swing.JPanel pnRadioButton1;
    private javax.swing.JRadioButton rbEntireDB;
    private javax.swing.JRadioButton rbParticularTables;
    // End of variables declaration//GEN-END:variables
}
