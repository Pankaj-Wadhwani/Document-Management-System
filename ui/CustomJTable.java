
import database.MySqlConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amin11
 */
public class CustomJTable {
    static void insertInJtable(JTable jtb,String table){
        try {
            Connection conn=MySqlConnect.connectDB("documentmanagement"); 
            String sql="SELECT * FROM "+table;
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            //if(rs.next())
            jtb.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Exception" + e.getMessage(), "JCustomJTable",JOptionPane.ERROR_MESSAGE);
        }
        
    }
     static void insertInJtable(JTable jtb,String table,int profId,String subId){
        try {
            Connection conn=MySqlConnect.connectDB("documentmanagement");
            System.out.println("pid = "+ profId);
            System.out.println("sid = " + subId);
            String sql="SELECT * FROM "+table+" WHERE profid=" + profId + " AND subid='" + subId + "'";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            //if(rs.next())
            jtb.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Exception" + e.getMessage(), "JCustomJTable",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
}
