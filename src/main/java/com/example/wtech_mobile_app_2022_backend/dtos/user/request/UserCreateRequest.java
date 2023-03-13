package com.example.wtech_mobile_app_2022_backend.dtos.user.request;

import com.example.wtech_mobile_app_2022_backend.entities.concrate.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    @Email
    private String email;

    @NotBlank
    @NotNull
    private String password;

    @NotBlank
    @NotNull
    private String phoneNumber;

    private Role role;

    @NotBlank
    @NotNull
    private String identityNumber;

}
