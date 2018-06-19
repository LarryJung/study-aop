package com.larry.studyaop.factoryBeanExample;


import com.larry.studyaop.beforeBeanFactory.Hello;
import com.larry.studyaop.beforeBeanFactory.HelloTarget;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloFactoryBeanTest {

    @Autowired
    Object hello;

    @Test
    public void uppercaseTest() {
        assertThat(((Hello) hello).sayHello("Larry"), is("HELLO LARRY"));
    }

}
