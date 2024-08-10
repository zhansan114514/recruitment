package com.maven.recruitment.service.impl;

import cn.hutool.json.JSONObject;
import com.maven.recruitment.exception.RankException;
import com.maven.recruitment.mapper.RankMapper;
import com.maven.recruitment.pojo.Info.Cdata;
import com.maven.recruitment.pojo.Info.Javadata;
import com.maven.recruitment.pojo.Info.Pythondata;
import com.maven.recruitment.pojo.Info.Websitedata;
import com.maven.recruitment.pojo.vo.RankDataVo;
import com.maven.recruitment.pojo.vo.SelfGradeVo;
import com.maven.recruitment.service.RankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Slf4j
@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RankMapper rankMapper;

    /*定义SelfGradeVo以存储用户个人数据 */
    SelfGradeVo dataSelf =new SelfGradeVo();
    int[] place;
    String[] point;
    int[] test;
    int how_many=10;

    @Override
    public RankDataVo rankC(String userId){
        log.info("service: cdata表中的数据排序");
        try {
            List<Cdata> rankList=rankMapper.rankUserByC();
            int size=rankList.size();
            String[] names = new String[how_many];
            String[] points = new String[how_many];
            int[] tests = new int[how_many];
            for (int i = 0; i < size ; i++) {
                Cdata cdata = rankList.get(i);
                //获取c方向前十名用户数据
                if(i<how_many){
                    names[i]=cdata.getUsername();
                    points[i]=cdata.getTotal_score();
                    tests[i]=cdata.getTests();
                }
                //获取当前用户数据
                if(Objects.equals(userId, cdata.getStudentid())){
                    dataSelf.setName(cdata.getName());
                    place[0]=i+1;
                    point[0]=cdata.getTotal_score();
                    test[0]=cdata.getTests();
                }
            }
            int amount = rankMapper.countUserByC();
            if(size>how_many){
                size=how_many;
            }
            return new RankDataVo(names,points,tests,size,amount);
        } catch (Exception e) {
            // 处理异常，简单地返回错误信息
            log.error("service:c方向用户数据排序失败", e);
            throw new RankException("c方向用户数据排序失败");
        }
    }

    @Override
    public RankDataVo rankPython(String userId){
        log.info("service: pythondata表中的数据排序");
        try {
            List<Pythondata> rankList=rankMapper.rankUserByPython();
            int size=rankList.size();
            String[] names = new String[how_many];
            String[] points = new String[how_many];
            int[] tests = new int[how_many];
            for (int i = 0; i < size ; i++) {
                Pythondata pythondata = rankList.get(i);
                if(i<how_many){
                    names[i]=pythondata.getUsername();
                    points[i]=pythondata.getTotal_score();
                    tests[i]=pythondata.getTests();
                }
                if(Objects.equals(userId, pythondata.getStudentid())){
                    dataSelf.setName(pythondata.getName());
                    place[1]=i+1;
                    point[1]=pythondata.getTotal_score();
                    test[1]=pythondata.getTests();
                }
            }
            int amount = rankMapper.countUserByPython();
            if(size>how_many){
                size=how_many;
            }
            return new RankDataVo(names,points,tests,size,amount);
        } catch (Exception e) {
            // 处理异常，简单地返回错误信息
            log.error("service:机器学习方向用户数据排序失败", e);
            throw new RankException("机器学习方向用户数据排序失败");
        }
    }

    @Override
    public RankDataVo rankWebsite(String userId){
        log.info("service: websitedata表中的数据排序");
        try {
            List<Websitedata> rankList=rankMapper.rankUserByWebsite();
            int size=rankList.size();
            String[] names = new String[how_many];
            String[] points = new String[how_many];
            int[] tests = new int[how_many];
            for (int i = 0; i < size ; i++) {
                Websitedata websitedata = rankList.get(i);
                if(i<how_many){
                    names[i]=websitedata.getUsername();
                    points[i]=websitedata.getTotal_score();
                    tests[i]=websitedata.getTests();
                }
                if(Objects.equals(userId, websitedata.getStudentid())){
                    dataSelf.setName(websitedata.getName());
                    place[2]=i+1;
                    point[2]=websitedata.getTotal_score();
                    test[2]=websitedata.getTests();
                }
            }
            int amount = rankMapper.countUserByWebsite();
            if(size>how_many){
                size=how_many;
            }
            return new RankDataVo(names,points,tests,size,amount);
        } catch (Exception e) {
            // 处理异常，简单地返回错误信息
            log.error("service:前端方向用户数据排序失败", e);
            throw new RankException("前端方向用户数据排序失败");
        }
    }

    @Override
    public RankDataVo rankJava(String userId){
        log.info("service: javadata表中的数据排序");
        try {
            List<Javadata> rankList=rankMapper.rankUserByJava();
            int size=rankList.size();
            String[] names = new String[how_many];
            String[] points = new String[how_many];
            int[] tests = new int[how_many];
            for (int i = 0; i < size ; i++) {
                Javadata javadata = rankList.get(i);
                if(i<how_many){
                    names[i]=javadata.getUsername();
                    points[i]=javadata.getTotal_score();
                    tests[i]=javadata.getTests();
                }
                if(Objects.equals(userId,javadata.getStudentid())){
                    dataSelf.setName(javadata.getName());
                    place[2]=i+1;
                    point[2]=javadata.getTotal_score();
                    test[2]=javadata.getTests();
                }
            }
            int amount = rankMapper.countUserByJava();
            if(size>how_many){
                size=how_many;
            }
            return new RankDataVo(names,points,tests,size,amount);
        } catch (Exception e) {
            // 处理异常，简单地返回错误信息
            log.error("service:后端方向用户数据排序失败", e);
            throw new RankException("后端方向用户数据排序失败");
        }
    }

    public JSONObject rankUser(String userId){
        Map<String,Object> dataMap =new HashMap<>();
            dataMap.put("cs", rankC(userId));
            dataMap.put("ai", rankPython(userId));
            dataMap.put("fr", rankWebsite(userId));
            dataMap.put("ba", rankJava(userId));
            dataMap.put("self", dataSelf);
            return new JSONObject(dataMap);
    }


}
