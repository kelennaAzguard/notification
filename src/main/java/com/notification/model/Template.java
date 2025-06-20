package com.notification.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator; 
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Version;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.PrePersist;

@Entity
@Table(name = "template")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Template {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "template_name", length = 100)
    private String templateName;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "template_content", columnDefinition = "text")
    private String templateContent;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "title", length = 500)
    private String title;

    @Column(name = "place_holder_data", columnDefinition = "text")
    private String placeHolderData;

    @Column(name = "summary_content", columnDefinition = "text")
    private String summaryContent;

    @Column(name = "content_category", length = 30)
    private String contentCategory;

    @Column(name = "content_type", length = 20)
    private String contentType;

    @Column(name = "is_active")
    private Boolean isActive;
    
    @PrePersist
    public void prePersist() {
        if (this.version == null) this.version = 0;
    }

}