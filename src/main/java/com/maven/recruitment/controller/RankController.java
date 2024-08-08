package com.maven.recruitment.controller;


import cn.hutool.json.JSONObject;
import com.maven.recruitment.pojo.vo.RankDataVo;
import com.maven.recruitment.pojo.vo.StatusVo;
import com.maven.recruitment.result.Result;
import com.maven.recruitment.service.RankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class RankController {

    @Autowired
    RankService rankService;

    /**
     * 用户排序
     * @return 已排好的用户数据，包括用户名，分数和过题数
     */
    @GetMapping("/rank")
    public Result<JSONObject> rank(){
        Map<String,RankDataVo> dataRank = rankService.rankUser();
        JSONObject resultRank = new JSONObject(dataRank);
        log.info("controller:获取排序数据");
        log.info("获取排序数据成功");
        return Result.success("获取数据成功",resultRank);
    }

}
