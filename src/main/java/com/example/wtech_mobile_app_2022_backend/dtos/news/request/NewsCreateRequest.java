package com.example.wtech_mobile_app_2022_backend.dtos.news.request;

import com.example.wtech_mobile_app_2022_backend.entities.concrate.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCreateRequest {
    private String title;
    private String organizationName;
    private String description;
    private int viewCount;
}
