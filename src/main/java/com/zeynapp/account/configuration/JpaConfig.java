package com.zeynapp.account.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.zeynapp.account.repository")
public class JpaConfig {
    // Your JPA configuration
}