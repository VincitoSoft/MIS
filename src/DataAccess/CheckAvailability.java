/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Malaka
 */
public class CheckAvailability {
    
    ConnectToDB conDB=ConnectToDB.getInstance();
    Statement st=conDB.accessDataBase();//Creating a ststement to execute quaries
    ResultSet rs;
    
    public boolean checkAvailabity(int Studentid){
     boolean validity=false;
     
     String qu1="select count(*) from Student where Std_Index="+Studentid;
        try {
            rs=st.executeQuery(qu1);
            rs.next();
            if(rs.getInt(1)==0){
                JOptionPane.showMessageDialog(null,"No UserId"+Studentid,"Warnning",2);
                 return false;
            }
            else{
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnualPayments_DA.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     return validity;
    }
    
}
