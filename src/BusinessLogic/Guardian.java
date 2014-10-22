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
public class Guardian {
    private String full_name_guardian;
    private String NIC_no;
    private String address;
    private String contact_number;
    
    public void Guardian(String full_name_guardian,String NIC_no,String address,String contact_number){
       this.NIC_no=NIC_no;
       this.address=address;
       this.contact_number=contact_number;
       this.full_name_guardian=full_name_guardian;
    }

    /**
     * @return the full_name_guardian
     */
    public String getFull_name_guardian_to_GUI() {
        return full_name_guardian;
    }

    /**
     * @param full_name_guardian the full_name_guardian to set
     */
    public void gui_setFull_name_guardian(String full_name_guardian) {
        this.full_name_guardian = full_name_guardian;
    }

    /**
     * @return the NIC_no
     */
    public String getNIC_no_to_GUI() {
        return NIC_no;
    }

    /**
     * @param NIC_no the NIC_no to set
     */
    public void gui_setNIC_no(String NIC_no) {
        this.NIC_no = NIC_no;
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
    
    
    
     public String getFull_name_guardian_to_DB() {
        return full_name_guardian;
    }

    /**
     * @param full_name_guardian the full_name_guardian to set
     */
    public void db_setFull_name_guardian(String full_name_guardian) {
        this.full_name_guardian = full_name_guardian;
    }

    /**
     * @return the NIC_no
     */
    public String getNIC_no_to_DB() {
        return NIC_no;
    }

    /**
     * @param NIC_no the NIC_no to set
     */
    public void db_setNIC_no(String NIC_no) {
        this.NIC_no = NIC_no;
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
    
}
