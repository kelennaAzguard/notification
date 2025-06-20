package com.notification.repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notification.model.Template;

@Repository
public interface TemplateRepository extends JpaRepository<Template, UUID> {
    // Optional: Add custom query methods if needed
    Template findByTemplateNameAndIsActiveTrue(String templateName);
}  