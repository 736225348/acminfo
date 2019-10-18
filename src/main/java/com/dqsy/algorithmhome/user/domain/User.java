package com.dqsy.algorithmhome.user.domain;

import javax.xml.crypto.Data;

public class User {
    int userID;
    String username;
    String password;
    int playerID;

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", playerID=" + playerID +
                ", eml='" + eml + '\'' +
                ", tel='" + tel + '\'' +
                ", idCard='" + idCard + '\'' +
                ", uName='" + uName + '\'' +
                ", grade=" + grade +
                ", sNumber='" + sNumber + '\'' +
                ", tNumber='" + tNumber + '\'' +
                ", photo='" + photo + '\'' +
                ", joinDate=" + joinDate +
                ", sitNumber=" + sitNumber +
                ", tSize='" + tSize + '\'' +
                ", remark='" + remark + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    String eml;
    String tel;
    String idCard;
    String uName;
    int grade;
    String sNumber;
    String tNumber;
    String photo;
    Data joinDate;

    int sitNumber;

    String tSize;
    String remark;
    String info;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getEml() {
        return eml;
    }

    public void setEml(String eml) {
        this.eml = eml;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }

    public String gettNumber() {
        return tNumber;
    }

    public void settNumber(String tNumber) {
        this.tNumber = tNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Data getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Data joinDate) {
        this.joinDate = joinDate;
    }

    public int getSitNumber() {
        return sitNumber;
    }

    public void setSitNumber(int sitNumber) {
        this.sitNumber = sitNumber;
    }

    public String gettSize() {
        return tSize;
    }

    public void settSize(String tSize) {
        this.tSize = tSize;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


}
