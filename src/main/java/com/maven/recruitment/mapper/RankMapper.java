package com.maven.recruitment.mapper;

import com.maven.recruitment.pojo.Info.*;
import com.maven.recruitment.pojo.vo.ProblemVO;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.parsing.Problem;

import java.util.List;

@Mapper
public interface RankMapper{

    /**
     * 分别查询各个方向的用户并按分数降序排序
     * @return 获取用户数据，按分数从高到低排序
     */
    @Select("select * from c方向答题 order by c方向答题.total_score desc ")
    List<Cdata> rankUserByC();
    @Select("select * from Java方向答题 order by Java方向答题.total_score desc ")
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

    @Select("SELECT COUNT(studentid) FROM Java方向答题")
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

    /**
     * 通过学号查询一个方向的成绩
     * @param studentid
     * @return 一个方向的成绩的列表
     */
    @Select("select score1,score2,score3,score4,score5,score6,score7,score8,score9,score10,score11,score12" +
            " from ${field} where studentid=#{studentid}")
    Score selectGrade(String studentid,String field);

    @Select("select question1,question2,question3,question4,question5,question6,question7,question8,question9,question10,question11,question12 " +
            "from ${field} where studentid=#{studentid}")
    Score selectUrl(String studentid,String field);


}
