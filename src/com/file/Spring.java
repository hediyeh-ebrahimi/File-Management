package com.file;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring {
    private static ApplicationContext applicationContext =new ClassPathXmlApplicationContext("spring.xml");
    public static Object getBean(String beanId){
        System.out.println("----------999-------------");

        return applicationContext.getBean(beanId);
    }
}
