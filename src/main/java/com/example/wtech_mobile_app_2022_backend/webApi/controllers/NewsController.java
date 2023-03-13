package com.example.wtech_mobile_app_2022_backend.webApi.controllers;

import com.example.wtech_mobile_app_2022_backend.business.abstracts.NewsService;
import com.example.wtech_mobile_app_2022_backend.dtos.news.request.NewsCreateRequest;
import com.example.wtech_mobile_app_2022_backend.dtos.news.response.NewsGetAllResponse;
import com.example.wtech_mobile_app_2022_backend.dtos.news.response.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {
    @Autowired
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public ResponseEntity<NewsCreateRequest> add (@RequestParam String title , @RequestParam String organizationName,
                                                  @RequestParam String description, @RequestParam MultipartFile image,
                                                  NewsCreateRequest newsCreateRequest) throws IOException {
        newsService.add(new NewsCreateRequest(title,organizationName,description,0),image);
        if(Objects.nonNull(newsCreateRequest)) {
            return new ResponseEntity<>(newsCreateRequest, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<NewsResponse> getById (@PathVariable String id) {
        NewsResponse newsResponse = newsService.getNewsById(id);
        if(Objects.nonNull(newsResponse)){
            return new ResponseEntity<>(newsResponse,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<NewsGetAllResponse>> getAll() {
        List<NewsGetAllResponse> newsGetAllResponses = newsService.getAllNews();
        if(newsGetAllResponses.isEmpty()){
            ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(newsGetAllResponses,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        newsService.delete(id);
    }
}
