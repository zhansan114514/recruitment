package com.maven.recruitment.mapper;

import com.maven.recruitment.pojo.Info.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {


    @Select("select * from user where username = #{username} and password = #{password}")
    User login(User user);

    /**
     * 注册用户信息，
     * @param user 用户信息
     */
    @Insert("insert into user(username, password, email, phone, name, StudentID) values(#{username}, #{password}, #{email}, #{phone}, #{name}, #{StudentID})")
    void signup(User user);
}
