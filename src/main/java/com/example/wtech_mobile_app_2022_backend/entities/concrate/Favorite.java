package com.example.wtech_mobile_app_2022_backend.entities.concrate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("favorites")
public class Favorite {

    @Id
    private String id;
    private Education education;
    private Event event;
    private Mentor mentors;
    private News news;
}


