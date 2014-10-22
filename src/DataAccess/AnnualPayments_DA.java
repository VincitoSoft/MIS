/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import BusinessLogic.AnnualPayments;
import java.util.Hashtable;

/**
 *
 * @author WaRLoCk
 */
public class AnnualPayments_DA {
    
    public void put(int Studentid,int year,boolean fee600Paid,boolean fee60Paid){
        
    }
    
    public Hashtable<Integer,Integer>getSiblings(int index){
        Hashtable<Integer,Integer> details=new Hashtable<Integer,Integer>();
        
        //details<index,state>
        // only Rs.60/= paid  => state= 1
        // only Rs.600/= paid =>  state=2
        // Rs.60/= & Rs.600/= paid  => state= 3
        // none is paid => state= 0
        
        return details;
    }
    
    public Integer getStudentPaymentState(int index){
        // only Rs.60/= paid  => return 1
        // only Rs.600/= paid => return 2
        // Rs.60/= & Rs.600/= paid  => return 3
        // none is paid => return 0
        // if no record for the student => return null
        return 1;
    }
   
    
   
      
}
