package com.maven.recruitment.controller;

import com.maven.recruitment.Utills.IdUtils;
import com.maven.recruitment.pojo.vo.AllGradeVO;
import com.maven.recruitment.pojo.vo.ProblemVO;
import com.maven.recruitment.result.Result;
import com.maven.recruitment.service.RankService;
import lombok.extern.slf4j.Slf4j;
import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class RankController {

    @Autowired
    RankService rankService;
    @Autowired
    IdUtils idUtils;

    /**
     * 用户排序
     * @return 已排好的各个方向的前十名用户数据，包括用户名，分数和过题数,以及本用户的数据
     */

    @PostMapping("/rank")
    public Result<JSONObject> rank(){
        String userId = idUtils.getStudentid();
        JSONObject dataRank = rankService.rankUser(userId);
        log.info("controller:获取排序数据");
        log.info("获取排序数据成功");
        return Result.success("获取数据成功",dataRank);
    }

    /**
     * 获取当前用户的成绩
     * @return 用户数据
     */
    @GetMapping("/problem")
    public Result<ProblemVO> grade(){
        log.info("获取用户成绩");
        ProblemVO problemVO= rankService.grade();
        log.info("controller:获取用户成绩成功");
        return Result.success("获取用户成绩成功",problemVO);
    }

    /**
     * 获取所有用户的成绩
     */
    @GetMapping Result<AllGradeVO> allGrade(){
        log.info("获取所有用户成绩");
        AllGradeVO allGradeVO=rankService.allGrade();
        log.info("controller:获取所有用户成绩成功");
        return Result.success("获取用户成绩成功",allGradeVO);
    }
}
