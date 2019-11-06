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
    @Insert("insert into clubStudent (name,classes,hduUser,StudentID,count) values (#{name},#{classes},#{hduUser},#{StudentID},#{count})")
    int addstu(acmstu acmstu);


    /**
     * 根据学号查找学生
     *
     * @param StudentID
     * @return
     */
    @Select("select * from clubStudent where StudentID=#{StudentID}")
    acmstu findstu(String StudentID);


    /**
     * 根据杭电oj账号查找学生
     *
     * @param
     * @return
     */
    @Select("select * from clubStudent where hduUser=#{hduUser}")
    acmstu findaccount(String hduUser);


    /**
     * 查看所有学生信息
     *
     * @return
     */
    @Select("select * from  clubStudent")
    List<acmstu> findstus();


    /**
     * 更新 学员的 杭电oj的 信息
     *
     * @param
     * @param
     */
    @Update("update clubStudent set count=#{count} where hduUser=#{hduUser}")
    void UpdateSum(@Param("hduUser") String hduUser, @Param("count") int count);

    /**
     * 更新 一个学院的所有信息
     *
     * @param acmstu
     */
    @Update("update clubStudent set name=#{name},hduUser=#{hduUser},count=#{count},classes=#{classes} where id=#{StudentID}")
    void UpdateOne(acmstu acmstu);

    /**
     * 模糊查询
     *
     * @param val
     * @return
     */
    @Select("select * from  clubStudent where name  like concat('%',#{val},'%') ")
    List<acmstu> BlurFindStuName(@Param("val") String val);

    @Select("select * from  clubStudent where classes  like concat('%',#{val},'%') ")
    List<acmstu> BlurFindStuClasses(@Param("val") String val);

    @Select("select * from  clubStudent where account  like concat('%',#{val},'%') ")
    List<acmstu> BlurFindStuAccount(@Param("val") String val);

    @Select("select * from  clubStudent where StudentID  like concat('%',#{val},'%') ")
    List<acmstu> BlurFindStuStudentID(@Param("val") String val);


}
