package com.maven.recruitment.service;


import com.maven.recruitment.pojo.vo.RankDataVo;
import com.maven.recruitment.pojo.vo.SelfGradeVo;
import cn.hutool.json.JSONObject;

public interface RankService {


    /**
     * 根据分数给C方向的用户排序
     * @param userId 登录的用户的学号
     * @return C方向用户数据，按分数从高到低排序，以及用户自身的数据
     */
    RankDataVo rankC(String userId);

    /**
     * 根据分数给机器学习方向的用户排序
     *  @param userId 登录的用户的学号
     * @return 机器学习方向用户数据，按分数从高到低排序，以及用户自身的数据
     */
    RankDataVo rankPython(String userId);

    /**
     * 根据分数给前端方向的用户排序
     * @param userId 登录的用户的学号
     * @return 前端方向用户数据，按分数从高到低排序，以及用户自身的数据
     */
    RankDataVo rankWebsite(String userId);

    /**
     * 根据分数给后端方向的用户排序
     * @param userId 登录的用户的学号
     * @return Java用户数据，按分数从高到低排序，以及用户自身的数据
     */
    RankDataVo rankJava(String userId);

    /**
     * 封装各个方向已排序好的用户数据
     * @param userId 登录的用户id
     * @return 四个方向前十名的用户数据，按分数从高到低排序，以及用户自身的数据
     */
    JSONObject rankUser(String userId);


}
