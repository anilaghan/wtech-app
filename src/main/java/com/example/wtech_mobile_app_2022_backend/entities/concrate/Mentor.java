package com.example.wtech_mobile_app_2022_backend.entities.concrate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("mentors")
public class Mentor extends User{
    private String title;
    private String organizationName;
    private String description;
    private String expertise;



}
