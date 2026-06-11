package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuizController {

    private final QuestionService service;

    public QuizController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("questions", service.getAllQuestions());
        model.addAttribute("question", new Question());
        return "index";
    }

    @PostMapping("/save")
    public String saveQuestion(@ModelAttribute Question question) {
        service.saveQuestion(question);
        return "redirect:/";
    }
}
