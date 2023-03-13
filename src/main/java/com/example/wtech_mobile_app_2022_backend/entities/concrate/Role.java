package com.example.wtech_mobile_app_2022_backend.entities.concrate;

public enum Role {
    ADMIN (1),MENTOR(2),STUDENT(3);
    private int value;
    private Role(int value){
        this.value=value;
    }
}
