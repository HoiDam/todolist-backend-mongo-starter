package com.afs.todolist.controller.dto;

public class TodoCreateRequest {
    private String text;
    private String color;
    private Boolean done;

    public TodoCreateRequest() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
