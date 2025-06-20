package com.notification;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import com.notification.model.Template;
import com.notification.repository.TemplateRepository;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@Bean
	public TemplateEngine templateEngine() {
		TemplateEngine engine = new TemplateEngine();
		engine.setTemplateResolver(stringTemplateResolver());
		return engine;
	}

	@Bean
	public ITemplateResolver stringTemplateResolver() {
		StringTemplateResolver resolver = new StringTemplateResolver();
		resolver.setTemplateMode(TemplateMode.HTML);
		resolver.setCacheable(false);
		return resolver;
	}
	
	
//	@Bean
//	public CommandLineRunner seedTemplate(TemplateRepository templateRepository) {
//	    return args -> {
//	        // Check if template already exists
////	        if (templateRepository.findByTemplateNameAndIsActiveTrue("testing_template")) {
//	            String htmlContent = """
//	                <!DOCTYPE html>
//	                <html xmlns:th="http://www.thymeleaf.org">
//	                <head>
//	                    <title th:text="${title}">Welcome</title>
//	                </head>
//	                <body>
//	                    <h1 th:text="${summary}">Hello!</h1>
//	                    <p th:text="${content}">Welcome to our platform.</p>
//	                </body>
//	                </html>
//	            """;
//	            
//	            Template template = Template.builder()
//	                .templateName("testing_template")
//	                .templateContent(htmlContent)
//	                .title("Welcome Email")
//	                .summaryContent("Welcome to our app")
//	                .contentCategory("EMAIL")
//	                .contentType("HTML")
//	                .isActive(true)
//	                .createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now()).build();
//	                
//	            templateRepository.save(template);
//	            System.out.println("Sample template seeded.");
////	        } else {
////	            System.out.println("Template already exists, skipping seed.");
////	        }
//	    };
//	}

}
