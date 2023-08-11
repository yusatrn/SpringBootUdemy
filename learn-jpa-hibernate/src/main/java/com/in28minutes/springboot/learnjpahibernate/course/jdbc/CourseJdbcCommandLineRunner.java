package com.in28minutes.springboot.learnjpahibernate.course.jdbc;

import com.in28minutes.springboot.learnjpahibernate.course.Course;
import com.in28minutes.springboot.learnjpahibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    //@Autowired
    //private CourseJdbcRepository repository;
    // @Autowired
    //private CourseJpaRepository repository;
    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS Now!", "in28minutes"));
        repository.save(new Course(2, "Learn Azure Now!", "in28minutes"));
        repository.save(new Course(3, "Learn DevOps Now!", "in28minutes"));
        repository.deleteById(1l);
        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));
        System.out.println("Hepsiiiii");
        System.out.println(repository.findAll());
        System.out.println("Toplam sayısı = " + repository.count());
        System.out.println("--------------------------------");
        System.out.println(repository.findByAuthor("in28minutes"));
        System.out.println(repository.findByAuthor(""));
        System.out.println("--------------------------------");
        System.out.println(repository.findByName("Learn AWS Now!"));
        System.out.println(repository.findByName("Learn Azure Now!"));


    }
}
