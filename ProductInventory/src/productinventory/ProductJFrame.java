/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package productinventory;

/**
 *
 * @author WINDOWS 10
 */

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileFilter;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class ProductJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ProductJFrame
     */
    public ProductJFrame() {
        initComponents();
        Connect();
        LoadProductNo();
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
    
    public void LoadProductNo() {
        try {
            preparedStatement = connection.prepareStatement("SELECT product_id FROM product_tbl");
            resultSet = preparedStatement.executeQuery();
            productIDJComboBox.removeAllItems();
            while(resultSet.next()) {
                productIDJComboBox.addItem(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Fetch() {
        try {
            int q;
            preparedStatement = connection.prepareStatement("SELECT * FROM product_tbl");
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rss = resultSet.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel defaultTable = (DefaultTableModel)dataJTable.getModel();
            defaultTable.setRowCount(0);
            while(resultSet.next()) {
                Vector vector = new Vector();
                for(int a=1; a<=q; a++) {
                    vector.add(resultSet.getString("product_id"));
                    vector.add(resultSet.getString("product_name"));
                    vector.add(resultSet.getString("product_cost_price"));
                    vector.add(resultSet.getString("product_retail_price"));
                    vector.add(resultSet.getString("product_quantity"));                    
                }
                defaultTable.addRow(vector);
            }
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

        productJLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        productNameJTextField = new javax.swing.JTextField();
        productCostPriceJTextField = new javax.swing.JTextField();
        productQuantityJTextField = new javax.swing.JTextField();
        productIDJComboBox = new javax.swing.JComboBox<>();
        productIDJLabel = new javax.swing.JLabel();
        searchJButton = new javax.swing.JButton();
        addJButton = new javax.swing.JButton();
        updateJButton = new javax.swing.JButton();
        productNameJLabel = new javax.swing.JLabel();
        deleteJButton = new javax.swing.JButton();
        productCostPriceJLabel = new javax.swing.JLabel();
        exportToCSVJButton = new javax.swing.JButton();
        productQuantityJLabel = new javax.swing.JLabel();
        exportToPDFJButton = new javax.swing.JButton();
        cancelJButton = new javax.swing.JButton();
        productRetailPriceJLabel = new javax.swing.JLabel();
        productRetailPriceJTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataJTable = new javax.swing.JTable();
        closeJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        productJLabel.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        productJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productJLabel.setText("PRODUCT");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INPUT DATA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        productNameJTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        productNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameJTextFieldActionPerformed(evt);
            }
        });

        productCostPriceJTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        productQuantityJTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        productIDJComboBox.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        productIDJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        productIDJLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        productIDJLabel.setText("Product ID");

        searchJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        searchJButton.setText("SEARCH");
        searchJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJButtonActionPerformed(evt);
            }
        });

        addJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        addJButton.setForeground(new java.awt.Color(0, 0, 255));
        addJButton.setText("ADD");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        updateJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        updateJButton.setForeground(new java.awt.Color(255, 153, 0));
        updateJButton.setText("UPDATE");
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });

        productNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        productNameJLabel.setText("Product Name");

        deleteJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        deleteJButton.setForeground(new java.awt.Color(255, 0, 0));
        deleteJButton.setText("DELETE");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });

        productCostPriceJLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        productCostPriceJLabel.setText("Cost Price");

        exportToCSVJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exportToCSVJButton.setText("Export to CSV");
        exportToCSVJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportToCSVJButtonActionPerformed(evt);
            }
        });

        productQuantityJLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        productQuantityJLabel.setText("Quantity");

        exportToPDFJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exportToPDFJButton.setText("Export to PDF");
        exportToPDFJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportToPDFJButtonActionPerformed(evt);
            }
        });

        cancelJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cancelJButton.setText("CANCEL");
        cancelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJButtonActionPerformed(evt);
            }
        });

        productRetailPriceJLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        productRetailPriceJLabel.setText("Retail Price");

        productRetailPriceJTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(exportToCSVJButton)
                        .addGap(18, 18, 18)
                        .addComponent(exportToPDFJButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productNameJLabel)
                            .addComponent(productCostPriceJLabel)
                            .addComponent(productQuantityJLabel)
                            .addComponent(productRetailPriceJLabel))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(productNameJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(productCostPriceJTextField)
                            .addComponent(productQuantityJTextField)
                            .addComponent(productRetailPriceJTextField))
                        .addGap(53, 53, 53)
                        .addComponent(productIDJLabel)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productIDJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addJButton)
                        .addGap(18, 18, 18)
                        .addComponent(updateJButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteJButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelJButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productNameJLabel)
                    .addComponent(productNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productIDJLabel)
                    .addComponent(productIDJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productCostPriceJLabel)
                    .addComponent(productCostPriceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchJButton))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productRetailPriceJLabel)
                    .addComponent(productRetailPriceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productQuantityJLabel)
                    .addComponent(productQuantityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addJButton)
                    .addComponent(updateJButton)
                    .addComponent(deleteJButton)
                    .addComponent(cancelJButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportToCSVJButton)
                    .addComponent(exportToPDFJButton))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        dataJTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dataJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Cost Price", "Retail Price", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(dataJTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        closeJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
            .addComponent(productJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(closeJButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(productJLabel)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closeJButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void productNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameJTextFieldActionPerformed

    private void searchJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJButtonActionPerformed
        try {
            // TODO add your handling code here:
            String product_id = productIDJComboBox.getSelectedItem().toString();

            preparedStatement = connection.prepareStatement("SELECT * FROM product_tbl WHERE product_id=?");
            preparedStatement.setString(1, product_id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()==true) {
                productNameJTextField.setText(resultSet.getString(2));
                productCostPriceJTextField.setText(resultSet.getString(3));
                productRetailPriceJTextField.setText(resultSet.getString(4));
                productQuantityJTextField.setText(resultSet.getString(5));
            } else {
                JOptionPane.showMessageDialog(this, "Record Not Found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        addJButton.setEnabled(false);
    }//GEN-LAST:event_searchJButtonActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        if(productNameJTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product name is required");
        } else if (productCostPriceJTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product cost price is required");
        } else if (productRetailPriceJTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product retail price is required");
        } else if (productQuantityJTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product quantity is required");
        } else {
            try {
                // TODO add your handling code here:
                String product_name = productNameJTextField.getText();
                String product_cost_price = productCostPriceJTextField.getText();
                String product_retail_price = productRetailPriceJTextField.getText();
                String product_quantity = productQuantityJTextField.getText();

                preparedStatement = connection.prepareStatement("INSERT INTO product_tbl (product_name,product_cost_price,product_retail_price,product_quantity) VALUES (?,?,?,?)");

                preparedStatement.setString(1, product_name);
                preparedStatement.setString(2, product_cost_price);
                preparedStatement.setString(3, product_retail_price);
                preparedStatement.setString(4, product_quantity);

                int k = preparedStatement.executeUpdate();

                if(k==1){
                    JOptionPane.showMessageDialog(this, "Record Successfully Added");
                    productNameJTextField.setText("");
                    productCostPriceJTextField.setText("");
                    productRetailPriceJTextField.setText("");
                    productQuantityJTextField.setText("");
                    Fetch();
                    LoadProductNo();
                } else {
                    JOptionPane.showMessageDialog(this, "Record Failed to Add");
                }

            } catch (SQLException ex) {
                Logger.getLogger(ProductJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addJButtonActionPerformed

    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJButtonActionPerformed
        if(productNameJTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product name is required");
        } else if (productCostPriceJTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product cost price is required");
        } else if (productRetailPriceJTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product retail price is required");
        } else if (productQuantityJTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product quantity is required");
        } else {
            try {
                // TODO add your handling code here:
                String product_name = productNameJTextField.getText();
                String product_cost_price = productCostPriceJTextField.getText();
                String product_retail_price = productRetailPriceJTextField.getText();
                String product_quantity = productQuantityJTextField.getText();
                String product_id = productIDJComboBox.getSelectedItem().toString();

                preparedStatement = connection.prepareStatement("UPDATE product_tbl SET product_name=?,product_cost_price=?,product_retail_price=?,product_quantity=? WHERE product_id=?");

                preparedStatement.setString(1, product_name);
                preparedStatement.setString(2, product_cost_price);
                preparedStatement.setString(3, product_retail_price);
                preparedStatement.setString(4, product_quantity);
                preparedStatement.setString(5, product_id);

                int k = preparedStatement.executeUpdate();

                if(k==1){
                    JOptionPane.showMessageDialog(this, "Record Successfully Updated");
                    productNameJTextField.setText("");
                    productCostPriceJTextField.setText("");
                    productRetailPriceJTextField.setText("");
                    productQuantityJTextField.setText("");
                    productNameJTextField.requestFocus();
                    Fetch();
                    LoadProductNo();
                } else {
                    JOptionPane.showMessageDialog(this, "Record Failed to Update");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        addJButton.setEnabled(true);
    }//GEN-LAST:event_updateJButtonActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        try {
            // TODO add your handling code here:
            String product_id = productIDJComboBox.getSelectedItem().toString();

            preparedStatement = connection.prepareStatement("DELETE FROM product_tbl WHERE product_id=?");
            preparedStatement.setString(1, product_id);

            int k = preparedStatement.executeUpdate();

            if(k==1){
                JOptionPane.showMessageDialog(this, "Record Successfully Deleted");
                productNameJTextField.setText("");
                productCostPriceJTextField.setText("");
                productRetailPriceJTextField.setText("");
                productQuantityJTextField.setText("");
                productNameJTextField.requestFocus();
                Fetch();
                LoadProductNo();
            } else {
                JOptionPane.showMessageDialog(this, "Record Failed to Delete");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        addJButton.setEnabled(true);
    }//GEN-LAST:event_deleteJButtonActionPerformed

    private void exportToCSVJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportToCSVJButtonActionPerformed
        // TODO add your handling code here:
        String fileName = "D:\\ExportedCSVFileJava.csv";

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            preparedStatement = connection.prepareStatement("SELECT * FROM product_tbl");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                fileWriter.append(resultSet.getString(1));
                fileWriter.append(',');
                fileWriter.append(resultSet.getString(2));
                fileWriter.append(',');
                fileWriter.append(resultSet.getString(3));
                fileWriter.append(',');
                fileWriter.append(resultSet.getString(4));
                fileWriter.append(',');
                fileWriter.append(resultSet.getString(5));
                fileWriter.append('\n');
            }
            JOptionPane.showMessageDialog(this, "CSV File Successfully Exported");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(ProductJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exportToCSVJButtonActionPerformed

    private void exportToPDFJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportToPDFJButtonActionPerformed
        try {
            // TODO add your handling code here: exportToPDFJButton
            preparedStatement = connection.prepareStatement("SELECT * FROM product_tbl");
            resultSet = preparedStatement.executeQuery();

            Document reportPDF = new Document();
            PdfWriter.getInstance(reportPDF, new FileOutputStream("D:\\ExportedReportPDFJava.pdf"));

            reportPDF.open();

            PdfPTable PDFTable = new PdfPTable(5);
            PdfPCell table_cell;

            while(resultSet.next()){
                String product_id = resultSet.getString("product_id");
                table_cell = new PdfPCell(new Phrase(product_id));
                PDFTable.addCell(table_cell);

                String product_name = resultSet.getString("product_name");
                table_cell = new PdfPCell(new Phrase(product_name));
                PDFTable.addCell(table_cell);

                String product_cost_price = resultSet.getString("product_cost_price");
                table_cell = new PdfPCell(new Phrase(product_cost_price));
                PDFTable.addCell(table_cell);

                String product_retail_price = resultSet.getString("product_retail_price");
                table_cell = new PdfPCell(new Phrase(product_retail_price));
                PDFTable.addCell(table_cell);
                
                String product_quantity = resultSet.getString("product_quantity");
                table_cell = new PdfPCell(new Phrase(product_quantity));
                PDFTable.addCell(table_cell);
            }
            JOptionPane.showMessageDialog(this, "PDF File Successfully Exported");
            reportPDF.add(PDFTable);
            reportPDF.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ProductJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exportToPDFJButtonActionPerformed

    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        // TODO add your handling code here:
        productNameJTextField.setText("");
        productCostPriceJTextField.setText("");
        productRetailPriceJTextField.setText("");
        productQuantityJTextField.setText("");
        productNameJTextField.requestFocus();
        Fetch();
        LoadProductNo();
        addJButton.setEnabled(true);
    }//GEN-LAST:event_cancelJButtonActionPerformed

    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeJButtonActionPerformed
        // TODO add your handling code here:
        new MainJFrame().setVisible(true);
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
            java.util.logging.Logger.getLogger(ProductJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton addJButton;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JButton closeJButton;
    private javax.swing.JTable dataJTable;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JButton exportToCSVJButton;
    private javax.swing.JButton exportToPDFJButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel productCostPriceJLabel;
    private javax.swing.JTextField productCostPriceJTextField;
    private javax.swing.JComboBox<String> productIDJComboBox;
    private javax.swing.JLabel productIDJLabel;
    private javax.swing.JLabel productJLabel;
    private javax.swing.JLabel productNameJLabel;
    private javax.swing.JTextField productNameJTextField;
    private javax.swing.JLabel productQuantityJLabel;
    private javax.swing.JTextField productQuantityJTextField;
    private javax.swing.JLabel productRetailPriceJLabel;
    private javax.swing.JTextField productRetailPriceJTextField;
    private javax.swing.JButton searchJButton;
    private javax.swing.JButton updateJButton;
    // End of variables declaration//GEN-END:variables
}