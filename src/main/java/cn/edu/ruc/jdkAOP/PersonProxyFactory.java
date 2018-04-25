package cn.edu.ruc.jdkAOP;

import cn.edu.ruc.CGLib.CGLibProxy;
import cn.edu.ruc.CGLib.Person;
import cn.edu.ruc.Speakable;

/**
 * @Author: Lishuai
 * @Date: Created on 2018/4/25
 */
public class PersonProxyFactory {

    public static Speakable newJdkProxy() {
        // 代理PersonImpl
        DynamicProxy dynamicProxy = new DynamicProxy(new PersonImpl());
        Speakable proxy = dynamicProxy.getProxy();
        return proxy;
    }

    public static Person newCglibProxy() {
        CGLibProxy cglibProxy = CGLibProxy.getInstance();
        Person proxy = cglibProxy.getProxy(Person.class);
        return proxy;
    }
}
