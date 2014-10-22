/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buiness_Logic;
import DataAccess.Student_Attendance_DA;

/**
 *
 * @author Dilan Nuwantha
 */
public class Student_Attendance {
       private int student_ID;
       private int student_attendance;
       private int temporary_student_attendance;
       private boolean confirmed=false;
       private int total_school_days; // total number of days held upto now
       private boolean eighty_persent_warning=false;
       private int attendances_persentage;
       
        
        
        public void gui_setAttendance_for_a_date(){   // mark attendance for a day
            temporary_student_attendance++;
        }
        
        public void gui_setAttendance_for_week(int attendance){
            this.temporary_student_attendance=attendance;
        }
        
        public void gui_confirmAttendance(){
             this.student_attendance=temporary_student_attendance;
             confirmed=true;
        }
        
        public Object setAttendance_for_DB(){
            if(confirmed)
                return student_attendance;
            else
                return null;
        }
        public int gui_absentDates(){
            return total_school_days-student_attendance;
        }
        
        public int gui_absentDates_persentage(){
            this.attendances_persentage=(student_attendance/total_school_days)*100;
            if(attendances_persentage<80)
                this.eighty_persent_warning=true;
            else
                this.eighty_persent_warning=false;
            
            return attendances_persentage;
        }
    /**
     * @return the student_ID
     */
    public int getStudent_ID() {
        return student_ID;
    }

    /**
     * @param student_ID the student_ID to set
     */
    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    /**
     * @return the student_attendance
     */
    public int gui_getStudent_attendance() {
        return student_attendance;
    }

    /**
     * @return the total_school_days
     */
    public int getTotal_school_days() {
        return total_school_days;
    }

    /**
     * @param total_school_days the total_school_days to set
     */
    public void setTotal_school_days(int total_school_days) {
        this.total_school_days = total_school_days;
    }

   
}
