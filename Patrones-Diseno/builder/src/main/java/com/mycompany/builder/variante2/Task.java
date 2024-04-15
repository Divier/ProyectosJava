/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.builder.variante2;

/**
 *
 * @author hsrx4
 */
import java.util.Date;

public class Task {

    private final long id;
    private String summary = "";
    private String description = "";
    private boolean done = false;
    private Date dueDate;

    public Task(TaskBuilder builder) {
        this.id = builder.id;
        this.summary = builder.summary;
        this.description = builder.description;
        this.done = builder.done;
        this.dueDate = builder.dueDate;
    }

    public long getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getDueDate() {
        return new Date(dueDate.getTime());
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = new Date(dueDate.getTime());
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", summary=" + summary + ", description=" + description + ", done=" + done + ", dueDate=" + dueDate + '}';
    }

    public static class TaskBuilder {

        private final long id;
        private String summary = "";
        private String description = "";
        private boolean done = false;
        private Date dueDate;

        public TaskBuilder(long id) {
            this.id = id;
        }

        public TaskBuilder(long id, String summary, String description, boolean done,
                Date dueDate) {
            this.id = id;
            this.summary = summary;
            this.description = description;
            this.done = done;
            this.dueDate = dueDate;
        }

        public TaskBuilder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public TaskBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public TaskBuilder setDone(boolean done) {
            this.done = done;
            return this;
        }

        public TaskBuilder setDueDate(Date dueDate) {
            this.dueDate = new Date(dueDate.getTime());
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
}
