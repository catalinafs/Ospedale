package core.view;

import core.model.Administrator;
import core.model.Appointment;
import core.model.AppointmentStatus;
import core.model.Doctor;
import core.model.Hospitalization;
import core.model.Patient;
import core.model.RoomType;
import core.model.Specialty;
import core.model.User;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PatientView extends javax.swing.JFrame {

    private int x, y;
    private User user;
    private ArrayList<User> users;
    private Patient patient;
    private ArrayList<Appointment> appointments;
    private ArrayList<Hospitalization> hospitalizations;

    public PatientView(User user,Patient patient, ArrayList<User> users, ArrayList<Appointment>appointments, ArrayList<Hospitalization> hospitalizations) {
        initComponents();
        this.user = user;
        this.users = users;
        this.patient = patient;
        this.hospitalizations = hospitalizations;
        this.appointments = appointments;
        if (user instanceof Administrator) {
            btnBackPV.setVisible(true);
        } else {
            btnBackPV.setVisible(false);
        }
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
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
        for(Appointment ap: this.appointments){
            if (ap.getId().equals(idAppointment)) {
                ap.setStatus(AppointmentStatus.CANCELED);
            }
        }
    }//GEN-LAST:event_btnCancelAppointPVActionPerformed

    private void btnSavePVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePVActionPerformed
        String firstname = inputFisrtnamePV.getText();
        String lastname = inputLastnamePV.getText();
        boolean gender = (inputSelectGenderPV.getSelectedIndex() == 0 ? null : (inputSelectGenderPV.getSelectedIndex() == 1));
        String birth = inputBirthPV.getText();
        String address = inputAddressPV.getText();
        long phone = Long.parseLong(inputPhonePV.getText());
        String email = inputEmailPV.getText();
        String username = inputUserPV.getText();
        String password = inputPassPV.getText();
        String comPassword = inputPassConfirPV.getText();
        LocalDate birthdate = LocalDate.of(Integer.parseInt(birth.substring(0, 4)), Integer.parseInt(birth.substring(5, 7)), Integer.parseInt(birth.substring(8)));
        if (comPassword.equals(password)) {
            for (User user : this.users) {
                if (user.getId() == this.user.getId() && user instanceof Patient) {
                    Patient userTemp = (Patient) user;
                    userTemp.setAddress(address);
                    userTemp.setBirthdate(birthdate);
                    userTemp.setEmail(email);
                    userTemp.setFirstname(firstname);
                    userTemp.setGender(gender);
                    userTemp.setLastname(lastname);
                    userTemp.setPassword(password);
                    userTemp.setPhone(phone);
                    userTemp.setUsername(username);
                }
            }
        }

    }//GEN-LAST:event_btnSavePVActionPerformed

    private void btnLogoutPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutPVActionPerformed
        MainView login = new MainView();
        this.setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_btnLogoutPVActionPerformed

    private void btnBackPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackPVActionPerformed
        AdminView admin = new AdminView(user, users,hospitalizations, appointments);
        this.setVisible(false);
        admin.setVisible(true);
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
        for (User doc : this.users) {
            if (doc instanceof Doctor) {
                inputSelectRequestPV.addItem(doc.getFirstname() + " " + doc.getLastname());
            }
        }
    }//GEN-LAST:event_btnRadioDoctorPVActionPerformed

    private void btnCreateRequestMediPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateRequestMediPVActionPerformed
        String appointDate = inputAppointDatePV.getText();
        LocalDate appointmentDate = LocalDate.of(Integer.parseInt(appointDate.substring(0, 4)), Integer.parseInt(appointDate.substring(5, 7)), Integer.parseInt(appointDate.substring(8)));
        LocalTime appointmentHour = LocalTime.of(Integer.parseInt(inputAppointTimePV.getText().substring(0, 2)), Integer.parseInt(inputAppointTimePV.getText().substring(3)));
        LocalDateTime Finally = LocalDateTime.of(appointmentDate, appointmentHour);
        String appointmentReason = inputTextAreaPV.getText();
        long docId = Long.parseLong(inputSelectRequestPV.getItemAt(inputSelectRequestPV.getSelectedIndex()));
        Doctor doctor = null;
        for(User use:this.users){
            if (use.getId() == docId) {
                doctor = (Doctor) use;
            }
        }
        boolean appointmentType = (inputSelectAppointTypePV.getSelectedIndex() == 0 ? null : (inputSelectAppointTypePV.getSelectedIndex() == 2 ));
        this.appointments.add(new Appointment(appointDate, patient, doctor, doctor.getSpecialty(), Finally, appointDate, appointmentType));
    }//GEN-LAST:event_btnCreateRequestMediPVActionPerformed


    private void btnRefreshPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshPVActionPerformed
        // TODO add your handling code here:
        Patient p = (Patient) user;
        DefaultTableModel model = (DefaultTableModel) tableAppointPV.getModel();
        model.setRowCount(0);
        for (Appointment a : p.getAppointments()) {
            model.addRow(new Object[]{a.getId(), a.getDatetime().toString(), a.getDoctor().getFirstname() + " " + a.getDoctor().getLastname(), a.getSpecialty().name(), a.isType() ? "In-person" : "Remote", a.getStatus().name()});
        }
    }//GEN-LAST:event_btnRefreshPVActionPerformed

    private void btnCreateHospiPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateHospiPVActionPerformed
        String hospitalizationReason = inputTextAreaHospiReasPV.getText();
        long idDoctor = Long.parseLong(inputSelectAttendingPV.getItemAt(inputSelectAttendingPV.getSelectedIndex()));
        Doctor doc = null;
        for(User use: this.users){
            if (use.getId()  == idDoctor ){ //Antes era use.id
                doc = (Doctor) use;
            }
        }
        LocalDate stimateDate = LocalDate.of(Integer.parseInt(inputEstiDatePV.getText().substring(0, 4)),Integer.parseInt(inputEstiDatePV.getText().substring(5, 7)), Integer.parseInt(inputEstiDatePV.getText().substring(8)));
        
        RoomType desireRoom = RoomType.valueOf(inputSelectDesiredRoomPV.getItemAt(inputSelectDesiredRoomPV.getSelectedIndex()).toUpperCase());
        String observations = inputTextAreaObservPV.getText();
        this.hospitalizations.add(new Hospitalization(observations, this.patient, doc, stimateDate, observations, desireRoom, observations));
    }//GEN-LAST:event_btnCreateHospiPVActionPerformed



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
