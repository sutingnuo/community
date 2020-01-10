package com.suspringboot.frame.community.exception;

public enum CustomizeEerrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"你找的问题不在啦 ，要不换个试试"),
    TAGET_PAPAM_NOT_FOUND(2002,"未选中任何评论或问题进行回复"),
    NO_LOGIN(2003,"未登录不能进行评论，请先登录"),
    SYS_ERROR(2004,"服务器冒烟了，要不你刷新试试"),
    TYPE_PAPAM_WRONG(2005,"评论类型错误或不存在");
    private String message;
    private Integer code;
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeEerrorCode( Integer code,String message) {
        this.message = message;
        this.code = code;
    }
}


