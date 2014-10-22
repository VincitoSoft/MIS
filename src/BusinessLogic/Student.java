/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buiness_Logic;

/**
 *
 * @author Dilan Nuwantha
 */
public class Student {
    private int student_ID;
    private String name_with_initals;
    private String full_name;
    private String gender;
    private String date_of_birth;
    private String address;
    private String nationality;
    private String contact_number;
    private Guardian guardian;
    
    public void Student(int student_ID, String name_with_initals,String full_name,String gender,String date_of_birth,String address,String nationality,String contact_number,Guardian guardian){
        this.address=address;
       this.contact_number=contact_number;
       this.date_of_birth=date_of_birth;
       this.full_name=full_name;
       this.gender=gender;
       this.guardian=guardian;
       this.name_with_initals=name_with_initals;
       this.nationality=nationality;
       this.student_ID=student_ID;
    }

    /**
     * @return the student_ID
     */
    public int getStudent_ID_to_GUI() {
        return student_ID;
    }

    /**
     * @param student_ID the student_ID to set
     */
    public void gui_setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    /**
     * @return the name_with_initals
     */
    public String getName_with_initals_to_GUI() {
        return name_with_initals;
    }

    /**
     * @param name_with_initals the name_with_initals to set
     */
    public void gui_setName_with_initals(String name_with_initals) {
        this.name_with_initals = name_with_initals;
    }

    /**
     * @return the full_name
     */
    public String getFull_name_to_GUI() {
        return full_name;
    }

    /**
     * @param full_name the full_name to set
     */
    public void gui_setFull_name(String full_name) {
        this.full_name = full_name;
    }

    /**
     * @return the gender
     */
    public String getGender_to_GUI() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void gui_setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the date_of_birth
     */
    public String getDate_of_birth_to_GUI() {
        return date_of_birth;
    }

    /**
     * @param date_of_birth the date_of_birth to set
     */
    public void gui_setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    /**
     * @return the address
     */
    public String getAddress_to_GUI() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void gui_setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the nationality
     */
    public String getNationality_to_GUI() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void gui_setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the contact_number
     */
    public String getContact_number_to_GUI() {
        return contact_number;
    }

    /**
     * @param contact_number the contact_number to set
     */
    public void gui_setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    /**
     * @return the guardian
     */
    public Guardian getGuardian_to_GUI() {
        return guardian;
    }

    /**
     * @param guardian the guardian to set
     */
    public void gui_setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }
    
     /**
     * @return the student_ID
     */
    public int getStudent_ID_to_DB() {
        return student_ID;
    }

    /**
     * @param student_ID the student_ID to set
     */
    public void db_setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    /**
     * @return the name_with_initals
     */
    public String getName_with_initals_to_DB() {
        return name_with_initals;
    }

    /**
     * @param name_with_initals the name_with_initals to set
     */
    public void db_setName_with_initals(String name_with_initals) {
        this.name_with_initals = name_with_initals;
    }

    /**
     * @return the full_name
     */
    public String getFull_name_to_DB() {
        return full_name;
    }

    /**
     * @param full_name the full_name to set
     */
    public void db_setFull_name(String full_name) {
        this.full_name = full_name;
    }

    /**
     * @return the gender
     */
    public String getGender_to_DB() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void db_setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the date_of_birth
     */
    public String getDate_of_birth_to_DB() {
        return date_of_birth;
    }

    /**
     * @param date_of_birth the date_of_birth to set
     */
    public void db_setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    /**
     * @return the address
     */
    public String getAddress_to_DB() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void db_setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the nationality
     */
    public String getNationality_to_DB() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void db_setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the contact_number
     */
    public String getContact_number_to_DB() {
        return contact_number;
    }

    /**
     * @param contact_number the contact_number to set
     */
    public void db_setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    /**
     * @return the guardian
     */
    public Guardian getGuardian_to_DB() {
        return guardian;
    }

    /**
     * @param guardian the guardian to set
     */
    public void db_setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }
    
    
}
