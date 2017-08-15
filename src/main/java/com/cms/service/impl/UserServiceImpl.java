package com.cms.service.impl;

import com.cms.dao.UserMapper;
import com.cms.entity.User;
import com.cms.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ykz on 2017/4/5.
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User selectByUser(User user) {
        return userMapper.getSelectByUser(user);
    }
}
