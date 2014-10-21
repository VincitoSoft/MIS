/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;
import java.sql.*;
/**
 *
 * @author Malaka
 */
public class ConnectToDB {

   private static ConnectToDB singleton = new ConnectToDB( );
   
   /* A private Constructor prevents any other 
    * class from instantiating.
    */
  private ConnectToDB(){
  
  };
   
   /* Static 'instance' method */ 
   public static ConnectToDB getInstance( ) {//This return the singleton object instance
      return singleton;
   }
   /* Other methods protected by singleton-ness */
   /**
    * 
    * @return
    */
   public Statement accessDataBase( ) {
       Statement statement=null;
       
       return statement;
      
   }
}
