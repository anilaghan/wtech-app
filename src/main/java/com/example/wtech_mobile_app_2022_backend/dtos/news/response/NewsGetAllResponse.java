package com.example.wtech_mobile_app_2022_backend.dtos.news.response;

import com.example.wtech_mobile_app_2022_backend.entities.concrate.Image;
import com.example.wtech_mobile_app_2022_backend.entities.concrate.News;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsGetAllResponse {
    private String title;
    private Image image;
    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdDate;

    public NewsGetAllResponse(News news) {
        this.title= news.getTitle();
        this.image = news.getImage();
        this.description = news.getDescription();
        this.createdDate = news.getCreatedDate();
    }
}
