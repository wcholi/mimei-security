package com.mimei.exception;

/**
 * @author wuchongliang
 * @create 2019-08-21 19:07:54
 * @description:
 */
public class UserNotExistException extends RuntimeException{

    private Long id;

    public UserNotExistException(Long id) {
        super("user not exist");
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
