package com.du.car.common.exception;

/**
 * @program: carsys
 * @description: 用户自定义异常
 * @author: You毒
 * @create: 2019-12-10 16:44
 **/
public class UserException extends Exception {
    public UserException() {
        super();
    }
    public UserException(String msg) {
        super(msg);
    }
}
