package com.dqsy.algorithmhome.hdoj.service;

import com.dqsy.algorithmhome.hdoj.domain.acmstu;
import com.dqsy.algorithmhome.hdoj.domain.proving;
import com.dqsy.algorithmhome.user.domain.EasyGrid;

import java.util.List;

public interface AcmService {

    proving addstu(acmstu acmstu);

    acmstu findstu(String StudentID);

    public  List<acmstu> findstuds();

    String RefreshData();

    Integer getHTMLSrc(String account);
}
