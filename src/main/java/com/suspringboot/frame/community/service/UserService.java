package com.suspringboot.frame.community.service;

import com.suspringboot.frame.community.mapper.UserMapper;
import com.suspringboot.frame.community.model.User;
import com.suspringboot.frame.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void CreateOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccount_idEqualTo(user.getAccount_id());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0) {
            user.setGmt_create(System.currentTimeMillis());
            user.setGmt_modified(user.getGmt_create());
            userMapper.insert(user);
        } else {
            User dbuser = users.get(0);
            User updateUser = new User();
            updateUser.setGmt_modified(System.currentTimeMillis());
            updateUser.setAvatar_url(user.getAvatar_url());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            UserExample example = new UserExample();
            example.createCriteria().andIdEqualTo(dbuser.getId());
            userMapper.updateByExampleSelective(updateUser,example);
        }
    }
}
