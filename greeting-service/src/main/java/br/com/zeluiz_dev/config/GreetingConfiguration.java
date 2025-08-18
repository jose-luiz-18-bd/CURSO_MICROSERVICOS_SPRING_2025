package br.com.zeluiz_dev.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("greeting-service")
public record GreetingConfiguration(String greeting, String defaultValue) {
}
