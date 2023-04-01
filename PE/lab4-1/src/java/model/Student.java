
package model;

import java.util.Date;


public class Student {
    private int id;
    private String name;
    private boolean gender;
    private Date DOB;

    public Student() {
    }

    public Student(int id, String name, boolean gender, Date DOB) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.DOB = DOB;
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

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
    
    
}
