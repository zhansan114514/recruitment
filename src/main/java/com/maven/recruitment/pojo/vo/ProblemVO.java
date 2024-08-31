package com.maven.recruitment.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

/**
 * 返回用户答题成绩
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProblemVO implements Serializable {
    private List<Integer> c,java,web,ml;
}
