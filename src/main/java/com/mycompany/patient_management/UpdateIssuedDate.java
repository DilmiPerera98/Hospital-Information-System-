/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.patient_management;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Tharindu Kumesh
 */
public class UpdateIssuedDate extends javax.swing.JFrame {

    /**
     * Creates new form UpdateIssuedDate
     * 
     * 
     */
    
    DBConnection db=new DBConnection();
    ArrayList<String> list=new ArrayList<>();
    
    
    
    public UpdateIssuedDate() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updateIdText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        updateIssuedDateBtn = new javax.swing.JButton();
        updateIssuedDateBackBtn = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        patientName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(updateIdText, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 30, 191, -1));

        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 33, -1, -1));

        jLabel2.setText("Issued Date");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 337, -1, -1));

        updateIssuedDateBtn.setText("Update");
        updateIssuedDateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateIssuedDateBtnActionPerformed(evt);
            }
        });
        getContentPane().add(updateIssuedDateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 398, -1, -1));

        updateIssuedDateBackBtn.setText("Back");
        updateIssuedDateBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateIssuedDateBackBtnActionPerformed(evt);
            }
        });
        getContentPane().add(updateIssuedDateBackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 398, -1, -1));
        getContentPane().add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 337, 191, -1));

        jLabel3.setText("Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 76, -1, -1));

        patientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientNameActionPerformed(evt);
            }
        });
        getContentPane().add(patientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 76, 191, -1));

        jButton1.setText("Check");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 109, -1, 45));

        jPanel1.setBackground(new java.awt.Color(152, 215, 215));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -4, 620, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateIssuedDateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateIssuedDateBtnActionPerformed
       
        try{
        
            if(db.checkPatientId(updateIdText.getText())){
        try{
        db.updateIssuedDate(updateIdText.getText(),((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
        
         JOptionPane.showMessageDialog(this, "Succusfully Updated Issued Date !!! ");
        
        }catch(Exception e){
        
            System.out.println("Exception in UpdateIssuedDate Method");
        
        }
            
            }else{
            
                JOptionPane.showMessageDialog(this,"Patient ID Not found !!! ");
            
            }
        
        }catch(Exception e){
        
         System.out.println("Exception in finding Patient ID ");
        
        }
        
        updateIdText.setText("");
        dateChooser.cleanup();
        
    }//GEN-LAST:event_updateIssuedDateBtnActionPerformed

    private void updateIssuedDateBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateIssuedDateBackBtnActionPerformed
        new UpdateMainWindow().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_updateIssuedDateBackBtnActionPerformed

    private void patientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
         try{
        if(db.checkPatientId(updateIdText.getText())){
        
            
            try{
            
                list=db.searchPatient(updateIdText.getText());
                
                patientName.setText(list.get(0)+" "+list.get(1)+" "+list.get(2));
            
            }catch(Exception e){
            
             JOptionPane.showMessageDialog(this,"Problem in Updating !!! ");
                
                
            }
            
        
        }else{
        
        JOptionPane.showMessageDialog(this,"Patient not Found !!! ");
        
        }
        
        }catch(Exception e){
        
         System.out.println("Exception in cheking patient id");
        
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateIssuedDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateIssuedDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateIssuedDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateIssuedDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateIssuedDate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField patientName;
    private javax.swing.JTextField updateIdText;
    private javax.swing.JButton updateIssuedDateBackBtn;
    private javax.swing.JButton updateIssuedDateBtn;
    // End of variables declaration//GEN-END:variables
}