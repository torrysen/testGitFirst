package com.liuyx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * javaåŠ¨æ€�ä»£ç�†æœ‰ä¸€å®šå±€é™�æ€§ï¼Œéœ€è¦�å®šä¹‰è‡³å°‘ä¸€ä¸ªæŽ¥å�£ï¼Œä½¿ç”¨cglibåˆ™ä¸�å¿…å¦‚æ­¤
 * @author ZhenShengSu
 *
 */
public class InvocationHandlerTest implements InvocationHandler {

    private Object target;

    Object bind(Object i) {
        target = i;
        Object warpedItf;
        warpedItf = Proxy.newProxyInstance(target.getClass().getClassLoader(), i.getClass().getInterfaces(), this);
        return warpedItf;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method excute!");
        method.invoke(target, args);
        System.out.println("after method excute!");
        return null;
    }
    
    public static void main(String[] args) {
        Cls c = new Cls();
        InvocationHandlerTest pxy = new InvocationHandlerTest();
        Itf itf = (Itf)pxy.bind(c);
        System.out.println("printMe start-------------------");
        itf.printMe();
        System.out.println("printMe end-------------------");
        System.out.println("printSth start-------------------");
        itf.printSth("Hello, torrysen");
        System.out.println("printSth end-------------------");
    }

}