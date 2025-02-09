package com.acknight.comsumer;

import com.acknight.common.model.User;
import com.acknight.common.serveice.UserService;
import com.acknight.rpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者
 */
public class EasyConsumerExample {
    
    public static void main(String[] args) {
        // 通过静态代理获取 UserService 对象
//        UserService userService = new UserServiceProxy();
        
        // 动态代理获取 UserService 对象
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("ACKnight");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}