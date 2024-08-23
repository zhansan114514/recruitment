package com.maven.recruitment.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 返回用户答题成绩
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProblemVO implements Serializable {
    private int[] c;
    private int[] java;
    private int[] web;
    private int[] ml;
}
