package com.suspringboot.frame.community.mapper;

import com.suspringboot.frame.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /*  @Select("select * from user")
      City findByState(@Param("state")String state);*/
    @Insert("insert into frameUser (name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}

