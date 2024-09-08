package com.maven.recruitment.service.impl;

import com.maven.recruitment.Utills.IdUtils;
import com.maven.recruitment.constant.SQL;
import com.maven.recruitment.exception.SearchException;
import com.maven.recruitment.exception.UpdateException;
import com.maven.recruitment.mapper.CorrectingMapper;
import com.maven.recruitment.mapper.RankMapper;
import com.maven.recruitment.pojo.Info.*;
import com.maven.recruitment.service.CorrectingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class CorrectingServiceImpl implements CorrectingService {

    @Autowired
    private CorrectingMapper correctingMapper;
    @Autowired
    private RankMapper rankMapper;
    @Autowired
    IdUtils idUtils;

    @Override
    public List<Cdata> CCorrectingService() {
        log.info("service: 展示cdata表中的数据");
        try {
            return correctingMapper.selectCdata();
        } catch (Exception e) {
            log.error("service: 展示cdata表中的数据失败");
            throw new SearchException("展示cdata表中的数据失败");
        }
    }

    @Override
    public void CCorrectingService(Cdata cdata) {
        log.info("service: 更新cdata表中的数据");
        try {
            correctingMapper.insertCdata(cdata);
        } catch (Exception e) {
            log.error("service: 更新cdata表中的数据失败",e);
            throw new UpdateException("更新cdata表中的数据失败");
        }
    }

    @Override
    public List<Javadata> JavaCorrectingService() {
        log.info("service: 展示javadata表中的数据");
        try {
            return correctingMapper.selectJavadata();
        } catch (Exception e) {
            log.error("service: 展示javadata表中的数据失败");
            throw new SearchException("展示javadata表中的数据失败");
        }
    }

    @Override
    public void JavaCorrectingService(Javadata javadata) {
        log.info("service: 更新javadata表中的数据");
        try {
            correctingMapper.insertJavadata(javadata);
        } catch (Exception e) {
            log.error("service: 更新javadata表中的数据失败");
            throw new UpdateException("更新javadata表中的数据失败");
        }
    }

    @Override
    public List<Pythondata> PythonCorrectingService() {
        log.info("service: 展示pythondata表中的数据");
        try {
            return correctingMapper.selectPythondata();
        } catch (Exception e) {
            log.error("service: 展示pythondata表中的数据失败");
            throw new SearchException("展示pythondata表中的数据失败");
        }
    }

    @Override
    public void PythonCorrectingService(Pythondata pythondata) {
        log.info("service: 更新pythondata表中的数据");
        try {
            correctingMapper.insertPythondata(pythondata);
        } catch (Exception e) {
            log.error("service: 更新pythondata表中的数据失败");
            throw new UpdateException("更新pythondata表中的数据失败");
        }
    }

    @Override
    public List<Websitedata> WebsiteCorrectingService() {
        log.info("service: 展示websitedata表中的数据");
        try {
            return correctingMapper.selectWebsitedata();
        } catch (Exception e) {
            log.error("service: 展示websitedata表中的数据失败");
            throw new SearchException("展示websitedata表中的数据失败");
        }
    }

    @Override
    public void WebsiteCorrectingService(Websitedata websitedata) {
        log.info("service: 更新websitedata表中的数据");
        try {
            correctingMapper.insertWebsitedata(websitedata);
        } catch (Exception e) {
            log.error("service: 更新websitedata表中的数据失败");
            throw new UpdateException("更新websitedata表中的数据失败");
        }
    }

    @Override
    public void submit(submitDTO dto) {
        log.info("service: 提交题解链接");
        dto.setStudentId(idUtils.getStudentid());


        if(Objects.equals(dto.getField(), "c")){
            dto.setField(SQL.C_TABLE);
        }
        else if(Objects.equals(dto.getField(), "java")){
            dto.setField(SQL.JAVA_TABLE);
        }
        else if(Objects.equals(dto.getField(), "web")){
            dto.setField(SQL.WEB_TABLE);
        }
        else if(Objects.equals(dto.getField(), "ml")){
            dto.setField(SQL.ML_TABLE);
        }

        //把分数置为0，表示已提交，未批改
        //TODO 对于历史分数的处理
        correctingMapper.updateScore(dto.getStudentId(),dto.getField(),dto.getId(),0);
        correctingMapper.insertURL(dto);
    }

    @Override
    public void updateGrade(UpdateGradeDTO dto) {
        if(dto.getField().equals("c")){
            dto.setField(SQL.C_TABLE);
        }
        else if(dto.getField().equals("java")){
            dto.setField(SQL.JAVA_TABLE);
        }
        else if(dto.getField().equals("web")){
            dto.setField(SQL.WEB_TABLE);
        }
        else if(dto.getField().equals("ml")){
            dto.setField(SQL.ML_TABLE);
        }
        correctingMapper.updateScore(dto.getStudentid(),dto.getField(),dto.getId(),dto.getScore());
        List<Integer> list = rankMapper.selectGrade(dto.getStudentid(), dto.getField()).toScoreList();
        int total_score = 0,tests=0;
        for (int score : list) {
            if (score >= 0) {
                total_score += score;
                tests++;
            }
        }
        correctingMapper.updateTotalScore(dto.getStudentid(), dto.getField(),tests, total_score);

    }
}
