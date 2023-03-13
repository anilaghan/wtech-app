package com.example.wtech_mobile_app_2022_backend.business.abstracts;

import com.example.wtech_mobile_app_2022_backend.entities.concrate.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    Image addImage(MultipartFile multipartFile) throws IOException;
}
