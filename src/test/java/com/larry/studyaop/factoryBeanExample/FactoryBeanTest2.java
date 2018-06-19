package com.larry.studyaop.factoryBeanExample;

import com.larry.studyaop.factoryBeanExample.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryBeanTest2 {

    @Autowired
    private Message message;

    @Autowired
    private Message message2;

    @Test
    public void asdf() {
        assertThat(message.getText(), is("Factory Bean"));
    }

    @Test
    public void asdf2() {
        assertThat(message2.getText(), is("Factory"));
    }

}
