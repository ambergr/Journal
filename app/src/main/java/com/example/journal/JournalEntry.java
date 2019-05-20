package com.example.journal;

import java.io.Serializable;

public class JournalEntry implements Serializable {

    private int id;
    private String title;
    private String content;
    private String mood;
    private int timestamp;

    public JournalEntry(String title, String content){
        this.title = title;
        this.content = content;
//        this.mood = mood;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
