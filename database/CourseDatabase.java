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
public class CourseDatabase {
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement preparedStatement=null;
    int numRows;
    public CourseDatabase(){
        numRows=0;
        conn = MySqlConnect.connectDB("documentmanagement");
    }
    
    public boolean insert(String CName,String acronym){
        try {
            String sql="INSERT INTO course VALUES (?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,CName);
            preparedStatement.setString(2,acronym);
           boolean value; 
            if(!(value=preparedStatement.execute())){
                numRows++;
               
            }
             return(!value);
            /*if(preparedStatement.execute()){
                
                JOptionPane.showConfirmDialog(null, "Inserted");
            
            }*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Exception:"+e.getMessage(),"CourseDatabase",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
    public String[] getAllCourses(){
        String courses[]=null; 
        
        int i=0;
        try {
            
            String sql;
            sql="SELECT COUNT(*) FROM course";
            preparedStatement=conn.prepareStatement(sql);
            rs =  preparedStatement.executeQuery();
            if(rs.next())
                courses=new String[rs.getInt(1)];
            
            sql="SELECT * FROM course";
            preparedStatement=conn.prepareStatement(sql);
            rs =  preparedStatement.executeQuery();
            while(rs.next()){
                courses[i]=rs.getString("coursename");
                i++;
            }
            return courses;
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Exception:"+e.getMessage()+" getAllCourses","CourseDatabase",JOptionPane.ERROR_MESSAGE);
             return null;
        }
        
    }
    //public void insert(String proName,)
    
}
