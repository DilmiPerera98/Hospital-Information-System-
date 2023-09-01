/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.patient_management;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tharindu Kumesh
 */
public class DBConnection {
    
    
    
    
    public Connection getDbconnection()throws Exception{
    
    
        String DBURL="jdbc:mysql://localhost:3306/patient_management";
        String USERNAME="root";
        String PW="";
        
        Connection conn=DriverManager.getConnection(DBURL, USERNAME, PW);
        
        return conn;
        
    
    }
    
    // add a new patient for the system
      public  void insertPatient(String id,String fname,String midname, String lname,String dob,String address,String issued_date,String disease,String allergies,String hos_id,String contact, String drug_details,String doctorId)throws Exception{
        
        Connection c=getDbconnection();
        Statement st=c.createStatement();
        
     String sql=" INSERT INTO patient(id,fname,midname,lname,dob,disease,address,issued_date,allergies,hos_id,contact,drug_details,doctor_id) VALUES('"+id+"','"+fname+"','"+midname+"','"+lname+"','"+dob+"','"+address+"','"+issued_date+"'"
             + ",'"+disease+"','"+allergies+"','"+hos_id+"','"+contact+"','"+drug_details+"','"+doctorId+"')";
        
        st.executeUpdate(sql);
     
        c.close();
          
    }
      
      
      //insert into hospital
      public void insertHospital(String id,String name)throws Exception{
      
          
           Connection c=getDbconnection();
        Statement st=c.createStatement();
        
        String sql="INSERT INTO hospital (hos_id,hos_name) VALUES('"+id+"','"+name+"')";
        
        st.executeUpdate(sql);
        
        c.close();
      
      }
      
      
     
     
      
       //insert into drug
        public  void insertDrug(String id,String name)throws Exception{
        
        Connection c=getDbconnection();
        Statement st=c.createStatement();
        
        String sql="INSERT INTO drug(drug_code,drug_name) VALUES('"+id+"','"+name+"')";
        
        st.executeUpdate(sql);
        
        c.close();
        
    }
        
        
        
        //insert user
        public  void insertUser(String pw,String username, String userid, String hosid,String phname)throws Exception{
        
        Connection c=getDbconnection();
        Statement st=c.createStatement();
        
        String sql="INSERT INTO pharmacist(hos_id,user_id,ph_name,username,password) VALUES('"+hosid+"','"+userid+"','"+phname+"','"+username+"','"+pw+"')";
        
        st.executeUpdate(sql);
        
        c.close();
        
      
    }
    
        
        
        //insert Doctor
        public void insertDoctor(String id, String name, String hos_id)throws Exception{
         Connection c=getDbconnection();
        Statement st=c.createStatement();
            
        String sql="INSERT INTO doctor(hos_id,doctor_id,doctor_name) VALUES('"+hos_id+"', '"+id+"', '"+name+"')";
        
        st.executeUpdate(sql);
        
        c.close();
        
        
        }
        
     
        
        // search a patient
        
        public ArrayList<String> searchPatient(String id)throws Exception{
            
            ArrayList<String> list=new ArrayList<>();
            
            Connection c=getDbconnection();
        Statement st=c.createStatement();
        
        String sql="SELECT fname,midname,lname,dob,disease,address,issued_date,allergies,hos_id,contact,drug_details,doctor_id FROM patient WHERE id='"+id+"' ";
          
        ResultSet rs=st.executeQuery(sql);
        
        while(rs.next()){
        
          list.add(rs.getString("fname")); // 0
          list.add(rs.getString("midname")); //1
          list.add(rs.getString("lname")); // 2
          list.add(rs.getString("dob")); // 3
          list.add(rs.getString("disease")); // 4
          list.add(rs.getString("address")); // 5
          list.add(rs.getString("issued_date")); //6
          list.add(rs.getString("allergies")); //7
          list.add(rs.getString("hos_id")); //8
          list.add(rs.getString("contact")); //9
          list.add(rs.getString("drug_details")); //10
           list.add(rs.getString("doctor_id")); //11
        }
        
        c.close();
        return list;
            
        }
        
        
        
        
          // Get the name of the Hospital
        
