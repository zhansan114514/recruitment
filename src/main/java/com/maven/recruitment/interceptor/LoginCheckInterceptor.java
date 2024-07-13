package com.maven.recruitment.interceptor;


import com.maven.recruitment.Utills.JwtUtils;
import com.maven.recruitment.result.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import static com.maven.recruitment.constant.HttpStatusConstant.BAD_REQUEST;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

        //获取令牌
        String jwt = req.getHeader("token");

        //无令牌显示未登录
        if(!StringUtils.hasLength((jwt))){
            log.info("请求头为空，返回未登录的信息");
            Result<String> error = Result.error("Not_LOGIN",BAD_REQUEST,"未登录");
            resp.getWriter().write(error.toString());
            return false;
        }

        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析失败");
            Result<String> error = Result.error("Not_LOGIN",BAD_REQUEST,"未登录");
            resp.getWriter().write(error.toString());
            return false;
        }

        log.info("令牌合法，放行");
        return true;
    }
}
