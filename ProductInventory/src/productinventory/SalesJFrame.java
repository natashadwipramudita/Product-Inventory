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

public class SalesJFrame extends javax.swing.JFrame {

    /**
     * Creates new form SalesJFrame
     */
    public SalesJFrame() {
        initComponents();
        Connect();
    }

    Connection connection;
    PreparedStatement preparedStatement;
    PreparedStatement preparedStatement1;
    PreparedStatement preparedStatement2;
    DefaultTableModel defaultTable;
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
    
    public void ProductID(){
        try {
            String product_id = productIDJTextField.getText();
            preparedStatement = connection.prepareStatement("SELECT * FROM product_tbl where product_id=?");
            preparedStatement.setString(1, product_id);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next() == false) {
                JOptionPane.showMessageDialog(this, "Product ID not found");
                productIDJTextField.setText("");
            } else {
                String product_name = resultSet.getString("product_name");
                String price = resultSet.getString("product_retail_price");
                
                productNameJTextField.setText(product_name.trim());
                productPriceJTextField.setText(price.trim());
                productQuantityJTextField.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Sales() {
        try {
            String product_id = productIDJTextField.getText();
            preparedStatement = connection.prepareStatement("SELECT * FROM product_tbl where product_id=?");
            preparedStatement.setString(1, product_id);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                int currentQuantity;
                currentQuantity = resultSet.getInt("product_quantity");
                
                int price = Integer.parseInt(productPriceJTextField.getText());
                int quantity = Integer.parseInt(productQuantityJTextField.getText());
        
                int total = price * quantity;
                
                if (quantity > currentQuantity) {
                    JOptionPane.showMessageDialog(this, "Quantity Is Not Enough!");
                } else {
                    defaultTable = (DefaultTableModel)salesJTable.getModel();
                    defaultTable.addRow(new Object[]{
                        productIDJTextField.getText(),
                        productNameJTextField.getText(),
                        productPriceJTextField.getText(),
                        productQuantityJTextField.getText(),
                        total
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        int sum = 0;
        
        for (int i = 0; i < salesJTable.getRowCount(); i++) {
            sum += Integer.parseInt(salesJTable.getValueAt(i, 4).toString());
        }
        
        totalCostJTextField.setText(String.valueOf(sum));
        
        productIDJTextField.setText("");
        productNameJTextField.setText("");
        productPriceJTextField.setText("");
        productQuantityJTextField.setText("");
    }
    
    public void Add() {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            String date = dateTimeFormatter.format(now);
            String subtotal = totalCostJTextField.getText();
            String payment = paymentJTextField.getText();
            String balance = balanceJTextField.getText();
            
            int lastid = 0;
            
            String query1 = "INSERT INTO sales_tbl (date,subtotal,payment,balance) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, subtotal);
            preparedStatement.setString(3, payment);
            preparedStatement.setString(4, balance);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            
            if (resultSet.next()) {
                lastid = resultSet.getInt(1);
            } 
            
            String query2 = "INSERT INTO sales_product_tbl(sales_id,product_id,product_retail_price,quantity,total) VALUES (?,?,?,?,?)";
            preparedStatement1 = connection.prepareStatement(query2);
            
            String productid;
            String price;
            String quantity;
            int total=0;
            
            for (int i = 0; i < salesJTable.getRowCount(); i++) {
                productid = (String)salesJTable.getValueAt(i, 0);
                price = (String)salesJTable.getValueAt(i, 2);
                quantity = (String)salesJTable.getValueAt(i, 3);
                total = (int)salesJTable.getValueAt(i, 4);
                
                preparedStatement1.setInt(1, lastid);
                preparedStatement1.setString(2, productid);
                preparedStatement1.setString(3, price);
                preparedStatement1.setString(4, quantity);
                preparedStatement1.setInt(5, total);
                preparedStatement1.executeUpdate();
            }
            
            String query3 = "UPDATE product_tbl SET product_quantity = product_quantity - ? WHERE product_id = ?";
            preparedStatement2 = connection.prepareStatement(query3);
            for (int i = 0; i < salesJTable.getRowCount(); i++) {
                productid = (String)salesJTable.getValueAt(i, 0);
                quantity = (String)salesJTable.getValueAt(i, 3);
                
                preparedStatement2.setString(1, quantity);
                preparedStatement2.setString(2, productid);
                preparedStatement2.executeUpdate();
            }
            JOptionPane.showMessageDialog(this, "Sales Completed!");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseJFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        salesJLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        productIDJLabel = new javax.swing.JLabel();
        productNameJLabel = new javax.swing.JLabel();
        productPriceJLabel = new javax.swing.JLabel();
        productQuantityJLabel = new javax.swing.JLabel();
        addJButton = new javax.swing.JButton();
        productIDJTextField = new javax.swing.JTextField();
        productNameJTextField = new javax.swing.JTextField();
        productPriceJTextField = new javax.swing.JTextField();
        productQuantityJTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        salesJTable = new javax.swing.JTable();
        totalCostJLabel = new javax.swing.JLabel();
        totalCostJTextField = new javax.swing.JTextField();
        paymentJLabel = new javax.swing.JLabel();
        paymentJTextField = new javax.swing.JTextField();
        balanceJLabel = new javax.swing.JLabel();
        balanceJTextField = new javax.swing.JTextField();
        addInvoiceJButton = new javax.swing.JButton();
        closeJButton = new javax.swing.JButton();
        viewSalesReportJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        salesJLabel.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        salesJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salesJLabel.setText("SALES");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        productIDJLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        productIDJLabel.setText("Product ID");

        productNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        productNameJLabel.setText("Product Name");

        productPriceJLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        productPriceJLabel.setText("Price");

        productQuantityJLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        productQuantityJLabel.setText("Quantity");

        addJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        addJButton.setText("ADD");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        productIDJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productIDJTextFieldKeyPressed(evt);
            }
        });

        salesJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Price", "Quantity", "Total"
            }
        ));
        jScrollPane1.setViewportView(salesJTable);

        totalCostJLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        totalCostJLabel.setText("Total Cost");

        paymentJLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        paymentJLabel.setText("Payment");

        balanceJLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        balanceJLabel.setText("Balance");

        addInvoiceJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        addInvoiceJButton.setText("ADD INVOICE");
        addInvoiceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInvoiceJButtonActionPerformed(evt);
            }
        });

        closeJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        closeJButton.setText("CLOSE");
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(totalCostJTextField)
                                    .addComponent(paymentJTextField)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(totalCostJLabel)
                                            .addComponent(paymentJLabel)
                                            .addComponent(balanceJLabel))
                                        .addGap(0, 135, Short.MAX_VALUE))
                                    .addComponent(balanceJTextField)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productIDJLabel)
                                    .addComponent(productIDJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productNameJLabel)
                                    .addComponent(productNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productPriceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productPriceJLabel))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(productQuantityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(addJButton))
                                    .addComponent(productQuantityJLabel)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(addInvoiceJButton)
                        .addGap(18, 18, 18)
                        .addComponent(closeJButton)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productIDJLabel)
                    .addComponent(productNameJLabel)
                    .addComponent(productPriceJLabel)
                    .addComponent(productQuantityJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productIDJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productPriceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productQuantityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addJButton))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(totalCostJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalCostJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(paymentJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paymentJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(balanceJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(balanceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addInvoiceJButton)
                    .addComponent(closeJButton))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        viewSalesReportJButton.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        viewSalesReportJButton.setText("View Sales Report");
        viewSalesReportJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSalesReportJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salesJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewSalesReportJButton)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salesJLabel)
                    .addComponent(viewSalesReportJButton))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        // TODO add your handling code here:
        Sales();
    }//GEN-LAST:event_addJButtonActionPerformed

    private void productIDJTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productIDJTextFieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ProductID();
        }
    }//GEN-LAST:event_productIDJTextFieldKeyPressed

    private void addInvoiceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInvoiceJButtonActionPerformed
        // TODO add your handling code here:
        int payment = Integer.parseInt(paymentJTextField.getText());
        int subtotal = Integer.parseInt(totalCostJTextField.getText());
        int balance = payment - subtotal;

        balanceJTextField.setText(String.valueOf(balance));
        Add();
    }//GEN-LAST:event_addInvoiceJButtonActionPerformed

    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeJButtonActionPerformed
        // TODO add your handling code here:
        new MainJFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_closeJButtonActionPerformed

    private void viewSalesReportJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSalesReportJButtonActionPerformed
        // TODO add your handling code here:
        new SalesReportJFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_viewSalesReportJButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SalesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton addInvoiceJButton;
    private javax.swing.JButton addJButton;
    private javax.swing.JLabel balanceJLabel;
    private javax.swing.JTextField balanceJTextField;
    private javax.swing.JButton closeJButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel paymentJLabel;
    private javax.swing.JTextField paymentJTextField;
    private javax.swing.JLabel productIDJLabel;
    private javax.swing.JTextField productIDJTextField;
    private javax.swing.JLabel productNameJLabel;
    private javax.swing.JTextField productNameJTextField;
    private javax.swing.JLabel productPriceJLabel;
    private javax.swing.JTextField productPriceJTextField;
    private javax.swing.JLabel productQuantityJLabel;
    private javax.swing.JTextField productQuantityJTextField;
    private javax.swing.JLabel salesJLabel;
    private javax.swing.JTable salesJTable;
    private javax.swing.JLabel totalCostJLabel;
    private javax.swing.JTextField totalCostJTextField;
    private javax.swing.JButton viewSalesReportJButton;
    // End of variables declaration//GEN-END:variables
}
