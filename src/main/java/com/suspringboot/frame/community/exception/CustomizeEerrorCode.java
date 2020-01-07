package com.suspringboot.frame.community.exception;

public enum CustomizeEerrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND("你找的问题不在啦 ，要不换个试试");
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    CustomizeEerrorCode(String message) {
        this.message = message;
    }
}


