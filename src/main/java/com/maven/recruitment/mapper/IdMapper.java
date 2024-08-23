package com.maven.recruitment.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IdMapper {

    /**
     * 通过用户名和密码查询学生id
     * @param username 用户名
     * @param password 密码
     * @return 学生id
     */
    @Select("select studentid from user where username = #{username} and password = #{password}")
    String selectId(String username,String password);

    @Select("select name from user where studentid = #{id}")
    String selectName(String id);
}
