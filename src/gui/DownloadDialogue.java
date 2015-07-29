package gui;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

public class DownloadDialogue extends javax.swing.JDialog {

    private Task task;
    public DownloadDialogue(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(this);
        this.getContentPane().setBackground(MainWindow.backgroundColorPanel);
        this.setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage()); 
        setLocationRelativeTo(parent);
        task = new Task();
        task.execute();
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        lbTitle.setBackground(new java.awt.Color(229, 229, 229));
        lbTitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbTitle.setText("Loading ...");
        lbTitle.setToolTipText("");
        lbTitle.setMaximumSize(new java.awt.Dimension(200, 50));
        lbTitle.setMinimumSize(new java.awt.Dimension(200, 50));
        lbTitle.setOpaque(true);
        lbTitle.setPreferredSize(new java.awt.Dimension(200, 50));
        getContentPane().add(lbTitle, java.awt.BorderLayout.NORTH);

        jProgressBar1.setBackground(new java.awt.Color(229, 229, 229));
        jProgressBar1.setIndeterminate(true);
        jProgressBar1.setMaximumSize(new java.awt.Dimension(200, 50));
        jProgressBar1.setMinimumSize(new java.awt.Dimension(200, 50));
        jProgressBar1.setOpaque(true);
        jProgressBar1.setPreferredSize(new java.awt.Dimension(200, 50));
        getContentPane().add(jProgressBar1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DownloadDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DownloadDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DownloadDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DownloadDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DownloadDialogue dialog = new DownloadDialogue(new javax.swing.JFrame(), true);
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
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lbTitle;
    // End of variables declaration//GEN-END:variables
}

class Task extends SwingWorker<Void, Void> {
        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
            Random random = new Random();
            
            //Sleep for at least one second to simulate "startup".
            try {
                Thread.sleep(1000 + random.nextInt(2000));
            } catch (InterruptedException ignore) {}
            return null;
        }

        /*
         * Executed in event dispatch thread
         */
        public void done() {
        }
    }
