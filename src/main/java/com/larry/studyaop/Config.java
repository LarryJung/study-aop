package com.larry.studyaop;

import com.larry.studyaop.beforeBeanFactory.Hello;
import com.larry.studyaop.beforeBeanFactory.HelloTarget;
import com.larry.studyaop.factoryBeanExample.HelloFactoryBean;
import com.larry.studyaop.factoryBeanExample.MessageFactoryBean;
import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

@Configuration
class Config {

    @Bean
    public MessageFactoryBean message() {
        MessageFactoryBean factoryBean = new MessageFactoryBean();
        factoryBean.setText("Factory Bean");
        return factoryBean;
    }

    @Bean
    public MessageFactoryBean message2() {
        MessageFactoryBean factoryBean = new MessageFactoryBean();
        factoryBean.setText("Factory");
        return factoryBean;
    }

    @Bean
    public HelloFactoryBean hello() {
        HelloFactoryBean helloFactoryBean = new HelloFactoryBean();
        helloFactoryBean.setTarget(helloTarget());
        helloFactoryBean.setPattern("say");
        helloFactoryBean.setHelloInterface(Hello.class);
        return helloFactoryBean;
    }

    @Bean
    public HelloTarget helloTarget() {
        return new HelloTarget();
    }
}
