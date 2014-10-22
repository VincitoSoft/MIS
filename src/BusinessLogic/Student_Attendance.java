/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buiness_Logic;
import DataAccess.Student_Attendance_DA;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author Dilan Nuwantha
 */
public class Student_Attendance {
       private Hashtable student_attendance[];
               
       private Hashtable<Integer,String> student_name=new Hashtable<Integer,String>();
       private Student_Attendance_DA student_attendance_DA=new Student_Attendance_DA();
       
       
       private String student_class;
       private Date current_date,last_updated_dated,selected_date;
       private int total_school_days; // total number of days held upto now
       
       
      //private int student_ID;
      // private int student_attendance;
      // private int temporary_student_attendance;
       private boolean confirmed=false;
       
       private boolean eighty_persent_warning=false;
       private int attendances_persentage;
       private int term;
       
       
       
        public void Student_Attendance(String student_class){
             this.student_class=student_class;
             this.student_name=student_attendance_DA.getStudentNames(student_class);
             this.last_updated_dated=student_attendance_DA.getUpdateddate();
             this.current_date=new Date();
             this.total_school_days=student_attendance_DA.getTotalSchoolDays();
             
             for(int i=0;i<3;i++){
                student_attendance[i]=new Hashtable<Integer,Integer>();
                student_attendance[i]=student_attendance_DA.getAttendance(student_class, i);
            }
             
        }
        
        
        public void getAttendance(){  // get attendance from DB to business_logic layer
            for(int i=0;i<3;i++){
                student_attendance[i]=new Hashtable<Integer,Integer>();
                student_attendance[i]=student_attendance_DA.getAttendance(student_class, i);
            }
        }
        
        public Hashtable getAttendanceUptoNow(int term){  // get attendance for the GUI
            if(!student_attendance[term].isEmpty())
                return student_attendance[term];
            else
                return null;
        }
        
        public void setSelectedDate(Date selectedDate){
            this.selected_date=selectedDate;
        }
        
       /* public int checkAvailableTerm(){ // use to check the term by date
           
            return 0;
        }*/
        
        public void setAttendance(Hashtable attendance,int term){
            student_attendance[term]=attendance;
        }
        
        
        public void setConfirmSavedata(){
            for(int i=0;i<3;i++){
                student_attendance_DA.setStudentAttendance(student_attendance[i],i);
            }
        }
        
       /* public int gui_absentDates(){
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
    
    public int getStudent_ID() {
        return student_ID;
    }

    
    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

   
    public int gui_getStudent_attendance() {
        return student_attendance;
    }

  
    public int getTotal_school_days() {
        return total_school_days;
    }

   
    public void setTotal_school_days(int total_school_days) {
        this.total_school_days = total_school_days;
       
    }*/

    
}
