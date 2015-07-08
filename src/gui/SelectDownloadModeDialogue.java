/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Sarah
 */
public class SelectDownloadModeDialogue extends javax.swing.JDialog {

    /**
     * Creates new form SelectDownloadModeDialogue
     */
    public SelectDownloadModeDialogue(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        lbTitle = new javax.swing.JLabel();
        pnSelectionModes = new javax.swing.JPanel();
        pnRadios = new javax.swing.JPanel();
        lbWhiteSpace = new javax.swing.JLabel();
        pnRadioButtons = new javax.swing.JPanel();
        rbPrincipal = new javax.swing.JRadioButton();
        rbCustomer = new javax.swing.JRadioButton();
        rbBoth = new javax.swing.JRadioButton();
        pnTables = new javax.swing.JPanel();
        spTables = new javax.swing.JScrollPane();
        jlTables = new javax.swing.JList();
        lbWhiteSpace5 = new javax.swing.JLabel();
        lbWhiteSpace6 = new javax.swing.JLabel();
        lbWhiteSpace7 = new javax.swing.JLabel();
        pnButtons = new javax.swing.JPanel();
        btDownlaod = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 350));
        setMinimumSize(new java.awt.Dimension(400, 350));
        setPreferredSize(new java.awt.Dimension(400, 350));
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        lbTitle.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Select Download Mode");
        lbTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbTitle.setMaximumSize(new java.awt.Dimension(185, 40));
        lbTitle.setMinimumSize(new java.awt.Dimension(185, 40));
        lbTitle.setPreferredSize(new java.awt.Dimension(185, 40));
        getContentPane().add(lbTitle, java.awt.BorderLayout.PAGE_START);

        pnSelectionModes.setLayout(new java.awt.GridLayout(1, 2, 10, 10));

        pnRadios.setLayout(new java.awt.BorderLayout());

        lbWhiteSpace.setMaximumSize(new java.awt.Dimension(20, 20));
        lbWhiteSpace.setMinimumSize(new java.awt.Dimension(20, 20));
        lbWhiteSpace.setPreferredSize(new java.awt.Dimension(20, 20));
        pnRadios.add(lbWhiteSpace, java.awt.BorderLayout.WEST);

        pnRadioButtons.setLayout(new java.awt.GridLayout(3, 1, 0, -30));

        bgGroup1.add(rbPrincipal);
        rbPrincipal.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        rbPrincipal.setSelected(true);
        rbPrincipal.setText("Principal");
        rbPrincipal.setMaximumSize(new java.awt.Dimension(100, 40));
        rbPrincipal.setMinimumSize(new java.awt.Dimension(100, 40));
        rbPrincipal.setPreferredSize(new java.awt.Dimension(100, 40));
        pnRadioButtons.add(rbPrincipal);

        bgGroup1.add(rbCustomer);
        rbCustomer.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        rbCustomer.setText("Customer");
        rbCustomer.setMaximumSize(new java.awt.Dimension(100, 40));
        rbCustomer.setMinimumSize(new java.awt.Dimension(100, 40));
        rbCustomer.setPreferredSize(new java.awt.Dimension(100, 40));
        pnRadioButtons.add(rbCustomer);

        bgGroup1.add(rbBoth);
        rbBoth.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        rbBoth.setText("Both");
        rbBoth.setMaximumSize(new java.awt.Dimension(100, 40));
        rbBoth.setMinimumSize(new java.awt.Dimension(100, 40));
        rbBoth.setPreferredSize(new java.awt.Dimension(100, 40));
        pnRadioButtons.add(rbBoth);

        pnRadios.add(pnRadioButtons, java.awt.BorderLayout.CENTER);

        pnSelectionModes.add(pnRadios);

        pnTables.setLayout(new java.awt.BorderLayout());

        jlTables.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlTables.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jlTables.setMaximumSize(new java.awt.Dimension(36, 40));
        jlTables.setMinimumSize(new java.awt.Dimension(36, 40));
        jlTables.setPreferredSize(new java.awt.Dimension(36, 40));
        spTables.setViewportView(jlTables);

        pnTables.add(spTables, java.awt.BorderLayout.CENTER);

        lbWhiteSpace5.setMaximumSize(new java.awt.Dimension(20, 20));
        lbWhiteSpace5.setMinimumSize(new java.awt.Dimension(20, 20));
        lbWhiteSpace5.setPreferredSize(new java.awt.Dimension(20, 20));
        pnTables.add(lbWhiteSpace5, java.awt.BorderLayout.PAGE_START);

        lbWhiteSpace6.setMaximumSize(new java.awt.Dimension(20, 20));
        lbWhiteSpace6.setMinimumSize(new java.awt.Dimension(20, 20));
        lbWhiteSpace6.setPreferredSize(new java.awt.Dimension(20, 20));
        pnTables.add(lbWhiteSpace6, java.awt.BorderLayout.PAGE_END);

        lbWhiteSpace7.setMaximumSize(new java.awt.Dimension(10, 10));
        lbWhiteSpace7.setMinimumSize(new java.awt.Dimension(10, 10));
        lbWhiteSpace7.setName(""); // NOI18N
        lbWhiteSpace7.setPreferredSize(new java.awt.Dimension(10, 10));
        pnTables.add(lbWhiteSpace7, java.awt.BorderLayout.LINE_END);

        pnSelectionModes.add(pnTables);

        getContentPane().add(pnSelectionModes, java.awt.BorderLayout.CENTER);

        pnButtons.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        btDownlaod.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btDownlaod.setText("Download");
        btDownlaod.setMaximumSize(new java.awt.Dimension(50, 40));
        btDownlaod.setMinimumSize(new java.awt.Dimension(50, 40));
        btDownlaod.setPreferredSize(new java.awt.Dimension(50, 40));
        btDownlaod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onDownload(evt);
            }
        });
        pnButtons.add(btDownlaod);

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

        getContentPane().add(pnButtons, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onDownload(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onDownload
        
        dispose();
    }//GEN-LAST:event_onDownload

    private void onCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCancel
        dispose();
    }//GEN-LAST:event_onCancel

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
            java.util.logging.Logger.getLogger(SelectDownloadModeDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectDownloadModeDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectDownloadModeDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectDownloadModeDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelectDownloadModeDialogue dialog = new SelectDownloadModeDialogue(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btDownlaod;
    private javax.swing.JList jlTables;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbWhiteSpace;
    private javax.swing.JLabel lbWhiteSpace5;
    private javax.swing.JLabel lbWhiteSpace6;
    private javax.swing.JLabel lbWhiteSpace7;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnRadioButtons;
    private javax.swing.JPanel pnRadios;
    private javax.swing.JPanel pnSelectionModes;
    private javax.swing.JPanel pnTables;
    private javax.swing.JRadioButton rbBoth;
    private javax.swing.JRadioButton rbCustomer;
    private javax.swing.JRadioButton rbPrincipal;
    private javax.swing.JScrollPane spTables;
    // End of variables declaration//GEN-END:variables
}
