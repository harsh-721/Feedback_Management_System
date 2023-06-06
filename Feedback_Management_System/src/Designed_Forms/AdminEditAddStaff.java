/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Designed_Forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.sql.PreparedStatement;

/**
 *
 * @author Vyata
 */
public class AdminEditAddStaff extends javax.swing.JFrame {

    /**
     * Creates new form AdminAddStudent
     */
    int studentID;
    String studentEmail, studentFirstName, studentLastName, studentPassword;
    DefaultTableModel model;
    public AdminEditAddStaff() {
       super("Add,Edit & Update Staff - Administrator | FEEDBACK MANAGEMENT SYSTEM");
        initComponents();
        fetchStudentDetails();
    }
    
    public void fetchStudentDetails(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback_management_system","root","");
            
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM staff ");
            
            while(rs.next()){
                int studentID = rs.getInt("ID");
                String studentEmail = rs.getString("Email");
                String studentFirstName = rs.getString("FirstName");
                String studentLastName = rs.getString("LastName");
                String studentPassword = rs.getString("Password");
                
                Object[] obj = {studentID, studentEmail, studentFirstName, studentLastName, studentPassword};
                model =(DefaultTableModel) tblStudentList.getModel();
                model.addRow(obj);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public boolean addStudent(){
        boolean studentAdded = false;
        //studentID = Integer.parseInt(edtStudentID.getText());
        studentEmail = edtEmail.getText();
        studentFirstName = edtFirstName.getText();
        studentLastName = edtLastName.getText();
        studentPassword = edtPassword.getText();
        
        try{
            Connection con = FMSDatabaseConnection.getConnection();
            String sql = "INSERT INTO staff(Email, FirstName, LastName, Password) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setInt(1, studentID);
            ps.setString(1,studentEmail);
            ps.setString(2,studentFirstName);
            ps.setString(3,studentLastName);
            ps.setString(4,studentPassword);
            
            int rowCount = ps.executeUpdate();
            
            if(rowCount>0){
                studentAdded = true;
                //JOptionPane.showMessageDialog(this, "Student Added Successfully.");
            }
            else{
                studentAdded = false;
                //JOptionPane.showMessageDialog(this,"Student couldn't be added.");
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return studentAdded;
    }
    
    public boolean updateStudent(){
        boolean studentUpdated = false;
        studentID = Integer.parseInt(edtStudentID.getText());
        studentEmail = edtEmail.getText();
        studentFirstName = edtFirstName.getText();
        studentLastName = edtLastName.getText();
        studentPassword = edtPassword.getText();
        
        try{
            Connection con = FMSDatabaseConnection.getConnection();
            String sql = "UPDATE staff SET Email= ?,FirstName= ?, LastName= ?, Password= ? WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1,studentEmail);
            ps.setString(2,studentFirstName);
            ps.setString(3,studentLastName);
            ps.setString(4,studentPassword);
            ps.setInt(5, studentID);
            
            int rowCount = ps.executeUpdate();
            
            if(rowCount>0){
                studentUpdated = true;
                //JOptionPane.showMessageDialog(this, "Student Added Successfully.");
            }
            else{
                studentUpdated = false;
                //JOptionPane.showMessageDialog(this,"Student couldn't be added.");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return studentUpdated;
    }
    
    public boolean deleteStudent(){
        boolean studentDeleted = false;
        studentID = Integer.parseInt(edtStudentID.getText());
        
        try{
            Connection con = FMSDatabaseConnection.getConnection();
            String sql = "DELETE FROM staff WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentID);
            
            int rowCount = ps.executeUpdate();
            
            if(rowCount>0){
                studentDeleted = true;
                //JOptionPane.showMessageDialog(this, "Student Added Successfully.");
            }
            else{
                studentDeleted = false;
                //JOptionPane.showMessageDialog(this,"Student couldn't be added.");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return studentDeleted;
    }
    
    public void tableBugFix(){
        DefaultTableModel model = (DefaultTableModel) tblStudentList.getModel();
        model.setRowCount(0);
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
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtFirstName = new app.bolivia.swing.JCTextField();
        edtLastName = new app.bolivia.swing.JCTextField();
        edtPassword = new rojerusan.RSPasswordTextPlaceHolder();
        edtStudentID = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        rSButtonMetro1 = new rojerusan.RSButtonMetro();
        btnAddStudent = new rojerusan.RSButtonMetro();
        btnUpdateStudent = new rojerusan.RSButtonMetro();
        btnDeleteStudent = new rojerusan.RSButtonMetro();
        btnBack = new rojerusan.RSButtonMetro();
        edtEmail = new app.bolivia.swing.JCTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudentList = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(0, 255, 153));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Impact", 0, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADMIN STAFF OPEARTION | FEEDBACK MANAGEMENT SYSTEM");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 255, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Staff");

        edtFirstName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        edtFirstName.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        edtFirstName.setPlaceholder("Staff First Name ");

        edtLastName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        edtLastName.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        edtLastName.setPlaceholder("Staff Last Name ");

        edtPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        edtPassword.setForeground(new java.awt.Color(0, 0, 0));
        edtPassword.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        edtPassword.setPhColor(new java.awt.Color(255, 51, 51));
        edtPassword.setPlaceholder("Password");

        edtStudentID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        edtStudentID.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        edtStudentID.setPlaceholder("Staff ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("ID");

        rSButtonMetro1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMetro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_Icons/search(32x32).png"))); // NOI18N
        rSButtonMetro1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        btnAddStudent.setBackground(new java.awt.Color(255, 255, 255));
        btnAddStudent.setForeground(new java.awt.Color(0, 0, 0));
        btnAddStudent.setText("ADD");
        btnAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentActionPerformed(evt);
            }
        });

        btnUpdateStudent.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdateStudent.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdateStudent.setText("UPDATE");
        btnUpdateStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStudentActionPerformed(evt);
            }
        });

        btnDeleteStudent.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteStudent.setForeground(new java.awt.Color(0, 0, 0));
        btnDeleteStudent.setText("DELETE");
        btnDeleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStudentActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        edtEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        edtEmail.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        edtEmail.setPlaceholder("Staff Email Address");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(edtStudentID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rSButtonMetro1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdateStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSButtonMetro1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(edtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(edtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(edtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Staff List");

        tblStudentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "EMAIL", "FIRSTNAME", "LAST NAME", "PASSWORD"
            }
        ));
        tblStudentList.setAltoHead(30);
        tblStudentList.setColorBackgoundHead(new java.awt.Color(0, 255, 153));
        tblStudentList.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblStudentList.setFuenteFilas(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblStudentList.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblStudentList.setFuenteHead(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblStudentList.setRowHeight(30);
        tblStudentList.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblStudentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudentList);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane1)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        setSize(new java.awt.Dimension(1294, 727));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblStudentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentListMouseClicked
        // TODO add your handling code here:
        int rowNo = tblStudentList.getSelectedRow();
        TableModel model = tblStudentList.getModel();
        
        edtStudentID.setText(model.getValueAt(rowNo, 0).toString());
        edtEmail.setText(model.getValueAt(rowNo, 1).toString());
        edtFirstName.setText(model.getValueAt(rowNo, 2).toString());
        edtLastName.setText(model.getValueAt(rowNo, 3).toString());
        edtPassword.setText(model.getValueAt(rowNo, 4).toString());
        
    }//GEN-LAST:event_tblStudentListMouseClicked

    private void btnAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudentActionPerformed
        // TODO add your handling code here:
        if(addStudent()==true){
            JOptionPane.showMessageDialog(this, "Student Added Successfully.");
            tableBugFix();
            fetchStudentDetails();
        }
        else{
            JOptionPane.showMessageDialog(this,"Student couldn't be added.");
        }
    }//GEN-LAST:event_btnAddStudentActionPerformed

    private void btnUpdateStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStudentActionPerformed
        // TODO add your handling code here:
        if(updateStudent()==true){
            JOptionPane.showMessageDialog(this, "Student Updated Successfully.");
            tableBugFix();
            fetchStudentDetails();
        }
        else{
            JOptionPane.showMessageDialog(this,"Student couldn't be Updated.");
        }
    }//GEN-LAST:event_btnUpdateStudentActionPerformed

    private void btnDeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStudentActionPerformed
        // TODO add your handling code here:
        if(deleteStudent()==true){
            JOptionPane.showMessageDialog(this, "Student Deleted Successfully.");
            tableBugFix();
            fetchStudentDetails();
        }
        else{
            JOptionPane.showMessageDialog(this,"Student couldn't be Deleted.");
        }
    }//GEN-LAST:event_btnDeleteStudentActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(AdminEditAddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminEditAddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminEditAddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminEditAddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminEditAddStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro btnAddStudent;
    private rojerusan.RSButtonMetro btnBack;
    private rojerusan.RSButtonMetro btnDeleteStudent;
    private rojerusan.RSButtonMetro btnUpdateStudent;
    private app.bolivia.swing.JCTextField edtEmail;
    private app.bolivia.swing.JCTextField edtFirstName;
    private app.bolivia.swing.JCTextField edtLastName;
    private rojerusan.RSPasswordTextPlaceHolder edtPassword;
    private app.bolivia.swing.JCTextField edtStudentID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSButtonMetro rSButtonMetro1;
    private rojeru_san.complementos.RSTableMetro tblStudentList;
    // End of variables declaration//GEN-END:variables
}
