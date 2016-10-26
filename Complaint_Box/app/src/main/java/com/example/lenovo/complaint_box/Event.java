package com.example.lenovo.complaint_box;

/**
 * Created by Lenovo on 09-06-2016.
 */
public class Event {
    private String event;
    private String location;

    public Event(String event, String location) {
        this.event = event;
        this.location = location;
    }

    public String getEvent() {
        return event;
    }
    public String getLocation() {
        return location;
    }
}
