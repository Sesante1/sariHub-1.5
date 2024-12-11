
package admins;

import static admins.createUserForm.hashing;
import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class addingFlight extends javax.swing.JFrame {

    public addingFlight() {
        initComponents();
        airlineList();
    }
    
    public void airlineList(){
        try{
            dbConnector dbc = new dbConnector();
            String query = "SELECT Airline FROM airlines";
            ResultSet resultSet = dbc.getData(query);
            
            while (resultSet.next()){
                String airline = resultSet.getString("airline");
                airlines.addItem(airline);
            }
            
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new dateChooser.DateChooser();
        dateArrival = new dateChooser.DateChooser();
        panelRound1 = new panelRoundComponents.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        departureDate = new javax.swing.JTextField();
        departureTime = new javax.swing.JTextField();
        fare = new javax.swing.JTextField();
        flyingFrom = new javax.swing.JTextField();
        arrivalDate = new javax.swing.JTextField();
        arrivalTime = new javax.swing.JTextField();
        FlyingTo = new javax.swing.JTextField();
        seats = new javax.swing.JTextField();
        addButton = new panelRoundComponents.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        cancelButton = new panelRoundComponents.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        airlines = new combo_suggestion.ComboBoxSuggestion();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        date.setForeground(new java.awt.Color(41, 123, 250));
        date.setTextRefernce(departureDate);

        dateArrival.setForeground(new java.awt.Color(41, 123, 250));
        dateArrival.setTextRefernce(arrivalDate);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        panelRound1.setPreferredSize(new java.awt.Dimension(966, 600));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 87, 228));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADD FLIGHT DETAILS");

        departureDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        departureDate.setForeground(new java.awt.Color(130, 130, 130));
        departureDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        departureDate.setPreferredSize(new java.awt.Dimension(6, 30));
        departureDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                departureDateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                departureDateFocusLost(evt);
            }
        });
        departureDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departureDateActionPerformed(evt);
            }
        });

        departureTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        departureTime.setForeground(new java.awt.Color(153, 153, 153));
        departureTime.setText("  Departure Time");
        departureTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        departureTime.setPreferredSize(new java.awt.Dimension(6, 30));
        departureTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                departureTimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                departureTimeFocusLost(evt);
            }
        });

        fare.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fare.setForeground(new java.awt.Color(153, 153, 153));
        fare.setText("  Price");
        fare.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        fare.setPreferredSize(new java.awt.Dimension(6, 30));
        fare.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fareFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fareFocusLost(evt);
            }
        });

        flyingFrom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        flyingFrom.setForeground(new java.awt.Color(153, 153, 153));
        flyingFrom.setText("  Flying from");
        flyingFrom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        flyingFrom.setPreferredSize(new java.awt.Dimension(6, 30));
        flyingFrom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                flyingFromFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                flyingFromFocusLost(evt);
            }
        });

        arrivalDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        arrivalDate.setForeground(new java.awt.Color(153, 153, 153));
        arrivalDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        arrivalDate.setPreferredSize(new java.awt.Dimension(6, 30));
        arrivalDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                arrivalDateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                arrivalDateFocusLost(evt);
            }
        });

        arrivalTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        arrivalTime.setForeground(new java.awt.Color(153, 153, 153));
        arrivalTime.setText("  Arrival Time");
        arrivalTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        arrivalTime.setPreferredSize(new java.awt.Dimension(6, 30));
        arrivalTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                arrivalTimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                arrivalTimeFocusLost(evt);
            }
        });

        FlyingTo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FlyingTo.setForeground(new java.awt.Color(153, 153, 153));
        FlyingTo.setText("  Flying to");
        FlyingTo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        FlyingTo.setPreferredSize(new java.awt.Dimension(6, 30));
        FlyingTo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FlyingToFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                FlyingToFocusLost(evt);
            }
        });

        seats.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        seats.setForeground(new java.awt.Color(153, 153, 153));
        seats.setText("  Seats");
        seats.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        seats.setPreferredSize(new java.awt.Dimension(6, 30));
        seats.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                seatsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                seatsFocusLost(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(83, 215, 105));
        addButton.setToolTipText("Refresh");
        addButton.setRoundBottomLeft(10);
        addButton.setRoundBottomRight(10);
        addButton.setRoundTopLeft(10);
        addButton.setRoundTopRight(10);
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addButtonMouseReleased(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Continue");

        javax.swing.GroupLayout addButtonLayout = new javax.swing.GroupLayout(addButton);
        addButton.setLayout(addButtonLayout);
        addButtonLayout.setHorizontalGroup(
            addButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addButtonLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(44, 44, 44))
        );
        addButtonLayout.setVerticalGroup(
            addButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        cancelButton.setBackground(new java.awt.Color(252, 61, 57));
        cancelButton.setToolTipText("Delete");
        cancelButton.setRoundBottomLeft(10);
        cancelButton.setRoundBottomRight(10);
        cancelButton.setRoundTopLeft(10);
        cancelButton.setRoundTopRight(10);
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelButtonMouseReleased(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Cancel");

        javax.swing.GroupLayout cancelButtonLayout = new javax.swing.GroupLayout(cancelButton);
        cancelButton.setLayout(cancelButtonLayout);
        cancelButtonLayout.setHorizontalGroup(
            cancelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cancelButtonLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(51, 51, 51))
        );
        cancelButtonLayout.setVerticalGroup(
            cancelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cancelButtonLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        airlines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                airlinesMouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Departure Date");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Arrival Date");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Departure Time");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Arrival Time");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Flying From");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Flying To");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Airline");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Fare");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Seats");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(airlines, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(arrivalDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(departureDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                .addComponent(flyingFrom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(FlyingTo, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                                .addComponent(arrivalTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(departureTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelRound1Layout.createSequentialGroup()
                                    .addComponent(fare, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addComponent(seats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(352, 352, 352))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(373, 373, 373))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(391, 391, 391))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(416, 416, 416))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addGap(132, 132, 132)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departureTime, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(3, 3, 3)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arrivalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arrivalTime, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(3, 3, 3)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flyingFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FlyingTo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(3, 3, 3)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fare, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seats, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(airlines, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void departureDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_departureDateFocusGained
        if (departureDate.getText().equals("  Departure")){
            departureDate.setText("");
            departureDate.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_departureDateFocusGained

    private void departureDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_departureDateFocusLost
        if (departureDate.getText().equals("")){
            departureDate.setText("  Departure");
            departureDate.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_departureDateFocusLost

    private void departureDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departureDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departureDateActionPerformed

    private void departureTimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_departureTimeFocusGained
        if (departureTime.getText().equals("  Departure Time")){
            departureTime.setText("");
            departureTime.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_departureTimeFocusGained

    private void departureTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_departureTimeFocusLost
        if (departureTime.getText().equals("")){
            departureTime.setText("  Departure Time");
            departureTime.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_departureTimeFocusLost

    private void arrivalDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_arrivalDateFocusGained
        if (arrivalDate.getText().equals("  Arrival")){
            arrivalDate.setText("");
            arrivalDate.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_arrivalDateFocusGained

    private void arrivalDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_arrivalDateFocusLost
        if (arrivalDate.getText().equals("")){
            arrivalDate.setText("  Arrival");
            arrivalDate.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_arrivalDateFocusLost

    private void arrivalTimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_arrivalTimeFocusGained
        if (arrivalTime.getText().equals("  Arrival Time")){
            arrivalTime.setText("");
            arrivalTime.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_arrivalTimeFocusGained

    private void arrivalTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_arrivalTimeFocusLost
        if (arrivalTime.getText().equals("")){
            arrivalTime.setText("  Arrival Time");
            arrivalTime.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_arrivalTimeFocusLost

    private void flyingFromFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_flyingFromFocusGained
        if (flyingFrom.getText().equals("  Flying from")){
            flyingFrom.setText("");
            flyingFrom.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_flyingFromFocusGained

    private void flyingFromFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_flyingFromFocusLost
        if (flyingFrom.getText().equals("")){
            flyingFrom.setText("  Flying from");
            flyingFrom.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_flyingFromFocusLost

    private void FlyingToFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FlyingToFocusGained
        if (FlyingTo.getText().equals("  Flying to")){
            FlyingTo.setText("");
            FlyingTo.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_FlyingToFocusGained

    private void FlyingToFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FlyingToFocusLost
        if (FlyingTo.getText().equals("")){
            FlyingTo.setText("  Flying to");
            FlyingTo.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_FlyingToFocusLost

    private void fareFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fareFocusGained
        if (fare.getText().equals("  Price")){
            fare.setText("");
            fare.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_fareFocusGained

    private void fareFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fareFocusLost
        if (fare.getText().equals("")){
            fare.setText("  Price");
            fare.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_fareFocusLost

    private void seatsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_seatsFocusGained
        if (seats.getText().equals("  Seats")){
            seats.setText("");
            seats.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_seatsFocusGained

    private void seatsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_seatsFocusLost
        if (seats.getText().equals("")){
            seats.setText("  Seats");
            seats.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_seatsFocusLost

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        
        dbConnector dbc = new dbConnector();
        if (departureDate.getText().isEmpty() || departureTime.getText().isEmpty() || arrivalDate.getText().isEmpty() || arrivalTime.getText().isEmpty() 
                || flyingFrom.getText().isEmpty() || FlyingTo.getText().isEmpty()  
                || fare.getText().isEmpty() || seats.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are required!");
        } else {
            if (dbc.insertData("INSERT INTO flights_table (Departure, Departure_Time, Arrival, Arrival_Time, Flying_From, Flying_To, Airline, Price, Seats, Status)"
                + "VALUES('" + departureDate.getText() + "','" + departureTime.getText() + "','" + arrivalDate.getText() + "','" + arrivalTime.getText() + "','" + flyingFrom.getText() + "','" + FlyingTo.getText() + "','" + airlines.getSelectedItem() + "','" + fare.getText() + "','"+seats.getText()+"','not departed')"))
            {
                JOptionPane.showMessageDialog(null, "Added Successfully.");               
            } else {
                JOptionPane.showMessageDialog(null, "Connection Error!");
            }
            
            this.dispose();   
        }
    }//GEN-LAST:event_addButtonMouseClicked

    private void addButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMousePressed
        addButton.setBackground(new Color(70,194,99));
    }//GEN-LAST:event_addButtonMousePressed

    private void addButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseReleased
        addButton.setBackground(new Color(83,215,105));
    }//GEN-LAST:event_addButtonMouseReleased

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void cancelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMousePressed
        cancelButton.setBackground(new Color(227,52,55));
    }//GEN-LAST:event_cancelButtonMousePressed

    private void cancelButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseReleased
        cancelButton.setBackground(new Color(252,61,57));
    }//GEN-LAST:event_cancelButtonMouseReleased

    private void airlinesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_airlinesMouseClicked
        
    }//GEN-LAST:event_airlinesMouseClicked


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
            java.util.logging.Logger.getLogger(addingFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addingFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addingFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addingFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addingFlight().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FlyingTo;
    private panelRoundComponents.PanelRound addButton;
    private combo_suggestion.ComboBoxSuggestion airlines;
    private javax.swing.JTextField arrivalDate;
    private javax.swing.JTextField arrivalTime;
    private panelRoundComponents.PanelRound cancelButton;
    private dateChooser.DateChooser date;
    private dateChooser.DateChooser dateArrival;
    private javax.swing.JTextField departureDate;
    private javax.swing.JTextField departureTime;
    private javax.swing.JTextField fare;
    private javax.swing.JTextField flyingFrom;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private panelRoundComponents.PanelRound panelRound1;
    private javax.swing.JTextField seats;
    // End of variables declaration//GEN-END:variables
}
