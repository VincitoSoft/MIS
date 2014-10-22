/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

import DataAccess.MarksForSubject_DA;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author WaRLoCk
 */
public class MarksForSubject {
     private Hashtable<String,Integer> marks;
     private String subjectName;
     private int year;
     
     private String className;
     
     private Hashtable<Integer,Integer> termTestMarks;
     private Hashtable<Integer,Integer> assignmentMarks;
     private Hashtable<Integer,Integer> monthlyTestMarks;
     
     private MarksForSubject_DA marksForSubjectDA;
     
    public MarksForSubject(String name){
        this.subjectName=name;       
        marksForSubjectDA=new MarksForSubject_DA();
    }
    
    public void setSubjectName(String name){
        
    }
    
    
    public void enterMarks(String AssesmentType,int mark){
        marks.put(AssesmentType, mark);
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return the monthlyTestMarks
     */
    public Hashtable<Integer,Integer> getMonthlyTestMarks() {
        return monthlyTestMarks;
    }

    /**
     * @param monthlyTestMarks the monthlyTestMarks to set
     */
    public void setMonthlyTestMarks(Hashtable<Integer,Integer> monthlyTestMarks) {
        this.monthlyTestMarks = monthlyTestMarks;
    }
    
    public void addTermtestMark(int studentId,int marks){
        termTestMarks.put(studentId, marks);
    }
    public void addMonthlyTestMark(int studentId,int marks){
        monthlyTestMarks.put(studentId,marks);
    }
     public void addAssignmentMark(int studentId,int marks){
        assignmentMarks.put(studentId,marks);
    }
     
    public void sendToDB(){
        marksForSubjectDA.putAssignmentMarks(assignmentMarks);
        marksForSubjectDA.putMonthlyTestMarks(monthlyTestMarks);
        marksForSubjectDA.putTermTestMarks(termTestMarks);
    }
    
    
    
    
     
}
