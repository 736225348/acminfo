package com.dqsy.algorithmhome.user.domain;

import org.springframework.stereotype.Service;

import java.util.List;
public class EasyGrid {
    private int total;
    private List<?> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
