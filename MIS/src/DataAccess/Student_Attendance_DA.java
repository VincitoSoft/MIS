/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;
import Buiness_Logic.Student_Attendance;
import java.sql.Date;
import java.util.Hashtable;
/**
 *
 * @author Dilan Nuwantha
 */
public class Student_Attendance_DA {
  
    private int total_school_days;// total number of days held upto now
    private Hashtable<Integer,Integer> student_attendance=new Hashtable<Integer,Integer>(); // student index and attendance 
    private Hashtable<Integer,String> student_names=new Hashtable<Integer,String>(); // student index and full name
    
    
    
    
    public Hashtable getAttendance(String student_class,int term){ // return student attendance for corresponding whole class
        
        return student_attendance;
    }
    
    public Hashtable getStudentNames(String student_class){ // return all student names for corresponding  class
        
        return student_names;
    }
    
    public int getTotalSchoolDays(){  //return total number of days held upto now
        return total_school_days;
    }
    
    public void setStudentAttendance(Hashtable student_attendances,int term){ // set attendance into the database
        
    }
    public Date getUpdateddate(){
        Date dt = null;
        
        return dt;
    }
    
}
