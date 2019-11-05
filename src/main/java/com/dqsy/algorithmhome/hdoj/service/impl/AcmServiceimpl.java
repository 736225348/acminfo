package com.dqsy.algorithmhome.hdoj.service.impl;

import com.dqsy.algorithmhome.hdoj.dao.AcmDao;
import com.dqsy.algorithmhome.hdoj.domain.acmstu;
import com.dqsy.algorithmhome.hdoj.domain.proving;
import com.dqsy.algorithmhome.hdoj.service.AcmService;
import com.dqsy.algorithmhome.user.domain.EasyGrid;
import com.dqsy.algorithmhome.user.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("AcmService")
class AcmServiceimpl implements AcmService {


    @Resource(name = "AcmDao")
    AcmDao acmDao;


    //注册失败返回一
    @Override
    public proving addstu(acmstu acmstu) {
        com.dqsy.algorithmhome.hdoj.domain.acmstu findstu = acmDao.findstu(acmstu.getStudentID());
        com.dqsy.algorithmhome.hdoj.domain.acmstu findaccount = acmDao.findaccount(acmstu.getAccount());
        proving proving = new proving(true, true);
        if (findstu != null) {
            proving.setStudentID(false);
        }
        if (findaccount != null) {
            proving.setAccount(false);
        }
        if (findstu == null && findaccount == null) {
            int addstu = acmDao.addstu(acmstu);
            return proving;
        } else {
            return proving;
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


    public String RefreshData() {
        List<acmstu> findstus = acmDao.findstus();
        for (acmstu acm : findstus) {
            int htmlSrc = getHTMLSrc(acm.getAccount());
            acmDao.UpdateSum(acm.getAccount(), htmlSrc);
        }

        return "更新数据成功";
    }


    public Integer getHTMLSrc(String account) {
        String url = "http://acm.hdu.edu.cn/userstatus.php?user=" + account;
        InputStream openStream = null;
        BufferedReader buf = null;
        String qwww = "";
        Integer valueOf = 0;
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
