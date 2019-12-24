package com.suspringboot.frame.community.mapper;

import com.suspringboot.frame.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    /*  @Select("select * from user")
      City findByState(@Param("state")String state);*/
    @Insert("insert into frameUser (name,account_id,token,gmt_create,gmt_modified,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatar_url})")
    void insert(User user);


    @Select("select * from frameUser where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from frameUser where id=#{id}")
    User findById(@Param("id")Integer id);
}

