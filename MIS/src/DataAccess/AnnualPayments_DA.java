/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;
import java.sql.*;
import BusinessLogic.AnnualPayments;

/**
 *
 * @author WaRLoCk
 */
public class AnnualPayments_DA {
    ConnectToDB condb=ConnectToDB.getInstance();
    public void put(String Studentid,int year,boolean fee600Paid,boolean fee60Paid){
        Statement st=condb.accessDataBase();
        String quary1="insert into Annual_Payments "
        st.executeQuery();
    }
      
}
