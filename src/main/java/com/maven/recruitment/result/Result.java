package com.maven.recruitment.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回的结果类
 * @param<T>>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public static <T>Result<T> success(){
        Result<T> result = new Result<T>();
        result.code = 1;
        result.msg = "成功";
        return result;
    }

    public static <T> Result<T> success(String message){
        Result<T> result = new Result<T>();
        result.code = 200;
        result.msg = message;
        return result;
    }

    public static <T>Result<T> success(T data){

        Result<T> result = new Result<T>();
        result.code = 1;
        result.msg = "成功";
        result.data = data;
        return result;
    }

    public static <T> Result<T> success(String message,T object){
        Result<T> result = new Result<T>();
        result.code = 200;
        result.msg = message;
        result.data = object;
        return result;
    }
    public static <T>Result<T> error(){
        Result<T> result = new Result<T>();
        result.code = 0;
        result.msg = "错误";
        return result;
    }

    public static <T> Result<T> error(String message, Integer code){
        Result<T> result = new Result<T>();
        result.code = code;
        result.msg = message;
        return result;
    }

    public static <T>Result<T> error(T data){
        Result<T> result = new Result<T>();
        result.code = 1;
        result.msg = "错误";
        result.data = data;
        return result;
    }

    public static <T> Result<T> error(String message, Integer code, T object){
        Result<T> result = new Result<T>();
        result.code = code;
        result.msg = message;
        result.data = object;
        return result;
    }

    public static <T> Result<T> error(String message){
        Result<T> result = new Result<T>();
        result.msg = message;
        return result;
    }
}
