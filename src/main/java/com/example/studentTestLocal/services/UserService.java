package com.example.studentTestLocal.services;

import com.example.studentTestLocal.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

@Getter
@Setter
public class UserService {
    @Autowired
    private User user;
    @Autowired
    private LanguageHandler languageHandler;

    public void inputUser() {
        Scanner in = new Scanner(System.in);
        boolean isNotEmpty = false;
        while (!isNotEmpty) {

            System.out.println(languageHandler.getBundle().getString("enterName"));
            user.setName(in.nextLine());
            System.out.println(languageHandler.getBundle().getString("enterLastName"));
            user.setLastName(in.nextLine());
            if (!user.getName().isEmpty() && !user.getLastName().isEmpty())
                isNotEmpty = true;
            else System.out.println(languageHandler.getBundle().getString("wrong"));
        }
    }
}
