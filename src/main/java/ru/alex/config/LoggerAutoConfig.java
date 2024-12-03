package ru.alex.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.alex.service.HttpLogger;
import ru.alex.service.HttpLoggerConfig;

@Configuration
@EnableConfigurationProperties(LoggerProperties.class)
public class LoggerAutoConfig {
    private final LoggerProperties loggerProperties;

    public LoggerAutoConfig(LoggerProperties loggerProperties) {
        this.loggerProperties = loggerProperties;
    }

    @Bean
    public HttpLogger httpLogger(HttpLoggerConfig config) {
        return new HttpLogger(config);
    }

    @Bean
    public HttpLoggerConfig httpLoggerConfig() {
        boolean isEnabled = loggerProperties.getEnabled();
        String level = loggerProperties.getLevel();

        if (level == null) {
            level = "INFO";
        }

        return new HttpLoggerConfig(isEnabled, level);
    }
}
