package com.notification.service;

import java.util.Map;
import java.util.UUID;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.notification.model.Template;
import com.notification.repository.TemplateRepository;

@Service
public class NotificationService {

	private final TemplateRepository templateRepository;
	private final TemplateEngine templateEngine;

	public NotificationService(TemplateRepository templateRepository, TemplateEngine templateEngine) {
		this.templateRepository = templateRepository;
		this.templateEngine = templateEngine;
	}

	public String generateHtml(String templateName, Map<String, Object> variables) {
		Template template = templateRepository.findByTemplateNameAndIsActiveTrue(templateName);
		if (ObjectUtils.isEmpty(template)) {
			throw new RuntimeException("template not found...");
		}
		Context context = new Context();
		context.setVariables(variables);
		return templateEngine.process(template.getTemplateContent(), context);
	}

}
