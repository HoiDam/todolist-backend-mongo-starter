package com.afs.todolist.controller.dto;

public class TodoUpdateRequest {
    private Boolean done;
    private String text;

    private String color;

    public TodoUpdateRequest() {
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
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
}
