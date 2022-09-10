package com.example.studentTestLocal.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;
@Getter
@Setter
public class TestService {
    @Autowired
    private TestFileReader testFileReader;
    private int number;
    private int correctAnswers;
    @Autowired
    private LanguageHandler languageHandler;


    public void ask() {
        Scanner in = new Scanner(System.in);
        testFileReader.getRecords().forEach(q -> {
                    System.out.println(question());
            if (checkAnswer(in.nextLine()))
                correctAnswers++;
            number++;
        });
        System.out.println(languageHandler.getBundle().getString("correctAnswers")  + correctAnswers);
    }

    private String question() {
        List<String> record = testFileReader.getRecords().get(number);
        return record.get(1) + "\\n Answer options: " + String.join(
                ", ", record.get(2), record.get(3), record.get(4), record.get(5));
    }

    private boolean checkAnswer(String answer) {
        return testFileReader.getRecords().get(number).get(6).equals(answer);
    }
}

