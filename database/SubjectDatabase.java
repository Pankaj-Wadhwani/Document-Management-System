package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author S Wadhwani
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
public class SubjectDatabase {
    
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement preparedStatement=null;
    int numRows;
    public SubjectDatabase(){
        numRows=0;
        conn = MySqlConnect.connectDB("documentmanagement");
    }
    
    public boolean insert(String pk,String subName,String CName,int semester){
        try {
            String sql;
            sql = "SELECT * FROM subject WHERE coursename='"+CName+"' AND name='"+subName+"'";
           preparedStatement = conn.prepareStatement(sql); 
           rs=preparedStatement.executeQuery();
           if(!(rs.next())){
                sql="INSERT INTO subject(subjectid,name,coursename,semester) VALUES (?,?,?,?)";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,pk);
                preparedStatement.setString(2,subName);
                preparedStatement.setString(3,CName);
                preparedStatement.setInt(4, semester);
               boolean value; 
                if(!(value=preparedStatement.execute())){
                    numRows++;

                }
                 return(!value);
           }
           else
               JOptionPane.showMessageDialog(null, "Subject is already added in this course","SubjectDatabase",JOptionPane.ERROR_MESSAGE);
            return false;
            /*if(preparedStatement.execute()){
                
                JOptionPane.showConfirmDialog(null, "Inserted");
            
            }*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Exception:"+e.getMessage(),"SubjectDatabase",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
    public String[] getSubjects(String cname,int sem){
        try {
             int insertValue=0 ;
           String sql = "SELECT COUNT(*) FROM subject";
           preparedStatement = conn.prepareStatement(sql); 
           rs=preparedStatement.executeQuery();
           String[] subjects;
           int num=0;
           if(rs.next()){
                num=rs.getInt(1);
                
           }
           subjects = new String[num];
          // System.out.println( "num rows=" + num);
           sql = "SELECT * FROM subject WHERE coursename='"+cname+"' AND semester="+sem;
           preparedStatement = conn.prepareStatement(sql); 
            
            
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                
                subjects[insertValue] = rs.getString("name");
                insertValue++;
            }
            
            return subjects;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Exception" + e, "SubjectDatabase", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String[] getSubjectIDs(String course,int sem) {
        try {
             int insertValue=0 ;
             String sql;
             
          sql = "SELECT COUNT(*) FROM subject WHERE coursename='"+course+"' AND semester="+sem;
           preparedStatement = conn.prepareStatement(sql); 
           rs=preparedStatement.executeQuery();
           String[] subjects;
           int num=0;
           if(rs.next()){
                num=rs.getInt(1);
              
           }
           subjects = new String[num];
          // System.out.println( "num rows=" + num);
           sql = "SELECT * FROM subject where coursename='"+course+"' AND semester="+sem;
           preparedStatement = conn.prepareStatement(sql); 
            
            
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                
                subjects[insertValue] = rs.getString("subjectid");
                insertValue++;
            }
            
            return subjects;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Exception" + e, "SubjectDatabase", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public Vector<String> getSubjects(String course,int sem,Vector<String> subjects) {
        Vector<String> returningSubs=new Vector();
        try {
            int i=0;
            while(i<subjects.size()){
                 
                 String sql = "SELECT * FROM `subject` WHERE `subjectid`='"+ subjects.get(i) +"' AND `coursename`='"+ course + "' AND `semester`=" + sem;
                 preparedStatement = conn.prepareStatement(sql); 
                 rs=preparedStatement.executeQuery();
                 if(rs.next())
                     returningSubs.add(rs.getString("name"));
                i++;
            }
            return returningSubs;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Exception" + e, "SubjectDatabase", JOptionPane.ERROR_MESSAGE);
            
        }
        return null;
        
        
    }
    public String getSubjectID(String sName) {
         String temp=null;
        try {
             int insertValue=0 ;
             String sql;
          
           sql = "SELECT * FROM subject where name='" + sName + "'";
           preparedStatement = conn.prepareStatement(sql); 
            
            
            rs=preparedStatement.executeQuery();
           
            if(rs.next()){
                
               temp = rs.getString("subjectid");
               
            }
            
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Exception" + e, "SubjectDatabase", JOptionPane.ERROR_MESSAGE);
          
        }
         return temp;
    }
   
}