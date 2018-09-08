
import static com.sun.glass.events.KeyEvent.VK_BACKSPACE;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author S Wadhwani
 */

public class AlphaJTextfield {

    public AlphaJTextfield(JTextField obj,JLabel lbl) {
        obj.addKeyListener(new KeyAdapter(){
            boolean backspace=false;
            boolean isSpace=false;
            @Override
            public void keyPressed(KeyEvent ke){
               
                if(ke.getKeyCode() == VK_BACKSPACE){
                     backspace=true;
                }
            }
            @Override
            public void keyReleased(KeyEvent ke){
                regex();
                /*String str=ke.getKeyChar()+"";
                String regex="^[A-Za-z]";
                if(!backspace){
                    
                    if(Character.isSpaceChar(ke.getKeyChar()) && !isSpace)
                        isSpace=true;
                    else if(Character.isSpaceChar(ke.getKeyChar())){
                        JOptionPane.showMessageDialog(null, "Cannot insert other than alphabets");
                        ke.consume();
                    }
                    else if(!(Pattern.matches(regex,str))){
                        JOptionPane.showMessageDialog(null, "Cannot insert other than alphabets");
                        ke.consume();
                    }
                
                }*/
                
            }
            private void regex(){
                String regex="^[a-zA-Z]+\\s{0,1}[a-zA-Z]*";
                String txt=obj.getText();
                
                        
                if((Pattern.matches(regex,txt)))
                    lbl.setText("y");
                else
                    lbl.setText("n");
            }
        });
    }
}
