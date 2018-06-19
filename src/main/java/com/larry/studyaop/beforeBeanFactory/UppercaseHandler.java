package com.larry.studyaop.beforeBeanFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 다이나맥 프록시로부터 메소드 호출 정보를 받아서 처리하는 놈
public class UppercaseHandler implements InvocationHandler {

    Object target;

    private String pattern;

    public UppercaseHandler setPattern(String pattern) {
        this.pattern = pattern;
        return this;
    }

    public UppercaseHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        Object ret = method.invoke(target, args);
        if (ret instanceof String && method.getName().startsWith(pattern)) {
            return ((String) ret).toUpperCase();
        }
        return ret;
    }
}
