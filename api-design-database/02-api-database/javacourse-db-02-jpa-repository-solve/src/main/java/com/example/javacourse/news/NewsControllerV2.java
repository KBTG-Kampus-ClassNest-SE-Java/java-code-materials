package com.example.javacourse.news;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/news")
public class NewsControllerV2 {
    @GetMapping(value = "/latest")
    public NewsV2Dto latestNewsV2() {
        return new NewsV2Dto("Title Day-1", "Body");
    }
}

record NewsV2Dto(String title, String content) {}
