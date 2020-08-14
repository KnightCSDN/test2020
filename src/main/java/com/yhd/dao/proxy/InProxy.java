package com.yhd.dao.proxy;

import com.yhd.dao.UserMapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InProxy implements InvocationHandler {
    UserMapper userMapper;
    public Object getUserMapper(UserMapper userMapper){
        return Proxy.newProxyInstance(userMapper.getClass().getClassLoader(),userMapper.getClass().getInterfaces(),this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在方法执行前执行");
        Object o = method.invoke(userMapper, args);
        System.out.println("在方法执行后执行");
        return o;
    }

}
