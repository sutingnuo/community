package com.suspringboot.frame.community.dto;

/**
 * github用户
 */
import lombok.Data;

@Data
public class GithubUser {
    private String name;
    private String id;
    private String bio;
    private String  avatar_url;



    @Override
    public String toString() {
        return "GithubUser{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", bio='" + bio + '\'' +
                '}';
    }
}
