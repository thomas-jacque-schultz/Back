package fr.schub.schubback.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SchubBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchubBackApplication.class, args);
    }
}
