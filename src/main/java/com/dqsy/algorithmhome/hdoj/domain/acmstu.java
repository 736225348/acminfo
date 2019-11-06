package com.dqsy.algorithmhome.hdoj.domain;

import javax.xml.crypto.Data;
import java.util.Date;

public class acmstu implements Comparable<acmstu> {
    String StudentID;
    String name;
    String hduUser;

    @Override
    public String toString() {
        return "acmstu{" +
                "StudentID='" + StudentID + '\'' +
                ", name='" + name + '\'' +
                ", hduUser='" + hduUser + '\'' +
                ", classes='" + classes + '\'' +
                ", count=" + count +
                '}';
    }

    String classes;
    int count;


    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHduUser() {
        return hduUser;
    }

    public void setHduUser(String hduUser) {
        this.hduUser = hduUser;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public int compareTo(acmstu o) {
        return -(this.getCount() - o.getCount());
    }
}
