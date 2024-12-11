
package admins;

import config.dbConnector;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import transition.TransitionsForm;

public class manageUser extends  TransitionsForm{

    public manageUser() {
        initComponents();
        init();
        displayData(); 
    }
    
    private void init(){
        registeredUsers.fixTable(scrollPaneWin111);
    }
    
    public boolean refresh = false;
    
    public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT Id, First_Name, Last_Name, Email, Contact, User_Type, Status FROM user_table");
            registeredUsers.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        roundPanel1 = new panelRoundComponents.RoundPanel();
        scrollPaneWin111 = new scrollPane.ScrollPaneWin11();
        registeredUsers = new table.Table();
        panelRound1 = new panelRoundComponents.PanelRound();
        searchBar = new javax.swing.JTextField();
        search = new javax.swing.JLabel();
        deleteButton = new panelRoundComponents.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        updateButton = new panelRoundComponents.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addUserButton = new panelRoundComponents.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        refreshButton = new panelRoundComponents.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1030, 527));

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1030, 490));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setRound(10);
        roundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollPaneWin111.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        registeredUsers.setForeground(new java.awt.Color(102, 102, 102));
        registeredUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        registeredUsers.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        registeredUsers.getTableHeader().setReorderingAllowed(false);
        scrollPaneWin111.setViewportView(registeredUsers);

        roundPanel1.add(scrollPaneWin111, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 960, 360));

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

        deleteButton.setBackground(new java.awt.Color(252, 61, 57));
        deleteButton.setToolTipText("Delete");
        deleteButton.setRoundBottomLeft(10);
        deleteButton.setRoundBottomRight(10);
        deleteButton.setRoundTopLeft(10);
        deleteButton.setRoundTopRight(10);
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteButtonMouseReleased(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("DELETE");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-18.png"))); // NOI18N

        javax.swing.GroupLayout deleteButtonLayout = new javax.swing.GroupLayout(deleteButton);
        deleteButton.setLayout(deleteButtonLayout);
        deleteButtonLayout.setHorizontalGroup(
            deleteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deleteButtonLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        deleteButtonLayout.setVerticalGroup(
            deleteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteButtonLayout.createSequentialGroup()
                .addGroup(deleteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        updateButton.setBackground(new java.awt.Color(83, 215, 105));
        updateButton.setToolTipText("Update");
        updateButton.setRoundBottomLeft(10);
        updateButton.setRoundBottomRight(10);
        updateButton.setRoundTopLeft(10);
        updateButton.setRoundTopRight(10);
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                updateButtonMouseReleased(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("UPDATE");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-update-18.png"))); // NOI18N

        javax.swing.GroupLayout updateButtonLayout = new javax.swing.GroupLayout(updateButton);
        updateButton.setLayout(updateButtonLayout);
        updateButtonLayout.setHorizontalGroup(
            updateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateButtonLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(36, 36, 36))
        );
        updateButtonLayout.setVerticalGroup(
            updateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        addUserButton.setBackground(new java.awt.Color(91, 164, 252));
        addUserButton.setToolTipText("Add");
        addUserButton.setRoundBottomLeft(10);
        addUserButton.setRoundBottomRight(10);
        addUserButton.setRoundTopLeft(10);
        addUserButton.setRoundTopRight(10);
        addUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addUserButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addUserButtonMouseReleased(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ADD USER");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-add-18.png"))); // NOI18N

        javax.swing.GroupLayout addUserButtonLayout = new javax.swing.GroupLayout(addUserButton);
        addUserButton.setLayout(addUserButtonLayout);
        addUserButtonLayout.setHorizontalGroup(
            addUserButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUserButtonLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(30, 30, 30))
        );
        addUserButtonLayout.setVerticalGroup(
            addUserButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        refreshButton.setBackground(new java.awt.Color(83, 215, 105));
        refreshButton.setToolTipText("Refresh");
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

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("REFRESH");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-refresh-18.png"))); // NOI18N

        javax.swing.GroupLayout refreshButtonLayout = new javax.swing.GroupLayout(refreshButton);
        refreshButton.setLayout(refreshButtonLayout);
        refreshButtonLayout.setHorizontalGroup(
            refreshButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, refreshButtonLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(36, 36, 36))
        );
        refreshButtonLayout.setVerticalGroup(
            refreshButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void deleteButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMousePressed
        deleteButton.setBackground(new Color(227,52,55));
    }//GEN-LAST:event_deleteButtonMousePressed

    private void deleteButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseReleased
        deleteButton.setBackground(new Color(252,61,57));
    }//GEN-LAST:event_deleteButtonMouseReleased

    private void updateButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMousePressed
        updateButton.setBackground(new Color(70,194,99));
    }//GEN-LAST:event_updateButtonMousePressed

    private void updateButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseReleased
        updateButton.setBackground(new Color(83,215,105));
    }//GEN-LAST:event_updateButtonMouseReleased

    private void addUserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserButtonMouseClicked
        createUserForm addUser = new createUserForm();
        addUser.setVisible(true);
    }//GEN-LAST:event_addUserButtonMouseClicked

    private void addUserButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserButtonMousePressed
        addUserButton.setBackground(new Color(88,151,238));
    }//GEN-LAST:event_addUserButtonMousePressed

    private void addUserButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserButtonMouseReleased
        addUserButton.setBackground(new Color(91,164,252));
    }//GEN-LAST:event_addUserButtonMouseReleased

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

    private void updateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseClicked
        int rowIndex = registeredUsers.getSelectedRow();
        updateUser update = new updateUser();
        if (rowIndex < 0){
            JOptionPane.showMessageDialog(null, "Please select row to update");
        } else{
            
            update.setVisible(true);
            
            try {
                dbConnector dbc = new dbConnector();
                TableModel tbl = registeredUsers.getModel();
                ResultSet rs = dbc.getData("SELECT * FROM user_table WHERE Id = '"+ tbl.getValueAt(rowIndex, 0) +"'");
                
                // password double hashing on updating users
                
                if (rs.next()){
                    update.uid.setText("" + rs.getInt("Id"));
                    update.fname.setText("" + rs.getString("First_Name"));
                    update.lname.setText("" + rs.getString("Last_Name"));
                    update.email.setText("" + rs.getString("Email"));
                    update.username.setText("" + rs.getString("Username"));
                    //update.password.setText("" + rs.getString("Password"));
                    //update.password.setText("*");
                    update.phoneNumber.setText("" + rs.getString("Contact"));
                    update.userType.setSelectedItem("" + rs.getString("User_type"));
                    update.userStatus.setSelectedItem("" + rs.getString("Status"));
                    
                    //update.image.setIcon(new ImageIcon(rs.getString("profile")));
//                    update.destination = rs.getString("profile");
//                    update.oldpath = rs.getString("profile");
//                    update.path = rs.getString("profile");
//                    
//                    if (rs.getString("profile").isEmpty()){               
//                        update.uploadImage.setVisible(true);
//                        update.removeImage.setVisible(false);
//                    } else {
//                        update.profilePic.setIcon(new ImageIcon(rs.getString("profile")));
//                        update.uploadImage.setVisible(false);
//                        update.removeImage.setVisible(true);
//                    }
                }
                
            } catch(SQLException ex){
                System.out.println(""+ ex);
            }
        }
    }//GEN-LAST:event_updateButtonMouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        displayData(); 
        System.out.println("Clicked");
    }//GEN-LAST:event_refreshButtonMouseClicked

    private void refreshButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMousePressed
        refreshButton.setBackground(new Color(70,194,99));
    }//GEN-LAST:event_refreshButtonMousePressed

    private void refreshButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseReleased
        refreshButton.setBackground(new Color(83,215,105));
    }//GEN-LAST:event_refreshButtonMouseReleased

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        int rowIndex = registeredUsers.getSelectedRow();
        
        if (rowIndex < 0){
            JOptionPane.showMessageDialog(null, "Please select row to delete");
        } else{
            TableModel model = registeredUsers.getModel();
            Object value = model.getValueAt(rowIndex, 0);
            String id = value.toString();
            int a = JOptionPane.showConfirmDialog(null, "Are you sure to delete ID: " + id);
            if (a == JOptionPane.YES_OPTION){
                dbConnector dbc = new dbConnector();
                int ids = Integer.parseInt(id);
                dbc.delete(ids, "users_table");
                displayData();
            }
        }
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        /*DefaultTableModel ob = (DefaultTableModel) registeredUsers.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        registeredUsers.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(searchBar.getText()));*/
        

    }//GEN-LAST:event_searchMouseClicked

    private void searchBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyPressed
        
    }//GEN-LAST:event_searchBarKeyPressed

    private void searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyReleased
        /*DefaultTableModel ob = (DefaultTableModel) registeredUsers.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        registeredUsers.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(searchBar.getText()));*/
        /*DefaultTableModel ob = (DefaultTableModel) registeredUsers.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        registeredUsers.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(searchBar.getText()));

        // Get the row count after filtering
        int rowCount = obj.getViewRowCount();

        // Loop through the filtered rows to get the model indices
        for (int i = 0; i < rowCount; i++) {
            int viewIndex = i;
            int modelIndex = registeredUsers.convertRowIndexToModel(viewIndex);
            System.out.println("View Index: " + viewIndex + ", Model Index: " + modelIndex);
        }*/
        try {
            dbConnector dbc = new dbConnector();
            String searchText = searchBar.getText().trim();
            ResultSet rs;

            if (searchText.isEmpty()) {
                rs = dbc.getData("SELECT Id, First_Name, Last_Name, Contact, User_type, Status FROM user_table");
            } else {
                rs = dbc.getData("SELECT Id, First_Name, Last_Name, Contact, User_type, Status FROM user_table WHERE First_Name LIKE '%" + searchText + "%'");
            }

            registeredUsers.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }

    
    }//GEN-LAST:event_searchBarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private panelRoundComponents.PanelRound addUserButton;
    private panelRoundComponents.PanelRound deleteButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private panelRoundComponents.PanelRound panelRound1;
    private panelRoundComponents.PanelRound refreshButton;
    private table.Table registeredUsers;
    private panelRoundComponents.RoundPanel roundPanel1;
    private scrollPane.ScrollPaneWin11 scrollPaneWin111;
    private javax.swing.JLabel search;
    private javax.swing.JTextField searchBar;
    private panelRoundComponents.PanelRound updateButton;
    // End of variables declaration//GEN-END:variables
}
