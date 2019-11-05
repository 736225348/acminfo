package com.dqsy.algorithmhome.hdoj.domain;

public class proving {
    boolean StudentID;
    boolean account;

    @Override
    public String toString() {
        return "proving{" +
                "StudentID=" + StudentID +
                ", account=" + account +
                '}';
    }

    public proving(boolean studentID, boolean account) {
        StudentID = studentID;
        this.account = account;
    }

    public boolean isStudentID() {
        return StudentID;
    }

    public void setStudentID(boolean studentID) {
        StudentID = studentID;
    }

    public boolean isAccount() {
        return account;
    }

    public void setAccount(boolean account) {
        this.account = account;
    }
}
