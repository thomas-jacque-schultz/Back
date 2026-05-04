package fr.schub.schubback.api.config.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "auth.jwt")
public record JwtProperties(String secret, long expirationSeconds) {
}
