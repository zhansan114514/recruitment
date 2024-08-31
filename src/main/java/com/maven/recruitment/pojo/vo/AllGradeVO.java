package com.maven.recruitment.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AllGradeVO implements Serializable {
    private String studenid;
    private String name;
    private List<Problem> c,java,web,ml;
    //TODO 数据库中url为空，url应该存储的值为"-1"
    public void setC(String[] url,Integer[] score){
        for(int i=0;i<8;++i){
            if(url[i]==null){
                url[i]="-1";
            }
            c.add(new Problem(url[i],score[i]));
        }
    }
    public void setJava(String[] url,Integer[] score){
        for(int i=0;i<8;++i){
            if(url[i]==null){
                url[i]="-1";
            }
            java.add(new Problem(url[i],score[i]));
        }
    }
    public void setWeb(String[] url,Integer[] score){
        for(int i=0;i<8;++i){
            if(url[i]==null){
                url[i]="-1";
            }
            web.add(new Problem(url[i],score[i]));
        }
    }
    public void setMl(String[] url,Integer[] score){
        for(int i=0;i<8;++i){
            if(url[i]==null){
                url[i]="-1";
            }
            ml.add(new Problem(url[i],score[i]));
        }
    }
}
@AllArgsConstructor
class Problem{
    public String url="-1";
    public int score=-1;

    Problem(){
        url="-1";
        score=-1;
    }
}