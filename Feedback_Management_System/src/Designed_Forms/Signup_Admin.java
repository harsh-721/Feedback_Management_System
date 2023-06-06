/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Designed_Forms;
/*Manual import*/
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
/**
 *
 * @author Vyata
 */
public class Signup_Admin extends javax.swing.JFrame {

    /**
     * Creates new form Signup_Admin
     */
    public Signup_Admin() {
        super("Administrator Signup | FEEDBACK MANAGEMENT SYSTEM");
        initComponents();
    }
    /*Function_4: Admin signup*/
    public void adminSignupForm(){
        /*String,TextField,PassowrdField Variables*/
        String adminEmail = edtEmail.getText();
        String adminFirstName = edtFirstName.getText();
        String adminLastName = edtLastName.getText();
        String adminPassword = edtPassword.getText();
        String adminConfirmPassword = edtConfirmPassword.getText();
        
        try{
            
            /*Database Connection*/
            Connection con = FMSDatabaseConnection.getConnection();
            
            /*SQL Statement to execute query*/
            String sql = "INSERT INTO admin(Email, FirstName, LastName, Password, ConfirmPassword) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            /*Inserting values from the textfields to database*/
            ps.setString(1, adminEmail);
            ps.setString(2,adminFirstName);
            ps.setString(3,adminLastName);
            ps.setString(4,adminPassword);
            ps.setString(5,adminConfirmPassword);
            
            /*Query Executing Statement*/
            int addedAdmin = ps.executeUpdate();
            
            /*showing success or failure message*/
            if (addedAdmin > 0){
                JOptionPane.showMessageDialog(this, "Account created successfully. Go to Admin login page to login to your account.");
            }
            else{
                JOptionPane.showMessageDialog(this,"Account could not be created. Check Server Connection");
            }
        }
        catch(Exception e){
            /*Print error message*/
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    /*Function_5: Validation rules for all the fields*/
    public boolean signupValidation(){
        /*String,TextField,PassowrdField Variables*/
        String adminEmail = edtEmail.getText();
        String adminFirstName = edtFirstName.getText();
        String adminLastName = edtLastName.getText();
        String adminPassword = edtPassword.getText();
        String adminConfirmPassword = edtConfirmPassword.getText();
        
        /*Check For empty fields*/
        
        /*whether email address is empty or not + valid email address*/
        if(adminEmail.equals("") || !adminEmail.matches("^.+@.+\\..+$")){
            JOptionPane.showMessageDialog(this, "Email Address is Empty or Invalid.");
            return false;
        }
        /*For First Name field*/
        if(adminFirstName.equals("")){
            JOptionPane.showMessageDialog(this, "First Name is Required.");
            return false;
        }
        /*For Last Name Field*/
        if(adminLastName.equals("")){
            JOptionPane.showMessageDialog(this, "Last Name is Required.");
            return false;
        }
        /*For Password Field*/
        if(adminPassword.equals("")){
            JOptionPane.showMessageDialog(this, "Password Cannot be Empty.");
            return false;
        }
        /*For Confirm Password Field*/
        if(adminConfirmPassword.equals("")){
            JOptionPane.showMessageDialog(this, "You must confirm your password.");
            return false;
        }
        return true;
    }
    
    /*Function_6: Existing email address check.*/
    public boolean duplicateEmailAddress(){
        String adminEmail = edtEmail.getText();
        boolean existonDB = false;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback_management_system","root","");
            
            /*Statement to chech duplicate email*/
            PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE Email = ?");
            
            ps.setString(1,adminEmail);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                existonDB = true;
            }
            else{
                existonDB = false;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return existonDB;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        edtEmail = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        edtFirstName = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        edtLastName = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        edtPassword = new rojerusan.RSPasswordTextPlaceHolder();
        jLabel8 = new javax.swing.JLabel();
        edtConfirmPassword = new rojerusan.RSPasswordTextPlaceHolder();
        jLabel9 = new javax.swing.JLabel();
        btnSignUp = new rojerusan.RSButtonMetro();
        lblBackToLogin = new javax.swing.JLabel();
        lblAdminSignUp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 255, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Impact", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FEEDBACK MANAGEMENT SYSTEM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_Images/feedback_system_signup_admin.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SIGNUP | ADMINISTRATORS");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Email Address");

        edtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        edtEmail.setPlaceholder("eg. abc@gmail.com");
        edtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                edtEmailFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("First Name");

        edtFirstName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        edtFirstName.setPlaceholder("eg. abc");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Last Name");

        edtLastName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        edtLastName.setPlaceholder("eg. xyz");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Password");

        edtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        edtPassword.setPhColor(new java.awt.Color(0, 0, 0));
        edtPassword.setPlaceholder("Password(Alphanumeric)");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Confirm Password");

        edtConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        edtConfirmPassword.setPhColor(new java.awt.Color(0, 0, 0));
        edtConfirmPassword.setPlaceholder("Confirm Password");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("*By creating an account, you are agreed with our Terms & Conditions");

        btnSignUp.setBackground(new java.awt.Color(51, 255, 102));
        btnSignUp.setText("SIGNUP");
        btnSignUp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        lblBackToLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBackToLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBackToLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_Icons/back(16x16).png"))); // NOI18N
        lblBackToLogin.setText("BACK TO LOGIN");
        lblBackToLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBackToLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackToLoginMouseClicked(evt);
            }
        });

        lblAdminSignUp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAdminSignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdminSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_Icons/admin_signup(16x16).png"))); // NOI18N
        lblAdminSignUp.setText("STUDENT SIGNUP");
        lblAdminSignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAdminSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdminSignUpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(edtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lblBackToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblAdminSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBackToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdminSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        setSize(new java.awt.Dimension(1294, 727));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:
        /*Checking Validation Conditions*/
        if(signupValidation()==true){
        /*Calling Function_4: Result after clicking on Signup button*/
        /**/
        adminSignupForm();
        }
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void edtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtEmailFocusLost
        // TODO add your handling code here:
        /*Calling function 3: Action - Focus Lost*/
        if(duplicateEmailAddress() == true){
            JOptionPane.showMessageDialog(this,"This Email Address is already exists. Please try with different email.");
        }
    }//GEN-LAST:event_edtEmailFocusLost

    private void lblBackToLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackToLoginMouseClicked
        // TODO add your handling code here:
        Login_Admin loginAdmin = new Login_Admin();
        loginAdmin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBackToLoginMouseClicked

    private void lblAdminSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminSignUpMouseClicked
        // TODO add your handling code here:
        Signup signupStudent = new Signup();
        signupStudent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblAdminSignUpMouseClicked

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
            java.util.logging.Logger.getLogger(Signup_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro btnSignUp;
    private rojerusan.RSPasswordTextPlaceHolder edtConfirmPassword;
    private app.bolivia.swing.JCTextField edtEmail;
    private app.bolivia.swing.JCTextField edtFirstName;
    private app.bolivia.swing.JCTextField edtLastName;
    private rojerusan.RSPasswordTextPlaceHolder edtPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblAdminSignUp;
    private javax.swing.JLabel lblBackToLogin;
    // End of variables declaration//GEN-END:variables
}
