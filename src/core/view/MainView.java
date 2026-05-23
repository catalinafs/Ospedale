package core.view;

import core.controllers.AuthController;
import core.controllers.PatientController;
import core.controllers.utils.Response;
import java.awt.Color;
import javax.swing.JOptionPane;
import core.app.Navigator;
import core.controllers.utils.Status;

public class MainView extends javax.swing.JFrame {

    private int x, y;

    private PatientController patientController;
    private AuthController authController;
    private Navigator navigator;

    public MainView(PatientController patientController, AuthController authController, Navigator navigator) {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);

        this.patientController = patientController;
        this.authController = authController;
        this.navigator = navigator;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new core.view.PanelRound();
        panelRound2 = new core.view.PanelRound();
        btnExitMV = new javax.swing.JButton();
        tabbedPanelMV = new javax.swing.JTabbedPane();
        panelRound3 = new core.view.PanelRound();
        labelLoginMV = new javax.swing.JLabel();
        inputUserMV = new javax.swing.JTextField();
        labelUserMV = new javax.swing.JLabel();
        inputPassMV = new javax.swing.JTextField();
        labelPassMV = new javax.swing.JLabel();
        btnEnterMV = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        labelFirstnameMV = new javax.swing.JLabel();
        inputFisrtnameMV = new javax.swing.JTextField();
        labelLastnameMV = new javax.swing.JLabel();
        inputLastnameMV = new javax.swing.JTextField();
        labelIDMV = new javax.swing.JLabel();
        inputIDMV = new javax.swing.JTextField();
        labelGenderMV = new javax.swing.JLabel();
        labelPhoneMV = new javax.swing.JLabel();
        inputPhoneMV = new javax.swing.JTextField();
        labelEmailMV = new javax.swing.JLabel();
        inputEmailMV = new javax.swing.JTextField();
        labelUserRegisMV = new javax.swing.JLabel();
        inputUserRegisMV = new javax.swing.JTextField();
        inputPassRegisMV = new javax.swing.JTextField();
        labelPassRegisMV = new javax.swing.JLabel();
        labelPassConfirRegisMV = new javax.swing.JLabel();
        inputPassConfirRegisMV = new javax.swing.JTextField();
        inputSelectGenderMV = new javax.swing.JComboBox<>();
        btnSaveRegisMV = new javax.swing.JButton();
        labelAddressMV = new javax.swing.JLabel();
        inputAddressMV = new javax.swing.JTextField();
        labelBirthdateMV = new javax.swing.JLabel();
        inputBirthdateMV = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound1.setRadius(50);

