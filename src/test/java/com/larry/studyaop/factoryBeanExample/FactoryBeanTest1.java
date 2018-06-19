package com.larry.studyaop.factoryBeanExample;


import com.larry.studyaop.factoryBeanExample.Message;
import com.larry.studyaop.factoryBeanExample.MessageFactoryBean;
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
public class FactoryBeanTest1 {

    @Autowired
    private ApplicationContext context;

    @Test
    public void getMessageFromFactoryBean() throws Exception {
        Object message = context.getBean("message");
        assertThat(message, instanceOf(Message.class));
        assertThat(((Message)message).getText(), is("Factory Bean"));
    }

    @Test
    public void getFactoryBean() throws Exception {
        Object factoryBean = context.getBean("&message");
        assertThat(factoryBean, instanceOf(MessageFactoryBean.class));
    }


}
