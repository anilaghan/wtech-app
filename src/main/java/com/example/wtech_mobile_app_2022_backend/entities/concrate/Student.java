package com.example.wtech_mobile_app_2022_backend.entities.concrate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("students")
public class Student extends User{

    private List<Favorite> favorites;
    private List<Application> applications;

    

}
