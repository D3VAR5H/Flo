package GUIinterface;

import java.awt.Toolkit;
import JDBC.*;
import static java.lang.Math.floor;

public class LoginModule extends javax.swing.JFrame {

    public static String Username;
    public static String Email;
    public static String DownloadLocation;
    public static int UserID;
    private String Password;
    private int OTP;

    public LoginModule() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSignupGuestLogin = new javax.swing.JPanel();
        btnSignUp = new javax.swing.JButton();
        btnGuest = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pnlSignup1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSignupSignup = new javax.swing.JButton();
        createEmail = new javax.swing.JTextField();
        createUsername = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        createPassword = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        createErrorMessage = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        pnlLogin = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        loginEmailUsername = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        loginPassword = new javax.swing.JPasswordField();
        btnLoginLogin = new javax.swing.JButton();
        LoginErrorMessage1 = new javax.swing.JLabel();
        LoginErrorMessage2 = new javax.swing.JLabel();
        signup = new javax.swing.JLabel();
        pnlSignup2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnSignupSignup1 = new javax.swing.JButton();
        createEmail1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        createErrorMessage1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FLO");
        setForeground(new java.awt.Color(51, 51, 55));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/FloLogo.png")));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1252, 658));
        setName("LoginFrame"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        pnlSignupGuestLogin.setMaximumSize(new java.awt.Dimension(386, 480));
        pnlSignupGuestLogin.setMinimumSize(new java.awt.Dimension(386, 480));
        pnlSignupGuestLogin.setOpaque(false);
        pnlSignupGuestLogin.setLayout(null);

        btnSignUp.setBackground(new java.awt.Color(0, 102, 0));
        btnSignUp.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(255, 255, 255));
        btnSignUp.setText("Sign Up");
        btnSignUp.setBorder(null);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        pnlSignupGuestLogin.add(btnSignUp);
        btnSignUp.setBounds(80, 90, 230, 70);

