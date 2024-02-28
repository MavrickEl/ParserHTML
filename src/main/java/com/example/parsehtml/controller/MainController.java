package com.example.parsehtml.controller;

import com.example.parsehtml.service.WordServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {

    private final WordServiceImpl wordService;

    @GetMapping("/")
    public String mainPage() {
        return "main-page";
    }

    @PostMapping("/parse")
    public String parsePage(@ModelAttribute("link") String link, Model model) {
        List<String> words = wordService.parsePageAndSaveWords(link);
        if (words.size() == 0) {
            model.addAttribute("emptyLink", link);
            return "error";
        }
        model.addAttribute("words", words);
        return "parse";
    }

}
