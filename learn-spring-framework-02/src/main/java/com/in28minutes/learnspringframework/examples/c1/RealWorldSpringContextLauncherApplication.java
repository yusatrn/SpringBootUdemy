package com.in28minutes.learnspringframework.examples.c1;

import com.in28minutes.learnspringframework.examples.a0.SimpleSpringContextLauncherApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {
    public static void main(String[] args) {
        try (
                var context= new AnnotationConfigApplicationContext(
                        RealWorldSpringContextLauncherApplication.class)){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }

    }
}
