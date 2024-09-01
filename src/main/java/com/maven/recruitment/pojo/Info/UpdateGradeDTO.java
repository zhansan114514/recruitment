package com.maven.recruitment.pojo.Info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGradeDTO {
    String studentid;
    String field;
    Integer id;
    Integer score;
}
