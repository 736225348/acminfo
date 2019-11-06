package com.dqsy.algorithmhome.hdoj.service.impl;

import com.dqsy.algorithmhome.hdoj.dao.AcmDao;
import com.dqsy.algorithmhome.hdoj.domain.acmstu;
import com.dqsy.algorithmhome.hdoj.service.AcmService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service("AcmService")
class AcmServiceimpl implements AcmService {


    @Resource(name = "AcmDao")
    AcmDao acmDao;


    //注册失败返回一
    @Override
    public int addstu(acmstu acmstu) {
        com.dqsy.algorithmhome.hdoj.domain.acmstu findstu = acmDao.findstu(acmstu.getStudentID());
        com.dqsy.algorithmhome.hdoj.domain.acmstu findaccount = acmDao.findaccount(acmstu.getHduUser());

        if (findstu != null) {
            return 1; // 学号已经被注册
        } else if (findaccount != null) {
            return 2; // 杭电号已经被注册
        } else if (getHTMLSrc(acmstu.getHduUser()) == -1) {
            return 3; //杭电号不存在

        } else {
            acmstu.setCount(getHTMLSrc(acmstu.getHduUser()));
            acmDao.addstu(acmstu);
            return 0;
        }


    }

    @Override
    public acmstu findstu(String StudentID) {
        acmstu findstu = acmDao.findstu(StudentID);
        return findstu;
    }


    public List<acmstu> findstuds() {//第几页 pages   rows 一共有几页

        List<acmstu> findstus = acmDao.findstus();
        Collections.sort(findstus);
        return findstus;

    }

    @Override
    public List<acmstu> BlurFindStu(String cols, String val) {

        if (cols.equals("name")) {
            return acmDao.BlurFindStuName(val);

        } else if (cols.equals("classes")) {
            return acmDao.BlurFindStuClasses(val);

        } else if (cols.equals("hduUser")) {
            return acmDao.BlurFindStuAccount(val);

        } else if (cols.equals("StudentID")) {
            return acmDao.BlurFindStuStudentID(val);
        } else {
            return acmDao.findstus();

        }


    }


    public int RefreshData() {
        List<acmstu> findstus = acmDao.findstus();
        for (acmstu acm : findstus) {
            int htmlSrc = getHTMLSrc(acm.getHduUser());
            acmDao.UpdateSum(acm.getHduUser(), htmlSrc);
        }

        return 1;
    }

    //任务 定制
    //"*/20 * * * * ?"
    //"0 0 10,22 * * ?"
    //每天上午10点，下午2点，10点
    @Scheduled(cron = "0 0 10,22 * * ?")
    public void climbdata() {
        RefreshData();
    }


    public Integer getHTMLSrc(String account) {
        String url = "http://acm.hdu.edu.cn/userstatus.php?user=" + account;
        InputStream openStream = null;
        BufferedReader buf = null;
        String qwww = "";
        Integer valueOf = -1;
        try {
            String line = null;
            URL theUrl = new URL(url);
            openStream = theUrl.openStream();
            buf = new BufferedReader(new InputStreamReader(openStream, "GBK"));
            while ((line = buf.readLine()) != null) {

                if (line.contains("<h1 style=\"color:#1A5CC8\" align=center>")) {


                    qwe:
                    for (int i = 0; i < line.length(); i++) {
                        if (line.charAt(i) == '>') {
                            for (int k = i + 1; k < line.length(); k++) {
                                if (line.charAt(k) == '<') {
                                    break qwe;

                                }

                            }

                        }

                    }

                } // 用户名

                if (line.contains("<i style=\"color:blue\">from:")) {

//					System.out.println(line);  这里面有用户建立的时间
                    qwe:
                    for (int i = line.length() - 1; i >= 0; i--) {
                        if (line.charAt(i) == ':') {
                            for (int k = i + 2; k < line.length(); k++) {
                                if (line.charAt(k) == '&') {
                                    break qwe;

                                }

                            }

                        }

                    }

                }
                int sq = 0;

                if (line.contains("Problems Solved")) {

                    qwee:
                    for (int i = 0; i < line.length(); i++) {
                        if (sq == 4) {
                            for (int q = i; q < line.length(); q++) {
                                if (line.charAt(i) == '<') {
                                    break qwee;
                                }

                                qwww = qwww + line.charAt(q);
                            }

                        }

                        if (line.charAt(i) == '>') {
                            sq++;
                        }

                    }

                    for (int i = 0; i < qwww.length(); i++) {
                        if (qwww.charAt(i) == '<') {
                            break;

                        } else {
                            qwww = qwww + qwww.charAt(i);

                        }

                    }
                    String[] split = qwww.split("<");

                    valueOf = Integer.valueOf(split[0]);

                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (openStream != null) {
                    openStream.close();
                }
                if (buf != null) {
                    buf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return valueOf;

    }
}
