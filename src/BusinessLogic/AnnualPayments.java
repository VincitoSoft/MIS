/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;
import DataAccess.AnnualPayments_DA;
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

    public AnnualPayments(){
        fee600_paid=false;
        fee60_paid=false;
        
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
        
        
        if(!annualPaymentsDA.checkForSiblings(studentIndex)){
        annualPaymentsDA.put(studentIndex, year, fee600_paid, fee60_paid);
        return true;
        }
        
        else{
            return false;
        }
        
    }
    
   
    
    
    
    
    
    
}

