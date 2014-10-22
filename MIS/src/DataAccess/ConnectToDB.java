/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Malaka
 */
public class ConnectToDB {

    private static ConnectToDB singleton = new ConnectToDB();

    /*
     * A private Constructor prevents any other class from instantiating.
     */
    private ConnectToDB() {
    }

    ;
   
   /* Static 'instance' method */ 
   public static ConnectToDB getInstance() {//This return the singleton object instance
        return singleton;
    }
    /*
     * Other methods protected by singleton-ness
     */

    /**
     *
     * @return
     */
    protected Statement accessDataBase() {
        Statement statement = null;
        String dri = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/MISDB";

        try {
            Class.forName(dri);
           
            Connection con = DriverManager.getConnection(url, "root", "dinithi70060622");//Cra connection to url and user 
            statement = con.createStatement();//Create a sql statement
            
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return statement;

    }
}
