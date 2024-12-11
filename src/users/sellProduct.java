
package users;

import config.dbConnector;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import transition.TransitionsForm;
import static users.stocks.getHeightFromWidth;

public class sellProduct extends  TransitionsForm{

    public sellProduct() {
        initComponents();
        init();
        cart = new ArrayList<>();
        displayData(); 
        cancel.setVisible(false);
        back.setVisible(false);
    }
    
    private void init(){
        product.fixTable(scrollPaneWin111);
    }
    
    public static String getCurrentDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return today.format(formatter);
    }
    
    private ArrayList<CartItem> cart;
    
    static class CartItem {
        String productId;
        String productName;
        int quantity;
        double price;
        double totalAmount;

        CartItem(String productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
            this.totalAmount = quantity * price;
        }
    }
    
    public void addToCart(String productId, String productName, int quantity, double price) {
        CartItem item = new CartItem(productId, productName, quantity, price);
        cart.add(item);
        calculateSubtotal();
        total.setText(String.valueOf(subtotal));
        JOptionPane.showMessageDialog(this, "Product added to cart!");
    }

    public void printAllOrders() {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cart is empty!");
            return;
        }

        System.out.println("All Orders:");
        for (CartItem item : cart) {
            System.out.println("Product ID: " + item.productId +
                               ", Product Name: " + item.productName +
                               ", Quantity: " + item.quantity +
                               ", Price: " + item.price +
                               ", Total: " + item.totalAmount);
        }
    }
    
    public void checkout() {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cart is empty!");
            return;
        }
        
        dbConnector dbc = new dbConnector();

        if (!(cash.getText().isEmpty())){
            
            double cashAmount = Double.parseDouble(cash.getText()); 
            double totalAmount = Double.parseDouble(total.getText());
            double changeAmount = cashAmount - totalAmount;
            
            if (changeAmount >= 0) {
                JOptionPane.showMessageDialog(null, "Total Amount: ₱" + total.getText() + "\nChange: ₱" + changeAmount);

                for (CartItem item : cart) {
                    String productId = item.productId;
                    int quantitySold = item.quantity;

                    try {
                        ResultSet rs = dbc.getData("SELECT Quantity FROM product_table WHERE Id = '" + productId + "'");
                        if (rs.next()) {
                            int currentQuantity = rs.getInt("Quantity");
                            String outOfStock = "Out of stock";
                            int productNewQuantity = currentQuantity - quantitySold;

                            dbc.updateDataProduct("UPDATE product_table SET Quantity = '" + productNewQuantity + "' WHERE Id = '" + productId + "'");
                            
                            if (productNewQuantity == 0){
                                dbc.updateData("UPDATE product_table SET status = '" + outOfStock + "' WHERE Id = '" + productId + "'");
                            }
                            
                            dbc.updateData("INSERT INTO sales (products_Id, Quantity_sold, Date) VALUES ('" + productId + "', '" + quantitySold + "', '" + getCurrentDate() + "')");
                        }
                        
                        displayData();
                    } catch (SQLException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                }

                change.setText("₱" + changeAmount);
                quantity.setText("0");
                total.setText(" ");
                cart.clear();
                cartCount.setText(String.valueOf(countProductsInCart()));
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient cash. You need ₱" + (-changeAmount) + " more.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please input a cash first.");
        }
        
    }

    double subtotal = 0;
    
    public void calculateSubtotal() {
        subtotal = 0;
        for (CartItem item : cart) {
            subtotal += item.totalAmount;
        }
    }
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
    public boolean refresh = false;
    
    public void orders(javax.swing.JTable ordersTable) {

    String[] columnNames = {"Product ID", "Product Name", "Quantity", "Price", "Total"};

    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

    for (CartItem item : cart) {
        Object[] rowData = {item.productId, item.productName, item.quantity, item.price, item.totalAmount};
        tableModel.addRow(rowData);
    }

    ordersTable.setModel(tableModel);
}
    
    public void displayData(){
        try {
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT Id, Product_Name, Category, Price, Quantity FROM product_table WHERE Stat = 'unarchive'");
            product.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }
    
    public void category(){
        try {
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT Id, Product_Name, Category, Price, Quantity FROM product_table WHERE Category = '" + cat.getSelectedItem() + "' AND Stat = 'unarchive'");
            product.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
        ImageIcon MyImage = null;
            if(ImagePath !=null){
                MyImage = new ImageIcon(ImagePath);
            }else{
                MyImage = new ImageIcon(pic);
            }

        int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        roundPanel1 = new panelRoundComponents.RoundPanel();
        scrollPaneWin111 = new scrollPane.ScrollPaneWin11();
        product = new table.Table();
        cat = new combo_suggestion.ComboBoxSuggestion();
        order = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cancel = new panelRoundComponents.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        cartCount = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        panelRound1 = new panelRoundComponents.PanelRound();
        searchBar = new javax.swing.JTextField();
        search = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        productName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        change = new javax.swing.JTextField();
        addToCart = new panelRoundComponents.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        clear = new panelRoundComponents.PanelRound();
        jLabel21 = new javax.swing.JLabel();
        refreshButton = new panelRoundComponents.PanelRound();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        cash = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        checkOut = new panelRoundComponents.PanelRound();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1030, 527));

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1030, 490));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setRound(10);
        roundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollPaneWin111.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        product.setForeground(new java.awt.Color(102, 102, 102));
        product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        product.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productMouseClicked(evt);
            }
        });
        scrollPaneWin111.setViewportView(product);

        roundPanel1.add(scrollPaneWin111, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 550, 300));

        cat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        cat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Snacks", "Drinks", "Canned goods", "Crackers", "Poultry products", "Beverage", "Condiments", "Dairy", "Grains ", "Bread", "Oil ", "Fat" }));
        cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catActionPerformed(evt);
            }
        });
        cat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                catKeyReleased(evt);
            }
        });
        roundPanel1.add(cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 159, -1));

        order.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        order.setForeground(new java.awt.Color(128, 128, 128));
        order.setText("Product's");
        roundPanel1.add(order, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, 20));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/black-cart.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        roundPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 40, 40));

        cancel.setBackground(new java.awt.Color(255, 0, 0));
        cancel.setRoundBottomLeft(10);
        cancel.setRoundBottomRight(10);
        cancel.setRoundTopLeft(10);
        cancel.setRoundTopRight(10);
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cancel");

        javax.swing.GroupLayout cancelLayout = new javax.swing.GroupLayout(cancel);
        cancel.setLayout(cancelLayout);
        cancelLayout.setHorizontalGroup(
            cancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addContainerGap())
        );
        cancelLayout.setVerticalGroup(
            cancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        roundPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 90, 30));

        cartCount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cartCount.setForeground(new java.awt.Color(255, 0, 0));
        cartCount.setText("0");
        roundPanel1.add(cartCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 10, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back-arrow.png"))); // NOI18N
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        roundPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(10);
        panelRound1.setRoundBottomRight(10);
        panelRound1.setRoundTopLeft(10);
        panelRound1.setRoundTopRight(10);

        searchBar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        searchBar.setForeground(new java.awt.Color(102, 102, 102));
        searchBar.setText("Search");
        searchBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(245, 245, 245), 2, true));
        searchBar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchBarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchBarFocusLost(evt);
            }
        });
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchBarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBarKeyReleased(evt);
            }
        });

        search.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-30.png"))); // NOI18N
        search.setToolTipText("Search");
        search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel12.setText("Product Code");

        pid.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        pid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        pid.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel13.setText("Product Name");

        productName.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        productName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        productName.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel16.setText("Price");

        price.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        price.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel15.setText("Change");

        change.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        change.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        change.setEnabled(false);

        addToCart.setBackground(new java.awt.Color(83, 215, 105));
        addToCart.setRoundBottomLeft(10);
        addToCart.setRoundBottomRight(10);
        addToCart.setRoundTopLeft(10);
        addToCart.setRoundTopRight(10);
        addToCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addToCartMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addToCartMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addToCartMouseReleased(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Add to cart");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-buy-18.png"))); // NOI18N

        javax.swing.GroupLayout addToCartLayout = new javax.swing.GroupLayout(addToCart);
        addToCart.setLayout(addToCartLayout);
        addToCartLayout.setHorizontalGroup(
            addToCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addToCartLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(28, 28, 28))
        );
        addToCartLayout.setVerticalGroup(
            addToCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        clear.setBackground(new java.awt.Color(91, 164, 252));
        clear.setRoundBottomLeft(10);
        clear.setRoundBottomRight(10);
        clear.setRoundTopLeft(10);
        clear.setRoundTopRight(10);
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clearMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clearMouseReleased(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-clear-18.png"))); // NOI18N

        javax.swing.GroupLayout clearLayout = new javax.swing.GroupLayout(clear);
        clear.setLayout(clearLayout);
        clearLayout.setHorizontalGroup(
            clearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clearLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(61, 61, 61))
        );
        clearLayout.setVerticalGroup(
            clearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        refreshButton.setBackground(new java.awt.Color(83, 215, 105));
        refreshButton.setRoundBottomLeft(10);
        refreshButton.setRoundBottomRight(10);
        refreshButton.setRoundTopLeft(10);
        refreshButton.setRoundTopRight(10);
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                refreshButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                refreshButtonMouseReleased(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("REFRESH");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-refresh-18.png"))); // NOI18N

        javax.swing.GroupLayout refreshButtonLayout = new javax.swing.GroupLayout(refreshButton);
        refreshButton.setLayout(refreshButtonLayout);
        refreshButtonLayout.setHorizontalGroup(
            refreshButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, refreshButtonLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(20, 20, 20))
        );
        refreshButtonLayout.setVerticalGroup(
            refreshButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 130));

        quantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        quantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });

        cash.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        cash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        cash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cashKeyReleased(evt);
            }
        });

        total.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        total.setEnabled(false);
        total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                totalKeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel17.setText("Quantity");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel18.setText("Recieved");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel19.setText("Total");

        checkOut.setBackground(new java.awt.Color(255, 200, 50));
        checkOut.setRoundBottomLeft(10);
        checkOut.setRoundBottomRight(10);
        checkOut.setRoundTopLeft(10);
        checkOut.setRoundTopRight(10);
        checkOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkOutMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Check out");

        javax.swing.GroupLayout checkOutLayout = new javax.swing.GroupLayout(checkOut);
        checkOut.setLayout(checkOutLayout);
        checkOutLayout.setHorizontalGroup(
            checkOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkOutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );
        checkOutLayout.setVerticalGroup(
            checkOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel15)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17)
                            .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(addToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(checkOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addToCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
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

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchBarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchBarFocusLost
        if (searchBar.getText().equals("")){
            searchBar.setText("Search");
            searchBar.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_searchBarFocusLost

    private void searchBarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchBarFocusGained
        if (searchBar.getText().equals("Search")){
            searchBar.setText("");
            searchBar.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_searchBarFocusGained

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
 
    }//GEN-LAST:event_searchMouseClicked

    private void searchBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyPressed
        
    }//GEN-LAST:event_searchBarKeyPressed

    private void searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyReleased

        try {
            dbConnector dbc = new dbConnector();
            String searchText = searchBar.getText().trim();
            ResultSet rs;

            if (searchText.isEmpty()) {
                rs = dbc.getData("SELECT Id, Product_Name, Category, Price, Quantity FROM product_table");
            } else {
                rs = dbc.getData("SELECT Id, Product_Name, Category, Price, Quantity FROM product_table WHERE Product_Name LIKE '%" + searchText + "%'");
            }

            product.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }//GEN-LAST:event_searchBarKeyReleased
    
    public int countProductsInCart() {
        int totalProducts = 0;
        for (CartItem item : cart) {
            totalProducts += item.quantity;
        }
        return totalProducts;
    }
    
    double productPrice;
    
    private void addToCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToCartMouseClicked
        dbConnector dbc = new dbConnector();
        
        payment pay = new payment();
        
        if (pid.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select a product");
        }
        else if (quantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input a quantity.");
        }
        else {
            try {
                int purchasedQuantity = Integer.parseInt(quantity.getText());
                
//                double cashAmount = Double.parseDouble(cash.getText()); 
                String productId = pid.getText(); 

                ResultSet rs = dbc.getData("SELECT Quantity, Price FROM product_table WHERE Id = '" + productId + "'");
                if (rs.next()) {
//                    int currentQuantity = rs.getInt("Quantity");
//                    double productPrice = rs.getDouble("Price");
//                    
//                    if (currentQuantity >= purchasedQuantity) {
//                        int newQuantity = currentQuantity - purchasedQuantity;
//                        
//                        double totalAmount = purchasedQuantity * productPrice;
//                        
////                        double changeAmount = cashAmount - totalAmount;
//                        
//                        pay.setVisible(true);
//                        pay.productNewQuantity = newQuantity;
//                        pay.total.setText(" " + totalAmount);
//                        pay.productId = productId;
//                        pay.quantitySold = purchasedQuantity;
//
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Insufficient stock for the selected product.");
//                    }


                    int currentQuantity = rs.getInt("Quantity");
                    productPrice = rs.getDouble("Price");

                    if (currentQuantity >= purchasedQuantity) {
                        String name = productName.getText();
                        addToCart(productId, name, purchasedQuantity, productPrice);

//                        int newQuantity = currentQuantity - purchasedQuantity;
//                        dbc.updateData("UPDATE product_table SET Quantity = " + newQuantity + " WHERE Id = '" + productId + "'");
                        displayData();
                        countProductsInCart();
                        cartCount.setText(String.valueOf(countProductsInCart()));
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient stock for the selected product.");
                    }
                }
                rs.close();
            } catch (NumberFormatException | SQLException ex) {
                System.out.println("Errors: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_addToCartMouseClicked

    private void addToCartMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToCartMousePressed
        addToCart.setBackground(new Color(70,194,99));
    }//GEN-LAST:event_addToCartMousePressed

    private void addToCartMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToCartMouseReleased
        addToCart.setBackground(new Color(83,215,105));
    }//GEN-LAST:event_addToCartMouseReleased

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        pid.setText("");
        productName.setText("");
//        category.setSelectedItem("");
        price.setText("");
        change.setText("");
    }//GEN-LAST:event_clearMouseClicked

    private void clearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearMousePressed

    private void clearMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_clearMouseReleased

    private void productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productMouseClicked
        int rowIndex = product.getSelectedRow();

        if (rowIndex < 0){
            JOptionPane.showMessageDialog(null, "Please select row to update");
        } else{
            
            try {
                dbConnector dbc = new dbConnector();
                TableModel tbl = product.getModel();
                ResultSet rs = dbc.getData("SELECT * FROM product_table WHERE Id = '"+ tbl.getValueAt(rowIndex, 0) +"'");
                
                // password double hashing on updating users
                
                if (rs.next()){
                    pid.setText("" + rs.getInt("Id"));
                    productName.setText("" + rs.getString("Product_Name"));
                    price.setText("" + rs.getString("Price"));
                    destination = rs.getString("Product_img");
                    oldpath = rs.getString("Product_img");
                    path = rs.getString("Product_img");
                    
                    image.setIcon(ResizeImage(path, null, image));
                }
                
            } catch(SQLException ex){
                System.out.println(""+ ex);
            }
        }


//        int viewRowIndex = product.getSelectedRow(); // Get the view index after filtering
//
//        if (viewRowIndex < 0) {
//            JOptionPane.showMessageDialog(null, "Please select a row to update");
//        } else {
//            try {
//                dbConnector dbc = new dbConnector();
//                TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) product.getRowSorter();
//                int modelRowIndex = sorter.convertRowIndexToModel(viewRowIndex); // Convert view index to model index
//
//                // Now use modelRowIndex to fetch data from the database
//                TableModel tbl = product.getModel();
//                ResultSet rs = dbc.getData("SELECT * FROM product_table WHERE Id = '" + tbl.getValueAt(modelRowIndex, 0) + "'");
//
//                if (rs.next()) {
//                    pid.setText("" + rs.getInt("Id"));
//                    productName.setText("" + rs.getString("Product_Name"));
//                    price.setText("" + rs.getString("Price"));
//                    destination = rs.getString("Product_img");
//                    oldpath = rs.getString("Product_img");
//                    path = rs.getString("Product_img");
//
//                    image.setIcon(ResizeImage(path, null, image));
//                }
//
//            } catch (SQLException ex) {
//                System.out.println("" + ex);
//            }
//        }
    }//GEN-LAST:event_productMouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        displayData();
        order.setText("Product's");
        cancel.setVisible(false);
        total.setText(String.valueOf(subtotal));
    }//GEN-LAST:event_refreshButtonMouseClicked

    private void refreshButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMousePressed
        refreshButton.setBackground(new Color(70,194,99));
    }//GEN-LAST:event_refreshButtonMousePressed

    private void refreshButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseReleased
        refreshButton.setBackground(new Color(83,215,105));
    }//GEN-LAST:event_refreshButtonMouseReleased

    private void catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catActionPerformed
        category();
    }//GEN-LAST:event_catActionPerformed

    private void catKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_catKeyReleased
        category();
    }//GEN-LAST:event_catKeyReleased

    private void totalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalKeyReleased
        
    }//GEN-LAST:event_totalKeyReleased

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
    
        
    }//GEN-LAST:event_quantityKeyReleased

    private void checkOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkOutMouseClicked
        checkout();
    }//GEN-LAST:event_checkOutMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        orders(product);
        order.setText("Order list");
        cancel.setVisible(true);
        addToCart.setEnabled(false);
        back.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked

        int rowIndex = product.getSelectedRow();

        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row to update");
        } else {
            try {
                dbConnector dbc = new dbConnector();
                TableModel tbl = product.getModel();
                String productId = tbl.getValueAt(rowIndex, 0).toString();

                CartItem canceledItem = null;
                for (CartItem item : cart) {
                    if (item.productId.equals(productId)) {
                        canceledItem = item;
                        break;
                    }
                }

                if (canceledItem != null) {

                    double totalAmountToRemove = canceledItem.totalAmount;

                    cart.remove(canceledItem);

                    ResultSet rs = dbc.getData("SELECT Quantity FROM product_table WHERE Id = '" + productId + "'");

//                    if (rs.next()) {
//                        int currentQuantity = rs.getInt("Quantity");
//                        int canceledQuantity = canceledItem.quantity; 
//
//                        int newQuantity = currentQuantity + canceledQuantity;
//
//                        String updateQuery = "UPDATE product_table SET Quantity = " + newQuantity + " WHERE Id = '" + productId + "'";
//                        dbc.updateData(updateQuery);
//
//                        JOptionPane.showMessageDialog(null, "Product removed from cart and quantity updated in the database.");
//
//                        subtotal -= totalAmountToRemove;
//
//                        total.setText(String.valueOf(subtotal));
//                        
//                    }
                    JOptionPane.showMessageDialog(null, "Product removed from cart.");
                    subtotal -= totalAmountToRemove;
                    total.setText(String.valueOf(subtotal));
                    orders(product);
                    cartCount.setText(String.valueOf(countProductsInCart()));
                    rs.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Product not found in cart.");
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }

    }//GEN-LAST:event_cancelMouseClicked

    Border border = BorderFactory.createLineBorder(new Color(255, 127, 127));
    
    private void cashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashKeyReleased
        
        double cashAmount = 0; 
        double totalAmount = 0; 

        try {
            
            if (!cash.getText().isEmpty()) {
                cashAmount = Double.parseDouble(cash.getText());
            }
            if (!total.getText().isEmpty()) {
                totalAmount = Double.parseDouble(total.getText());
            }
            
            if (cash.getText().isEmpty()){
                change.setText(" ");
            } else {
                
                double remainingAmount = 0;
                
                if (cashAmount >= 0) {
                    remainingAmount = cashAmount - totalAmount;
                
                    change.setText(String.valueOf(remainingAmount));
                } 
                
                if (remainingAmount < cashAmount){
                    change.setForeground(new Color(255, 0, 0)); 
                } else {
                    change.setForeground(new Color(0, 0, 0)); 
                }
            }
            
        } catch (NumberFormatException e) {
            
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
        }
    }//GEN-LAST:event_cashKeyReleased

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        displayData();
        back.setVisible(false);
        cancel.setVisible(true);
    }//GEN-LAST:event_backMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private panelRoundComponents.PanelRound addToCart;
    private javax.swing.JLabel back;
    private panelRoundComponents.PanelRound cancel;
    private javax.swing.JLabel cartCount;
    private javax.swing.JTextField cash;
    private combo_suggestion.ComboBoxSuggestion cat;
    private javax.swing.JTextField change;
    private panelRoundComponents.PanelRound checkOut;
    private panelRoundComponents.PanelRound clear;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel order;
    private panelRoundComponents.PanelRound panelRound1;
    private javax.swing.JTextField pid;
    private javax.swing.JTextField price;
    private table.Table product;
    private javax.swing.JTextField productName;
    private javax.swing.JTextField quantity;
    private panelRoundComponents.PanelRound refreshButton;
    private panelRoundComponents.RoundPanel roundPanel1;
    private scrollPane.ScrollPaneWin11 scrollPaneWin111;
    private javax.swing.JLabel search;
    private javax.swing.JTextField searchBar;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
