package com.example.wtech_mobile_app_2022_backend.entities.concrate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.MediaType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("images")
public class Image {

    @Id
    private String id;
    private String fileName;
    private String filePath;
    private Long size;
    private String mediaType;
}
