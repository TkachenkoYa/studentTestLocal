package com.example.studentTestLocal.services;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.sound.sampled.Control;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

@Getter
@Setter
public class LanguageHandler {
    private Locale locale;
    private ResourceBundle bundle;
    @PostConstruct
    public void selectLanguage() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please change language: Українська ua, English en ___ ");
        locale = new Locale(in.nextLine());
        bundle = ResourceBundle.getBundle("language", locale);
    }

}
