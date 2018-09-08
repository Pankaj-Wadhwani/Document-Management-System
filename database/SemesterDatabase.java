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
public class SemesterDatabase {
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement preparedStatement=null;
    int numRows;
    public SemesterDatabase(){
       // numRows=0;
        conn = MySqlConnect.connectDB("documentmanagement");
    }
    public boolean insertSem(){
        try {
            String sql="INSERT INTO semester VALUES (NULL)";
            preparedStatement=conn.prepareStatement(sql);
            boolean value=preparedStatement.execute();
           /* if(!value){
                numRows++;
            }*/
            return (!value);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Exception:"+e.getMessage(),"CourseDatabase",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public int[] getSems(){
        try {
             int insertValue=0 ;
           String sql = "SELECT COUNT(*) FROM semester";
           preparedStatement = conn.prepareStatement(sql); 
           rs=preparedStatement.executeQuery();
           int[] years;
           int num=0;
           if(rs.next()){
                num=rs.getInt(1);
                
           }
           years = new int[num];
           System.out.println( "num rows=" + num);
           sql = "SELECT * FROM semester";
           preparedStatement = conn.prepareStatement(sql); 
            
            
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                
                years[insertValue] = rs.getInt("sem");
                insertValue++;
            }
            
            return years;
        } catch (Exception e) {
            System.out.println("exception in getYears()" + e.getMessage() );
            return null;
        }
    }
   
}
