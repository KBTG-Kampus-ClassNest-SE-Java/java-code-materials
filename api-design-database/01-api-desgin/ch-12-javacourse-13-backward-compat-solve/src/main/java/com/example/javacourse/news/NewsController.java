package com.example.javacourse.news;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {

    @GetMapping(value = "/latest")
    public News latestNews() {
        return new News("Title Day-1", "Body");
    }
}

record News(String title, String body) {}