        panelRound2.setRadius(50);
        panelRound2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelRound2MouseDragged(evt);
            }
        });
        panelRound2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelRound2MousePressed(evt);
            }
        });

        btnExitMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnExitMV.setText("X");
        btnExitMV.setBorderPainted(false);
        btnExitMV.setContentAreaFilled(false);
        btnExitMV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExitMV.setFocusable(false);
        btnExitMV.setRequestFocusEnabled(false);
        btnExitMV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitMVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExitMV)
                .addGap(19, 19, 19))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExitMV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        labelLoginMV.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        labelLoginMV.setText("LOGIN");

        inputUserMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputUserMV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        labelUserMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelUserMV.setText("USERNAME");

        inputPassMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputPassMV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        labelPassMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelPassMV.setText("PASSWORD");

        btnEnterMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnEnterMV.setText("ENTER");
        btnEnterMV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterMVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(475, Short.MAX_VALUE)
                .addComponent(labelLoginMV)
                .addGap(481, 481, 481))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelPassMV, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelUserMV, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputPassMV, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputUserMV, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(471, 471, 471)
                        .addComponent(btnEnterMV)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(labelLoginMV)
                .addGap(74, 74, 74)
                .addComponent(labelUserMV)
                .addGap(18, 18, 18)
                .addComponent(inputUserMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPassMV)
                .addGap(18, 18, 18)
                .addComponent(inputPassMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnEnterMV)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        tabbedPanelMV.addTab("Login", panelRound3);

        labelFirstnameMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelFirstnameMV.setText("Firstname");

        inputFisrtnameMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelLastnameMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelLastnameMV.setText("Lastname");

        inputLastnameMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelIDMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelIDMV.setText("ID");

        inputIDMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelGenderMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelGenderMV.setText("Gender");

        labelPhoneMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelPhoneMV.setText("Phone");

        inputPhoneMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelEmailMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelEmailMV.setText("Email");

        inputEmailMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelUserRegisMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelUserRegisMV.setText("User");

        inputUserRegisMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        inputPassRegisMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelPassRegisMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelPassRegisMV.setText("Password");

        labelPassConfirRegisMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelPassConfirRegisMV.setText("Password confirmation");

        inputPassConfirRegisMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputPassConfirRegisMV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPassConfirRegisMVActionPerformed(evt);
            }
        });

        inputSelectGenderMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputSelectGenderMV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one", "Female", "Male" }));

        btnSaveRegisMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnSaveRegisMV.setText("Save");
        btnSaveRegisMV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRegisMVActionPerformed(evt);
            }
        });

        labelAddressMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelAddressMV.setText("Address");

        inputAddressMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelBirthdateMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelBirthdateMV.setText("Birthdate");

        inputBirthdateMV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(labelPassRegisMV))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(434, 434, 434)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputUserRegisMV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPassRegisMV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(473, 473, 473)
                        .addComponent(labelUserRegisMV))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addComponent(inputPassConfirRegisMV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(456, 456, 456)
                        .addComponent(btnSaveRegisMV))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(396, 396, 396)
                        .addComponent(labelPassConfirRegisMV))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelBirthdateMV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputBirthdateMV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelFirstnameMV)
                                .addGap(34, 34, 34)
                                .addComponent(inputFisrtnameMV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelLastnameMV)
                            .addComponent(labelAddressMV))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(inputLastnameMV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelIDMV)
                                .addGap(30, 30, 30)
                                .addComponent(inputIDMV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelGenderMV)
                                .addGap(26, 26, 26)
                                .addComponent(inputSelectGenderMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(inputAddressMV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelPhoneMV)
                                .addGap(18, 18, 18)
                                .addComponent(inputPhoneMV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelEmailMV)
                                .addGap(18, 18, 18)
                                .addComponent(inputEmailMV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFirstnameMV)
                    .addComponent(inputFisrtnameMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLastnameMV)
                    .addComponent(inputLastnameMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIDMV)
                    .addComponent(inputIDMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelGenderMV)
                    .addComponent(inputSelectGenderMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelBirthdateMV)
                        .addComponent(inputBirthdateMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelAddressMV)
                        .addComponent(inputAddressMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPhoneMV)
                        .addComponent(inputPhoneMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelEmailMV)
                        .addComponent(inputEmailMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(labelUserRegisMV)
                .addGap(18, 18, 18)
                .addComponent(inputUserRegisMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPassRegisMV)
                .addGap(18, 18, 18)
                .addComponent(inputPassRegisMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPassConfirRegisMV)
                .addGap(18, 18, 18)
                .addComponent(inputPassConfirRegisMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnSaveRegisMV)
                .addGap(42, 42, 42))
        );

        tabbedPanelMV.addTab("Patient register", jPanel3);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(tabbedPanelMV, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPanelMV)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelRound2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_panelRound2MousePressed

    private void panelRound2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_panelRound2MouseDragged

    private void btnExitMVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitMVActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitMVActionPerformed

    private void btnEnterMVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterMVActionPerformed
        String psswd = inputPassMV.getText();
        String user = inputUserMV.getText();
        Response res = authController.login(user, psswd);
        if (res.getStatus() == Status.OK) {
            navigator.openAfterLogin(res);
        } else {
            JOptionPane.showInternalMessageDialog(null, res.getMessage(), "Oops..", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEnterMVActionPerformed

    private void btnSaveRegisMVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRegisMVActionPerformed
        String firstname = inputFisrtnameMV.getText();
        String lastname = inputLastnameMV.getText();
        String id = inputIDMV.getText();
        int gender = inputSelectGenderMV.getSelectedIndex();
        String birth = inputBirthdateMV.getText();
        String address = inputAddressMV.getText();
        String phone = inputPhoneMV.getText();
        String email = inputEmailMV.getText();
        String user = inputUserRegisMV.getText();
        String password = inputPassRegisMV.getText();
        String comPassword = inputPassConfirRegisMV.getText();

        Response res = patientController.register(id, user, firstname, lastname, password, comPassword, email, birth, gender, phone, address);
        if (res.getStatus() == Status.CREATED) {
            JOptionPane.showInternalMessageDialog(null, res.getMessage(), "Registration successful", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showInternalMessageDialog(null, res.getMessage(), "Oops..", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveRegisMVActionPerformed

    private void inputPassConfirRegisMVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPassConfirRegisMVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPassConfirRegisMVActionPerformed

    /**
     * @param args the command line arguments
     */
    /* Lo comento para cambiar el main y mantengo este por si acaso
    public static void main(String args[]) {
        System.setProperty("flatlaf.useNativeLibrary", "false");

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        //Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnterMV;
    private javax.swing.JButton btnExitMV;
    private javax.swing.JButton btnSaveRegisMV;
    private javax.swing.JTextField inputAddressMV;
    private javax.swing.JTextField inputBirthdateMV;
    private javax.swing.JTextField inputEmailMV;
    private javax.swing.JTextField inputFisrtnameMV;
    private javax.swing.JTextField inputIDMV;
    private javax.swing.JTextField inputLastnameMV;
    private javax.swing.JTextField inputPassConfirRegisMV;
    private javax.swing.JTextField inputPassMV;
    private javax.swing.JTextField inputPassRegisMV;
    private javax.swing.JTextField inputPhoneMV;
    private javax.swing.JComboBox<String> inputSelectGenderMV;
    private javax.swing.JTextField inputUserMV;
    private javax.swing.JTextField inputUserRegisMV;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelAddressMV;
    private javax.swing.JLabel labelBirthdateMV;
    private javax.swing.JLabel labelEmailMV;
    private javax.swing.JLabel labelFirstnameMV;
    private javax.swing.JLabel labelGenderMV;
    private javax.swing.JLabel labelIDMV;
    private javax.swing.JLabel labelLastnameMV;
    private javax.swing.JLabel labelLoginMV;
    private javax.swing.JLabel labelPassConfirRegisMV;
    private javax.swing.JLabel labelPassMV;
    private javax.swing.JLabel labelPassRegisMV;
    private javax.swing.JLabel labelPhoneMV;
    private javax.swing.JLabel labelUserMV;
    private javax.swing.JLabel labelUserRegisMV;
    private core.view.PanelRound panelRound1;
    private core.view.PanelRound panelRound2;
    private core.view.PanelRound panelRound3;
    private javax.swing.JTabbedPane tabbedPanelMV;
    // End of variables declaration//GEN-END:variables
}
