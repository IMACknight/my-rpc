package com.acknight.provider;

import com.acknight.common.serveice.UserService;
import com.acknight.provider.service.Impl.UserServiceImpl;
import com.acknight.rpc.registry.LocalRegistry;
import com.acknight.rpc.server.HttpServer;
import com.acknight.rpc.server.VertxHttpServe;

/**
 * 简易服务提供者
 */
public class EasyProviderExample {
    
    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        
        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServe();
        httpServer.doStart(8080);
    }
}