
import java.awt.CardLayout;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rp wadhwani
 */
public class ShowHome {
    static CardLayout cl;
    public static void showHome(JPanel jp,String pnlName){
        cl=(CardLayout)jp.getLayout();
        cl.show(jp, pnlName);
        
    }
}
