package com.mimei.controller;

import com.mimei.exception.UserNotExistException;
import org.omg.CORBA.OBJ_ADAPTER;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuchongliang
 * @create 2019-08-21 19:07:09
 * @description:
 */
@ControllerAdvice   // 用于处理异常的类
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)  // 处理UserNotExistException的方法
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> handleUserNotExistException(UserNotExistException exception) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", exception.getId());
        result.put("message", exception.getMessage());
        return result;
    }

}
