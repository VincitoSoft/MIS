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
     
     private Hashtable termTestMarks[];
     private Hashtable assignmentMarks[];
     private Hashtable monthlyTestMarks[];
     
     private int currentTerm;
     private int currentAssignment;
     private int currentMonth;
     
     
     
     private MarksForSubject_DA marksForSubjectDA;
     
    public MarksForSubject(String name){
        this.subjectName=name;       
        marksForSubjectDA=new MarksForSubject_DA();
        
        for(int i=0;i<3;i++){
            termTestMarks[i]=new Hashtable<Integer,Integer>();
        }
        for(int i=0;i<12;i++){
            assignmentMarks[i]=new Hashtable<Integer,Integer>();
        }
        for(int i=0;i<12;i++){
            monthlyTestMarks[i]=new Hashtable<Integer,Integer>();
        }
        
        
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
    public Hashtable<Integer,Integer>[] getMonthlyTestMarks() {
        return monthlyTestMarks;
    }

    /**
     * @param monthlyTestMarks the monthlyTestMarks to set
     */
    
    
    public void addTermtestMark(int term,int studentId,int marks){
        termTestMarks[term-1].put(studentId, marks);
    }
    public void addMonthlyTestMark(int month,int studentId,int marks){
        monthlyTestMarks[month-1].put(studentId,marks);
    }
    public void addAssignmentMark(int assignmentNo,int studentId,int marks){
        assignmentMarks[assignmentNo-1].put(studentId,marks);
    }
     
    public void sendToDB(int type,int term,Hashtable<Integer,Integer>marks){
        switch(type){
            case 1:
                marksForSubjectDA.putAssignmentMarks(currentAssignment,assignmentMarks[term-1]);
                break;
            case 2:
                marksForSubjectDA.putMonthlyTestMarks(currentMonth,monthlyTestMarks[term-1]);
                break;
            case 3:
                marksForSubjectDA.putTermTestMarks(currentTerm,termTestMarks[term-1]);
                break;
        }
       
      
    }

    public void setYear(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
     
}
