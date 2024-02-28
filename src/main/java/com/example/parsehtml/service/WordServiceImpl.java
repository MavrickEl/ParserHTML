package com.example.parsehtml.service;

import com.example.parsehtml.DAO.WordRepository;
import com.example.parsehtml.service.parser.MyParser;
import com.example.parsehtml.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WordServiceImpl implements WordService {

    @Autowired
    private WordRepository wordRepository;

    @Override
    public List<String> parsePageAndSaveWords(String link) {
        MyParser parser = new MyParser();
        HashMap<String, Integer> words = parser.parsing(link);
        for (Map.Entry<String, Integer> result : words.entrySet()) {
            Word word = new Word();
            word.setWord(result.getKey());
            word.setAmount(result.getValue());
            wordRepository.save(word);
        }
        List<String> wordsAndCount = parser.toString(words);
        return wordsAndCount;
    }

}
