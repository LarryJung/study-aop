package com.larry.studyaop.beforeBeanFactory;

import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class beforeBeanFactoryTest {

    @Test
    public void helloTarget() {
        Hello hello = new HelloTarget();
        assertThat(hello.sayHello("Toby"), is("Hello Toby"));
    }

    @Test
    public void simpleProxy() {
        // 클라이언트가 사용하는 것은 타깃이 아니라 타킷을 감싸고 있는 프록시이다.
        Hello proxiedHello1 = new HelloUppercase(new HelloTarget());
        assertThat(proxiedHello1.sayHello("Toby"), is("HELLO TOBY"));
    }

    @Test
    public void dynamicProxy() {
        // 적절히 인자를 넘겨주고 팩토리에서 프록시를 생성한다.
        Hello proxiedHello2 = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] {Hello.class},
                new UppercaseHandler(new HelloTarget()).setPattern("say")
        );
        assertThat(proxiedHello2.sayHello("Toby"), is("HELLO TOBY"));
    }

}
