package com.maven.recruitment.service.impl;

import com.maven.recruitment.exception.RankException;
import com.maven.recruitment.mapper.RankMapper;
import com.maven.recruitment.pojo.Info.Cdata;
import com.maven.recruitment.pojo.Info.Javadata;
import com.maven.recruitment.pojo.Info.Pythondata;
import com.maven.recruitment.pojo.Info.Websitedata;
import com.maven.recruitment.pojo.vo.RankDataVo;
import com.maven.recruitment.service.RankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RankMapper rankMapper;

    @Override
    public RankDataVo rankC(){
        log.info("service: cdata表中的数据排序");
        try {
            List<Cdata> rankList=rankMapper.rankUserByC();
            int size=rankList.size();
            String[] names = new String[size];
            String[] points = new String[size];
            int[] tests = new int[size];
            for (int i = 0; i < size ; i++) {
                Cdata cdata = rankList.get(i);
                names[i]=cdata.getUsername();
                points[i]=cdata.getTotal_score();
                tests[i]=cdata.getTests();
            }
            int amount = rankMapper.countUserByC();
            return new RankDataVo(names,points,tests, amount);
        } catch (Exception e) {
            // 处理异常，简单地返回错误信息
            log.error("service:c方向用户数据排序失败", e);
            throw new RankException("c方向用户数据排序失败");
        }
    }

    @Override
    public RankDataVo rankJava(){
        try {
            log.info("service: Javadata表中的数据排序");
            List<Javadata> rankList=rankMapper.rankUserByJava();
            int size=rankList.size();
            String[] names = new String[size];
            String[] points = new String[size];
            int[] tests = new int[size];
            for (int i = 0; i <  size; i++) {
                Javadata javadata = rankList.get(i);
                names[i]=javadata.getUsername();
                points[i]=javadata.getTotal_score();
                tests[i]=javadata.getTests();
            }
            int amount = rankMapper.countUserByC();
            return new RankDataVo(names,points,tests, amount);
        } catch (Exception e) {
            // 处理异常，简单地返回错误信息
            log.error("service:java方向用户数据排序失败", e);
            throw new RankException("java方向用户数据排序失败");
        }
    }

    @Override
    public RankDataVo rankPython(){
        try {
            log.info("service: Pythondata表中的数据排序");
            List<Pythondata> rankList=rankMapper.rankUserByPython();
            int size=rankList.size();
            String[] names = new String[size];
            String[] points = new String[size];
            int[] tests = new int[size];
            for (int i = 0; i <  size; i++) {
                Pythondata pythondata = rankList.get(i);
                names[i]=pythondata.getUsername();
                points[i]=pythondata.getTotal_score();
                tests[i]=pythondata.getTests();
            }
            int amount = rankMapper.countUserByPython();
            return new RankDataVo(names,points,tests, amount);
        } catch (Exception e) {
            // 处理异常，简单地返回错误信息
            log.error("service:Python方向用户数据排序失败", e);
            throw new RankException("Python方向用户数据排序失败");
        }
    }

    @Override
    public RankDataVo rankWebsite(){
        try {
            log.info("service: Website表中的数据排序");
            List<Websitedata> rankList=rankMapper.rankUserByWebsite();
            int size=rankList.size();
            String[] names = new String[size];
            String[] points = new String[size];
            int[] tests = new int[size];
            for (int i = 0; i <  rankList.size(); i++) {
                Websitedata websitedata = rankList.get(i);
                names[i]=websitedata.getUsername();
                points[i]=websitedata.getTotal_score();
                tests[i]=websitedata.getTests();
            }
            int amount = rankMapper.countUserByWebsite();
            return new RankDataVo(names,points,tests, amount);
        } catch (Exception e) {
            // 处理异常，简单地返回错误信息
            log.error("service:Website方向用户数据排序失败", e);
            throw new RankException("Website方向用户数据排序失败");
        }
    }

    public Map<String,RankDataVo> rankUser(){
         Map<String,RankDataVo> dataMap =new HashMap<>();
            dataMap.put("C", rankC());
            dataMap.put("AI", rankPython());
            dataMap.put("FrontEnd", rankJava());
            dataMap.put("BackEnd", rankWebsite());
            return dataMap;
    }
}
