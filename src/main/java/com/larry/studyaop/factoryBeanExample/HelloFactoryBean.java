package com.larry.studyaop.factoryBeanExample;

import com.larry.studyaop.beforeBeanFactory.UppercaseHandler;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

public class HelloFactoryBean implements FactoryBean<Object>{

    private Object target;
    private String pattern;
    private Class<?> helloInterface;

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setHelloInterface(Class<?> helloInterface) {
        this.helloInterface = helloInterface;
    }

    @Override
    public Object getObject() throws Exception {

        UppercaseHandler handler = new UppercaseHandler(target);
        return Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] {helloInterface},
                handler.setPattern(pattern));
    }

    @Override
    public Class<?> getObjectType() {
        return helloInterface;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
