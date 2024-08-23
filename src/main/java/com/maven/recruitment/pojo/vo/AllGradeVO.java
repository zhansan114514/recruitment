package com.maven.recruitment.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder

public class AllGradeVO implements Serializable {
    private String studenid;
    private String name;
    private Problem[] c,java,web,ml;

    public void setC(String[] url,Integer[] score){
        for(int i=0;i<8;++i){
            c[i].score=score[i];
            if(url[i]!=null){
                c[i].url=url[i];
            }
        }
    }
    public void setJava(String[] url,Integer[] score){
        for(int i=0;i<8;++i){
            java[i].score=score[i];
            if(url[i]!=null){
                java[i].url=url[i];
            }
        }
    }
    public void setWeb(String[] url,Integer[] score){
        for(int i=0;i<8;++i){
            web[i].score=score[i];
            if(url[i]!=null){
                web[i].url=url[i];
            }
        }
    }
    public void setMl(String[] url,Integer[] score){
        for(int i=0;i<8;++i){
            ml[i].score=score[i];
            if(url[i]!=null){
                ml[i].url=url[i];
            }
        }
    }
    public AllGradeVO(){
        c=new Problem[8];
        java=new Problem[11];
        web=new Problem[10];
        ml=new Problem[10];
    }
}
class Problem{
    public String url;
    public int score;

    Problem(){
        url="-1";
        score=-1;

    }
}