package com.maven.recruitment.handler;

import com.maven.recruitment.exception.*;
import com.maven.recruitment.pojo.vo.StatusVo;
import com.maven.recruitment.result.Result;
import com.maven.recruitment.constant.HttpStatusConstant;
import com.maven.recruitment.constant.MessageConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类,处理业务抛出的异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity exceptionHandler(BaseException ex){
        //处理上传信息填写失败异常
        if(ex instanceof UpdateException){
            log.info("信息上传失败:{}",ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.UPDATE_ERROR, HttpStatusConstant.BAD_REQUEST, statusVo), HttpStatus.BAD_REQUEST);
        } else if (ex instanceof LoginException) {
            log.info("登录或注册失败:{}",ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.ADD_ERROR, HttpStatusConstant.BAD_REQUEST, statusVo), HttpStatus.BAD_REQUEST);
        } else if (ex instanceof SearchException) {
            log.info("查找数据失败:{}",ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.SEARCH_ERROR, HttpStatusConstant.BAD_REQUEST, statusVo), HttpStatus.BAD_REQUEST);
        } else if (ex instanceof MailException) {
            log.info("邮件发送失败:{}",ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.MAIL_ERROR, HttpStatusConstant.BAD_REQUEST, statusVo), HttpStatus.BAD_REQUEST);
        }
        else if (ex instanceof RankException) {
            log.info("用户数据排序失败:{}",ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.Rank_ERROR, HttpStatusConstant.BAD_REQUEST, statusVo), HttpStatus.BAD_REQUEST);
        }

        //其他业务异常
        log.info("异常信息:{}",ex.getMessage());
        StatusVo statusVo = StatusVo.builder()
                .status(0)
                .message(ex.getMessage())
                .build();
        return new ResponseEntity(Result.error(ex.getMessage(),HttpStatusConstant.SERVICE_UNAVAILABLE,statusVo),HttpStatus.SERVICE_UNAVAILABLE);
    }

}
