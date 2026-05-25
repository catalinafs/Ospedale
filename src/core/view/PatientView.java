package core.view;

import core.app.INavigator;
import core.controllers.IAppointmentController;
import core.controllers.IAuthController;
import core.controllers.IDoctorController;
import core.controllers.IHospitalizationController;
import core.controllers.IPatientController;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.model.Doctor;
import core.model.IDataObserver;
import core.model.RoomType;
import core.model.Specialty;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PatientView extends javax.swing.JFrame implements IDataObserver {

    private int x, y;
    private long userId;
    private INavigator navigator;
    private IAuthController authController;
    private IPatientController patientController;
    private IDoctorController doctorController;
    private IAppointmentController appointmentController;
    private IHospitalizationController hospitalizationController;

    public PatientView(long userId,
            IAuthController authController,
            IPatientController patientController,
            IDoctorController doctorController,
            IAppointmentController appointmentController,
            IHospitalizationController hospitalizationController,
            INavigator navigator) {
        initComponents();
        this.userId = userId;
        this.authController = authController;
        this.patientController = patientController;
        this.doctorController = doctorController;
        this.appointmentController = appointmentController;
        this.hospitalizationController = hospitalizationController;
        this.navigator = navigator;

        Response res = authController.userIsOfType("ADMIN", userId);
        if (res.getStatus() == 200) {
            boolean isAdmin = (boolean) res.getData().get("matches");
            btnBackPV.setVisible(isAdmin);
        } else {
            navigator.showMain();
        }

        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);

        btnRefreshPVActionPerformed(null);

        for (Object doc : doctorController.getAllDoctors().getData().values().toArray()) {
            if (doc instanceof Doctor doc_) {
                inputSelectAttendingPV.addItem(doc_.getFirstname() + " " + doc_.getLastname());
            }
        }

        for (RoomType type : RoomType.values()) {
            inputSelectDesiredRoomPV.addItem(type.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new core.view.PanelRound();
        panelRound2 = new core.view.PanelRound();
        btnExtiPV = new javax.swing.JButton();
        labelPatientView = new javax.swing.JLabel();
        btnBackPV = new javax.swing.JButton();
        tabbedPanelPV = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableAppointPV = new javax.swing.JTable();
        btnRefreshPV = new javax.swing.JButton();
        btnLogoutPV = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelFistnamePV = new javax.swing.JLabel();
        inputFisrtnamePV = new javax.swing.JTextField();
        labelLastnamePV = new javax.swing.JLabel();
        inputLastnamePV = new javax.swing.JTextField();
        labelBirthPV = new javax.swing.JLabel();
        inputBirthPV = new javax.swing.JTextField();
        labelGenderPV = new javax.swing.JLabel();
        labelEmailPV = new javax.swing.JLabel();
        inputEmailPV = new javax.swing.JTextField();
        labelPhonePV = new javax.swing.JLabel();
        inputPhonePV = new javax.swing.JTextField();
        labelAddressPV = new javax.swing.JLabel();
        inputAddressPV = new javax.swing.JTextField();
        inputPassPV = new javax.swing.JTextField();
        labelPassPV = new javax.swing.JLabel();
        labelPassConfirPV = new javax.swing.JLabel();
        inputPassConfirPV = new javax.swing.JTextField();
        btnSavePV = new javax.swing.JButton();
        labelUserPV = new javax.swing.JLabel();
        inputUserPV = new javax.swing.JTextField();
        inputSelectGenderPV = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        labelRequestMediAppointPV = new javax.swing.JLabel();
        btnRadioSpecialtyPV = new javax.swing.JRadioButton();
        btnRadioDoctorPV = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        labelAppointDatePV = new javax.swing.JLabel();
        inputAppointDatePV = new javax.swing.JTextField();
        inputAppointTimePV = new javax.swing.JTextField();
        labelAppointTimePV = new javax.swing.JLabel();
        labelAppointTypePV = new javax.swing.JLabel();
        labelAppointReasPV = new javax.swing.JLabel();
        inputSelectAppointTypePV = new javax.swing.JComboBox<>();
        btnCreateRequestMediPV = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        labelHospiPV = new javax.swing.JLabel();
        labelHospiReasoPV = new javax.swing.JLabel();
        labelAttendingPV = new javax.swing.JLabel();
        inputSelectAttendingPV = new javax.swing.JComboBox<>();
        inputEstiDatePV = new javax.swing.JTextField();
        labelEstiiDatePV = new javax.swing.JLabel();
        labelDesiredRoomPV = new javax.swing.JLabel();
        inputSelectDesiredRoomPV = new javax.swing.JComboBox<>();
        inputObservPV = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputTextAreaObservPV = new javax.swing.JTextArea();
        btnCreateHospiPV = new javax.swing.JButton();
        labelCancelAppointPV = new javax.swing.JLabel();
        labelAppoinPV = new javax.swing.JLabel();
        labelObservAppoinPV = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputTextAreaObservAppointPV = new javax.swing.JTextArea();
        btnCancelAppointPV = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        inputTextAreaHospiReasPV = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        inputTextAreaPV = new javax.swing.JTextArea();
        inputSelectIDappointPV = new javax.swing.JComboBox<>();
        inputSelectRequestPV = new javax.swing.JComboBox<>();

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

        btnExtiPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnExtiPV.setText("X");
        btnExtiPV.setBorderPainted(false);
        btnExtiPV.setContentAreaFilled(false);
        btnExtiPV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExtiPV.setFocusable(false);
        btnExtiPV.setRequestFocusEnabled(false);
        btnExtiPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtiPVActionPerformed(evt);
            }
        });

        labelPatientView.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        labelPatientView.setText("PATIENT VIEW");

        btnBackPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnBackPV.setText("Back");
        btnBackPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackPVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(labelPatientView)
                .addGap(29, 29, 29)
                .addComponent(btnBackPV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExtiPV)
                .addGap(19, 19, 19))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExtiPV))
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBackPV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labelPatientView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tableAppointPV.setAutoCreateRowSorter(true);
        tableAppointPV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Date", "Doctor", "Specialty", "Type", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableAppointPV);

        btnRefreshPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRefreshPV.setText("Refresh");
        btnRefreshPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshPVActionPerformed(evt);
            }
        });

        btnLogoutPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnLogoutPV.setText("Logout");
        btnLogoutPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutPVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(602, 602, 602)
                .addComponent(btnRefreshPV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogoutPV)
                .addGap(78, 78, 78))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefreshPV)
                    .addComponent(btnLogoutPV))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        tabbedPanelPV.addTab("Appointment history", jPanel3);

        labelFistnamePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelFistnamePV.setText("Firstname");

        inputFisrtnamePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelLastnamePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelLastnamePV.setText("Lastname");

        inputLastnamePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelBirthPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelBirthPV.setText("Birthdate");

        inputBirthPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelGenderPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelGenderPV.setText("Gender");

        labelEmailPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelEmailPV.setText("Email");

        inputEmailPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelPhonePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelPhonePV.setText("Phone");

        inputPhonePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelAddressPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelAddressPV.setText("Address");

        inputAddressPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        inputPassPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelPassPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelPassPV.setText("Password");

        labelPassConfirPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelPassConfirPV.setText("Password confirmation");

        inputPassConfirPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        btnSavePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnSavePV.setText("Save");
        btnSavePV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePVActionPerformed(evt);
            }
        });

        labelUserPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelUserPV.setText("User");

        inputUserPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        inputSelectGenderPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputSelectGenderPV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one", "Female", "Male" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(labelFistnamePV)
                .addGap(18, 18, 18)
                .addComponent(inputFisrtnamePV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(labelLastnamePV)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelPhonePV)
                        .addGap(18, 18, 18)
                        .addComponent(inputPhonePV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelAddressPV)
                        .addGap(18, 18, 18)
                        .addComponent(inputAddressPV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inputLastnamePV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelBirthPV)
                        .addGap(18, 18, 18)
                        .addComponent(inputBirthPV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelGenderPV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputSelectGenderPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(labelEmailPV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(inputEmailPV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(141, 141, 141))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(516, 516, 516)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnSavePV))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(inputPassConfirPV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelPassConfirPV)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(labelPassPV))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputUserPV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addComponent(labelUserPV)))
                            .addComponent(inputPassPV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFistnamePV)
                    .addComponent(inputFisrtnamePV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLastnamePV)
                    .addComponent(inputLastnamePV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBirthPV)
                    .addComponent(inputBirthPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelGenderPV)
                    .addComponent(labelEmailPV)
                    .addComponent(inputEmailPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputSelectGenderPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPhonePV)
                    .addComponent(inputPhonePV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAddressPV)
                    .addComponent(inputAddressPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(labelUserPV)
                .addGap(18, 18, 18)
                .addComponent(inputUserPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPassPV)
                .addGap(18, 18, 18)
                .addComponent(inputPassPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPassConfirPV)
                .addGap(18, 18, 18)
                .addComponent(inputPassConfirPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnSavePV)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        tabbedPanelPV.addTab("Modify info", jPanel1);

        labelRequestMediAppointPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelRequestMediAppointPV.setText("Request medical appointment");

        btnRadioSpecialtyPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRadioSpecialtyPV.setText("Specialty");
        btnRadioSpecialtyPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadioSpecialtyPVActionPerformed(evt);
            }
        });

        btnRadioDoctorPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRadioDoctorPV.setText("Doctor");
        btnRadioDoctorPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadioDoctorPVActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        labelAppointDatePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelAppointDatePV.setText("Appointment date");

        inputAppointDatePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        inputAppointTimePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelAppointTimePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelAppointTimePV.setText("Appointment time");

        labelAppointTypePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelAppointTypePV.setText("Appointment type");

        labelAppointReasPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelAppointReasPV.setText("Appointment reason");

        inputSelectAppointTypePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputSelectAppointTypePV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one", "Remote", "In-person" }));

        btnCreateRequestMediPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnCreateRequestMediPV.setText("Create");
        btnCreateRequestMediPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateRequestMediPVActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        labelHospiPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelHospiPV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHospiPV.setText("Request hospitalization");

        labelHospiReasoPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelHospiReasoPV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHospiReasoPV.setText("Hospitalization reason");

        labelAttendingPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelAttendingPV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAttendingPV.setText("Attending doctor");

        inputSelectAttendingPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputSelectAttendingPV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one" }));

        inputEstiDatePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        labelEstiiDatePV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelEstiiDatePV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEstiiDatePV.setText("Estimated date of admission");
        labelEstiiDatePV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelDesiredRoomPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelDesiredRoomPV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDesiredRoomPV.setText("Desired room type");

        inputSelectDesiredRoomPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputSelectDesiredRoomPV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one" }));

        inputObservPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputObservPV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inputObservPV.setText("Observations");

        inputTextAreaObservPV.setColumns(20);
        inputTextAreaObservPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputTextAreaObservPV.setRows(5);
        jScrollPane1.setViewportView(inputTextAreaObservPV);

        btnCreateHospiPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnCreateHospiPV.setText("Create");
        btnCreateHospiPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateHospiPVActionPerformed(evt);
            }
        });

        labelCancelAppointPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelCancelAppointPV.setText("Cancel appointment");

        labelAppoinPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelAppoinPV.setText("ID appointment");

        labelObservAppoinPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        labelObservAppoinPV.setText("Observations");

        inputTextAreaObservAppointPV.setColumns(20);
        inputTextAreaObservAppointPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputTextAreaObservAppointPV.setRows(5);
        jScrollPane2.setViewportView(inputTextAreaObservAppointPV);

        btnCancelAppointPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnCancelAppointPV.setText("Cancel");
        btnCancelAppointPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelAppointPVActionPerformed(evt);
            }
        });

        inputTextAreaHospiReasPV.setColumns(20);
        inputTextAreaHospiReasPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputTextAreaHospiReasPV.setRows(5);
        jScrollPane4.setViewportView(inputTextAreaHospiReasPV);

        inputTextAreaPV.setColumns(20);
        inputTextAreaPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputTextAreaPV.setRows(5);
        jScrollPane5.setViewportView(inputTextAreaPV);

        inputSelectIDappointPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputSelectIDappointPV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one" }));

        inputSelectRequestPV.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        inputSelectRequestPV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnRadioSpecialtyPV)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRadioDoctorPV))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(63, 63, 63)
                                    .addComponent(inputAppointDatePV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelAppointTimePV)
                                        .addComponent(labelAppointDatePV)
                                        .addComponent(inputSelectRequestPV, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(63, 63, 63)
                                    .addComponent(inputAppointTimePV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addComponent(labelAppointReasPV))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addComponent(labelAppointTypePV))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(55, 55, 55)
                                    .addComponent(inputSelectAppointTypePV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(labelRequestMediAppointPV)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btnCreateRequestMediPV)))
                .addGap(69, 69, 69)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(211, 211, 211)
                            .addComponent(btnCreateHospiPV))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelHospiReasoPV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(labelHospiPV, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                .addComponent(labelAttendingPV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputObservPV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelEstiiDatePV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelDesiredRoomPV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(inputSelectAttendingPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(inputEstiDatePV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(inputSelectDesiredRoomPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(labelCancelAppointPV))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(btnCancelAppointPV))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inputSelectIDappointPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelAppoinPV)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(labelObservAppoinPV)))
                        .addGap(49, 49, 49)))
                .addGap(81, 81, 81))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelHospiPV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(labelHospiReasoPV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelAttendingPV)
                        .addGap(18, 18, 18)
                        .addComponent(inputSelectAttendingPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelEstiiDatePV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputEstiDatePV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(labelDesiredRoomPV)
                        .addGap(18, 18, 18)
                        .addComponent(inputSelectDesiredRoomPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputObservPV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreateHospiPV)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelRequestMediAppointPV)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnRadioSpecialtyPV)
                                    .addComponent(btnRadioDoctorPV))
                                .addGap(18, 18, 18)
                                .addComponent(inputSelectRequestPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelAppointDatePV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputAppointDatePV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(labelAppointTimePV)
                                .addGap(18, 18, 18)
                                .addComponent(inputAppointTimePV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelAppointReasPV)
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelCancelAppointPV)
                                .addGap(39, 39, 39)
                                .addComponent(labelAppoinPV)
                                .addGap(18, 18, 18)
                                .addComponent(inputSelectIDappointPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelObservAppoinPV)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(btnCancelAppointPV)))
                        .addGap(18, 18, 18)
                        .addComponent(labelAppointTypePV)
                        .addGap(18, 18, 18)
                        .addComponent(inputSelectAppointTypePV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnCreateRequestMediPV)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tabbedPanelPV.addTab("Request/Cancel", jPanel2);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabbedPanelPV)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPanelPV))
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

    private void btnExtiPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtiPVActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExtiPVActionPerformed

    private void btnCancelAppointPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelAppointPVActionPerformed
        String idAppointment = inputSelectIDappointPV.getItemAt(inputSelectIDappointPV.getSelectedIndex());
        Response res = appointmentController.cancelAppointment(idAppointment, userId);
        if (res.getStatus() == Status.OK) {
            JOptionPane.showInternalMessageDialog(null, res.getMessage(), "Appointment cancellation succesful", JOptionPane.INFORMATION_MESSAGE);
            inputSelectIDappointPV.setSelectedIndex(0);
            btnRefreshPVActionPerformed(null);
        } else {
            JOptionPane.showInternalMessageDialog(null, res.getMessage(), "Oops..", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCancelAppointPVActionPerformed

    private void btnSavePVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePVActionPerformed
        String firstname = inputFisrtnamePV.getText();
        String lastname = inputLastnamePV.getText();
        int gender = inputSelectGenderPV.getSelectedIndex();
        String birth = inputBirthPV.getText();
        String address = inputAddressPV.getText();
        String phone = inputPhonePV.getText();
        String email = inputEmailPV.getText();
        String username = inputUserPV.getText();
        String password = inputPassPV.getText();
        String comPassword = inputPassConfirPV.getText();
        Response res = patientController.update(userId, username, firstname, lastname, password, comPassword, email, birth, gender, phone, address);
        if (res.getStatus() == Status.OK) {
            JOptionPane.showInternalMessageDialog(null, res.getMessage(), "Update successful", JOptionPane.INFORMATION_MESSAGE);
            inputFisrtnamePV.setText(""); inputLastnamePV.setText(""); inputBirthPV.setText("");
            inputAddressPV.setText(""); inputPhonePV.setText(""); inputEmailPV.setText("");
            inputUserPV.setText(""); inputPassPV.setText(""); inputPassConfirPV.setText("");
            inputSelectGenderPV.setSelectedIndex(0);
        } else {
            JOptionPane.showInternalMessageDialog(null, res.getMessage(), "Oops..", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSavePVActionPerformed

    private void btnLogoutPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutPVActionPerformed
        navigator.logout();
    }//GEN-LAST:event_btnLogoutPVActionPerformed

    private void btnBackPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackPVActionPerformed
        navigator.showAdminView();
    }//GEN-LAST:event_btnBackPVActionPerformed

    private void btnRadioSpecialtyPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRadioSpecialtyPVActionPerformed
        if (btnRadioDoctorPV.isSelected()) {
            btnRadioDoctorPV.setSelected(false);
        }

        inputSelectRequestPV.removeAllItems();

        inputSelectRequestPV.addItem("Select one");
        for (Specialty spec : Specialty.values()) {
            inputSelectRequestPV.addItem(spec.toString().replaceAll("_", " & "));
        }
    }//GEN-LAST:event_btnRadioSpecialtyPVActionPerformed

    private void btnRadioDoctorPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRadioDoctorPVActionPerformed
        if (btnRadioSpecialtyPV.isSelected()) {
            btnRadioSpecialtyPV.setSelected(false);
        }
        inputSelectRequestPV.removeAllItems();

        inputSelectRequestPV.addItem("Select one");
        for (Object doc : doctorController.getAllDoctors().getData().values().toArray()) {
            if (doc instanceof Doctor doc_) {
                inputSelectRequestPV.addItem(doc_.getFirstname() + " " + doc_.getLastname());
            }
        }

    }//GEN-LAST:event_btnRadioDoctorPVActionPerformed

    private void btnCreateRequestMediPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateRequestMediPVActionPerformed
        String date = inputAppointDatePV.getText();
        String time = inputAppointTimePV.getText();
        String reason = inputTextAreaPV.getText();
        String selected_id = inputSelectRequestPV.getItemAt(inputSelectRequestPV.getSelectedIndex());
        int type = inputSelectAppointTypePV.getSelectedIndex();
        boolean isSpecialty = btnRadioSpecialtyPV.isSelected();

        Response res = appointmentController.requestAppointment(userId, date, time, type, reason, selected_id, isSpecialty);
        if (res.getStatus() == Status.CREATED) {
            JOptionPane.showInternalMessageDialog(null, res.getMessage(), "Appointment request creation successful", JOptionPane.INFORMATION_MESSAGE);
            inputAppointDatePV.setText(""); inputAppointTimePV.setText(""); inputTextAreaPV.setText("");
            inputSelectAppointTypePV.setSelectedIndex(0);
            inputSelectRequestPV.setSelectedIndex(0);
            btnRefreshPVActionPerformed(null);
        } else {
            JOptionPane.showInternalMessageDialog(null, res.getMessage(), "Oops..", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCreateRequestMediPVActionPerformed


    private void btnRefreshPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshPVActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableAppointPV.getModel();
        model.setRowCount(0);

        Response res = appointmentController.getPatientAppointments(userId);
        ArrayList<HashMap<String, Object>> appointments = (ArrayList<HashMap<String, Object>>) res.getData().get("appointments");

        inputSelectIDappointPV.removeAllItems();
        inputSelectIDappointPV.addItem("Select one");
        for (HashMap<String, Object> a : appointments) {
            inputSelectIDappointPV.addItem(String.valueOf(a.get("id")));
            model.addRow(new Object[]{
                a.get("id"),
                a.get("date"),
                a.get("doctor"),
                a.get("specialty"),
                a.get("type"),
                a.get("status")
            });

        }
    }//GEN-LAST:event_btnRefreshPVActionPerformed

    private void btnCreateHospiPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateHospiPVActionPerformed
        String reason = inputTextAreaHospiReasPV.getText();
        String doctor_id = inputSelectAttendingPV.getItemAt(inputSelectAttendingPV.getSelectedIndex());
        String admission_date = inputEstiDatePV.getText();
        String room_type = inputSelectDesiredRoomPV.getItemAt(inputSelectDesiredRoomPV.getSelectedIndex());
        String observations = inputTextAreaObservPV.getText();

        Response res = hospitalizationController.requestHospitalization(userId, reason, doctor_id, admission_date, room_type, observations);
        if (res.getStatus() == Status.CREATED) {
            JOptionPane.showInternalMessageDialog(null, res.getMessage(), "Hospitalization request creation successful", JOptionPane.INFORMATION_MESSAGE);
            btnRefreshPVActionPerformed(null);
        } else {
            JOptionPane.showInternalMessageDialog(null, res.getMessage(), "Oops..", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCreateHospiPVActionPerformed

    @Override
    public void onDataChanged(String storageName) {
        if ("AppointmentStorage".equals(storageName)) {
            btnRefreshPVActionPerformed(null);
        } else if ("HospitalizationStorage".equals(storageName)) {
            btnRefreshPVActionPerformed(null);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackPV;
    private javax.swing.JButton btnCancelAppointPV;
    private javax.swing.JButton btnCreateHospiPV;
    private javax.swing.JButton btnCreateRequestMediPV;
    private javax.swing.JButton btnExtiPV;
    private javax.swing.JButton btnLogoutPV;
    private javax.swing.JRadioButton btnRadioDoctorPV;
    private javax.swing.JRadioButton btnRadioSpecialtyPV;
    private javax.swing.JButton btnRefreshPV;
    private javax.swing.JButton btnSavePV;
    private javax.swing.JTextField inputAddressPV;
    private javax.swing.JTextField inputAppointDatePV;
    private javax.swing.JTextField inputAppointTimePV;
    private javax.swing.JTextField inputBirthPV;
    private javax.swing.JTextField inputEmailPV;
    private javax.swing.JTextField inputEstiDatePV;
    private javax.swing.JTextField inputFisrtnamePV;
    private javax.swing.JTextField inputLastnamePV;
    private javax.swing.JLabel inputObservPV;
    private javax.swing.JTextField inputPassConfirPV;
    private javax.swing.JTextField inputPassPV;
    private javax.swing.JTextField inputPhonePV;
    private javax.swing.JComboBox<String> inputSelectAppointTypePV;
    private javax.swing.JComboBox<String> inputSelectAttendingPV;
    private javax.swing.JComboBox<String> inputSelectDesiredRoomPV;
    private javax.swing.JComboBox<String> inputSelectGenderPV;
    private javax.swing.JComboBox<String> inputSelectIDappointPV;
    private javax.swing.JComboBox<String> inputSelectRequestPV;
    private javax.swing.JTextArea inputTextAreaHospiReasPV;
    private javax.swing.JTextArea inputTextAreaObservAppointPV;
    private javax.swing.JTextArea inputTextAreaObservPV;
    private javax.swing.JTextArea inputTextAreaPV;
    private javax.swing.JTextField inputUserPV;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelAddressPV;
    private javax.swing.JLabel labelAppoinPV;
    private javax.swing.JLabel labelAppointDatePV;
    private javax.swing.JLabel labelAppointReasPV;
    private javax.swing.JLabel labelAppointTimePV;
    private javax.swing.JLabel labelAppointTypePV;
    private javax.swing.JLabel labelAttendingPV;
    private javax.swing.JLabel labelBirthPV;
    private javax.swing.JLabel labelCancelAppointPV;
    private javax.swing.JLabel labelDesiredRoomPV;
    private javax.swing.JLabel labelEmailPV;
    private javax.swing.JLabel labelEstiiDatePV;
    private javax.swing.JLabel labelFistnamePV;
    private javax.swing.JLabel labelGenderPV;
    private javax.swing.JLabel labelHospiPV;
    private javax.swing.JLabel labelHospiReasoPV;
    private javax.swing.JLabel labelLastnamePV;
    private javax.swing.JLabel labelObservAppoinPV;
    private javax.swing.JLabel labelPassConfirPV;
    private javax.swing.JLabel labelPassPV;
    private javax.swing.JLabel labelPatientView;
    private javax.swing.JLabel labelPhonePV;
    private javax.swing.JLabel labelRequestMediAppointPV;
    private javax.swing.JLabel labelUserPV;
    private core.view.PanelRound panelRound1;
    private core.view.PanelRound panelRound2;
    private javax.swing.JTabbedPane tabbedPanelPV;
    private javax.swing.JTable tableAppointPV;
    // End of variables declaration//GEN-END:variables
}
