/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;
import DataAccess.AnnualPayments_DA;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
/**
 *
 * @author WaRLoCk
 */
public class AnnualPayments {
    private int studentIndex;
    private boolean fee600_paid;
    private boolean fee60_paid;
    private int year;
    private AnnualPayments_DA annualPaymentsDA=null;
    private int paymentState;

    public AnnualPayments(){
        fee600_paid=false;
        fee60_paid=false;
        paymentState=0;
        
        annualPaymentsDA=new AnnualPayments_DA();
    }
    /**
     * @return the studentIndex
     */
    public int getStudentIndex() {
        return studentIndex;
    }

    /**
     * @param studentIndex the studentIndex to set
     */
    public void setStudentIndex(int studentIndex) {
        this.studentIndex = studentIndex;
    }

    /**
     * @return the fee600_paid
     */
    public boolean isFee600_paid() {
        return fee600_paid;
    }

    /**
     * @param fee600_paid the fee600_paid to set
     */
    public void setFee600_paid(boolean fee600_paid) {
        this.fee600_paid = fee600_paid;
    }

    /**
     * @return the fee60_paid
     */
    public boolean isFee60_paid() {
        return fee60_paid;
    }

    /**
     * @param fee60_paid the fee60_paid to set
     */
    public void setFee60_paid(boolean fee60_paid) {
        this.fee60_paid = fee60_paid;
    }
    
   
    
    public boolean sendToDB(){        
        
        /*if(!annualPaymentsDA.checkForSiblings(studentIndex)){
        annualPaymentsDA.put(studentIndex, year, fee600_paid, fee60_paid);
        return true;
        }
        
        else{
            return false;
        }*/
        
        
        boolean state60=false;
        boolean state600=false;
        Integer check=annualPaymentsDA.getStudentPaymentState(studentIndex);
        if(check==null){
            Hashtable<Integer,Integer> details=annualPaymentsDA.getSiblings(studentIndex);
            if(details!=null){
                if(isFee60_paid() && !checkFor60(details)){
                    state60=true;
                }
                if(isFee600_paid() && !checkFor600(details)){
                    state600=true;
                }                
            }
            
            if((state60=true) && (state600==true)){
                annualPaymentsDA.put(studentIndex, year, true, true);
                return true;
            }
            else if((state60=true) && (state600==false)){
                annualPaymentsDA.put(studentIndex, year, true, false);
                return true;
            }
            else if((state60=false) && (state600==true)){
                annualPaymentsDA.put(studentIndex, year, false, true);
                return true;
            }
            else{
                return false;
            }
             
        }
        else{
             if((isFee60_paid()==true) && (isFee600_paid()==true)){
                annualPaymentsDA.put(studentIndex, year, true, true);
                return true;
            }
            else if((isFee60_paid()==true) && (isFee600_paid()==false)){
                annualPaymentsDA.put(studentIndex, year, true, false);
                return true;
            }
            else if((isFee60_paid()==false) && (isFee600_paid()==true)){
                annualPaymentsDA.put(studentIndex, year, false, true);
                return true;
            }
            else{
                return false;
            }
        }
        
    }
    
    boolean checkFor60(Hashtable<Integer,Integer> details){
        int cnt=0;
        Enumeration keys;
        keys=details.elements();
         while(keys.hasMoreElements()){
             Integer val=(Integer)keys.nextElement();
             if(val==1 || val==3){
                 cnt++;
                 if(cnt>=2)
                     break;                 
             }
         }
         
         if(cnt==2){
             return true;
         }
         return false;             
    }
   
     boolean checkFor600(Hashtable<Integer,Integer> details){
        int cnt=0;
        Enumeration keys;
        keys=details.elements();
         while(keys.hasMoreElements()){
             Integer val=(Integer)keys.nextElement();
             if(val==2 || val==3){
                 cnt=1;
                 break;                 
             }
         }
         
         if(cnt==1){
             return true;
         }
         return false;             
    }
    
    
    
    
    
    
}

