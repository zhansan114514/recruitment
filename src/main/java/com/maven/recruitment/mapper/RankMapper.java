package com.maven.recruitment.mapper;

import com.maven.recruitment.pojo.Info.*;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface RankMapper{

    /**
     * 分别查询各个方向的用户并按分数降序排序
     * @return 获取用户数据，按分数从高到低排序
     */
    @Select("select * from c方向答题 order by c方向答题.total_score desc ")
    List<Cdata> rankUserByC();
    @Select("select * from java方向答题 order by java方向答题.total_score desc ")
    List<Javadata> rankUserByJava();
    @Select("select * from 机器学习方向答题 order by 机器学习方向答题.total_score desc ")
    List<Pythondata> rankUserByPython();
    @Select("select * from 前端方向答题 order by 前端方向答题.total_score desc ")
    List<Websitedata> rankUserByWebsite();

    /**
     * 分别统计各个方向的用户数
     * @return 各个方向参与排名的人数
     */
    @Select("SELECT COUNT(studentid) FROM c方向答题")
    int countUserByC();

    @Select("SELECT COUNT(studentid) FROM java方向答题")
    int countUserByJava();

    @Select("SELECT COUNT(studentid) FROM 机器学习方向答题")
    int countUserByPython();

    @Select("SELECT COUNT(studentid) FROM 前端方向答题")
    int countUserByWebsite();

    /**
     * 通过学号查询学生姓名
     * @param studentid 学号
     * @return 学生姓名
     */
    @Select("select name from user where studentid = #{studentid} ")
    String selectName(String studentid);
}
