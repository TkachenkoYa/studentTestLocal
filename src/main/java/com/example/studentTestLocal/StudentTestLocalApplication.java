package com.example.studentTestLocal;

import com.example.studentTestLocal.services.TestService;
import com.example.studentTestLocal.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class StudentTestLocalApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Configuration.class);
        UserService userService = context.getBean(UserService.class);
        TestService testService = context.getBean(TestService.class);

        userService.inputUser();
        testService.ask();

    }
}