        public ArrayList<String> getDrugCode()throws Exception{
        Connection c=getDbconnection();
        Statement st=c.createStatement();
        ArrayList<String> hospital=new ArrayList<>();
        
        String sql="SELECT drug_code FROM drug";
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            hospital.add(rs.getString("drug_code"));
            
        }
        c.close();
        return hospital;
        }
        
        
        
        // search a Doctor
        
        public String getDoctor(String d)throws Exception{
         Connection c=getDbconnection();
        Statement st=c.createStatement();
        String doctor="";
        
        String sql="SELECT doctor_name FROM doctor WHERE doctor_id='"+d+"'";
        
        ResultSet rs=st.executeQuery(sql);
        
        
        while(rs.next()){
        
           doctor=rs.getString("doctor_name");
        
        }
        
        c.close();
        return doctor;
        
        }
        
        
        
        
        
        // get doctor id
        
         public ArrayList<String> getDoctorid()throws Exception{
         Connection c=getDbconnection();
        Statement st=c.createStatement();
       
        ArrayList<String> doctor=new ArrayList<>();
        
        String sql="SELECT doctor_id FROM doctor ";
        
        ResultSet rs=st.executeQuery(sql);
        
        
        while(rs.next()){
        
           doctor.add(rs.getString("doctor_id"));
        
        }
        
        c.close();
        return doctor;
        
        }
        
        
         
         
         //get Hospital ID
         
         public ArrayList<String> getHospitalid()throws Exception{
         Connection c=getDbconnection();
        Statement st=c.createStatement();
       
        ArrayList<String> doctor=new ArrayList<>();
        
        String sql="SELECT hos_id FROM hospital ";
        
        ResultSet rs=st.executeQuery(sql);
        
        
        while(rs.next()){
        
           doctor.add(rs.getString("hos_id"));
        
        }
        
        c.close();
        return doctor;
        
        }
         
         
         
         //get Drug Name
         
        public String getDrug(String id)throws Exception{
         Connection c=getDbconnection();
        Statement st=c.createStatement();
       
        String drug=null;
        
        String sql="SELECT drug_name FROM drug WHERE drug_code='"+id+"' ";
        
        ResultSet rs=st.executeQuery(sql);
        
        
        while(rs.next()){
        
           drug=rs.getString("drug_name");
        
        }
        
        c.close();
        return drug;
        
        }
        
        
        
        // Get the name of the Hospital
        
        public String getHospital(String id)throws Exception{
        Connection c=getDbconnection();
        Statement st=c.createStatement();
        String hospital="";
        
        String sql="SELECT hos_name FROM hospital WHERE hos_id='"+id+"'";
        
        ResultSet rs=st.executeQuery(sql);
        
        while(rs.next()){
        
            hospital=rs.getString("hos_name");
            
        }
        
        c.close();
        return hospital;
        
        }
        
        
        
        
        // update the date of drug issued for the patient
        
        public void updateIssuedDate(String id,String date)throws Exception{
        
             Connection c=getDbconnection();
        Statement st=c.createStatement();
        
        String sql="UPDATE patient SET issued_date='"+date+"' WHERE id='"+id+"'" ;
        
        st.executeUpdate(sql);
        
        c.close();
            
        
        }
        
        
        
        // update an adderss
        
        public void updateAddress(String id,String address)throws Exception{
        
            Connection c=getDbconnection();
            Statement st=c.createStatement();
            
            String sql="UPDATE patient SET address='"+address+"' WHERE id='"+id+"'";
        
            st.executeUpdate(sql);
            c.close();
            
        }
        
        
        
        // update patient contat number
        
        public void updateContact(String id, String contact)throws Exception{
        
             Connection c=getDbconnection();
            Statement st=c.createStatement();
            String sql="UPDATE patient SET contact='"+contact+"' WHERE id='"+id+"'";
            st.executeUpdate(sql);
            c.close();
        
        }
        
        
        
        
        
       
        // delete a patient from the system
    
    public void deletePatient(String id)throws Exception {
        
        Connection c=getDbconnection();
        
        Statement st=c.createStatement();
        
        String sql="DELETE FROM patient WHERE id='"+id+"'";
        
        st.executeUpdate(sql);
        
        c.close();
       
        
    }
    
    
    
    // delete a drug from the system
    
    public void deleteDrug(String id)throws Exception {
    
        Connection c=getDbconnection();
        
        Statement st=c.createStatement();
        
        String sql="DELETE FROM drug WHERE drug_code='"+id+"'";
        
        st.executeUpdate(sql);
        
        c.close();
        
        
        
    }
    
    
    
    // delete a hospital from the system
    
    public void deleteHospital(String id)throws Exception {
        Connection c=getDbconnection();
        Statement st=c.createStatement();
        String sql="DELETE FROM hospital WHERE hos_id='"+id+"'";
        st.executeUpdate(sql);
        c.close();
    }
    
    
    
    
    
    // delete an user
    public void deleteUser(String username, String pw)throws Exception{
    
         Connection c=getDbconnection();
        Statement st=c.createStatement();
        String sql="DELETE FROM user WHERE username='"+username+"' AND password='"+pw+"'";
        st.executeUpdate(sql);
        
        c.close();
    
    }
    
    
    
    //delete Doctor
    
    public void deleteDoctor(String id)throws Exception{
    
        Connection c=getDbconnection();
        Statement st=c.createStatement();
        String sql="DELETE FROM doctor WHERE doctor_id='"+id+"'";
    
        st.executeUpdate(sql);
        c.close();
    }
    
    
    
    
    
    public boolean login(String username,String password)throws Exception{
    
         Connection c=getDbconnection();
        
         Statement st=c.createStatement();
        boolean choice = false;

        String sql = "SELECT * FROM pharmacist WHERE username = ? AND password = ?";

            try{

            PreparedStatement ps = c.prepareStatement(sql);
        
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

		choice = true;	

            }else{

		choice = false;

            }

               }catch (SQLException ex){

            Logger.getLogger(WelcomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            //Replace YourClass with Actual Classname
        
               }
    
            return choice;

}

  
    // cheking the existence of athe drug code
  public boolean checkDrugcode(String id)throws Exception{
  
      Connection c=getDbconnection();
        
         Statement st=c.createStatement();
        boolean choice = false;
        
        String sql="SELECT * FROM drug WHERE drug_code='"+id+"'";
        
        ResultSet rs=st.executeQuery(sql);
        
        if(rs.next()){
            
            choice=true;
        
        }else{
        
         choice=false;
        }
        
        c.close();
        return choice;
      
  }  
    
    
  
  
   // cheking the existence of the Hospital ID
  
  public boolean checkHospitalId(String id)throws Exception{
  
      Connection c=getDbconnection();
        
         Statement st=c.createStatement();
        boolean choice = false;
        
        String sql="SELECT * FROM hospital WHERE hos_id='"+id+"'";
        
        ResultSet rs=st.executeQuery(sql);
        
        if(rs.next()){
            
            choice=true;
        
        }else{
        
         choice=false;
        }
        
        c.close();
        return choice;
      
  } 
    
    
  
  
  
  // cheking the existence of the Hospital ID
  
  public boolean checkDoctorId(String id)throws Exception{
  
      Connection c=getDbconnection();
        
         Statement st=c.createStatement();
        boolean choice = false;
        
        String sql="SELECT * FROM doctor WHERE doctor_id='"+id+"'";
        
        ResultSet rs=st.executeQuery(sql);
        
        if(rs.next()){
            
            choice=true;
        
        }else{
        
         choice=false;
        }
        
        c.close();
        return choice;
      
  } 
    
    
    
  
  // cheking the existence of the patient ID
  
  public boolean checkPatientId(String id)throws Exception{
  
      Connection c=getDbconnection();
        
         Statement st=c.createStatement();
        boolean choice = false;
        
        String sql="SELECT * FROM patient WHERE id='"+id+"'";
        
        ResultSet rs=st.executeQuery(sql);
        
        if(rs.next()){
            
            choice=true;
        
        }else{
        
         choice=false;
        }
        
        c.close();
        return choice;
      
  } 
    
    
    
    
    
    
    
    
    
    
    
    

}