package com.maven.recruitment.controller;

import com.maven.recruitment.result.Result;
import com.maven.recruitment.service.RankService;
import lombok.extern.slf4j.Slf4j;
import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController

public class RankController {

    @Autowired
    RankService rankService;

    /**
     * 用户排序
     * @return 已排好的各个方向的前十名用户数据，包括用户名，分数和过题数,以及本用户的数据
     */

    @PostMapping("/rank")
    public Result<JSONObject> rank(String userId){
        JSONObject dataRank = rankService.rankUser(userId);
        log.info("controller:获取排序数据");
        log.info("获取排序数据成功");
        return Result.success("获取数据成功",dataRank);
    }

}
