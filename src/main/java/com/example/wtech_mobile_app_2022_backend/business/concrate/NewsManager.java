package com.example.wtech_mobile_app_2022_backend.business.concrate;

import com.example.wtech_mobile_app_2022_backend.business.abstracts.ImageService;
import com.example.wtech_mobile_app_2022_backend.business.abstracts.NewsService;
import com.example.wtech_mobile_app_2022_backend.dtos.news.request.NewsCreateRequest;
import com.example.wtech_mobile_app_2022_backend.dtos.news.response.NewsGetAllResponse;
import com.example.wtech_mobile_app_2022_backend.dtos.news.response.NewsResponse;
import com.example.wtech_mobile_app_2022_backend.entities.concrate.Image;
import com.example.wtech_mobile_app_2022_backend.entities.concrate.News;
import com.example.wtech_mobile_app_2022_backend.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsManager implements NewsService {

    private final NewsRepository newsRepository;
    private final ImageService imageService;

    @Override
    public News add(NewsCreateRequest newsCreateRequest , MultipartFile image) throws IOException {
        Image image1 = imageService.addImage(image);
        News news = new News();
        news.setTitle(newsCreateRequest.getTitle());
        news.setOrganizationName(newsCreateRequest.getOrganizationName());
        news.setImage(image1);
        news.setDescription(newsCreateRequest.getDescription());
        news.setCreatedDate(LocalDateTime.now());
        news.setViewCount(0);

        return newsRepository.save(news);
    }

    @Override
    public NewsResponse getNewsById(String id) {
        News news = newsRepository.findById(id).orElseThrow();
        NewsResponse newsResponse = new NewsResponse();
        news.incrementViewCount();
        newsRepository.save(news);
        newsResponse.setTitle(news.getTitle());
        newsResponse.setOrganizationName(news.getOrganizationName());
        newsResponse.setImage(news.getImage());
        newsResponse.setDescription(news.getDescription());
        newsResponse.setViewCount(news.getViewCount());
        newsResponse.setCreatedDate(news.getCreatedDate());

        return newsResponse;
    }

    @Override
    public List<NewsGetAllResponse> getAllNews() {
        return newsRepository.findAll().stream().map(NewsGetAllResponse::new).toList();
    }

    @Override
    public void delete(String id) {
        newsRepository.deleteById(id);
    }
}
