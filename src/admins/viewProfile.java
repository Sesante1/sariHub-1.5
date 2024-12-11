
package admins;

import config.Session;
import java.awt.Color;

public class viewProfile extends javax.swing.JFrame {

    Session session = Session.getInstance();
    
    public viewProfile() {
        initComponents();
        //setting_name.setText(session.getFname() + " " + session.getLname());
       //setting_username.setText(session.getUsername());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new panelRoundComponents.PanelRound();
        container_name = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        setting_name = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        container_username = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        setting_username = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        container_contact = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        setting_contact = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        container_password = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        setting_password = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        exit = new panelRoundComponents.PanelRound();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings-profile.png"))); // NOI18N

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        container_name.setBackground(new java.awt.Color(255, 255, 255));
        container_name.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        container_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                container_nameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                container_nameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                container_nameMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Name");

        setting_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setting_name.setForeground(new java.awt.Color(102, 102, 102));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow.png"))); // NOI18N

        javax.swing.GroupLayout container_nameLayout = new javax.swing.GroupLayout(container_name);
        container_name.setLayout(container_nameLayout);
        container_nameLayout.setHorizontalGroup(
            container_nameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, container_nameLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(setting_name, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(4, 4, 4))
        );
        container_nameLayout.setVerticalGroup(
            container_nameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(setting_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelRound1.add(container_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 425, 50));

        container_username.setBackground(new java.awt.Color(255, 255, 255));
        container_username.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        container_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                container_usernameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                container_usernameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                container_usernameMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Username");

        setting_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setting_username.setForeground(new java.awt.Color(102, 102, 102));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow.png"))); // NOI18N

        javax.swing.GroupLayout container_usernameLayout = new javax.swing.GroupLayout(container_username);
        container_username.setLayout(container_usernameLayout);
        container_usernameLayout.setHorizontalGroup(
            container_usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, container_usernameLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(setting_username, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(5, 5, 5))
        );
        container_usernameLayout.setVerticalGroup(
            container_usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(setting_username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelRound1.add(container_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 425, 50));

        container_contact.setBackground(new java.awt.Color(255, 255, 255));
        container_contact.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        container_contact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                container_contactMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                container_contactMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                container_contactMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Cotact No");

        setting_contact.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setting_contact.setForeground(new java.awt.Color(102, 102, 102));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow.png"))); // NOI18N

        javax.swing.GroupLayout container_contactLayout = new javax.swing.GroupLayout(container_contact);
        container_contact.setLayout(container_contactLayout);
        container_contactLayout.setHorizontalGroup(
            container_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, container_contactLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(setting_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(4, 4, 4))
        );
        container_contactLayout.setVerticalGroup(
            container_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setting_contact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelRound1.add(container_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 425, 50));

        container_password.setBackground(new java.awt.Color(255, 255, 255));
        container_password.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        container_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                container_passwordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                container_passwordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                container_passwordMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Password");

        setting_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setting_password.setForeground(new java.awt.Color(102, 102, 102));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow.png"))); // NOI18N

        javax.swing.GroupLayout container_passwordLayout = new javax.swing.GroupLayout(container_password);
        container_password.setLayout(container_passwordLayout);
        container_passwordLayout.setHorizontalGroup(
            container_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(container_passwordLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(setting_password, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(4, 4, 4))
        );
        container_passwordLayout.setVerticalGroup(
            container_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setting_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelRound1.add(container_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 425, 50));

        exit.setBackground(new java.awt.Color(245, 245, 245));
        exit.setRoundBottomLeft(50);
        exit.setRoundBottomRight(50);
        exit.setRoundTopLeft(50);
        exit.setRoundTopRight(50);
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("X");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout exitLayout = new javax.swing.GroupLayout(exit);
        exit.setLayout(exitLayout);
        exitLayout.setHorizontalGroup(
            exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );
        exitLayout.setVerticalGroup(
            exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setting_name.setText(session.getFname() + " " + session.getLname());
        setting_username.setText(session.getUsername());
        setting_contact.setText(session.getContact());
        setting_password.setText("***********");
    }//GEN-LAST:event_formWindowActivated

    private void container_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_container_nameMouseClicked
        container_name.setBackground(new Color(238,238,238));
        updateName name = new updateName();
        name.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_container_nameMouseClicked

    private void container_usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_container_usernameMouseClicked
        container_username.setBackground(new Color(238,238,238));
        changeUsername username = new changeUsername();
        username.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_container_usernameMouseClicked

    private void container_contactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_container_contactMouseClicked
        container_contact.setBackground(new Color(238,238,238));
        updateContact contact = new updateContact();
        contact.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_container_contactMouseClicked

    private void container_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_container_passwordMouseClicked
        container_password.setVisible(true);
        changePassword password = new changePassword();
        password.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_container_passwordMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        exit.setBackground(new Color(230,230,230));
        this.dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        exit.setBackground(new Color(230,230,230));
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        exit.setBackground(new Color(245,245,245));
    }//GEN-LAST:event_exitMouseExited

    private void container_nameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_container_nameMouseEntered
        container_name.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_container_nameMouseEntered

    private void container_nameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_container_nameMouseExited
        container_name.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_container_nameMouseExited

    private void container_usernameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_container_usernameMouseEntered
        container_username.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_container_usernameMouseEntered

    private void container_usernameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_container_usernameMouseExited
        container_username.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_container_usernameMouseExited

    private void container_contactMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_container_contactMouseEntered
        container_contact.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_container_contactMouseEntered

    private void container_contactMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_container_contactMouseExited
        container_contact.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_container_contactMouseExited

    private void container_passwordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_container_passwordMouseEntered
        container_password.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_container_passwordMouseEntered

    private void container_passwordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_container_passwordMouseExited
        container_password.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_container_passwordMouseExited

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
            java.util.logging.Logger.getLogger(viewProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container_contact;
    private javax.swing.JPanel container_name;
    private javax.swing.JPanel container_password;
    private javax.swing.JPanel container_username;
    private panelRoundComponents.PanelRound exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private panelRoundComponents.PanelRound panelRound1;
    private javax.swing.JLabel setting_contact;
    private javax.swing.JLabel setting_name;
    private javax.swing.JLabel setting_password;
    private javax.swing.JLabel setting_username;
    // End of variables declaration//GEN-END:variables
}
