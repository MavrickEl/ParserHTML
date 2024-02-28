package com.example.parsehtml.service.parser;

import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
public class MyParser {

    private String regex = " |\\,|\\.|\\!|\\?|\\;|\\:|\\'|\\[|\\(|\\)|\\]|\\s|\"|\\-|\\/|\\«|\\»|\\<|\\>|\\ ";

    public HashMap<String, Integer> parsing(String link) {
        Document html;
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        try {
            html = Jsoup.connect(link).get();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return words;
        }
        String[] text = html.body().text().toUpperCase().split(regex);
        for (int i = 0; i < text.length; i++) {
            String key = text[i];
            if (!key.isBlank()) {
                int count = words.getOrDefault(key, 0);
                words.put(key, ++count);
            }
        }
        return words;
    }

    public List<String> toString(HashMap<String, Integer> words) {
        List<String> wordsAndCount = new ArrayList<>();
        for (Map.Entry<String, Integer> result : words.entrySet()) {
            wordsAndCount.add(result.getKey() + " - " + result.getValue() + "\n");
        }
        return wordsAndCount;
    }


}
