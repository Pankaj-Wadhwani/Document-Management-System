package database;


import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rp wadhwani
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class DocumentDatabase {
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement preparedStatement=null;
    int numRows;
    public DocumentDatabase(){
       
        conn = MySqlConnect.connectDB("documentmanagement");
    }
    public boolean insert(int profid,String subid,String name,Date dos,String comment){ 
        try {
            String sql="INSERT INTO document(profid,subid,name,dos,comment) VALUES (?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,profid);
            preparedStatement.setString(2,subid);
            preparedStatement.setString(3, name);
            preparedStatement.setDate(4, dos);
            preparedStatement.setString(5, comment);
           
            
           boolean value; 
           // if(!(value=)){
               return(!preparedStatement.execute());
               
            //}
             
            /*if(preparedStatement.execute()){
                
                JOptionPane.showConfirmDialog(null, "Inserted");
            
            }*/
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Exception:"+e.getMessage(),"DocumentDatabase",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public boolean insertInReIssue(int profid,String subid,String name,Date doi,Date dor){ 
        try {
            String sql="INSERT INTO reissue(profid,subid,docname,doi,dor) VALUES (?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,profid);
            preparedStatement.setString(2,subid);
            preparedStatement.setString(3, name);
            preparedStatement.setDate(4, doi);
            preparedStatement.setDate(5, dor);
           
            
           //boolean value; 
           // if(!(value=)){
               return(!preparedStatement.execute());
               
            //}
             
            /*if(preparedStatement.execute()){
                
                JOptionPane.showConfirmDialog(null, "Inserted");
            
            }*/
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Exception 1:"+e.getMessage(),"DocumentDatabase",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public boolean isSubmitted(String docName,String subId,int pid){
        try {
            System.out.println("is submitted");
            String sql="SELECT * FROM document WHERE name='"+docName+"' and subid='" + subId + "' and profid="  + pid;
            preparedStatement = conn.prepareStatement(sql);
            rs=preparedStatement.executeQuery(sql);
            System.out.println("is submitted");
            if(rs.next()){
                 System.out.println("yes submitted");
                return true;
            }
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Exception submitted:"+e.getMessage(),"DocumentDatabase",JOptionPane.ERROR_MESSAGE);
            
        }
        return false;
    }
   public int numOfReIssue(int profId,String subId,String docName){
       try {
            String sql="SELECT count(*) FROM reissue WHERE docname='"+docName+"' and subid='" + subId + "' and profid="  + profId;
            preparedStatement = conn.prepareStatement(sql);
            rs=preparedStatement.executeQuery(sql);
           
            if(rs.next()){
                 System.out.println("num of re issue:"+ rs.getInt(1));
                  return rs.getInt(1);
            }
           
       } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Exception:"+e.getMessage(),"DocumentDatabase",JOptionPane.ERROR_MESSAGE);
       }
       return -1;
      
   }
    public int numOfSubmitted(int profId,String subId,String docName){
         try {
            String sql="SELECT count(*) FROM document WHERE name='"+docName+"' and subid='" + subId + "' and profid="  + profId;
            preparedStatement = conn.prepareStatement(sql);
            rs=preparedStatement.executeQuery(sql);
           
            if(rs.next()){
                 System.out.println("num of submitted:"+ rs.getInt(1));
                  return rs.getInt(1);
            }
           
       } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Exception:"+e.getMessage(),"DocumentDatabase",JOptionPane.ERROR_MESSAGE);
       }
       return -1;
    }
   
}
