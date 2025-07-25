package com.maven.recruitment.pojo.vo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 各个方向用户排序数据的模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RankDataVo implements Serializable {
    private String[] name;
    private int[] point;
    private int[] test;
    private int how_many;
    private int amount;
}
