package com.dqsy.algorithmhome.user.domain;

public class peo {
    String username;
    String password;

    @Override
    public String toString() {
        return "peo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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
