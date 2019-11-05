package com.dqsy.algorithmhome.hdoj.controller;


import com.dqsy.algorithmhome.hdoj.domain.acmstu;
import com.dqsy.algorithmhome.hdoj.domain.proving;
import com.dqsy.algorithmhome.hdoj.service.AcmService;
import com.dqsy.algorithmhome.user.domain.EasyGrid;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.lang.reflect.AccessibleObject;
import java.util.Date;
import java.util.List;

@Controller
public class AcmUserController {

    @Resource(name = "AcmService")
    AcmService acmService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @ResponseBody
    @PostMapping("/login")
    public proving registerAcm(acmstu acmstu) {
//        acmService.RefreshData();
        System.out.println(acmstu);
        acmstu.setTime(new Date());
        acmstu.setSum(acmService.getHTMLSrc(acmstu.getAccount()));
        proving addstu = acmService.addstu(acmstu);
        System.out.println(addstu);
        return addstu;
    }

    @ResponseBody
    @GetMapping("/ShowCount")
    public List<acmstu> ShowCount() {
        List<acmstu> list = acmService.findstuds();
        return list;
    }


}
