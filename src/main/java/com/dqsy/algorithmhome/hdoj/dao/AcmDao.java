package com.dqsy.algorithmhome.hdoj.dao;

import com.dqsy.algorithmhome.hdoj.domain.acmstu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("AcmDao")
public interface AcmDao {
    // 学生的插入
    // @Insert("insert into user(username,password,eml,tel,idCard,info,uName,grade,sNumber,tNumber,photo,sitNumber,tSize,remark) values(#{username},#{password},#{eml},#{tel},#{idCard},#{info},#{uName},#{grade},#{sNumber},#{tNumber},#{photo},#{sitNumber},#{tSize},#{remark})")
    @Insert("insert into studentsacm (name,classes,account,time,StudentID,sum) values (#{name},#{classes},#{account},#{time},#{StudentID},#{sum})")
    int addstu(acmstu acmstu);

    @Select("select * from studentsacm where StudentID=#{StudentID}")
    acmstu findstu(String StudentID);

    @Select("select * from studentsacm where account=#{account}")
    acmstu findaccount(String account);

    @Select("select * from  studentsacm")
    List<acmstu> findstus();

    @Update("update studentsacm set sum=#{sum} where account=#{account}")
    void UpdateSum(@Param("account") String account, @Param("sum") int sum);
}
