package com.dqsy.algorithmhome.hdoj.service;

import com.dqsy.algorithmhome.hdoj.domain.acmstu;

import java.util.List;

public interface AcmService {
    int
    addstu(acmstu acmstu);

    acmstu findstu(String StudentID);

    List<acmstu> findstuds();


    List<acmstu> BlurFindStu(String cols, String val);

    int RefreshData();

    Integer getHTMLSrc(String account);
}
