package com.file.model;


//public class Main {


//    public static void main(String[] args) {
//        System.out.println("hi Spring");
//    }
//
////    public void onStartup(ServletContext sc) throws ServletException {
////        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
////        root.register(SpringCoreConfig.class);
////        sc.addListener(new ContextLoaderListener(root));
////    }

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//}
//
//@Configuration
//@EnableWebMvc
//public class Main extends WebMvcConfigurerAdapter {
//
//    @Bean
//    public ViewResolver getViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".html");
//        return resolver;
//    }
//
//    @Override
//    public void configureDefaultServletHandling(
//            DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        System.out.println("-------------------------474747----------------------");
//        registry.addResourceHandler("/resource/**").addResourceLocations("WEB-INF/resources/");
//    }
//}