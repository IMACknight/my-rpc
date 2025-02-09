package com.acknight.provider.service.Impl;

import com.acknight.common.model.User;
import com.acknight.common.serveice.UserService;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {
    
    @Override
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
