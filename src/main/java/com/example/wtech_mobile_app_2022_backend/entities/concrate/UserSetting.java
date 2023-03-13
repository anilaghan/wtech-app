package com.example.wtech_mobile_app_2022_backend.entities.concrate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("user_settings")
public class UserSetting {
    @Id
    private String id;
    private boolean pauseNotification;
    private boolean sendFewerNotification;

    private boolean nightMode;

    private boolean language;


}
