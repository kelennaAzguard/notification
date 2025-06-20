package com.notification.model;

import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Column;

@Entity
@Table(name = "notification_app")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationApp {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "platform", length = 20)
    private String platform;

    @Column(name = "setting_data", length = 4000)
    private String settingData;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}