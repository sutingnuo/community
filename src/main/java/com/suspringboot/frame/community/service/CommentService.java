package com.suspringboot.frame.community.service;

import com.suspringboot.frame.community.enums.CommentTypeEnum;
import com.suspringboot.frame.community.exception.CustomizeEerrorCode;
import com.suspringboot.frame.community.exception.CustomizeException;

import com.suspringboot.frame.community.model.Comment;

public class CommentService {
    public void insert(Comment comment) {
        if(comment.getParent_id()==null||comment.getParent_id()==0){
            throw new CustomizeException(CustomizeEerrorCode.TAGET_PAPAM_NOT_FOUND);
        }
        if (comment.getCom_type()==null|| CommentTypeEnum.isExist(comment.getCom_type())){
            throw new CustomizeException(CustomizeEerrorCode.TYPE_PAPAM_WRONG);

        }
    }
}
