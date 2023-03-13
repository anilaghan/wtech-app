package com.example.wtech_mobile_app_2022_backend.business.abstracts;

import com.example.wtech_mobile_app_2022_backend.dtos.news.request.NewsCreateRequest;
import com.example.wtech_mobile_app_2022_backend.dtos.news.response.NewsGetAllResponse;
import com.example.wtech_mobile_app_2022_backend.dtos.news.response.NewsResponse;
import com.example.wtech_mobile_app_2022_backend.entities.concrate.News;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface NewsService {
    News add(NewsCreateRequest newsCreateRequest, MultipartFile image) throws IOException;

    NewsResponse getNewsById(String id);

    List<NewsGetAllResponse> getAllNews();

    void delete(String id);
}
