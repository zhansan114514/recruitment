package com.maven.recruitment.service;

import com.maven.recruitment.pojo.Info.Cdata;
import com.maven.recruitment.pojo.vo.RankDataVo;

import java.util.List;
import java.util.Map;

public interface RankService {


    /**
     * 根据分数给C方向的用户排序
     * @return C方向用户数据，按分数从高到低排序，包括昵称
     */
    RankDataVo rankC();

    /**
     * 根据分数给后端方向的用户排序
     * @return Java用户数据，按分数从高到低排序，包括昵称
     */
    RankDataVo rankJava();

    /**
     * 根据分数给机器学习方向的用户排序
     * @return C方向用户数据，按分数从高到低排序，包括昵称
     */
    RankDataVo rankPython();

    /**
     * 根据分数给前端方向的用户排序
     * @return C方向用户数据，按分数从高到低排序，包括昵称
     */
    RankDataVo rankWebsite();

    /**
     * 封装各个方向已排序好的用户数据
     * @return 四个方向的用户数据，按分数从高到低排序，包括昵称
     */
    Map<String,RankDataVo> rankUser();
}
