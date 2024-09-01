package com.maven.recruitment.mapper;

import com.maven.recruitment.pojo.Info.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {


    /**
     * 登录用户信息
     * @param user 用户信息
     * @return 用户信息
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    User login(User user);

    /**
     * 注册用户信息，
     * @param user 用户信息
     */
    @Insert("insert into user (username, password, email, name, studentid) values(#{username}, #{password}, #{email}, #{name}, #{studentid})")
    void signup(User user);

    @Insert("insert into c方向答题 (studentid, username) values(#{studentid}, #{username})")
    void signupC(User user);

    @Insert("insert into Java方向答题 (studentid, username) values(#{studentid}, #{username})")
    void signupJava(User user);

    @Insert("insert into 机器学习方向答题 (studentid, username) values(#{studentid}, #{username})")
    void signupPython(User user);

    @Insert("insert into 前端方向答题 (studentid, username) values(#{studentid}, #{username})")
    void signupWebsite(User user);

    @Select("select * from user where email = #{email}")
    User selectEmail(String email);
}
