package com.maven.recruitment.controller;

import com.maven.recruitment.pojo.Info.*;
import com.maven.recruitment.pojo.vo.StatusVo;
import com.maven.recruitment.result.Result;
import com.maven.recruitment.service.CorrectingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CorrectingController {

    @Autowired
    CorrectingService correctingService;

    /**
     * 获取数据
     * @return cdata中的数据
     */
    @PostMapping("/correcting/c/getData")
    public Result<StatusVo> getData() {
        log.info("controller:获取数据");
        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message(correctingService.CCorrectingService().toString())
                .build();
        log.info("获取数据成功");
        return Result.success("获取数据成功", statusVo);
    }

    /**
     * 修改数据
     * @param cdata 修改的数据
     * @return 修改数据成功
     */
    @PostMapping("/correcting/c/updateData")
    public Result<StatusVo> updateData(@RequestBody Cdata cdata) {
        log.info("controller:修改数据");
        correctingService.CCorrectingService(cdata);
        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("修改数据成功")
                .build();
        log.info("修改数据成功");
        return Result.success("修改数据成功", statusVo);
    }

    /**
     * 获取数据
     * @return javadata中的数据
     */
    @PostMapping("/correcting/java/getData")
    public Result<StatusVo> getJavaData() {
        log.info("controller:获取数据");
        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message(correctingService.JavaCorrectingService().toString())
                .build();
        log.info("获取数据成功");
        return Result.success("获取数据成功", statusVo);
    }

    /**
     * 修改数据
     * @param javadata 修改的数据
     * @return 修改数据成功
     */
    @PostMapping("/correcting/java/updateData")
    public Result<StatusVo> updateJavaData(@RequestBody Javadata javadata) {
        log.info("controller:修改数据");
        correctingService.JavaCorrectingService(javadata);
        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("修改数据成功")
                .build();
        log.info("修改数据成功");
        return Result.success("修改数据成功", statusVo);
    }

    /**
     * 获取数据
     * @return pythondata中的数据
     */
    @PostMapping("/correcting/python/getData")
    public Result<StatusVo> getPythonData() {
        log.info("controller:获取数据");
        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message(correctingService.PythonCorrectingService().toString())
                .build();
        log.info("获取数据成功");
        return Result.success("获取数据成功", statusVo);
    }

    /**
     * 修改数据
     * @param pythondata 修改的数据
     * @return 修改数据成功
     */
    @PostMapping("/correcting/python/updateData")
    public Result<StatusVo> updatePythonData(@RequestBody Pythondata pythondata) {
        log.info("controller:修改数据");
        correctingService.PythonCorrectingService(pythondata);
        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("修改数据成功")
                .build();
        log.info("修改数据成功");
        return Result.success("修改数据成功", statusVo);
    }

    /**
     * 获取数据
     * @return websitedata中的数据
     */
    @PostMapping("/correcting/website/getData")
    public Result<StatusVo> getWebsiteData() {
        log.info("controller:获取数据");
        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message(correctingService.WebsiteCorrectingService().toString())
                .build();
        log.info("获取数据成功");
        return Result.success("获取数据成功", statusVo);
    }

    /**
     * 修改数据
     * @param websitedata 修改的数据
     * @return 修改数据成功
     */
    @PostMapping("/correcting/website/updateData")
    public Result<StatusVo> updateWebsiteData(@RequestBody Websitedata websitedata) {
        log.info("controller:修改数据");
        correctingService.WebsiteCorrectingService(websitedata);
        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("修改数据成功")
                .build();
        log.info("修改数据成功");
        return Result.success("修改数据成功", statusVo);
    }

    @PostMapping("/problem")
    public Result<StatusVo> submit(@RequestBody submitDTO dto){
        log.info("controller:提交答案");
        correctingService.submit(dto);
        StatusVo statusVo=StatusVo.builder()
                .status(1)
                .message("提交链接成功")
                .build();
        return Result.success("提交链接成功",statusVo);
    }
}
