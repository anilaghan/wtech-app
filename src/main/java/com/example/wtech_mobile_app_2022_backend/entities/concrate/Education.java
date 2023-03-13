package com.example.wtech_mobile_app_2022_backend.entities.concrate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("educations")
public class Education {
    @Id
    private String id;
    private EducationLevel educationLevel;
    private int educationTime;
    private boolean certificateStatus;
    private String language;
    private String description;
    private String conditionsOfParticipation;
    private String archivements;
    private String workingPlaces;


}
