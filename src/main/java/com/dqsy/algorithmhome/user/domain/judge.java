package com.dqsy.algorithmhome.user.domain;

public class judge {

    public judge() {

    }

    public Boolean getCause() {
        return cause;
    }

    public void setCause(Boolean cause) {
        this.cause = cause;
    }

    public judge(Boolean cause) {
        this.cause = cause;
    }

    Boolean cause;
}
