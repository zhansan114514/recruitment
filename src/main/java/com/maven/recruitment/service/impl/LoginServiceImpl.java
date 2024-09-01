package com.maven.recruitment.service.impl;

import com.maven.recruitment.exception.MailException;
import com.maven.recruitment.mapper.LoginMapper;
import com.maven.recruitment.pojo.Info.User;
import com.maven.recruitment.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.maven.recruitment.exception.LoginException;

import java.util.Random;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private JavaMailSenderImpl mailSender;
    @Override
    public User login(User user) {return loginMapper.login(user);}

    @Override
    public void signup(User user) {

        if (user.getUsername() == null
                || user.getPassword() == null
                || user.getEmail() == null
                || user.getName() == null) {
            throw new LoginException("注册信息不得为空");
        }
        try {
            loginMapper.signup(user);
            loginMapper.signupC(user);
            loginMapper.signupJava(user);
            loginMapper.signupPython(user);
            loginMapper.signupWebsite(user);
        } catch (Exception e) {
            log.error("用户注册失败");
            throw new LoginException("用户注册失败,请检查学号，用户名等个人信息是否重复qwq");
        }
        log.info("用户注册成功");
    }

    @Override
    public String registerCode(String email) {
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        if (loginMapper.selectEmail(email) != null) {
            throw new MailException("该邮箱已被注册");
        }
        log.info("验证码为:{}", verifyCode);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("微光账号注册");
        mailMessage.setText("您的验证码为:" + verifyCode);
        mailMessage.setTo(email);
        mailMessage.setFrom("1727448271@qq.com");

        try {
            mailSender.send(mailMessage);
            log.info("邮件发送成功");
            return verifyCode;
        } catch (Exception e) {
            log.error("邮件发送失败");
            throw new MailException("邮件发送失败,请检查邮箱地址是否正确qwq");
        }
    }
}
