package com.suspringboot.frame.community.dto;

import com.suspringboot.frame.community.exception.CustomizeEerrorCode;
import lombok.Data;

@Data
public class ResultDTO {
    private Integer code;
    private String message;
    public static ResultDTO errorof(Integer code,String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return  resultDTO;
    }


    public static ResultDTO errorof(CustomizeEerrorCode noLogin) {
        return errorof(noLogin.getCode(),noLogin.getMessage());
    }
}
