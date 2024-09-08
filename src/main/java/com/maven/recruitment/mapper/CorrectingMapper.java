package com.maven.recruitment.mapper;

import com.maven.recruitment.Utills.IdUtils;
import com.maven.recruitment.pojo.Info.*;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface CorrectingMapper {

    @Select("select * from c方向答题")
    List<Cdata> selectCdata();

    @Update("update c方向答题 " +
            "set score1 = #{score1}, score2 = #{score2}, score3 = #{score3}, score4 = #{score4}, score5 = #{score5}, score6 = #{score6}, score7 = #{score7}, score8 = #{score8},total_score = #{total_score} " +
            "where studentid = #{studentid}")
    void insertCdata(Cdata cdata);

    @Select("select * from recruitment.java方向答题")
    List<Javadata> selectJavadata();

    @Update("update Java方向答题 " +
            "set score1 = #{score1}, score2 = #{score2}, score3 = #{score3}, score4 = #{score4}, score5 = #{score5}, score6 = #{score6}, score7 = #{score7}, score8 = #{score8}, score9 = #{score9}, score10 = #{score10}, score11 = #{score11}, total_score = #{total_score} " +
            "where studentid = #{studentid}")
    void insertJavadata(Javadata javadata);

    @Select("select * from 机器学习方向答题")
    List<Pythondata> selectPythondata();

    @Update("update 机器学习方向答题 " +
            "set score1 = #{score1}, score2 = #{score2}, score3 = #{score3}, score4 = #{score4}, score5 = #{score5}, score6 = #{score6}, score7 = #{score7}, score8 = #{score8}, score9 = #{score9}, score10 = #{score10}, total_score = #{total_score} " +
            "where studentid = #{studentid}")
    void insertPythondata(Pythondata pythondata);

    @Select("select * from 前端方向答题")
    List<Websitedata> selectWebsitedata();

    @Update("update 前端方向答题 " +
            "set score1 = #{score1}, score2 = #{score2}, score3 = #{score3}, score4 = #{score4}, score5 = #{score5}, score6 = #{score6}, score7 = #{score7}, score8 = #{score8}, score9 = #{score9}, score10 = #{score10}, total_score = #{total_score} " +
            "where studentid = #{studentid}")
    void insertWebsitedata(Websitedata websitedata);

    @Update("update ${field} "+
            "set question${id} = #{url} "+
            "where studentid = #{studentId}"
    )
    void insertURL(submitDTO dto);

    @Update("update ${field} " +
            "set score${id} = #{score} " +
            "where studentid = #{studentid}")
    void updateScore(String studentid,String field,int id,int score);

    @Update("update ${field} " +
            "set total_score = #{total_score} " +
            "where studentid = #{studentid}")
    void updateTotalScore(String studentid,String field,int total_score);
}