        btnGuest.setBackground(new java.awt.Color(0, 0, 102));
        btnGuest.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnGuest.setForeground(new java.awt.Color(255, 255, 255));
        btnGuest.setText("Sign in as Guest");
        btnGuest.setBorder(null);
        btnGuest.setBorderPainted(false);
        btnGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuestActionPerformed(evt);
            }
        });
        pnlSignupGuestLogin.add(btnGuest);
        btnGuest.setBounds(80, 190, 230, 70);

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setText("Login");
        btnLogin.setBorder(null);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlSignupGuestLogin.add(btnLogin);
        btnLogin.setBounds(80, 320, 230, 70);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Already a user ?");
        pnlSignupGuestLogin.add(jLabel2);
        jLabel2.setBounds(130, 280, 140, 30);

        getContentPane().add(pnlSignupGuestLogin);
        pnlSignupGuestLogin.setBounds(780, 60, 386, 480);

        pnlSignup1.setAutoscrolls(true);
        pnlSignup1.setOpaque(false);
        pnlSignup1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Create Account");
        pnlSignup1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 270, 50));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("What's your email?");
        pnlSignup1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 170, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enter your Username");
        pnlSignup1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        btnSignupSignup.setBackground(new java.awt.Color(255, 255, 255));
        btnSignupSignup.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnSignupSignup.setForeground(new java.awt.Color(0, 0, 0));
        btnSignupSignup.setText("DONE");
        btnSignupSignup.setBorder(null);
        btnSignupSignup.setEnabled(false);
        btnSignupSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupSignupActionPerformed(evt);
            }
        });
        pnlSignup1.add(btnSignupSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 160, 50));

        createEmail.setBackground(new java.awt.Color(255, 255, 255));
        createEmail.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        createEmail.setForeground(new java.awt.Color(0, 0, 0));
        createEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        createEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                createEmailKeyReleased(evt);
            }
        });
        pnlSignup1.add(createEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 310, 30));

        createUsername.setBackground(new java.awt.Color(255, 255, 255));
        createUsername.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        createUsername.setForeground(new java.awt.Color(0, 0, 0));
        createUsername.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        createUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                createUsernameKeyReleased(evt);
            }
        });
        pnlSignup1.add(createUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 310, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pick a password");
        pnlSignup1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 150, -1));

        createPassword.setBackground(new java.awt.Color(255, 255, 255));
        createPassword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        createPassword.setForeground(new java.awt.Color(0, 0, 0));
        createPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        createPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                createPasswordKeyReleased(evt);
            }
        });
        pnlSignup1.add(createPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 310, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("By signing up, you agree to Flo's Terms of Service");
        jLabel6.setToolTipText("");
        pnlSignup1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, -1));

        createErrorMessage.setForeground(new java.awt.Color(255, 255, 255));
        pnlSignup1.add(createErrorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 310, -1));

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Already a user ?  Log In");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });
        pnlSignup1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, -1, -1));

        getContentPane().add(pnlSignup1);
        pnlSignup1.setBounds(0, 0, 386, 484);
        pnlSignup1.setOpaque(false);
        pnlSignup1.setVisible(false);

        pnlLogin.setAutoscrolls(true);
        pnlLogin.setMaximumSize(new java.awt.Dimension(386, 490));
        pnlLogin.setMinimumSize(new java.awt.Dimension(386, 490));
        pnlLogin.setOpaque(false);
        pnlLogin.setPreferredSize(new java.awt.Dimension(386, 490));
        pnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Log in");
        pnlLogin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, 50));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email or username");
        pnlLogin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 170, -1));

        loginEmailUsername.setBackground(new java.awt.Color(255, 255, 255));
        loginEmailUsername.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        loginEmailUsername.setForeground(new java.awt.Color(0, 0, 0));
        loginEmailUsername.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        pnlLogin.add(loginEmailUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 310, 30));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password");
        pnlLogin.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 90, -1));

        loginPassword.setBackground(new java.awt.Color(255, 255, 255));
        loginPassword.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        loginPassword.setForeground(new java.awt.Color(0, 0, 0));
        loginPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        loginPassword.setEchoChar('\u25cf');
        pnlLogin.add(loginPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 310, 30));

        btnLoginLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLoginLogin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnLoginLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLoginLogin.setText("Login");
        btnLoginLogin.setBorder(null);
        btnLoginLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(btnLoginLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 160, 50));

        LoginErrorMessage1.setForeground(new java.awt.Color(255, 255, 255));
        pnlLogin.add(LoginErrorMessage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 310, -1));

        LoginErrorMessage2.setForeground(new java.awt.Color(255, 255, 255));
        pnlLogin.add(LoginErrorMessage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        signup.setBackground(new java.awt.Color(255, 255, 255));
        signup.setForeground(new java.awt.Color(255, 255, 255));
        signup.setText("Create an Account ? Sign Up");
        signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupMouseClicked(evt);
            }
        });
        pnlLogin.add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, -1));

        getContentPane().add(pnlLogin);
        pnlLogin.setBounds(390, 0, 386, 490);
        pnlLogin.setOpaque(false);
        pnlLogin.setVisible(false);

        pnlSignup2.setAutoscrolls(true);
        pnlSignup2.setMaximumSize(new java.awt.Dimension(386, 484));
        pnlSignup2.setMinimumSize(new java.awt.Dimension(386, 484));
        pnlSignup2.setOpaque(false);
        pnlSignup2.setPreferredSize(new java.awt.Dimension(386, 484));
        pnlSignup2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Create Account");
        pnlSignup2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 270, 50));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Enter your OTP");
        pnlSignup2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 170, -1));

        btnSignupSignup1.setBackground(new java.awt.Color(255, 255, 255));
        btnSignupSignup1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnSignupSignup1.setForeground(new java.awt.Color(0, 0, 0));
        btnSignupSignup1.setText("Create");
        btnSignupSignup1.setBorder(null);
        btnSignupSignup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupSignup1ActionPerformed(evt);
            }
        });
        pnlSignup2.add(btnSignupSignup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 160, 50));

        createEmail1.setBackground(new java.awt.Color(255, 255, 255));
        createEmail1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        createEmail1.setForeground(new java.awt.Color(0, 0, 0));
        createEmail1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        createEmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createEmail1ActionPerformed(evt);
            }
        });
        pnlSignup2.add(createEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 320, 30));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("By signing up, you agree to Flo's Terms of Service");
        jLabel16.setToolTipText("");
        pnlSignup2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));

        createErrorMessage1.setForeground(new java.awt.Color(255, 255, 255));
        pnlSignup2.add(createErrorMessage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 310, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        pnlSignup2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 290, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Resend  OTP");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        pnlSignup2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 80, 20));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setToolTipText("");
        pnlSignup2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 300, 20));

        getContentPane().add(pnlSignup2);
        pnlSignup2.setBounds(400, 190, 386, 484);
        pnlSignup2.setOpaque(false);
        pnlSignup2.setVisible(false);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Capture.PNG"))); // NOI18N
        jLabel12.setText("jLabel12");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, 0, 1250, 670);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        pnlSignupGuestLogin.setVisible(false);
        pnlSignup1.setVisible(true);
        pnlSignup1.setBounds(780, 100, 386, 484);
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuestActionPerformed
        UserDatabaseConnectivity.LoginAuthentication("guest123456789", "guest123456789");
        MainFrame mainFrame = new MainFrame();
        mainFrame.setDetails();
        mainFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGuestActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        pnlSignupGuestLogin.setVisible(false);
        pnlLogin.setVisible(true);
        pnlLogin.setBounds(780, 100, 386, 484);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSignupSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupSignupActionPerformed
        // TODO add your handling code here:
        Username = createUsername.getText();
        Email = createEmail.getText();
        Password = createPassword.getText();
        btnSignupSignup.setText("Creating...");

        try {
            if (!UserDatabaseConnectivity.CheckExistence(Username, Email)) {
                jLabel1.setText("An Email with an OTP has been sent to "+Email);
                OTP = (int) floor(100000 + Math.random()*(900000));
                coolFeatures.sendMail(Email, OTP);
                pnlSignup1.setVisible(false);
                pnlSignup2.setBounds(780, 100, 386, 484);
                pnlSignup2.setVisible(true);
            } else {
                btnSignupSignup.setText("DONE");
                createErrorMessage.setText("This Email or Username already exists. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }     
    }//GEN-LAST:event_btnSignupSignupActionPerformed

    private void btnLoginLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginLoginActionPerformed
        String EmailUsername = loginEmailUsername.getText();
        String Password = loginPassword.getText();
        btnLoginLogin.setText("Logging in...");

        // Code to Mainframe
        if (UserDatabaseConnectivity.LoginAuthentication(EmailUsername, Password)) {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setDetails(Username, DownloadLocation, UserID);
            mainFrame.setVisible(true);
            this.dispose();
        } else {
            btnLoginLogin.setText("Login");
            LoginErrorMessage1.setText("Your email and password combination does not match");
            LoginErrorMessage2.setText("any Flo account. Please try again.");
        }
    }//GEN-LAST:event_btnLoginLoginActionPerformed

    private void createEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_createEmailKeyReleased
        if (createEmail.getText().isEmpty() || createPassword.getText().isEmpty() || createUsername.getText().isEmpty()) {
            btnSignupSignup.setEnabled(false);
        } else {
            btnSignupSignup.setEnabled(true);
        }
    }//GEN-LAST:event_createEmailKeyReleased
    private void createPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_createPasswordKeyReleased
        createEmailKeyReleased(evt);
    }//GEN-LAST:event_createPasswordKeyReleased
    private void createUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_createUsernameKeyReleased
        createEmailKeyReleased(evt);
    }//GEN-LAST:event_createUsernameKeyReleased

    private void btnSignupSignup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupSignup1ActionPerformed
        int enteredOTP = Integer.parseInt(createEmail1.getText());

        if (enteredOTP != OTP) {
            jLabel15.setText("The OTP you entered is incorrect");
        } else {
            try {
                if (UserDatabaseConnectivity.CreateAccount(Username, Email, Password)) {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setDetails(Username, DownloadLocation, UserID);
                    mainFrame.setVisible(true);
                    this.dispose();

                } else {

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSignupSignup1ActionPerformed

    private void createEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createEmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createEmail1ActionPerformed

    private void signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupMouseClicked
        pnlLogin.setVisible(false);
        pnlSignup1.setVisible(true);
        pnlSignup1.setBounds(780, 100, 386, 484);
    }//GEN-LAST:event_signupMouseClicked
    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        pnlSignup1.setVisible(false);
        pnlLogin.setVisible(true);
        pnlLogin.setBounds(780, 100, 386, 484);
    }//GEN-LAST:event_loginMouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        OTP = (int) floor(100000 + Math.random()*(900000));
        coolFeatures.sendMail(Email, OTP);
    }//GEN-LAST:event_jLabel14MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoginErrorMessage1;
    private javax.swing.JLabel LoginErrorMessage2;
    private javax.swing.JButton btnGuest;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLoginLogin;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JButton btnSignupSignup;
    private javax.swing.JButton btnSignupSignup1;
    private javax.swing.JTextField createEmail;
    private javax.swing.JTextField createEmail1;
    private javax.swing.JLabel createErrorMessage;
    private javax.swing.JLabel createErrorMessage1;
    private javax.swing.JTextField createPassword;
    private javax.swing.JTextField createUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel login;
    private javax.swing.JTextField loginEmailUsername;
    private javax.swing.JPasswordField loginPassword;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlSignup1;
    private javax.swing.JPanel pnlSignup2;
    private javax.swing.JPanel pnlSignupGuestLogin;
    private javax.swing.JLabel signup;
    // End of variables declaration//GEN-END:variables
}
