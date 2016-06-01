package com.example.lenovo.complaint_box;

/**
 * Created by Lenovo on 01-06-2016.
 */
public class UserComplaint {
    private String title;

    public UserComplaint() {}

    public UserComplaint(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
