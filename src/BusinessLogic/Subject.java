/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

import java.util.Hashtable;

/**
 *
 * @author WaRLoCk
 */
public class Subject {
     private Hashtable<String,Integer> marks;
     private String subjectName;
    
    public Subject(String name){
        marks=new Hashtable<String,Integer>();
        this.subjectName=name;
    }
    
    public void enterMarks(String AssesmentType,int mark){
        marks.put(AssesmentType, mark);
    }
    
}
