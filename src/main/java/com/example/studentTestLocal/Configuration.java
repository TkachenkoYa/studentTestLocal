package com.example.studentTestLocal;

import com.example.studentTestLocal.services.LanguageHandler;
import com.example.studentTestLocal.services.TestFileReader;
import com.example.studentTestLocal.services.TestService;
import com.example.studentTestLocal.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
@org.springframework.context.annotation.Configuration

public class Configuration {
    private static final String FILE_PATH = "tests.csv";

    @Bean("user")
    public User user() {
        return new User();
    }


    @Bean("userService")
    public UserService userService() {
        return new UserService();
    }

    @Bean("testFileReader")
    public TestFileReader testFileReader() {
        return new TestFileReader(FILE_PATH);
    }

    @Bean("testService")
    public TestService testService() {
        return new TestService();
    }

    @Bean("languageHandler")
    public LanguageHandler languageHandler() {
        return new LanguageHandler();
    }

}
