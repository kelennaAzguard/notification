package com.notification.controller;

import java.util.Map;

import com.notification.model.NotificationApp;
import com.notification.service.EmailService;
import com.notification.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private EmailService emailService;

	@PostMapping("/template/{templateName}")
	public ResponseEntity<String> sendEmailNotification(@PathVariable String templateName,
			@RequestParam String recipientEmail, @RequestBody Map<String, Object> variables) {

		String html = notificationService.generateHtml(templateName, variables);
		emailService.sendHtmlEmail(recipientEmail, "Notification", html);
		return ResponseEntity.ok(html);
	}
}
