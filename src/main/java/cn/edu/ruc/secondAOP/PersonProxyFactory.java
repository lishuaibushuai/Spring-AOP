package cn.edu.ruc.secondAOP;

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
}
