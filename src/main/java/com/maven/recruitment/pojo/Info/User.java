package com.maven.recruitment.pojo.Info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String StudentID;
}
