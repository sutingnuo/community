package com.suspringboot.frame.community.mapper;

import com.suspringboot.frame.community.model.Question;
import org.apache.ibatis.annotations.Insert;

/**
 private String title;
 private String description;
 private long gmtCreate;
 private long gmtMdified;
 private Integer createor;

 private String tag;
 */
public interface QuestionMapper {
    @Insert("insert into question(title,description, gmt_create,gmt_modified,createor,tag )values(#{title},#{description},#{gmtCreate},#{gmtMdified},#{createor},#{tag})")
     void create(Question question);
}
