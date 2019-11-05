package com.dqsy.algorithmhome.hdoj.domain;

import javax.xml.crypto.Data;
import java.util.Date;

public class acmstu implements Comparable<acmstu> {
    String name;
    String classes;
    String account;
    int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "acmstu{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", account='" + account + '\'' +
                ", time=" + time +
                ", StudentID='" + StudentID + '\'' +
                '}';
    }

    Date time;
    String StudentID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    @Override
    public int compareTo(acmstu o) {
        return -(this.getSum() - o.getSum());
    }
}
