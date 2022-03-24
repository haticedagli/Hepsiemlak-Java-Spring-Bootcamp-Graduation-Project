package com.hepsiemlak.notificationservice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class EmailConfig {

	@Value("${mail.host}")
	private String smtpServer;
	@Value("${mail.port}")
	private String smtpPort;
	@Value("${mail.username}")
	private String username;
	@Value("${mail.password}")
	private String password;
	@Value("${mail.from}")
	private String from;

}
