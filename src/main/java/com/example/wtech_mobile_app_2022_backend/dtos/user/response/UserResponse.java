package com.example.wtech_mobile_app_2022_backend.dtos.user.response;

import com.example.wtech_mobile_app_2022_backend.entities.concrate.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private Image profileImage;
    private String name;

}
