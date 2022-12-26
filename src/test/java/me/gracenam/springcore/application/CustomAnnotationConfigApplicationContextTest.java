package me.gracenam.springcore.application;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class CustomAnnotationConfigApplicationContextTest {

    @Test
    public void config_custom() {
        final BeanFactory context =
                new CustomAnnotationConfigApplicationContext(ApplicationConfig.class);

        log.debug("before getBean()");

        context.getBean(BookService.class);
    }

    @Test
    public void config_beanFactory() {
        final BeanFactory context = new ClassPathXmlApplicationContext("xml/application.xml");

        log.debug("before getBean()");

        context.getBean(BookService.class);
    }

    @Test
    public void config() {
        final BeanFactory context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        log.debug("before getBean()");

        context.getBean(BookService.class);
    }

}