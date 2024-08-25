package com.maven.recruitment.service.impl;

import cn.hutool.json.JSONObject;
import com.maven.recruitment.Utills.IdUtils;
import com.maven.recruitment.exception.RankException;
import com.maven.recruitment.mapper.IdMapper;
import com.maven.recruitment.mapper.RankMapper;
import com.maven.recruitment.pojo.Info.Cdata;
import com.maven.recruitment.pojo.Info.Javadata;
import com.maven.recruitment.pojo.Info.Pythondata;
import com.maven.recruitment.pojo.Info.Websitedata;
import com.maven.recruitment.pojo.vo.AllGradeVO;
import com.maven.recruitment.pojo.vo.ProblemVO;
import com.maven.recruitment.pojo.vo.RankDataVo;
import com.maven.recruitment.pojo.vo.SelfGradeVo;
import com.maven.recruitment.service.RankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Slf4j
@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RankMapper rankMapper;
    @Autowired
    IdUtils idUtils;
    @Autowired
    private IdMapper idMapper;

    /*定义SelfGradeVo以存储用户个人数据 */
    SelfGradeVo dataSelf =new SelfGradeVo();
    int[] place=new int[4];
    int[] point=new int[4];
    int[] test=new int[4];
    int how_many=10;

    @Override
    public RankDataVo rankC(String userId){
        log.info("service: cdata表中的数据排序");
        try {
            List<Cdata> rankList=rankMapper.rankUserByC();
            int size=rankList.size();
            String[] names = new String[how_many];
            int[] points = new int[how_many];
            int[] tests = new int[how_many];
            for (int i = 0; i < size ; i++) {
                Cdata cdata = rankList.get(i);
                //获取c方向前十名用户数据
                if(i<how_many){
                    names[i]=cdata.getUsername();
                    points[i]=cdata.getTotalscore();
                    tests[i]=cdata.getTests();
                }
                //获取当前用户数据
                if(Objects.equals(userId, cdata.getStudentid())){
                    place[0]=i+1;
                    point[0]=cdata.getTotalscore();
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
            int[] points = new int[how_many];
            int[] tests = new int[how_many];
            for (int i = 0; i < size ; i++) {
                Pythondata pythondata = rankList.get(i);
                if(i<how_many){
                    names[i]=pythondata.getUsername();
                    points[i]=pythondata.getTotalscore();
                    tests[i]=pythondata.getTests();
                }
                if(Objects.equals(userId, pythondata.getStudentid())){

                    place[1]=i+1;
                    point[1]=pythondata.getTotalscore();
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
            int[] points = new int[how_many];
            int[] tests = new int[how_many];
            for (int i = 0; i < size ; i++) {
                Websitedata websitedata = rankList.get(i);
                if(i<how_many){
                    names[i]=websitedata.getUsername();
                    points[i]=websitedata.getTotalscore();
                    tests[i]=websitedata.getTests();
                }
                if(Objects.equals(userId, websitedata.getStudentid())){
                    place[2]=i+1;
                    point[2]=websitedata.getTotalscore();
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
            int[] points = new int[how_many];
            int[] tests = new int[how_many];
            for (int i = 0; i < size ; i++) {
                Javadata javadata = rankList.get(i);
                if(i<how_many){
                    names[i]=javadata.getUsername();
                    points[i]=javadata.getTotalscore();
                    tests[i]=javadata.getTests();
                }
                if(Objects.equals(userId,javadata.getStudentid())){
                    place[3]=i+1;
                    point[3]=javadata.getTotalscore();
                    test[3]=javadata.getTests();
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
        Map<String,JSONObject> dataMap =new LinkedHashMap<>();
            dataMap.put("cs",new JSONObject(rankC(userId)));
            dataMap.put("ai",new JSONObject(rankPython(userId)));
            dataMap.put("fr",new JSONObject(rankWebsite(userId)));
            dataMap.put("ba",new JSONObject(rankJava(userId)));
            dataSelf.setPlace(place);
            dataSelf.setTest(test);
            dataSelf.setPoint(point);
            dataSelf.setName(rankMapper.selectName(userId));
            dataMap.put("self",new JSONObject(dataSelf));
            return new JSONObject(dataMap);
    }

    /**
     * 返回用户成绩
     * @return
     */
    @Override
    public ProblemVO grade() {
//        int[] c=new int[8];
//        int[] java=new int[11];
//        int[] web=new int[10];
//        int[] ml=new int[10];
        List<Integer> c,java,web,ml;
        c=rankMapper.selectGrade(idUtils.getStudentid(),"c方向答题");

        java=rankMapper.selectGrade(idUtils.getStudentid(),"java方向答题");

        web=rankMapper.selectGrade(idUtils.getStudentid(),"前端方向答题");


        ml=rankMapper.selectGrade(idUtils.getStudentid(),"机器学习方向答题");

        return new ProblemVO(c,java,web,ml);
    }

    @Override
    public AllGradeVO allGrade() {
        AllGradeVO allGradeVO=new AllGradeVO();
        allGradeVO.setStudenid(idUtils.getStudentid());
        allGradeVO.setName(idMapper.selectName(idUtils.getStudentid()));

        List<Integer> grade = rankMapper.selectGrade(allGradeVO.getStudenid(),"c方向答题");
        List<String> url= rankMapper.selectUrl(allGradeVO.getStudenid(),"c方向答题");
        allGradeVO.setC(url.toArray(new String[url.size()]),grade.toArray(new Integer[grade.size()]));

        grade = rankMapper.selectGrade(allGradeVO.getStudenid(),"java方向答题");
        url= rankMapper.selectUrl(allGradeVO.getStudenid(),"java方向答题");
        allGradeVO.setJava(url.toArray(new String[url.size()]),grade.toArray(new Integer[grade.size()]));

        grade = rankMapper.selectGrade(allGradeVO.getStudenid(),"前端方向答题");
        url= rankMapper.selectUrl(allGradeVO.getStudenid(),"前端方向答题");
        allGradeVO.setWeb(url.toArray(new String[url.size()]),grade.toArray(new Integer[grade.size()]));

        grade = rankMapper.selectGrade(allGradeVO.getStudenid(),"机器学习方向答题");
        url= rankMapper.selectUrl(allGradeVO.getStudenid(),"机器学习方向答题");
        allGradeVO.setMl(url.toArray(new String[url.size()]),grade.toArray(new Integer[grade.size()]));

        return allGradeVO;
    }
}
