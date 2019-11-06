package com.dqsy.algorithmhome.hdoj.controller;


import com.dqsy.algorithmhome.hdoj.domain.acmstu;
import com.dqsy.algorithmhome.hdoj.service.AcmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AcmUserController {

    @Resource(name = "AcmService")
    AcmService acmService;


    /**
     * 跳转页面
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/show")
    public String show() {
        return "clubStudentList";
    }


    /**
     * 学院信息采集
     * 返回 0 成功
     * 1 学号已经被绑定
     * 2 杭电号已经被绑定
     * 3 杭电 oj 号不存在
     *
     * @param acmstu
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public int registerAcm(acmstu acmstu) {
        int addstu = acmService.addstu(acmstu);
        System.out.println("/////////////////");
        System.out.println(addstu);
        return addstu;
    }

    /**
     * 数据接口 ： 展示数据
     *
     * @return
     */


    /**
     * 更新所有人杭电oj的账号
     * 返回   1  表示 更新成功
     *
     * @return
     */
    @ResponseBody
    @PostMapping("/Refresh")
    public int Refresh() {
        return acmService.RefreshData();
    }


    @ResponseBody
    @PostMapping("/ShowCount")
    public List<acmstu> ShowCount(@RequestParam(value = "cols", defaultValue = "no") String cols, @RequestParam(value = "val", defaultValue = "no") String val) {
        System.out.println(cols + " " + val);
        if (cols.equals("no") || val.equals("no")) {
            return acmService.findstuds();
        } else {
            return acmService.BlurFindStu(cols, val);
        }
    }
}
