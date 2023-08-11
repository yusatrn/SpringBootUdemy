package com.in28minutes.learnspringframework.examples.d1;

import com.in28minutes.learnspringframework.examples.c1.BusinessCalculationService;
import com.in28minutes.learnspringframework.examples.c1.RealWorldSpringContextLauncherApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class ClassA{

}
@Component
class ClassB{
    public ClassB(ClassA classA) {
        System.out.println("Some Initialization logic");
    }
    public void doSomething(){
        System.out.println("Do something");
    }
}
@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {
        try (
                var context= new AnnotationConfigApplicationContext(
                        LazyInitializationLauncherApplication.class)){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("Initialization of context is complete");
            context.getBean(ClassB.class).doSomething();
        }

    }
}
