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
@Document("events")
public class Event {
    @Id
    private String id;
    private String image;
    private String title;
    private String organizationName;
    private LocalDate eventDate;
    private LocalDate createdDate;
    private String description;


}
