package com.example.wtech_mobile_app_2022_backend.dtos.user.request;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class UserSettingsRequest {
    private String email;
    private boolean pauseNotification;
    private boolean sendFewerNotification;

    private boolean nightMode;

    private boolean language;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getPauseNotification() {
        return pauseNotification;
    }

    public void setPauseNotification(boolean pauseNotification) {
        this.pauseNotification = pauseNotification;
    }

    public boolean getSendFewerNotification() {
        return sendFewerNotification;
    }

    public void setSendFewerNotification(boolean sendFewerNotification) {
        this.sendFewerNotification = sendFewerNotification;
    }

    public boolean getNightMode() {
        return nightMode;
    }

    public void setNightMode(boolean nightMode) {
        this.nightMode = nightMode;
    }

    public boolean getLanguage() {
        return language;
    }

    public void setLanguage(boolean language) {
        this.language = language;
    }


}
