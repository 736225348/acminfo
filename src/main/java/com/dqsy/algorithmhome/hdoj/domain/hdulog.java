package com.dqsy.algorithmhome.hdoj.domain;

import java.util.Date;

public class hdulog {
    String StudentID;

    @Override
    public String toString() {
        return "hdulog{" +
                "StudentID='" + StudentID + '\'' +
                ", count=" + count +
                ", hdate=" + hdate +
                '}';
    }

    int count;
    Date hdate;

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getHdate() {
        return hdate;
    }

    public void setHdate(Date hdate) {
        this.hdate = hdate;
    }


}
