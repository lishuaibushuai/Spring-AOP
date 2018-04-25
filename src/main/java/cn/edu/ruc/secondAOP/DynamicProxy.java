package cn.edu.ruc.secondAOP;

import cn.edu.ruc.springAOP.MonitorSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Lishuai
 * @Date: Created on 2018/4/25
 * 利用InvocationHandler实现一个代理，让它去包含Person这个对象。
 * 那么再运行期实际上是执行这个代理的方法，然后代理再去执行真正的方法。
 * 所以我们得以在执行真正方法的前后做一些手脚。
 * JDK动态代理是利用反射实现。
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
        MonitorSession.begin(arg1.getName());
        Object obj = arg1.invoke(target, arg2);
        MonitorSession.end();
        return obj;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }
}
