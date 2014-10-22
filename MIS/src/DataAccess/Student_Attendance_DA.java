/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;
import Buiness_Logic.Student_Attendance;
import java.sql.Date;
/**
 *
 * @author Dilan Nuwantha
 */
public class Student_Attendance_DA {
    private int student_attendance;
    private int total_school_days;// total number of days held upto now
    
    
    
    
    
    public int getAttendance(int student_ID,int term){ // return attendance for corresponding student
        
        return student_attendance;
    }
    
    public int getTotalSchoolDays(){  //return total number of days held upto now
        return total_school_days;
    }
    
    public void setStudentAttendance(int student_ID,int attendance,int term){ // set attendance into the database
        
    }
    public Date getUpdateddate(){
        Date dt = null;
        
        return dt;
    }
    
}
