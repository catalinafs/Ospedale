package core.view;

import core.app.INavigator;
import core.controllers.IDoctorController;
import core.controllers.IPatientController;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.model.Specialty;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminView extends javax.swing.JFrame {

    private int x, y;
    private long userId;
    private IPatientController patientController;
    private IDoctorController doctorController;
    private INavigator navigator;
    private java.util.HashMap<String, Long> doctorNameToId = new java.util.HashMap<>();
    private java.util.HashMap<String, Long> patientNameToId = new java.util.HashMap<>();

    public AdminView(long userId, IPatientController patientController, IDoctorController doctorController, INavigator navigator) {
        initComponents();
        this.userId = userId;
        this.patientController = patientController;
        this.doctorController = doctorController;
        this.navigator = navigator;

        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);

        Response resPat = patientController.getAllPatients();
        ArrayList<HashMap<String, Object>> patients = (ArrayList<HashMap<String, Object>>) resPat.getData().get("patients");
        inputSelectPatientAV.removeAllItems();
        inputSelectPatientAV.addItem("Select one");
        for (HashMap<String, Object> pat : patients) {
            String fullname = String.valueOf(pat.get("fullname"));
            long id = Long.parseLong(String.valueOf(pat.get("id")));
            patientNameToId.put(fullname, id);
            inputSelectPatientAV.addItem(fullname);
        }

        Response resDoc = doctorController.getAllDoctors();
        ArrayList<HashMap<String, Object>> doctors = (ArrayList<HashMap<String, Object>>) resDoc.getData().get("doctors");
        inputSelectDoctorAV.removeAllItems();
        inputSelectDoctorAV.addItem("Select one");
        for (HashMap<String, Object> doc : doctors) {
            String fullname = String.valueOf(doc.get("fullname"));
            long id = Long.parseLong(String.valueOf(doc.get("id")));
            doctorNameToId.put(fullname, id);
            inputSelectDoctorAV.addItem(fullname);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new core.view.PanelRound();
        panelRound2 = new core.view.PanelRound();
        btnExitAV = new javax.swing.JButton();
        labelAdminView = new javax.swing.JLabel();
        panelRound3 = new core.view.PanelRound();
        btnDoctorViewAV = new javax.swing.JButton();
        btnPatientViewAV = new javax.swing.JButton();
        labelFirstNameAV = new javax.swing.JLabel();
        inputFirstnameAV = new javax.swing.JTextField();
        labelLastnameAV = new javax.swing.JLabel();
        inputLastnameAV = new javax.swing.JTextField();
        labelIDAV = new javax.swing.JLabel();
        inputIDAV = new javax.swing.JTextField();
        labelSpecialtyAV = new javax.swing.JLabel();
        labelLicenseAV = new javax.swing.JLabel();
        inputLicenseAV = new javax.swing.JTextField();
        labelAssignedOfficeAV = new javax.swing.JLabel();
        inputAssignedOfficeAV = new javax.swing.JTextField();
        labelUserAV = new javax.swing.JLabel();
        inputUserAV = new javax.swing.JTextField();
        labelPassAV = new javax.swing.JLabel();
        inputPassAV = new javax.swing.JTextField();
        labelPassConfirmAV = new javax.swing.JLabel();
        inputPassConfirmAV = new javax.swing.JTextField();
        inputSelectSpecialtyAV = new javax.swing.JComboBox<>();
        btnSaveAV = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        inputSelectDoctorAV = new javax.swing.JComboBox<>();
        labelDoctorAV = new javax.swing.JLabel();
        labelPatientAV = new javax.swing.JLabel();
        inputSelectPatientAV = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        btnLogoutAV = new javax.swing.JButton();

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

        btnExitAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnExitAV.setText("X");
        btnExitAV.setBorderPainted(false);
        btnExitAV.setContentAreaFilled(false);
        btnExitAV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExitAV.setFocusable(false);
        btnExitAV.setRequestFocusEnabled(false);
        btnExitAV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitAVActionPerformed(evt);
            }
        });

        labelAdminView.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        labelAdminView.setText("ADMIN VIEW");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelAdminView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExitAV)
                .addGap(19, 19, 19))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnExitAV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelAdminView))
        );

        btnDoctorViewAV.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        btnDoctorViewAV.setText("DOCTOR VIEW");
        btnDoctorViewAV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoctorViewAVActionPerformed(evt);
            }
        });

        btnPatientViewAV.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        btnPatientViewAV.setText("PATIENT VIEW");
        btnPatientViewAV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientViewAVActionPerformed(evt);
            }
        });

        labelFirstNameAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelFirstNameAV.setText("Firstname");

        inputFirstnameAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelLastnameAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelLastnameAV.setText("Lastname");

        inputLastnameAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelIDAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelIDAV.setText("ID");

        inputIDAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelSpecialtyAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelSpecialtyAV.setText("Specialty");

        labelLicenseAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelLicenseAV.setText("License Number");

        inputLicenseAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelAssignedOfficeAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelAssignedOfficeAV.setText("Assigned office");

        inputAssignedOfficeAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelUserAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelUserAV.setText("User");

        inputUserAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelPassAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelPassAV.setText("Password");

        inputPassAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelPassConfirmAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelPassConfirmAV.setText("Password confirmation");

        inputPassConfirmAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        inputSelectSpecialtyAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputSelectSpecialtyAV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one", "General Medicine", "Cardiology", "Pediatrics", "Neurology", "Traumatology & Orthopedics", "Gynecology & Obstetrics", "Dermatology", "Psychiatry", "Oncology", "Ophthalmology", "Internal Medicine" }));

        btnSaveAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnSaveAV.setText("Save");
        btnSaveAV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAVActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        inputSelectDoctorAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputSelectDoctorAV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one" }));

        labelDoctorAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelDoctorAV.setText("Doctor");

        labelPatientAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelPatientAV.setText("Patient");

        inputSelectPatientAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputSelectPatientAV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one" }));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnLogoutAV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnLogoutAV.setText("Logout");
        btnLogoutAV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutAVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(btnSaveAV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelFirstNameAV)
                                    .addComponent(labelSpecialtyAV))
                                .addGap(18, 18, 18)
                                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRound3Layout.createSequentialGroup()
                                        .addComponent(inputSelectSpecialtyAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelLicenseAV)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputLicenseAV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelRound3Layout.createSequentialGroup()
                                        .addComponent(inputFirstnameAV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(labelLastnameAV)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputLastnameAV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelIDAV)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputIDAV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addComponent(labelAssignedOfficeAV)
                                .addGap(18, 18, 18)
                                .addComponent(inputAssignedOfficeAV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelRound3Layout.createSequentialGroup()
                                    .addComponent(labelUserAV)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputUserAV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelRound3Layout.createSequentialGroup()
                                    .addComponent(labelPassAV)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputPassAV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelRound3Layout.createSequentialGroup()
                                    .addComponent(labelPassConfirmAV)
                                    .addGap(18, 18, 18)
                                    .addComponent(inputPassConfirmAV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDoctorViewAV)
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(inputSelectDoctorAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(labelDoctorAV)))
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogoutAV)
                        .addGap(318, 318, 318)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPatientViewAV)
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(inputSelectPatientAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(labelPatientAV)))
                .addGap(88, 88, 88))
            .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                    .addContainerGap(707, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(523, 523, 523)))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFirstNameAV)
                    .addComponent(inputFirstnameAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLastnameAV)
                    .addComponent(inputLastnameAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIDAV)
                    .addComponent(inputIDAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSpecialtyAV)
                    .addComponent(inputSelectSpecialtyAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLicenseAV)
                    .addComponent(inputLicenseAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAssignedOfficeAV)
                    .addComponent(inputAssignedOfficeAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelUserAV)
                            .addComponent(inputUserAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPassAV)
                            .addComponent(inputPassAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPassConfirmAV)
                            .addComponent(inputPassConfirmAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(labelDoctorAV)
                        .addGap(18, 18, 18)
                        .addComponent(inputSelectDoctorAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnDoctorViewAV)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(btnSaveAV)
                .addGap(123, 123, 123)
                .addComponent(btnLogoutAV)
                .addGap(38, 38, 38))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(labelPatientAV)
                .addGap(18, 18, 18)
                .addComponent(inputSelectPatientAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnPatientViewAV)
                .addContainerGap(336, Short.MAX_VALUE))
            .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator2)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnExitAVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitAVActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitAVActionPerformed

    private void btnSaveAVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAVActionPerformed
        String firstname = inputFirstnameAV.getText();
        String lastname = inputLastnameAV.getText();
        String idStr = inputIDAV.getText();
        String spec = inputSelectSpecialtyAV.getItemAt(inputSelectSpecialtyAV.getSelectedIndex());
        String licenseNumber = inputLicenseAV.getText();
        String assignedOffice = inputAssignedOfficeAV.getText();
        String username = inputUserAV.getText();
        String password = inputPassAV.getText();
        String comPassword = inputPassConfirmAV.getText();
        
        if (spec.equals("Select one")) {
            return;
        }
        Specialty specialty = Specialty.valueOf(spec.replaceAll(" &", "").replaceAll(" ", "_"));
        Response res = doctorController.register(Long.parseLong(idStr), username, firstname, lastname, password, comPassword, specialty, licenseNumber, assignedOffice);
        if (res.getStatus() == Status.CREATED) {
            JOptionPane.showMessageDialog(null, res.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
            inputFirstnameAV.setText(""); inputLastnameAV.setText(""); inputIDAV.setText("");
            inputLicenseAV.setText(""); inputAssignedOfficeAV.setText(""); inputUserAV.setText("");
            inputPassAV.setText(""); inputPassConfirmAV.setText("");
            inputSelectSpecialtyAV.setSelectedIndex(0);
            Response resDoc = doctorController.getAllDoctors();
            ArrayList<HashMap<String, Object>> doctors = (ArrayList<HashMap<String, Object>>) resDoc.getData().get("doctors");
            inputSelectDoctorAV.removeAllItems();
            inputSelectDoctorAV.addItem("Select one");
            doctorNameToId.clear();
            for (HashMap<String, Object> doc : doctors) {
                String fullname = String.valueOf(doc.get("fullname"));
                long id = Long.parseLong(String.valueOf(doc.get("id")));
                doctorNameToId.put(fullname, id);
                inputSelectDoctorAV.addItem(fullname);
            }
        } else {
            JOptionPane.showMessageDialog(null, res.getMessage(), "Oops..", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveAVActionPerformed

    private void btnDoctorViewAVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoctorViewAVActionPerformed
        String selected = inputSelectDoctorAV.getItemAt(inputSelectDoctorAV.getSelectedIndex());
        if (selected == null || selected.equals("Select one")) {
            JOptionPane.showMessageDialog(null, "Please select a doctor.", "Oops..", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Long doctorId = doctorNameToId.get(selected);
        if (doctorId != null) {
            navigator.showDoctorById(doctorId);
        }
    }//GEN-LAST:event_btnDoctorViewAVActionPerformed

    private void btnLogoutAVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutAVActionPerformed
        navigator.logout();
    }//GEN-LAST:event_btnLogoutAVActionPerformed

    private void btnPatientViewAVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientViewAVActionPerformed
        String selected = inputSelectPatientAV.getItemAt(inputSelectPatientAV.getSelectedIndex());
        if (selected == null || selected.equals("Select one")) {
            JOptionPane.showMessageDialog(null, "Please select a patient.", "Oops..", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Long patientId = patientNameToId.get(selected);
        if (patientId != null) {
            navigator.showPatientById(patientId);
        }
    }//GEN-LAST:event_btnPatientViewAVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoctorViewAV;
    private javax.swing.JButton btnExitAV;
    private javax.swing.JButton btnLogoutAV;
    private javax.swing.JButton btnPatientViewAV;
    private javax.swing.JButton btnSaveAV;
    private javax.swing.JTextField inputAssignedOfficeAV;
    private javax.swing.JTextField inputFirstnameAV;
    private javax.swing.JTextField inputIDAV;
    private javax.swing.JTextField inputLastnameAV;
    private javax.swing.JTextField inputLicenseAV;
    private javax.swing.JTextField inputPassAV;
    private javax.swing.JTextField inputPassConfirmAV;
    private javax.swing.JComboBox<String> inputSelectDoctorAV;
    private javax.swing.JComboBox<String> inputSelectPatientAV;
    private javax.swing.JComboBox<String> inputSelectSpecialtyAV;
    private javax.swing.JTextField inputUserAV;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelAdminView;
    private javax.swing.JLabel labelAssignedOfficeAV;
    private javax.swing.JLabel labelDoctorAV;
    private javax.swing.JLabel labelFirstNameAV;
    private javax.swing.JLabel labelIDAV;
    private javax.swing.JLabel labelLastnameAV;
    private javax.swing.JLabel labelLicenseAV;
    private javax.swing.JLabel labelPassAV;
    private javax.swing.JLabel labelPassConfirmAV;
    private javax.swing.JLabel labelPatientAV;
    private javax.swing.JLabel labelSpecialtyAV;
    private javax.swing.JLabel labelUserAV;
    private core.view.PanelRound panelRound1;
    private core.view.PanelRound panelRound2;
    private core.view.PanelRound panelRound3;
    // End of variables declaration//GEN-END:variables
}
