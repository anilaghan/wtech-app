package com.example.wtech_mobile_app_2022_backend.business.concrate;


import com.example.wtech_mobile_app_2022_backend.business.abstracts.ImageService;
import com.example.wtech_mobile_app_2022_backend.entities.concrate.Image;
import com.example.wtech_mobile_app_2022_backend.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageManager implements ImageService {

    private final ImageRepository imageRepository;

    private final String imageFilePath = "/src/main/resources/images/";

    @Override
    public Image addImage(MultipartFile multipartFile) throws IOException {
        String appPath = System.getProperty("user.dir");
        String fileName = multipartFile.getOriginalFilename();
        String fileExt = fileName.substring(fileName.lastIndexOf(".")+1);
        String contentType = multipartFile.getContentType();

        MediaType myMediaType = MediaType.valueOf(contentType);
        UUID uuid = UUID.randomUUID();

        Path path = Path.of(appPath + imageFilePath + uuid + "." + fileExt);
        Path createdFilePath = Files.createFile(path);
        byte [] imageData = multipartFile.getBytes();

        Files.write(createdFilePath, imageData);

        Image image = new Image();
        image.setSize(multipartFile.getSize());
        image.setFilePath(imageFilePath + uuid + "." + fileExt);
        image.setFileName(uuid + "." + fileExt);
        image.setMediaType(myMediaType.toString());

        return imageRepository.save(image);
    }
}
