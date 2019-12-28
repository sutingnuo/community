package com.suspringboot.frame.community.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private long account_id;
    private String token;
    private Long gmt_create;
    private Long gmt_modified;
    private String  avatar_url;
    private String bio;
}
