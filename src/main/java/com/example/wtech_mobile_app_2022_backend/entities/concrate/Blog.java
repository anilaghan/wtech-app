package com.example.wtech_mobile_app_2022_backend.entities.concrate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("blog")
public class Blog {
    @Id
    private String id;
    private String imagePath;
    private String title;
    private String organizationName;
    private LocalDate createdDate;
    private String description;
    private int viewCount;

    public void incrementViewCount(){
        viewCount++;
    }

}
