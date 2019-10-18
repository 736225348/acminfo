package com.dqsy.algorithmhome.user.domain;

public class daom {
    String username;
    aaa luo;
    String password;

    @Override
    public String toString() {
        return "daom{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", luo=" + luo +
                '}';
    }
    public aaa getLuo() {
        return luo;
    }

    public void setLuo(aaa luo) {
        this.luo = luo;
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
}
