package com.example.messageboard;

import java.util.Calendar;

public class Topic {

    private String title;
    private Calendar timestamp;
    private String createdBy;
    private Integer id;
    private Calendar recentMessage;

    public Topic() {
    }

    public Topic(String title, Calendar timestamp, String createdBy) {
        this.title = title;
        this.timestamp = timestamp;
        this.createdBy = createdBy;
        this.recentMessage = null;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setRecentMessage(Calendar recentMessage) {
        this.recentMessage = recentMessage;
    }

    public Calendar getRecentMessage() {
        return recentMessage;
    }
}
