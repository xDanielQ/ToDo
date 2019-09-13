package com.sda.todo.model;

import java.util.Date;

public class Todo {

    private String status;
    private Date createDate;
    private Date endDate;
    private String title;
    private String task;

    public Todo() {
    }

    public Todo( String status, Date createDate, Date endDate, String title, String task) {

        this.status = status;
        this.createDate = createDate;
        this.endDate = endDate;
        this.title = title;
        this.task = task;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
