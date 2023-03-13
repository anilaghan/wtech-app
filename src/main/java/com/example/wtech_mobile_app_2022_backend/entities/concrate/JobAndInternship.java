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
@Document("jobs")
public class JobAndInternship {
    @Id
    private String id;
    private String imagePath;
    private String organizationName;
    private LocalDate updateDate;
    private LocalDate createdDate;
    private String description;
    private String candidateRequirement;
    private String positionDetails;




}
