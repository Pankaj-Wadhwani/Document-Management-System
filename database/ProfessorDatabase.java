package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amin11
 */
public class ProfessorDatabase {
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement preparedStatement=null;
    int numRows;
    public ProfessorDatabase(){
        numRows=0;
        conn = MySqlConnect.connectDB("documentmanagement");
    }
    
    public boolean insert(String professorName,List subList,String course,int sem){
        try {
            String sql;
            sql="SELECT * FROM professor where professorname = '" + professorName +"'";
            preparedStatement = conn.prepareStatement(sql);
            rs =  preparedStatement.executeQuery();
            if(rs.next()){
                //JOptionPane.showConfirmDialog(null, "Professor Already exists,CONTINUE???", "ProfessorDatabase", JOptionPane.INFORMATION_MESSAGE);
               int val=JOptionPane.showConfirmDialog(null, "Professor Already exists,CONTINUE???", "ProfessorDatabase", JOptionPane.YES_NO_OPTION);
               if(val==JOptionPane.YES_OPTION)
                    return(teaches(professorName,subList,course,sem));
               
               return false;
                
            }
            else{
                sql="INSERT INTO professor(professorname) VALUES (?)";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,professorName);

                boolean value=false; 
                if(!(preparedStatement.execute())){
                   numRows++;
                   value=teaches(professorName,subList,course,sem);
                    System.out.println(value);

                }
                return(value);
            }   
            /*if(preparedStatement.execute()){
                
                JOptionPane.showConfirmDialog(null, "Inserted");
            
            }*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Exception:"+e.getMessage(),"CourseDatabase",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
    private boolean teaches(String profName,List subList,String course,int sem){
        try {
            System.out.println("TEaches called");
            String sql;
            sql="SELECT * FROM `professor` WHERE `professorname`='"+profName+"'";
            preparedStatement = conn.prepareStatement(sql);
            rs =  preparedStatement.executeQuery();
            boolean val=false;
            //System.out.println(rs.next());
            if(rs.next()){
                
                int pid=rs.getInt("pid");
                System.out.println("pid" + pid);
                for(int i=0;i<subList.size();i++){
                        System.out.println("item = " + subList.get(i));
                      // sql="SELECT * FROM subject WHERE 'name'='"+subList.get(i)+"' AND 'coursename'='"+course + "' AND 'semester'='" + sem+"'";
                       sql="SELECT * FROM `subject` WHERE `name`='"+subList.get(i)+"' AND `coursename`='" + course + "' AND `semester`='"+ sem +"'";
                       
                       preparedStatement = conn.prepareStatement(sql);
                       rs =  preparedStatement.executeQuery();
                       if(rs.next())
                           System.out.println("rs has something");
                       String subId=rs.getString("subjectid");
                        System.out.println(subId);
                        sql="INSERT INTO teaches(`professorid`, `subjectid`) VALUES (" + pid+",'"+ subId+"')"; 
                        preparedStatement=conn.prepareStatement(sql);
                        
                        if(!(preparedStatement.execute())){
                            val=true;
                            System.out.println("RECORD Inserted");
                         }
                         
                }
                
            }
            return val;

        } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "Exception:"+e.getMessage(),"ProfessorDatabase",JOptionPane.ERROR_MESSAGE);
               return false;
        }
        

        
    }
    public Vector<String> getProfessors(int pid[]){
        
        Vector<String> v=null;
        try{
            String sql;
            
            int num=pid.length;
            v=new Vector();
            for(int i=0;i<num;i++){
               // sql= "SELECT * FROM professor WHERE 'pid'=" + pid[i];
                sql="SELECT * FROM `professor` WHERE `pid`="+pid[i];
                preparedStatement = conn.prepareStatement(sql); 
                rs=preparedStatement.executeQuery();
                if(rs.next()){
                    v.add(rs.getString("professorname"));
                }
            }
           
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Exception" + e, "ProfessorDatabase", JOptionPane.ERROR_MESSAGE);
        }
         return v;
    }
    public int[] getPIDsfromTeaches(String subId[]){
         int pid[]=null;
        try{
            String sql;
            
            int num=subId.length;
            pid=new int[num];
            
            for(int i=0;i<num;i++){
               // sql= "SELECT * FROM professor WHERE 'pid'=" + pid[i];
               
                sql="SELECT * FROM `teaches` WHERE `subjectid`='"+subId[i]+"'";
               
                preparedStatement = conn.prepareStatement(sql); 
                rs=preparedStatement.executeQuery();
                if(rs.next()){
                    pid[i]=rs.getInt("professorid");
                }
            }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Exception" + e, "ProfessorDatabase", JOptionPane.ERROR_MESSAGE);
        }
         return pid;
    }
    
    
    
    public int getProfId(String profName){
        try{
            String sql="SELECT * FROM `professor` WHERE `professorname`='"+profName+"'";
            preparedStatement = conn.prepareStatement(sql); 
            rs=preparedStatement.executeQuery();
            if(rs.next())
                return(rs.getInt("pid"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Exception" + e, "ProfessorDatabase", JOptionPane.ERROR_MESSAGE);
        }
        return(-1);
    }
    
    
    
    public Vector<String> getSubjectIds(String profName){
        int profId=this.getProfId(profName);
        System.out.println("profid="+profId);
        Vector<String> subjects=new Vector(); 
        try{   
           
            String sql="SELECT * FROM `teaches` WHERE `professorid`="+profId;
            preparedStatement = conn.prepareStatement(sql); 
            rs=preparedStatement.executeQuery();
            int i=0;
            while(rs.next()){
                
                subjects.add(rs.getString("subjectid"));
                
                i++;
            }
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Exception" + e, "ProfessorDatabase", JOptionPane.ERROR_MESSAGE);
        }
       return subjects;
    }
      
}


