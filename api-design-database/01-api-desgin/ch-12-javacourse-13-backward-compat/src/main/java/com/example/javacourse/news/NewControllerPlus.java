package com.example.javacourse.news;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
public class NewControllerPlus {

    @GetMapping("/latest")
    public News latestNews() {
        return new News("Title Day-1", "Body");
    }

    @GetMapping(path = "/latest", headers = "X-API-VERSION=2")
    public NewsV2Dto getLatestNewsV2() {
        return new NewsV2Dto("Title Day-1", "Body");
    }

//    @RequestHeader(value = "X-Api-Version", required = false) Integer apiVersion
}
