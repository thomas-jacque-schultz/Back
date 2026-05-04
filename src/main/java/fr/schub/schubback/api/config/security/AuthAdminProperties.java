package fr.schub.schubback.api.config.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "auth.admin")
public record AuthAdminProperties(String username, String password) {
}
