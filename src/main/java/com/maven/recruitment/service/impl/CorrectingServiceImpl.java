package com.maven.recruitment.service.impl;

import com.maven.recruitment.Utills.IdUtils;
import com.maven.recruitment.exception.SearchException;
import com.maven.recruitment.exception.UpdateException;
import com.maven.recruitment.mapper.CorrectingMapper;
import com.maven.recruitment.pojo.Info.*;
import com.maven.recruitment.service.CorrectingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CorrectingServiceImpl implements CorrectingService {

    @Autowired
    private CorrectingMapper correctingMapper;
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
        log.info("service: 提交链接");
        dto.setStudentId(idUtils.getStudentid());


        if(dto.getField()=="c"){
            dto.setField("c方向答题");
        }
        else if(dto.getField()=="java"){
            dto.setField("java方向答题");
        }
        else if(dto.getField()=="web"){
            dto.setField("前端方向答题");
        }
        else if(dto.getField()=="ml"){
            dto.setField("机器学习方向答题");
        }

        //把分数置为0，表示已提交，未批改
        correctingMapper.updateScore(dto.getStudentId(),dto.getField(),dto.getId(),0);
        correctingMapper.insertURL(dto);
    }
}
