package com.suspringboot.frame.community.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private long parent_id;
    private String content;
    private Integer com_type;
}
