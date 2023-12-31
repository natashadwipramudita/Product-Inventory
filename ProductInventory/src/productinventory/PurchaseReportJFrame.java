/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package productinventory;

/**
 *
 * @author WINDOWS 10
 */
import java.awt.event.KeyEvent;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PurchaseReportJFrame extends javax.swing.JFrame {

    /**
     * Creates new form PurchaseReportJFrame
     */
    public PurchaseReportJFrame() {
        initComponents();
        Connect();
        Fetch();
    }

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public void Connect() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/dbinventory";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                System.out.println("Error connection!");
            }
        }
    }

    public void Fetch() {
        try {
            int q;
            preparedStatement = connection.prepareStatement("SELECT `purchase_item_tbl`.`purchase_id`, `purchase_tbl`.`date`, `purchase_tbl`.`vendor_name`, `purchase_item_tbl`.`product_id`, `product_tbl`.`product_name`, `purchase_item_tbl`.`product_cost_price`, `purchase_item_tbl`.`quantity`, `purchase_item_tbl`.`total`\n"
                    + "FROM `purchase_item_tbl` \n"
                    + "	LEFT JOIN `purchase_tbl` ON `purchase_item_tbl`.`purchase_id` = `purchase_tbl`.`purchase_id` \n"
                    + "	LEFT JOIN `product_tbl` ON `purchase_item_tbl`.`product_id` = `product_tbl`.`product_id`;");
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rss = resultSet.getMetaData();
            q = rss.getColumnCount();

            DefaultTableModel defaultTable = (DefaultTableModel) purchaseJTable.getModel();
            defaultTable.setRowCount(0);
            while (resultSet.next()) {
                Vector vector = new Vector();
                for (int a = 1; a <= q; a++) {
                    vector.add(resultSet.getString("purchase_id"));
                    vector.add(resultSet.getString("date"));
                    vector.add(resultSet.getString("vendor_name"));
                    vector.add(resultSet.getString("product_id"));
                    vector.add(resultSet.getString("product_name"));
                    vector.add(resultSet.getString("product_cost_price"));
                    vector.add(resultSet.getString("quantity"));
                    vector.add(resultSet.getString("total"));
                }
                defaultTable.addRow(vector);
            }

            int sumPrice = 0;

            for (int i = 0; i < purchaseJTable.getRowCount(); i++) {
                sumPrice += Integer.parseInt(purchaseJTable.getValueAt(i, 7).toString());
            }

            totalCostJTextField.setText(String.valueOf(sumPrice));

            int sumQuantity = 0;

            for (int i = 0; i < purchaseJTable.getRowCount(); i++) {
                sumQuantity += Integer.parseInt(purchaseJTable.getValueAt(i, 6).toString());
            }

            totalQuantityJTextField.setText(String.valueOf(sumQuantity));
        } catch (SQLException ex) {
            Logger.getLogger(ProductJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        purchaseReportJLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseJTable = new javax.swing.JTable();
        totalCostJTextField = new javax.swing.JTextField();
        totalCostJLabel = new javax.swing.JLabel();
        totalQuantityProductPurchaseJLabel = new javax.swing.JLabel();
        totalQuantityJTextField = new javax.swing.JTextField();
        closeJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        purchaseReportJLabel.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        purchaseReportJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        purchaseReportJLabel.setText("PURCHASE REPORT");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        purchaseJTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        purchaseJTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        purchaseJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Purchase ID", "Date", "Vendor Name", "Product ID", "Product Name", "Price", "Quantity", "Total"
            }
        ));
        jScrollPane1.setViewportView(purchaseJTable);
        if (purchaseJTable.getColumnModel().getColumnCount() > 0) {
            purchaseJTable.getColumnModel().getColumn(0).setHeaderValue("Purchase ID");
            purchaseJTable.getColumnModel().getColumn(1).setHeaderValue("Date");
            purchaseJTable.getColumnModel().getColumn(2).setHeaderValue("Vendor Name");
            purchaseJTable.getColumnModel().getColumn(3).setHeaderValue("Product ID");
            purchaseJTable.getColumnModel().getColumn(4).setHeaderValue("Product Name");
            purchaseJTable.getColumnModel().getColumn(5).setHeaderValue("Price");
            purchaseJTable.getColumnModel().getColumn(6).setHeaderValue("Quantity");
            purchaseJTable.getColumnModel().getColumn(7).setHeaderValue("Total");
        }

        totalCostJLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        totalCostJLabel.setText("Total Purchase");

        totalQuantityProductPurchaseJLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        totalQuantityProductPurchaseJLabel.setText("Total Quantity Product Purchase");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(totalQuantityProductPurchaseJLabel)
                            .addComponent(totalCostJLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalCostJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalQuantityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalQuantityProductPurchaseJLabel)
                    .addComponent(totalQuantityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalCostJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalCostJLabel))
                .addContainerGap(14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        closeJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        closeJButton.setText("CLOSE");
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(purchaseReportJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(closeJButton)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(purchaseReportJLabel)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closeJButton)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeJButtonActionPerformed
        // TODO add your handling code here:
        new PurchaseJFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_closeJButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PurchaseReportJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseReportJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseReportJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseReportJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton closeJButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable purchaseJTable;
    private javax.swing.JLabel purchaseReportJLabel;
    private javax.swing.JLabel totalCostJLabel;
    private javax.swing.JTextField totalCostJTextField;
    private javax.swing.JTextField totalQuantityJTextField;
    private javax.swing.JLabel totalQuantityProductPurchaseJLabel;
    // End of variables declaration//GEN-END:variables
}
