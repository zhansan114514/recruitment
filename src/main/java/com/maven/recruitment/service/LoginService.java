package com.maven.recruitment.service;


import com.maven.recruitment.pojo.Info.User;

public interface LoginService {
    /**
     * 注册用户信息，
     * 并将其加入数据库。
     * @param user 用户信息
     * */
    User login(User user);

    /**
     * 接受用户名和密码，
     * 将其与数据库中的数据匹配，
     * 匹配成功返回相应信息。
     * @param user 用户信息
     */
    void signup(User user);
}
