
package admins;

import config.dbConnector;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import transition.TransitionsForm;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class sales extends  TransitionsForm{

    public sales() {
        initComponents();
        init();
        displayData();
        productSold();
        totalSales();
        dailySales();
    }
    
    public static String getCurrentDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return today.format(formatter);
    }
//    private void init(){
//        product.fixTable(scrollPaneWin111);
//    }
//    
//    public boolean refresh = false;
//    
//    public void displayData(){
//        try{
//            dbConnector dbc = new dbConnector();
//            ResultSet rs = dbc.getData("SELECT Id, Product_Name, Category, Price, Quantity FROM product_table");
//            product.setModel(DbUtils.resultSetToTableModel(rs));
//            rs.close();
//        }catch(SQLException ex){
//            System.out.println("Errors: "+ex.getMessage());
//        }
//    }
    
    private void init(){
        sales_list.fixTable(jScrollPane1);
    }
    
//    public void displayData(){
//        try{
//            dbConnector dbc = new dbConnector();
//            ResultSet rs = dbc.getData("SELECT sales.Id AS Sale_Id, product_table.Product_Name, product_table.Category, " +
//                       "product_table.Price, sales.Quantity_Sold " +
//                       "FROM sales " +
//                       "JOIN product_table ON sales.products_Id = product_table.Id");
//            sales_list.setModel(DbUtils.resultSetToTableModel(rs));
//            rs.close();
//        }catch(SQLException ex){
//            System.out.println("Errors: "+ex.getMessage());
//        }
//    }
//    public void displayData(){
//        try {
//            dbConnector dbc = new dbConnector();
//            ResultSet rs = dbc.getData(
//                "SELECT sales.Id AS Sale_Id, product_table.Product_Name, product_table.Category, " +
//                "product_table.Price, sales.Quantity_Sold " +
//                "FROM sales " +
//                "JOIN product_table ON sales.products_Id = product_table.Id " +
//                "ORDER BY sales.Quantity_Sold DESC" // Order by Quantity_Sold in descending order
//            );
//            sales_list.setModel(DbUtils.resultSetToTableModel(rs));
//            rs.close();
//        } catch (SQLException ex) {
//            System.out.println("Errors: " + ex.getMessage());
//        }
//    }
    
    public void displayData(){
        try {
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData(
                "SELECT sales.Id AS Sales_Id, product_table.Product_Name, product_table.Category, " +
                "product_table.Price, sales.Quantity_Sold, " +
                "(product_table.Price * sales.Quantity_Sold) AS Total " +  
                "FROM sales " +
                "JOIN product_table ON sales.products_Id = product_table.Id " +
                "ORDER BY sales.Quantity_Sold DESC" 
            );
            sales_list.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }

    public void productSold(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT COUNT(*) AS NROWS FROM sales");
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt("NROWS");
            }
            product.setText(""+rowCount+" ");
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    
    public void totalSales() {
        try {
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData(
                "SELECT SUM(product_table.Price * sales.Quantity_Sold) AS TotalSales " +
                "FROM sales " +
                "JOIN product_table ON sales.products_Id = product_table.Id"
            );
            double totalSales = 0;
            if (rs.next()) {
                totalSales = rs.getDouble("TotalSales"); 
            }
            totalSale.setText("₱" + String.format("%.2f", totalSales)); 
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }
    
//    public void dailySales() {
//        try {
//            dbConnector dbc = new dbConnector();
//            ResultSet rs = dbc.getData(
//                "SELECT SUM(product_table.Price * sales.Quantity_Sold) AS TotalSales " +
//                "FROM sales " +
//                "JOIN product_table ON sales.products_Id = product_table.Id"
//            );
//            double totalSales = 0;
//            if (rs.next()) {
//                totalSales = rs.getDouble("TotalSales"); 
//            }
//            dailySales.setText("₱" + String.format("%.2f", totalSales)); 
//        } catch (SQLException ex) {
//            System.out.println("Errors: " + ex.getMessage());
//        }
//    }
    public void dailySales() {
        try {
            dbConnector dbc = new dbConnector();
            String currentDate = getCurrentDate();
            ResultSet rs = dbc.getData(
                "SELECT SUM(product_table.Price * sales.Quantity_Sold) AS TotalSales " +
                "FROM sales " +
                "JOIN product_table ON sales.products_Id = product_table.Id " +
                "WHERE sales.Date = '" + currentDate + "'" // Filter by today's date
            );
            
            double totalSales = 0;
            if (rs.next()) {
                totalSales = rs.getDouble("TotalSales"); 
            }
            dailySales.setText("₱" + String.format("%.2f", totalSales)); 
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }

    
    public void countOfAllProducts(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT COUNT(*) AS NROWS FROM product_table");
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt("NROWS");
            }
            product.setText(""+rowCount+" ");
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        roundPanel5 = new panelRoundComponents.RoundPanel();
        jScrollPane1 = new scrollPane.ScrollPaneWin11();
        sales_list = new table.Table();
        label = new javax.swing.JLabel();
        panelRound4 = new panelRoundComponents.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new panelRoundComponents.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        totalSale = new javax.swing.JLabel();
        panelRound2 = new panelRoundComponents.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        product = new javax.swing.JLabel();
        panelRound3 = new panelRoundComponents.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        dailySales = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1030, 527));

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1030, 490));

        roundPanel5.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel5.setRound(10);

        jScrollPane1.setBorder(null);

        sales_list.setForeground(new java.awt.Color(153, 153, 153));
        sales_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        sales_list.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sales_list.setShowVerticalLines(false);
        jScrollPane1.setViewportView(sales_list);

        label.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        label.setForeground(new java.awt.Color(153, 153, 153));
        label.setText("Sale's list");

        panelRound4.setBackground(new java.awt.Color(83, 215, 105));
        panelRound4.setRoundBottomLeft(10);
        panelRound4.setRoundBottomRight(10);
        panelRound4.setRoundTopLeft(10);
        panelRound4.setRoundTopRight(10);
        panelRound4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Print");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addComponent(label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Dashboard");

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setForeground(new java.awt.Color(0, 204, 0));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 128, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total Sales");

        totalSale.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        totalSale.setForeground(new java.awt.Color(0, 128, 0));
        totalSale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalSale.setText("0");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(totalSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(totalSale)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setForeground(new java.awt.Color(0, 204, 0));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(41, 123, 250));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Product");

        product.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        product.setForeground(new java.awt.Color(41, 123, 250));
        product.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        product.setText("0");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(product)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setForeground(new java.awt.Color(0, 204, 0));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(252, 61, 57));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Daily Sales");

        dailySales.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        dailySales.setForeground(new java.awt.Color(252, 61, 57));
        dailySales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dailySales.setText("0");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(dailySales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(dailySales)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelRound4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound4MouseClicked
        try {
            boolean print = sales_list.print();
            if (!print) {
                JOptionPane.showMessageDialog(null, "Unable To Print !!..");
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_panelRound4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dailySales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private panelRoundComponents.PanelRound panelRound1;
    private panelRoundComponents.PanelRound panelRound2;
    private panelRoundComponents.PanelRound panelRound3;
    private panelRoundComponents.PanelRound panelRound4;
    private javax.swing.JLabel product;
    private panelRoundComponents.RoundPanel roundPanel5;
    private table.Table sales_list;
    private javax.swing.JLabel totalSale;
    // End of variables declaration//GEN-END:variables
}
