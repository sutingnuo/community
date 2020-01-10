package com.suspringboot.frame.community.dto;

import com.suspringboot.frame.community.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private long gmt_create;
    private long gmt_modified;
    private Integer creator;
    private Integer comment_count=0;
    private Integer view_count=0;
    private Integer like_count=0;
    private String tag;
    private User user;
}
