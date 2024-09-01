package com.maven.recruitment.pojo.Info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    private int score1,score2,score3,score4,score5,score6,score7,score8,score9,score10,score11,score12;
    private String question1,question2,question3,question4,question5,question6,question7,question8,question9,question10,question11,question12;

    public List<Integer> toScoreList(){
        List<Integer> list=new ArrayList<>();
        list.add(score1);
        list.add(score2);
        list.add(score3);
        list.add(score4);
        list.add(score5);
        list.add(score6);
        list.add(score7);
        list.add(score8);
        list.add(score9);
        list.add(score10);
        list.add(score11);
        list.add(score12);

        return list;
    }
    public List<String> toUrlList(){
        List<String> list=new ArrayList<>();
        list.add(question1);
        list.add(question2);
        list.add(question3);
        list.add(question4);
        list.add(question5);
        list.add(question6);
        list.add(question7);
        list.add(question8);
        list.add(question9);
        list.add(question10);
        list.add(question11);
        list.add(question12);

        return list;
    }
}
