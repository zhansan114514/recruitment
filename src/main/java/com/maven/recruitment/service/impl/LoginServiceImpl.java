package com.maven.recruitment.service.impl;

import com.maven.recruitment.mapper.LoginMapper;
import com.maven.recruitment.pojo.Info.User;
import com.maven.recruitment.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.recruitment.exception.LoginException;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Override
    public User login(User user) {return loginMapper.login(user);}

    @Override
    public void signup(User user) {

        if (user.getUsername() == null
                || user.getPassword() == null
                || user.getPhone() == null) {
            throw new LoginException("注册信息不得为空");
        }

        loginMapper.signup(user);
    }
}
