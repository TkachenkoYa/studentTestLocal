package com.example.studentTestLocal.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class TestFileReader {
    private ClassPathResource resource;
    private List<List<String>> records;
    @Autowired
    private LanguageHandler languageHandler;

    public TestFileReader(String path) {

        resource = new ClassPathResource(path);
    }

    @PostConstruct
    public void readFile() {
        records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> tests = new ArrayList<>();
                String[] units = line.split(",");
                records.add(Arrays.asList(units));
            }
            filterByLanguage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void  filterByLanguage(){
        records = records.stream()
                .filter(list -> list.get(0).startsWith(languageHandler.getLocale().getLanguage()))
                .collect(Collectors.toList());
    }
}
