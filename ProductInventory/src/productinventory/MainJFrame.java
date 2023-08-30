/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package productinventory;

/**
 *
 * @author WINDOWS 10
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoJLabel = new javax.swing.JLabel();
        mainMenuJPanel = new javax.swing.JPanel();
        mainMenuJLabel = new javax.swing.JLabel();
        vendorJButton = new javax.swing.JButton();
        productJButton = new javax.swing.JButton();
        purchaseJButton = new javax.swing.JButton();
        salesJButton = new javax.swing.JButton();
        logOutJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        logoJLabel.setBackground(new java.awt.Color(255, 255, 255));
        logoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productinventory/logoNatNatInventory.png"))); // NOI18N

        mainMenuJPanel.setBackground(new java.awt.Color(0, 0, 255));

        mainMenuJLabel.setBackground(new java.awt.Color(0, 0, 255));
        mainMenuJLabel.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        mainMenuJLabel.setForeground(new java.awt.Color(255, 255, 255));
        mainMenuJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainMenuJLabel.setText("MAIN MENU");

        javax.swing.GroupLayout mainMenuJPanelLayout = new javax.swing.GroupLayout(mainMenuJPanel);
        mainMenuJPanel.setLayout(mainMenuJPanelLayout);
        mainMenuJPanelLayout.setHorizontalGroup(
            mainMenuJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainMenuJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainMenuJPanelLayout.setVerticalGroup(
            mainMenuJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainMenuJPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainMenuJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        vendorJButton.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        vendorJButton.setForeground(new java.awt.Color(0, 0, 153));
        vendorJButton.setText("Vendor");
        vendorJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorJButtonActionPerformed(evt);
            }
        });

        productJButton.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        productJButton.setForeground(new java.awt.Color(0, 0, 153));
        productJButton.setText("Product");
        productJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productJButtonActionPerformed(evt);
            }
        });

        purchaseJButton.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        purchaseJButton.setForeground(new java.awt.Color(0, 0, 153));
        purchaseJButton.setText("Purchase");
        purchaseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseJButtonActionPerformed(evt);
            }
        });

        salesJButton.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        salesJButton.setForeground(new java.awt.Color(0, 0, 153));
        salesJButton.setText("Sales");
        salesJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesJButtonActionPerformed(evt);
            }
        });

        logOutJButton.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        logOutJButton.setForeground(new java.awt.Color(255, 0, 0));
        logOutJButton.setText("LOG OUT");
        logOutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainMenuJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(logoJLabel)
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vendorJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(purchaseJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salesJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logOutJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(215, 215, 215))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(logoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(mainMenuJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(vendorJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(purchaseJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salesJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logOutJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void vendorJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendorJButtonActionPerformed
        // TODO add your handling code here:
        new VendorJFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_vendorJButtonActionPerformed

    private void productJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productJButtonActionPerformed
        // TODO add your handling code here:
        new ProductJFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_productJButtonActionPerformed

    private void purchaseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseJButtonActionPerformed
        // TODO add your handling code here:
        new PurchaseJFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_purchaseJButtonActionPerformed

    private void salesJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesJButtonActionPerformed
        // TODO add your handling code here:
        new SalesJFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_salesJButtonActionPerformed

    private void logOutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutJButtonActionPerformed
        // TODO add your handling code here:
        new LoginJFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logOutJButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton logOutJButton;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JLabel mainMenuJLabel;
    private javax.swing.JPanel mainMenuJPanel;
    private javax.swing.JButton productJButton;
    private javax.swing.JButton purchaseJButton;
    private javax.swing.JButton salesJButton;
    private javax.swing.JButton vendorJButton;
    // End of variables declaration//GEN-END:variables
}
