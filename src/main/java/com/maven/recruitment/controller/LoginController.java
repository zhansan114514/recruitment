package com.maven.recruitment.controller;

import com.maven.recruitment.Utills.JwtUtils;
import com.maven.recruitment.pojo.Info.User;
import com.maven.recruitment.pojo.vo.StatusVo;
import com.maven.recruitment.result.Result;
import com.maven.recruitment.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 用户登录,下发jwt令牌
     */
    @PostMapping("/login")
    public Result<StatusVo> login(@RequestBody User user) {
        log.info("用户登录:{}", user);
        User data = loginService.login(user);

        //登录成功，下发令牌
        if (data != null) {
            Map<String, Object> claims = new HashMap<>();

            claims.put("username", user.getUsername());
            claims.put("password", user.getPassword());
            claims.put("name", user.getName());

            String jwt = JwtUtils.generateJwt(claims);
            StatusVo statusVo = StatusVo.builder()
                    .status(1)
                    .message(jwt)
                    .build();
            return Result.success("登录成功", statusVo);
        }
        log.info("用户名或密码错误,登录失败");
        //登录失败
        StatusVo statusVo = StatusVo.builder()
                .status(0)
                .message("用户名或密码错误,登录失败")
                .build();
        return Result.error(statusVo);
    }
    /**
     * 用户注册
     */
    @PostMapping("/signup")
    public Result<StatusVo> signup(@RequestBody User user) {
        log.info("用户注册:{}", user);
        loginService.signup(user);
        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("注册成功")
                .build();
        return Result.success("成功",statusVo);
    }

}
