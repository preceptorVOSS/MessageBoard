package com.example.messageboard;

import java.util.Calendar;

public class Message {

    private String title;
    private Calendar timestamp;
    private String createdBy;
    private String text;
    private Integer id;

    public Message() {
    }

    public Message(String title, Calendar timestamp, String createdBy, String text) {
        this.title = title;
        this.timestamp = timestamp;
        this.createdBy = createdBy;
        this.text = text;
    }

    public void setTitle(String topic) {
        this.title = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
