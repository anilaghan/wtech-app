package com.example.wtech_mobile_app_2022_backend.dtos.user.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {

    private MultipartFile profileImage;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    @Indexed(unique = true)
    @Email
    private String email;

    @NotBlank
    @NotNull
    private String phoneNumber;






}
