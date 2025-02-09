package com.acknight.comsumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.acknight.common.model.User;
import com.acknight.common.serveice.UserService;
import com.acknight.rpc.model.RpcRequest;
import com.acknight.rpc.model.RpcResponse;
import com.acknight.rpc.serializer.JdkSerializer;
import com.acknight.rpc.serializer.Serializer;

/**
 * 静态代理
 */
public class UserServiceProxy implements UserService {
    
    public User getUser(User user) {
        // 指定序列化器
        Serializer serializer = new JdkSerializer();
        
        // 发请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();
        
        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("hppt://localhost:8080")
                    .body(bodyBytes)
                    .execute()) {
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
