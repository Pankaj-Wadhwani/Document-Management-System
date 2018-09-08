package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
public class MySqlConnect {
    public static Connection connectDB(String db){
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "documentmanagement","pankaj","pankaj");
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Connection Unsuccessfull : "+e.getMessage(), "MySqlConnect",JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Connection Unsuccessfull : "+e.getMessage(), "MySqlConnect",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
}
