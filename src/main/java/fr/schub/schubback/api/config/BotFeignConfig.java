package fr.schub.schubback.api.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Configuration
public class BotFeignConfig {

    @Value("${bot.internal-secret}")
    private String botInternalSecret;

    @Bean
    public RequestInterceptor botInternalAuthInterceptor() {
        return template -> {
            template.header("X-Internal-Secret", botInternalSecret);
            template.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        };
    }
}
