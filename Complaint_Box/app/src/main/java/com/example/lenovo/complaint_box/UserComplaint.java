package com.example.lenovo.complaint_box;

/**
 * Created by Lenovo on 01-06-2016.
 */
public class UserComplaint {
    private String complaint;
    private String address;
    private String phone;


    public UserComplaint(String complaint, String address, String phone) {
        this.complaint = complaint;
        this.address = address;
        this.phone = phone;
    }

    public String getComplaint() {
        return complaint;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }

}
