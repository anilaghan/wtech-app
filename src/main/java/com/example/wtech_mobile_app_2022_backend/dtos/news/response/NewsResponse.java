package com.example.wtech_mobile_app_2022_backend.dtos.news.response;

import com.example.wtech_mobile_app_2022_backend.entities.concrate.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponse {
    private String title;
    private String OrganizationName;
    private Image image;
    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdDate;
    private int viewCount;

}
