package gui;

import beans.Table;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import listModel.TableNamesLM;
import listModel.TableNamesLMD;

public class TableDialogue extends javax.swing.JDialog {

    private boolean ok = false;
    public static String selectedList;
    private LinkedList<Table> liTablesList = new LinkedList<>();
    public static LinkedList<Table> selectedTables = new LinkedList<>();
    private TableNamesLM tnlm;
    private TableNamesLMD tnlmd;
    public boolean equalTablesList = false;
    private boolean tableNames;
    private LinkedList<String> liAllTableNames = new LinkedList<>();
    public static LinkedList<String> liSelectedTableNames = new LinkedList<>();

    public TableDialogue(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            this.getContentPane().setBackground(MainWindow.backgroundColorPanel);
            btCancel.setBackground(MainWindow.backgroundColorButton);
            btOk.setBackground(MainWindow.backgroundColorButton);
            btAdd.setBackground(MainWindow.backgroundColorButton);
            btRemove.setBackground(MainWindow.backgroundColorButton);
            this.setLocationRelativeTo(parent);
            this.setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
            selectedTables.clear();            
        } catch (Exception s) {
            System.out.println("TableDialogue : Constructor : " + s.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTables = new javax.swing.JLabel();
        pnTableButton = new javax.swing.JPanel();
        pnButtons = new javax.swing.JPanel();
        btOk = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        pnLists = new javax.swing.JPanel();
        pnButtonsSelection = new javax.swing.JPanel();
        lbWhiteSpace1 = new javax.swing.JLabel();
        lbWhiteSpace2 = new javax.swing.JLabel();
        btAdd = new javax.swing.JButton();
        btRemove = new javax.swing.JButton();
        lbWhiteSpace3 = new javax.swing.JLabel();
        lbWhiteSpace4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        liList2 = new javax.swing.JList();
        spTables = new javax.swing.JScrollPane();
        liTables = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        lbTables.setBackground(new java.awt.Color(229, 229, 229));
        lbTables.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbTables.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTables.setText("Tables");
        lbTables.setToolTipText("");
        lbTables.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbTables.setMaximumSize(new java.awt.Dimension(55, 35));
        lbTables.setMinimumSize(new java.awt.Dimension(55, 35));
        lbTables.setOpaque(true);
        lbTables.setPreferredSize(new java.awt.Dimension(55, 35));
        getContentPane().add(lbTables, java.awt.BorderLayout.PAGE_START);

        pnTableButton.setBackground(new java.awt.Color(229, 229, 229));
        pnTableButton.setLayout(new java.awt.BorderLayout(10, 10));

        pnButtons.setBackground(new java.awt.Color(229, 229, 229));
        pnButtons.setLayout(new java.awt.GridLayout(1, 2, 25, 10));

        btOk.setBackground(new java.awt.Color(229, 229, 229));
        btOk.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btOk.setText("OK");
        btOk.setMaximumSize(new java.awt.Dimension(50, 70));
        btOk.setMinimumSize(new java.awt.Dimension(50, 70));
        btOk.setPreferredSize(new java.awt.Dimension(50, 70));
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onOK(evt);
            }
        });
        pnButtons.add(btOk);

        btCancel.setBackground(new java.awt.Color(229, 229, 229));
        btCancel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btCancel.setText("Cancel");
        btCancel.setMaximumSize(new java.awt.Dimension(50, 70));
        btCancel.setMinimumSize(new java.awt.Dimension(50, 70));
        btCancel.setPreferredSize(new java.awt.Dimension(50, 70));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCancel(evt);
            }
        });
        pnButtons.add(btCancel);

        pnTableButton.add(pnButtons, java.awt.BorderLayout.PAGE_END);

        pnLists.setBackground(new java.awt.Color(229, 229, 229));
        pnLists.setLayout(new java.awt.BorderLayout(15, 0));

        pnButtonsSelection.setBackground(new java.awt.Color(229, 229, 229));
        pnButtonsSelection.setToolTipText("");
        pnButtonsSelection.setLayout(new java.awt.GridLayout(6, 1));

        lbWhiteSpace1.setBackground(new java.awt.Color(229, 229, 229));
        lbWhiteSpace1.setToolTipText("");
        pnButtonsSelection.add(lbWhiteSpace1);

        lbWhiteSpace2.setBackground(new java.awt.Color(229, 229, 229));
        lbWhiteSpace2.setToolTipText("");
        pnButtonsSelection.add(lbWhiteSpace2);

        btAdd.setBackground(new java.awt.Color(229, 229, 229));
        btAdd.setText(">");
        btAdd.setToolTipText("");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAddTable(evt);
            }
        });
        pnButtonsSelection.add(btAdd);

        btRemove.setBackground(new java.awt.Color(229, 229, 229));
        btRemove.setText("<");
        btRemove.setToolTipText("");
        btRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onRemoveTable(evt);
            }
        });
        pnButtonsSelection.add(btRemove);

        lbWhiteSpace3.setBackground(new java.awt.Color(229, 229, 229));
        lbWhiteSpace3.setToolTipText("");
        pnButtonsSelection.add(lbWhiteSpace3);

        lbWhiteSpace4.setBackground(new java.awt.Color(229, 229, 229));
        lbWhiteSpace4.setToolTipText("");
        pnButtonsSelection.add(lbWhiteSpace4);

        pnLists.add(pnButtonsSelection, java.awt.BorderLayout.CENTER);

        jScrollPane1.setBackground(new java.awt.Color(229, 229, 229));
        jScrollPane1.setToolTipText("");
        jScrollPane1.setMaximumSize(new java.awt.Dimension(200, 200));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(200, 200));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 200));

        liList2.setBackground(new java.awt.Color(229, 229, 229));
        liList2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        liList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        liList2.setToolTipText("");
        jScrollPane1.setViewportView(liList2);

        pnLists.add(jScrollPane1, java.awt.BorderLayout.EAST);

        spTables.setBackground(new java.awt.Color(229, 229, 229));
        spTables.setMaximumSize(new java.awt.Dimension(200, 200));
        spTables.setMinimumSize(new java.awt.Dimension(200, 200));
        spTables.setPreferredSize(new java.awt.Dimension(200, 200));

        liTables.setBackground(new java.awt.Color(229, 229, 229));
        liTables.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        liTables.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        spTables.setViewportView(liTables);

        pnLists.add(spTables, java.awt.BorderLayout.WEST);

        pnTableButton.add(pnLists, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnTableButton, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onOK(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onOK
        if (!tableNames) {
            if (selectedTables.size() > 0) {
                ok = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "nothing is selected");
            }
        } else {
            if (liSelectedTableNames.size() > 0) {
                ok = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "nothing is selected");
            }
        }
    }//GEN-LAST:event_onOK
    private void onCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCancel
        ok = false;
        dispose();
    }//GEN-LAST:event_onCancel
    private void onAddTable(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAddTable
        if (!tableNames) {
            if (liTablesList.size() > 0) {
                selectedTables.add(liTablesList.get(liTables.getSelectedIndex()));
                liTablesList.remove(liTables.getSelectedIndex());
                liTables.updateUI();
                liList2.updateUI();
            }
        } else {
            if (liAllTableNames.size() > 0) {
                liSelectedTableNames.add(liAllTableNames.get(liTables.getSelectedIndex()));
                liAllTableNames.remove(liTables.getSelectedIndex());
                liTables.updateUI();
                liList2.updateUI();
            }
        }
    }//GEN-LAST:event_onAddTable
    private void onRemoveTable(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onRemoveTable
        if (!tableNames) {
            if (selectedTables.size() > 0) {
                liTablesList.add(selectedTables.get(liList2.getSelectedIndex()));
                selectedTables.remove(liList2.getSelectedIndex());
                liList2.updateUI();
                liTables.updateUI();
            }
        } else {
            if (liSelectedTableNames.size() > 0) {
                liAllTableNames.add(liSelectedTableNames.get(liList2.getSelectedIndex()));
                liSelectedTableNames.remove(liList2.getSelectedIndex());
                liList2.updateUI();
                liTables.updateUI();
            }
        }
    }//GEN-LAST:event_onRemoveTable
    public boolean isOK() {
        return ok;
    }

    public void setLiAllTableNames(LinkedList<String> liAllTableNames) throws ClassNotFoundException {
        tableNames = true;
        Collections.sort(this.liAllTableNames);
        tnlmd = new TableNamesLMD(this.liAllTableNames);
        liTables.setModel(new TableNamesLMD(liAllTableNames));
        liList2.setModel(new TableNamesLMD(liSelectedTableNames));
    }

    public void setLiAllTables(LinkedList<Table> liAllTables) {
        tableNames = false;
        try {
            this.liTablesList = liAllTables;
            Collections.sort(this.liTablesList);
            tnlm = new TableNamesLM(this.liTablesList);
            liTables.setModel(tnlm);
            liList2.setModel(new TableNamesLM(selectedTables));
        } catch (Exception e) {
            System.out.println("TableDialogue : setLiAllTables : " + e.toString());
        }
    }

    public void setEqualTablesList(boolean equalTablesList) {
        this.equalTablesList = equalTablesList;
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
            java.util.logging.Logger.getLogger(TableDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TableDialogue dialog = new TableDialogue(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOk;
    private javax.swing.JButton btRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTables;
    private javax.swing.JLabel lbWhiteSpace1;
    private javax.swing.JLabel lbWhiteSpace2;
    private javax.swing.JLabel lbWhiteSpace3;
    private javax.swing.JLabel lbWhiteSpace4;
    private javax.swing.JList liList2;
    private javax.swing.JList liTables;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnButtonsSelection;
    private javax.swing.JPanel pnLists;
    private javax.swing.JPanel pnTableButton;
    private javax.swing.JScrollPane spTables;
    // End of variables declaration//GEN-END:variables
}
