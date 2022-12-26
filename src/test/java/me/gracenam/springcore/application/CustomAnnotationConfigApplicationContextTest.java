package me.gracenam.springcore.application;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

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
        DefaultListableBeanFactory context = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(new ClassPathResource("xml/application.xml"));

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