package model;

import java.sql.Date;

public class Student {
    private int id;
    private String name;
    private boolean gender;
    private Date date;

    public Student() {
    }

    public Student(int id, String name, boolean gender, Date date) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date = date;
    }
    public Student(String name, boolean gender, Date date) {
        this.name = name;
        this.gender = gender;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }
    
    public String getGender() {
        return gender ? "Male" : "Female";
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}