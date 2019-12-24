package com.suspringboot.frame.community.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private long accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String  avatar_url;
}
